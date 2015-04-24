package me.mani.open2d.game.map;

import me.mani.open2d.Collision;
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
	
	public Collision checkCollision(GameObject gameObject) {
		try {
			if (
					// Top Left
					blockedLocations[(int) gameObject.getX()][(int) gameObject.getY()] ||
					// Top Right
					blockedLocations[(int) gameObject.getX() + gameObject.getTexture().getImage().getWidth() - 1][(int) gameObject.getY()] ||
					// Bottom Right
					blockedLocations[(int) gameObject.getX() + gameObject.getTexture().getImage().getWidth() - 1][(int) gameObject.getY() + gameObject.getTexture().getImage().getHeight() - 1] ||
					// Bottom Left
					blockedLocations[(int) gameObject.getX()][(int) gameObject.getY() + gameObject.getTexture().getImage().getHeight() - 1]
			) {
				if (blockedLocations[(int) gameObject.getX() + 1][(int) gameObject.getY()] && blockedLocations[(int) gameObject.getX() + gameObject.getTexture().getImage().getWidth() - 2][(int) gameObject.getY()])
					return Collision.TOP;
				if (blockedLocations[(int) gameObject.getX() + gameObject.getTexture().getImage().getWidth() - 1][(int) gameObject.getY() + 1] && blockedLocations[(int) gameObject.getX() + gameObject.getTexture().getImage().getWidth() - 1][(int) gameObject.getY() + gameObject.getTexture().getImage().getHeight() - 2])
					return Collision.RIGHT;
				if (blockedLocations[(int) gameObject.getX() + 1][(int) gameObject.getY() + gameObject.getTexture().getImage().getHeight() - 1] && blockedLocations[(int) gameObject.getX() + gameObject.getTexture().getImage().getWidth() - 2][(int) gameObject.getY() + gameObject.getTexture().getImage().getHeight() - 1])
					return Collision.BOTTOM;
				if (blockedLocations[(int) gameObject.getX()][(int) gameObject.getY() + gameObject.getTexture().getImage().getHeight() - 2] && blockedLocations[(int) gameObject.getX()][(int) gameObject.getY() + 1])
					return Collision.LEFT;
				return Collision.UNKNOWN;
			}
		}
		catch (ArrayIndexOutOfBoundsException e) {}
		return Collision.NONE;
	}
	
//	@Override
//	public void update(long delta) {
//		x = 0 - (Game.getInstance().getPlayer().getX() * 3);
//		y = 0 - (Game.getInstance().getPlayer().getY() * 3);
//	}
	
}
