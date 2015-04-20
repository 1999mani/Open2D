package me.mani.open2d.game.map;

import me.mani.open2d.game.Game;
import me.mani.open2d.game.GameObject;
import me.mani.open2d.game.Texture;

public class Map extends GameObject {

	private boolean[][] blockedLocations;
	
	public Map() {
		super(Texture.loadTexture("media/map.png"));
	}
	
	public void setupMap() {
		blockedLocations = new boolean[getTexture().getImage().getWidth()][getTexture().getImage().getHeight()];
		for (int y = 0; y < getTexture().getImage().getHeight(); y++)
			for (int x = 0; x < getTexture().getImage().getWidth(); x++)
				blockedLocations[x][y] = getTexture().getImage().getRGB(x, y) == 0xFF000000;
	}
	
	public boolean checkCollision(GameObject gameObject) {
		try {
			return 
				blockedLocations[(int) gameObject.getX()][(int) gameObject.getY()] ||
				blockedLocations[(int) gameObject.getX() + gameObject.getTexture().getImage().getWidth() - 1][(int) gameObject.getY()] ||
				blockedLocations[(int) gameObject.getX()][(int) gameObject.getY() + gameObject.getTexture().getImage().getHeight() - 1] ||
				blockedLocations[(int) gameObject.getX() + gameObject.getTexture().getImage().getWidth() - 1][(int) gameObject.getY() + gameObject.getTexture().getImage().getHeight() - 1]
			;
		}
		catch (ArrayIndexOutOfBoundsException e) {
			return true;
		}
	}
	
	@Override
	public void update(long delta) {
		x = 0 - (Game.getInstance().getPlayer().getX() * 3);
		y = 0 - (Game.getInstance().getPlayer().getY() * 3);
	}
	
}
