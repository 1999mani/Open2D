package me.mani.open2d.game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.HashSet;
import java.util.Set;

public class InputListener implements KeyListener, MouseListener, MouseMotionListener {

	private static Set<KeyControlable> keyControlables = new HashSet<>();
	private static Set<MouseControlable> mouseControlables = new HashSet<>();
	
	@Override
	public void keyPressed(KeyEvent ev) {
		keyControlables.forEach((controlable) -> controlable.onKeyToggle(ev.getKeyCode(), true));
	}

	@Override
	public void keyReleased(KeyEvent ev) {
		keyControlables.forEach((controlable) -> controlable.onKeyToggle(ev.getKeyCode(), false));
	}

	@Override
	public void keyTyped(KeyEvent ev) {}

	@Override
	public void mouseClicked(MouseEvent ev) {}

	@Override
	public void mouseEntered(MouseEvent ev) {}

	@Override
	public void mouseExited(MouseEvent ev) {}

	@Override
	public void mousePressed(MouseEvent ev) {
		mouseControlables.forEach((controlable) -> controlable.onMouseToggle(ev.getX(), ev.getY(), true));
	}

	@Override
	public void mouseReleased(MouseEvent ev) {
		mouseControlables.forEach((controlable) -> controlable.onMouseToggle(ev.getX(), ev.getY(), false));
	}
	
	@Override
	public void mouseDragged(MouseEvent ev) {
		mouseControlables.forEach((controlable) -> controlable.onMouseMove(ev.getX(), ev.getY()));
	}

	@Override
	public void mouseMoved(MouseEvent ev) {
		mouseControlables.forEach((controlable) -> controlable.onMouseMove(ev.getX(), ev.getY()));
	}
	
	public static void registerKey(KeyControlable controlable) {
		keyControlables.add(controlable);
	}
	
	public static void registerMouse(MouseControlable controlable) {
		mouseControlables.add(controlable);
	}

}
