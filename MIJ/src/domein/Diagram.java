package domein;

import java.awt.*;
import java.io.File;

import javax.activation.MimetypesFileTypeMap;
import javax.swing.*;

public class Diagram extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2447333907698791408L;
	private String naam;
	private String directory;
	private Image img;
	
	public Diagram (String naam, String dir) {
		this.directory = dir;
		this.naam = naam;
        File f = new File(dir);
        String mimetype= new MimetypesFileTypeMap().getContentType(f);
        String type = mimetype.split("/")[0];
        if(type.equals("image")){
			this.img = Toolkit.getDefaultToolkit().getImage(dir);
		}

	}
	
	@Override
	public void paintComponent(Graphics g){
		 g.drawImage(img,50,10,200,200, this); // locatie 50, 10 en breedte + hoogte 200 x 200
		}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}
	
	public String getDirectory() {
		return directory;
	}

	public void setDirectory(String directory) {
		this.directory = directory;
	}

//	@Override
//	public boolean imageUpdate(Image arg0, int arg1, int arg2, int arg3,
//			int arg4, int arg5) {
//		// TODO Auto-generated method stub
//		return false;
//	}
}
