package domein;

public class Problem {
	
	private String problem;
	
	public Problem (String problem) {
		this.problem = problem;
	}
	
	public String getProblem(){
		return problem;
	}
	
	public void setProblem(String Pr) {
		this.problem = Pr;
	}
	
	public String toString(){
		return problem;
	}
}
