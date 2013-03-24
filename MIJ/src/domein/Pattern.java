package domein;


import java.util.ArrayList;

public class Pattern {
	private String naam;
	private Context context;
	private Diagram diagram;
	private ArrayList<Consequences> consequences = new ArrayList<Consequences>();
	private ArrayList<Problem> problems = new ArrayList<Problem>();
	
	public Pattern (){}

	
	public Pattern(String naam, Context context, Diagram diagram) {
		this.naam = naam;
		this.context = context;
		this.diagram = diagram;

	}


	public String getNaam() {
		return naam;
	}


	public void setNaam(String naam) {
		this.naam = naam;
	}


	public Context getContext() {
		return context;
	}


	public void setContext(Context context) {
		this.context = context;
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
}
