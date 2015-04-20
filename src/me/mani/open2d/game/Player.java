package me.mani.open2d.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Player extends GameObject implements KeyControlable, MouseControlable {

	private boolean isMovingUp, isMovingDown, isMovingLeft, isMovingRight, isShooting;
	private int mouseX, mouseY;
	
	public Player() {
		super(Texture.loadTexture("media/player.png"), 10, 10);
		InputListener.registerKey(this);
		InputListener.registerMouse(this);
	}

	@Override
	public void update(long delta) {
		for (int i = 0; i <= 1; i++) {
			if (isMovingUp) {
				y--;
				if (Game.getInstance().getMap().checkCollision(this))
					y++;
			}
			if (isMovingDown) {
				y++;
				if (Game.getInstance().getMap().checkCollision(this))
					y--;
			}
			if (isMovingLeft) {
				x--;
				if (Game.getInstance().getMap().checkCollision(this))
					x++;
			}
			if (isMovingRight) {
				x++;
				if (Game.getInstance().getMap().checkCollision(this))
					x--;
			}
		}
		if (isShooting)
			Game.getInstance().registerObject(new Arrow(
				x + getTexture().getImage().getWidth() / 2,
				y + getTexture().getImage().getHeight() / 2,
				Math.atan2(mouseY - y, mouseX - x) * 180 / Math.PI)
			);
	}
	
	@Override
	public void draw(Graphics g) {
		super.draw(g);
		int width = g.getFontMetrics().stringWidth(Game.getInstance().getPlayerName());
		int x = (int) (this.x + getTexture().getImage().getWidth() / 2 - width / 2);
		g.setColor(Color.WHITE);
		g.drawString(Game.getInstance().getPlayerName(), x + 1, (int) y - 5);
		g.setColor(Color.BLUE);		
		g.drawString(Game.getInstance().getPlayerName(), x, (int) y - 5);
	}
	
	@Override
	public void onKeyToggle(int keyCode, boolean down) {
		switch (keyCode) {
		case KeyEvent.VK_W:
			isMovingUp = down;
			break;
		case KeyEvent.VK_S:
			isMovingDown = down;
			break;
		case KeyEvent.VK_A:
			isMovingLeft = down;
			break;
		case KeyEvent.VK_D:
			isMovingRight = down;
			break;
		}
	}

	@Override
	public void onMouseToggle(int x, int y, boolean down) {
		isShooting = down;
	}

	@Override
	public void onMouseMove(int x, int y) {
		mouseX = x;
		mouseY = y;
	}

}
