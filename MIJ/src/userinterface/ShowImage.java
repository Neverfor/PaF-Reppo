package userinterface;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;

public class ShowImage extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5307274207587321866L;
	BufferedImage img;

	public ShowImage(String location) throws MalformedURLException, IOException {
		if (location.matches("^http.*")) {
			this.img = ImageIO.read(new URL(location));
		} else if (location.equals("")){
			img = new BufferedImage(100, 100, BufferedImage.TYPE_INT_BGR);
		}else {
			File f = new File(location);
			this.img = ImageIO.read(f);
		}
	}

	public void paintComponent(Graphics g) {
		// Teken image
		this.removeAll();
		g.drawImage(img, 0, 0, 100, 100, this);
		setSize(100, 100);
	}
}