package task;


import repository.Repository;

import domein.Consequences;
import domein.Pattern;
import domein.Problem;

public class ShowPatternTask {

	private Repository rp = Repository.getInstance();
	
	public String showPatternName(String patternName) {
		Pattern p = rp.getPattern(patternName);
		String is = p.getNaam();
		return is;

	}
	
	public String showPatternDesc(String patternName) {
		Pattern p = rp.getPattern(patternName);
		String is = p.getDescription();
		return is;

	}
	
	public String showPatternProb(String patternName) {
		Pattern p = rp.getPattern(patternName);
		String prob = "";
		
		if (p.getProblems() != null){
			for (Problem pr : p.getProblems()) {
				prob += pr.getProblem();
				}
			}
		
		return prob;

	}
	
	public String showPatternCon(String patternName) {
		Pattern p = rp.getPattern(patternName);
		String cons = "";

		if (p.getConsequences() != null){
		for (Consequences c : p.getConsequences()) {
			cons += c.getConsequence();
			}
		}
		
		return cons;

	}

	public String showPatternImage(String patternName) {
		Pattern p = rp.getPattern(patternName);
		return p.getDiagram().getLocation();
	}
}
