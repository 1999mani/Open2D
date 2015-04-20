package me.mani.open2d.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.HashSet;
import java.util.Set;

import me.mani.open2d.game.map.Map;

public class Game {

	private static Game instance;
	
	private String playerName;
	private Player player;
	private Screen screen;
	private RenderTask renderTask;
	private Set<GameObject> gameObjects = new HashSet<>();
	private Map map;
	
	private BufferedImage buffer;
	
	public Game(String playerName) {
		instance = this;
		this.playerName = playerName;
	}
	
	public void start() {
		screen = new Screen(this);
//		new Console();
		map = new Map();
		map.setupMap();
		player = new Player();
		gameObjects.add(player);
		renderTask = new RenderTask(this).start();
		
		buffer = new BufferedImage(screen.getWidth(), screen.getHeight(), BufferedImage.TYPE_INT_ARGB);
	}
	
	public Set<GameObject> getGameObjects() {
		return gameObjects;
	}
	
	public void updateAll(long delta) {
		map.update(delta);
		new HashSet<>(gameObjects).forEach((gameObject) -> gameObject.update(delta));
	}
	
	public void drawAll(Graphics g) {
		Graphics b = buffer.getGraphics();
		
		((Graphics2D) b).setBackground(Color.WHITE);
		b.clearRect(0, 0, screen.getWidth(), screen.getHeight());
		map.draw(b);
		new HashSet<>(gameObjects).forEach((gameObject) -> gameObject.draw(b));
		
		g.drawImage(buffer, 0, 0, null);
	}
	
	public void registerObject(GameObject gameObject) {
		gameObjects.add(gameObject);
	}
	
	public void unregisterObject(GameObject gameObject) {
		gameObjects.remove(gameObject);
	}
	
	public String getPlayerName() {
		return playerName;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public Screen getScreen() {
		return screen;
	}
	
	public Map getMap() {
		return map;
	}
	
	public static Game getInstance() {
		return instance;
	}
	
}
