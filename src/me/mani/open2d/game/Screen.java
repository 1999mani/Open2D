package me.mani.open2d.game;

import java.awt.Graphics;

import javax.swing.JFrame;

public class Screen extends JFrame {

	private static final long serialVersionUID = -8792091669104912174L;
		
	private Game game;
	
	public Screen(Game game) {
		super("Open2D");
		
		this.game = game;
		
		setSize(920, 720);
		setLocationByPlatform(true);
		InputListener inputListener = new InputListener();
		addKeyListener(inputListener);
		addMouseListener(inputListener);
		addMouseMotionListener(inputListener);
		
		setVisible(true);
	}
	
	@Override
	public void paint(Graphics g) {
		game.drawAll(g);
	}

}
