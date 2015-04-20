package me.mani.open2d.debug;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class Console {
	
	private static JFrame consoleFrame;
	private static JTextArea consoleTextArea;
	
	public Console() {
		consoleFrame = new JFrame("Open2D Console");
		consoleFrame.setSize(640, 320);
		consoleFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		consoleFrame.setLocationByPlatform(true);
		consoleFrame.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 25));
		
		consoleTextArea = new JTextArea(10, 40);
		consoleFrame.getContentPane().add(consoleTextArea);
		
		consoleFrame.setVisible(true);
	}

	public static void log(String message) {
		if (consoleTextArea != null)
			consoleTextArea.setText(consoleTextArea.getText() + message + "\n");
	}
	
}
