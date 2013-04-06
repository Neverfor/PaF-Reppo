package domein;


import java.util.ArrayList;

public class Pattern {
	private String naam;
	private ArrayList<Context> context = new ArrayList<Context>();
	private Diagram diagram;
	private ArrayList<Consequences> consequences = new ArrayList<Consequences>();
	private ArrayList<Problem> problems = new ArrayList<Problem>();
	
	public Pattern (){}

	
	public Pattern(String naam, Diagram diagram) {
		this.naam = naam;
		this.diagram = diagram;

	}


	public String getNaam() {
		return naam;
	}


	public void setNaam(String naam) {
		this.naam = naam;
	}


	public ArrayList<Context> getContext() {
		return context;
	}


	public void setContext(ArrayList<Context> context) {
		this.context = context;
	}


	public void addContext(Context context) {
		this.context.add(context);
	}


	public void addProblem(Problem problem) {
		this.problems.add(problem);
	}


	public void addConsequence(Consequences consequences) {
		this.consequences.add(consequences);
	}


	public Diagram getDiagram() {
		return diagram;
	}


	public void setDiagram(Diagram diagram) {
		this.diagram = diagram;
	}


	public ArrayList<Consequences> getConsequences() {
		return consequences;
	}


	public void setConsequences(ArrayList<Consequences> consequences) {
		this.consequences = consequences;
	}


	public ArrayList<Problem> getProblems() {
		return problems;
	}


	public void setProblems(ArrayList<Problem> problems) {
		this.problems = problems;
	}


	public String getDescription() {
		//TODO: dit
		return "";
		
	}
}
