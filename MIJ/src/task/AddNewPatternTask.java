package task;

import java.io.InvalidObjectException;
import java.util.ArrayList;
import java.util.Set;

import javax.swing.JComboBox;

import repository.Repository;
import domein.Category;
import domein.Consequences;
import domein.Context;
import domein.Pattern;
import domein.Problem;

public class AddNewPatternTask{
	
	public void fillCategoryCombobox(JComboBox<Object> cbCategories){
		Repository rp = Repository.getInstance();
		Set<Category> categories = rp.getCategories();
		
		for (Category category: categories){
			cbCategories.addItem(category);
		}
		
	}

	public void addPattern(String patternName, String PatternDescription, Object selectedCategory,
			ArrayList<String> contexts, ArrayList<String> problems,
			ArrayList<String> consequences) throws InvalidObjectException {	
		Repository rp = Repository.getInstance();
		Pattern newPattern = new Pattern();
		//TODO: selectedCategory should be an list of categories
		if(!(selectedCategory instanceof Category)){
			throw new InvalidObjectException("Category expected");
		}
		
		ArrayList<Consequences> patternConsequences = new ArrayList<Consequences>();
		for(String consequence: consequences){
			patternConsequences.add(new Consequences("Consequence", consequence));
		}
		newPattern.setConsequences(patternConsequences);
		
		ArrayList<Problem> patternProblems = new ArrayList<Problem>();
		for(String problem: problems){
			patternProblems.add(new Problem(problem));
		}
		newPattern.setProblems(patternProblems);
		
		newPattern.setNaam(patternName);
		newPattern.setContext(new Context(contexts.get(0)));
		ArrayList<Category> categories = new ArrayList<Category>();
		categories.add((Category)selectedCategory);
		rp.addPattern(newPattern, categories);
		System.out.println(rp.toString());
	}
}
