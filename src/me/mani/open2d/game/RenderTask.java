package me.mani.open2d.game;


public class RenderTask implements Runnable {
	
	private Game game;
	
	public RenderTask(Game game) {
		this.game = game;
	}
	
	public RenderTask start() {
		new Thread(this).start();
		return this;
	}
	
	@Override
	public void run() {
		long lastTime = System.currentTimeMillis();
		while (true) {
			lastTime = System.currentTimeMillis();
			if (Game.currentFrame >= 1000)
				Game.currentFrame = 0;
			else
				Game.currentFrame++;
			synchronized (game.getGameObjects()) {
				game.updateAll(System.currentTimeMillis() - lastTime);
				game.getScreen().repaint();
			}
			try {
				Thread.sleep(1000 / 60);
			} catch (InterruptedException e) {
				return;
			}
		}
	}

}
