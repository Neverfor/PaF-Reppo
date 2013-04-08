package task;

import repository.Reader;
import repository.Repository;
import repository.Writer;

public class PersistanceTasks {
	Repository rep; 
	
	public PersistanceTasks(){
		rep = Repository.getInstance();
	}
	
	public boolean doExport(String location){
		Writer wr = rep.getPersistanceFactory().createWriter();
		return wr.save(location);
	}
	
	public String getDefaultOutputLocation(){
		return rep.getConfig().getDefaultOutputLocation();
	}
	
	public void setDefaultOutputLocation(String location){
		rep.getConfig().setDefaultOutputLocation(location);
	}
	
	public boolean doImport(String location){
		Reader rr = rep.getPersistanceFactory().createReader();
		return rr.open(location);
	}
	
	public String getPersistanceType(){
		return rep.getConfig().getPersistanceType();
	}
	
	public void setPersistanceType(String pt){
		rep.getConfig().setPersistanceType(pt);
	}
}
