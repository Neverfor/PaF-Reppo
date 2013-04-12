package task;

import java.util.ArrayList;
import java.util.Collection;

import repository.Repository;

import domein.Category;
import domein.Consequences;
import domein.Context;
import domein.Pattern;
import domein.Problem;

public class SelectPatternTask{
	
	private ArrayList<Category> categories = new ArrayList<Category>();
	private ArrayList<Pattern> selectedPatterns = new ArrayList<Pattern>();
	private Repository rp = Repository.getInstance();
	public static String newline = System.getProperty("line.separator");

	public Collection<String> getCategories(){
		return rp.getCategories().keySet();
	}
	
	public Collection<String> getContexts(String selectedCategory){		
		ArrayList<String> coll = new ArrayList<String>();
		Collection<Pattern> patterns;
		//get patterns from selected cat, else get all patterns
		if(rp.getCategory(selectedCategory) == null){
			patterns = rp.getPatterns().values();
		}
		else{
			patterns = rp.getCategory(selectedCategory).getPatterns();
			//add contexts from subcategory
			if(rp.getCategory(selectedCategory).hasChilderen()){
				for(Category category: rp.getCategory(selectedCategory).getChilds()){
					coll.addAll(getContexts(category.getName()));
				}
			}
		}
		for(Pattern pattern: patterns){
			for(Context context: pattern.getContext())
				coll.add(context.toString());
		}
		return coll;
	}
	
	public Collection<String> getProblems(String selectedCategory, String selectedContext){	
		ArrayList<String> coll = new ArrayList<String>();
		Collection<Pattern> patterns;
		if(rp.getCategory(selectedCategory) == null){
			patterns = rp.getPatterns().values();		
		}else{
			patterns = rp.getCategory(selectedCategory).getPatterns();
			if(rp.getCategory(selectedCategory).hasChilderen()){
				for(Category category: rp.getCategory(selectedCategory).getChilds()){
					coll.removeAll(getProblems(category.getName(), selectedContext));
					coll.addAll(getProblems(category.getName(), selectedContext));
				}
			}
		}
		for(Pattern pattern: patterns){
			if(pattern.getContext() == null || 
					pattern.getContext().contains(new Context(selectedContext)) || selectedContext == null || selectedContext.isEmpty())			
				for(Problem problem: pattern.getProblems())
					if(!coll.contains(problem.toString()))
						coll.add(problem.toString());
		}		
		return coll;
	}

	public ArrayList<String[]> getPatterns(String selectedCategory, String selectedContext, String selectedProblem) {
		ArrayList<String[]> rtrnList = new ArrayList<String[]>();
		Collection<Pattern> patterns;
		if(rp.getCategory(selectedCategory) == null){
			patterns = rp.getPatterns().values();		
		}else{
			patterns = rp.getCategory(selectedCategory).getPatterns();
			if(rp.getCategory(selectedCategory).hasChilderen()){
				for(Category category: rp.getCategory(selectedCategory).getChilds()){
					patterns.removeAll(category.getPatterns());
					patterns.addAll(category.getPatterns());
				}
			}
		}
				
		for(Pattern pattern: patterns){
			String[] p = new String[2];
			if((pattern.getContext().contains(new Context(selectedContext)) || selectedContext.isEmpty())
					&& (pattern.getProblems().contains(new Problem(selectedProblem)) || selectedProblem.isEmpty())){
				p[0] =  pattern.getNaam();
				p[1] = pattern.getDescription();
				rtrnList.add(p);
			}
		}
		return rtrnList;
	}



	public String showPattern(String patternName) {
		ArrayList<Pattern> pp = new ArrayList<Pattern>();
		Pattern p = rp.getPattern(patternName);
		String is = "";
	
		//test in system ------>>>
		System.out.println("Name" + p.getNaam() + " "  );
		//<<<------ end of the test
		is += " Name" + p.getNaam();
		return is;

	}
	
	public String showPatternDesc(String patternName) {
		ArrayList<Pattern> pp = new ArrayList<Pattern>();
		Pattern p = rp.getPattern(patternName);
		String is = "";
	
		//test in system ------>>>
		System.out.println("  " + " Description : " + p.getDescription() );
		//<<<------ end of the test
		is += " " + " Description : " + p.getDescription();
		return is;

	}
	
	public String showPatternProb(String patternName) {
		ArrayList<Pattern> pp = new ArrayList<Pattern>();
		Pattern p = rp.getPattern(patternName);
		String is = "";
		String prob = "";
		
		if (p.getProblems() != null){
			for (Problem pr : p.getProblems()) {
				prob += pr.getProblem();
				}
			}
		
		//test in system ------>>>
		System.out.println(" Problems: " + prob );
		//<<<------ end of the test
		is += " " + " Problems : " + prob;
		return is;

	}
	
	public String showPatternCon(String patternName) {
		ArrayList<Pattern> pp = new ArrayList<Pattern>();
		Pattern p = rp.getPattern(patternName);
		String is = "";
		String cons = "";

		if (p.getConsequences() != null){
		for (Consequences c : p.getConsequences()) {
			cons += c.getConsequence();
			}
		}

		//test in system ------>>>
		System.out.println("Name" + p.getNaam() + newline + " Description : "
				+ p.getDescription() + cons);
		//<<<------ end of the test
		is += " " + " Consequences : " + cons;
		return is;

	}
	
}
