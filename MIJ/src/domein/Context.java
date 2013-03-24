package domein;

public class Context {
	
	public Context(String string) {
		this.context = string;
	}

	private String context;

	
	public String toString(){
		return context;
	}
	
	public boolean equals(Object o){
		if(o instanceof Context){
			if( ((Context)o).toString().equals(this.toString())){
				return true;
			}
		}
		return false;
	}
}
