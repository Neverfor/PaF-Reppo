package domein;

public class Diagram {
	
	private String naam;
	private String location;
	
	public Diagram (String naam, String location) {
		this.location = location;
		this.naam = naam;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}
	
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
}
