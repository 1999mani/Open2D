package me.mani.open2d.game;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import me.mani.open2d.debug.Console;

public class Texture {
	
	private BufferedImage bufferedImage;
	
	private Texture(BufferedImage bufferedImage) {
		this.bufferedImage = bufferedImage;
	}
	
	public BufferedImage getImage() {
		return bufferedImage;
	}
	
	public static Texture loadTexture(String filePath) {
		try {
			return new Texture(ImageIO.read(new File(filePath)));
		} catch (IOException e) {
			Console.log("Ressource leak: " + filePath + " cannot be read.");
			return null;
		}
	}
	
	public static Texture loadBlankTexture(int width, int height) {
		return new Texture(new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB));
	}
	
}
