package com.mgrimm21.elude;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Sprite {
	
	private BufferedImage image;
	
	public Sprite(String file) {
		try {
			image = ImageIO.read(new File(file));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Sprite(int r, int g, int b) {
		image = new BufferedImage(r, g, b);
	}
	
	public void render(int x, int y, Graphics g) {
		g.drawImage(image, x, y, null);
	}
	
	public int getWidth() {
		return image.getWidth();
	}
	
	public int getHeight() {
		return image.getHeight();
	}

}
