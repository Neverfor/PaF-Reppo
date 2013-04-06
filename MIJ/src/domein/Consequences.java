package domein;

public class Consequences {
	
	private String consequenceType;
	private String consequence;
	
	public Consequences (String type, String consequence) {
		this.consequenceType = type;
		this.consequence = consequence;
	}
	
	public String getConsequenceType(){
		return consequenceType;
	}
	
	public String getConsequence(){
		return consequence;
	}

}
