package me.mani.open2d.game;

import java.awt.Color;
import java.awt.Graphics;

public class Arrow extends GameObject {

	private int size = 10;
	private double rotation;
	
	public Arrow(double x, double y, double rotation) {
		super(Texture.loadBlankTexture(6, 6), x, y);
		this.rotation = rotation;
	}
	
	@Override
	public void update(long delta) {
		x += Math.cos(Math.toRadians(rotation)) * 4;
		y += Math.sin(Math.toRadians(rotation)) * 4;
		if (size <= 0 || x < 0 || x > Game.getInstance().getScreen().getWidth() || y < 0 || y > Game.getInstance().getScreen().getHeight())
			destroy();
		if (Game.getInstance().getMap().checkCollision(this))
			size--;
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(Color.RED);
		g.drawOval((int) x - size / 2, (int) y - size / 2, size, size);
	}
	
	public void destroy() {
		Game.getInstance().unregisterObject(this);
	}
	
}
