package me.mani.open2d;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import me.mani.open2d.game.Game;

public class Launcher {
	
	private JFrame launcherFrame;
	
	public Launcher() {
		launcherFrame = new JFrame("Open2D Launcher");
		launcherFrame.setSize(640, 320);
		launcherFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		launcherFrame.setLocationByPlatform(true);
		launcherFrame.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 25));
		
		JLabel titleLabel = new JLabel("Open 2D");
		titleLabel.setFont(new Font("Verdana", Font.PLAIN, 128));
		launcherFrame.getContentPane().add(titleLabel);
		JTextField nameChooseTextField = new JTextField(16);
		launcherFrame.getContentPane().add(nameChooseTextField);
		JButton submitButton = new JButton("Launch game");
		submitButton.addActionListener((ev) -> initGame(nameChooseTextField.getText()));
		launcherFrame.getContentPane().add(submitButton);
		
		launcherFrame.setVisible(true);
	}
	
	private void initGame(String playerName) {
		new Game(playerName).start();
		launcherFrame.dispose();
	}

}
