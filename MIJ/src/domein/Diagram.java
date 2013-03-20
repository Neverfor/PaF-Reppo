package domein;

import java.awt.Image;

public class Diagram {
	
	private String naam;
	private Image img;
	
	public Diagram (String naam, Image img) {
		this.naam = naam;
		this.img = img;

	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}
}
