package domein;

import java.awt.*;

import javax.swing.*;

public class Diagram extends JPanel {
	
	private String naam;
	private String directory;
	private Image img;
	
	public Diagram (String naam, String dir, Image img) {
		this.directory = dir;
		this.naam = naam;
		this.img = Toolkit.getDefaultToolkit().getImage(dir);

	}
	
	public void paintComponent(Graphics g){
		 g.drawImage(img,50,10,200,200, this); // locatie 50, 10 en breedte + hoogte 200 x 200
		}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

//	@Override
//	public boolean imageUpdate(Image arg0, int arg1, int arg2, int arg3,
//			int arg4, int arg5) {
//		// TODO Auto-generated method stub
//		return false;
//	}
}
