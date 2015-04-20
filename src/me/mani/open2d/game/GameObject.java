package me.mani.open2d.game;

import java.awt.Graphics;

public class GameObject {
	
	protected double x, y;
	private Texture texture;

	public GameObject(Texture texture) {
		this(texture, 0, 0);
	}
	
	public GameObject(Texture texture, double x, double y) {
		this.x = x;
		this.y = y;
		this.texture = texture;
	}
	
	public void update(long delta) {}
	
	public void draw(Graphics g) {
		g.drawImage(texture.getImage(), (int) x, (int) y, null);
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public Texture getTexture() {
		return texture;
	}

}
