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
	
	/*public void fillStaticRepo(){
		Category c = new Category("Creational");
		Repository.getInstance().addCategory(c, null);
		c = new Category("Class");
		Repository.getInstance().addCategory(c, null);
		Category c3 = new Category("child of class");
		Repository.getInstance().addCategory(c3, null);
		c.addChild(c3);
		Pattern p = new Pattern();
		p.setNaam("Factory Method");
		p.addContext(new Context("Context for test!"));
		p.addContext(new Context("Context2 for test!"));
		p.addProblem(new Problem("Problem test"));
		p.addConsequence(new Consequences("Consequence","jwh"));
		ArrayList<Category> cate = new ArrayList<Category>();
		cate.add(c);
		
		Repository.getInstance().addPattern(p, cate);
	}*/

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
		newPattern.addContext(new Context(contexts.get(0)));
		((Category)selectedCategory).addContext(newPattern.getContext().get(0));
		ArrayList<Category> categories = new ArrayList<Category>();
		categories.add((Category)selectedCategory);
		rp.addPattern(newPattern, categories);
		System.out.println(rp.toString());
	}
	
	
	public void addCategory(String categoryName,ArrayList<Category> parents) throws InvalidObjectException {
		Repository rp = Repository.getInstance();
		Category newCategory = new Category(categoryName);
		rp.addCategory(newCategory, parents);
	}
}
