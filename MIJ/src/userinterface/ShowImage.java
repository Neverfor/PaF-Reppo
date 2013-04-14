package userinterface;

import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import javax.swing.*;

public class ShowImage extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5307274207587321866L;
	Image img;

	public ShowImage(String location) throws MalformedURLException, IOException {
		super();
		//img = ImageIO.read(new URL("http://www.google.com/images/nav_logo4.png"));
		img = Toolkit.getDefaultToolkit().getImage(location); //getImage(location);
	}

	public void paintComponent(Graphics g) {
		// Teken image
		g.drawImage(img, 0, 0, img.getWidth(this), img.getHeight(this), this);
	}
}