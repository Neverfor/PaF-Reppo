package repository;

public class Config {
	public String persistanceType;
	public String defaultOutputLocation;
	
	public Config(){
		persistanceType = "XML";
		defaultOutputLocation = System.getProperty("user.home");
	}
	
	
	public String getPersistanceType() {
		return persistanceType;
	}
	public void setPersistanceType(String persistanceType) {
		this.persistanceType = persistanceType;
	}
	public String getDefaultOutputLocation() {
		return defaultOutputLocation;
	}
	public void setDefaultOutputLocation(String outputLocation) {
		this.defaultOutputLocation = outputLocation;
	}
}
