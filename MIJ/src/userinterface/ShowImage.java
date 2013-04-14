package userinterface;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.activation.MimetypesFileTypeMap;
import javax.imageio.ImageIO;
import javax.swing.*;

public class ShowImage extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5307274207587321866L;
	BufferedImage img;

	public ShowImage(String location) throws MalformedURLException, IOException {
		super();
		if(location.matches("^http.*")){
	        this.img = ImageIO.read(new URL(location));
		}else{
        File f = new File(location);
        String mimetype= new MimetypesFileTypeMap().getContentType(f);
        String type = mimetype.split("/")[0];
        System.out.println(type);
        this.img = ImageIO.read(f);
		}
		//img = ImageIO.read(new URL("http://www.google.com/images/nav_logo4.png"));
		//img = Toolkit.getDefaultToolkit().getImage(location); //getImage(location);
	}

	public void paintComponent(Graphics g) {
		// Teken image
		g.drawImage(img, 0, 0, 150, 150, this);
		setSize(200, 200);
	}
}