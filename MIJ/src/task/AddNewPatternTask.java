package task;

import java.io.InvalidObjectException;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.JComboBox;

import repository.Repository;
import domein.Category;
import domein.Consequences;
import domein.Context;
import domein.Diagram;
import domein.Pattern;
import domein.Problem;

public class AddNewPatternTask{
	Repository rp = Repository.getInstance();
	
	public void fillCategoryCombobox(JComboBox<Object> cbCategories){
		Repository rp = Repository.getInstance();
		Collection<Category> categories = rp.getCategories().values();
		
		for (Category category: categories){
			cbCategories.addItem(category);
		}
		
	}
	
	public Collection<String> getCategories(){
		return rp.getCategories().keySet();
	}
	
	public void fillStaticRepo(){
		Category c1 = new Category("Creational");
		Repository.getInstance().addCategory(c1, null);
		Category c2 = new Category("Behavioral");
		Repository.getInstance().addCategory(c2, null);
		Category c3 = new Category("Class");
		Repository.getInstance().addCategory(c3, null);
		Category c4 = new Category("Object");
		Repository.getInstance().addCategory(c4, null);
		
		Pattern p = new Pattern();
		p.setNaam("Factory Method");
		p.addContext(new Context("Factory Method Context"));
		p.addProblem(new Problem("Factory Method Problem"));
		Diagram d = new Diagram("Factory Method","diagram1.png");
		p.setDiagram(d);
		p.setDescription("Solution");
		p.addConsequence(new Consequences("Consequence","Factory Method Consequence"));
		ArrayList<Category> cate = new ArrayList<Category>();
		cate.add(c1);
		cate.add(c3);
		
		Repository.getInstance().addPattern(p, cate);
		p = new Pattern();
		p.setNaam("Singleton");
		p.addContext(new Context("Create a single object"));
		p.addContext(new Context("Object persists until application persists"));
		d = new Diagram("Singleton","diagram2.png");
		p.setDiagram(d);
		p.setDescription("Singleton description");
		p.addProblem(new Problem("Singleton Problem"));
		p.addConsequence(new Consequences("Consequence","Singleton is B.A.D."));
		cate = new ArrayList<Category>();
		cate.add(c1);
		cate.add(c4);
		
		Repository.getInstance().addPattern(p, cate);
		
		Repository.getInstance().addPattern(p, cate);
		p = new Pattern();
		p.setNaam("State");
		p.addContext(new Context("State context"));
		d = new Diagram("Singleton","http://content.comrz.com/AcuCustom/Sitename/DAM/374/Tux.png");
		p.setDiagram(d);
		p.setDescription("State desc");
		p.addProblem(new Problem("state Problem"));
		p.addConsequence(new Consequences("Consequence","State Consequence"));
		cate = new ArrayList<Category>();
		cate.add(c2);
		cate.add(c4);
		
		Repository.getInstance().addPattern(p, cate);
	}


	public void addPattern(String patternName, String PatternDescription, String selectedCategory,
			ArrayList<String> contexts, ArrayList<String> problems,
			ArrayList<String> consequences,Diagram diagram) throws InvalidObjectException {	
		Repository rp = Repository.getInstance();
		Pattern newPattern = new Pattern();
		newPattern.setDiagram(diagram);
		newPattern.setDescription(PatternDescription);
		
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
		
		ArrayList<Category> categories = new ArrayList<Category>();
		categories.add(rp.getCategory(selectedCategory));
		rp.addPattern(newPattern, categories);
		System.out.println(rp.toString());
	}
	
	
	public void addCategory(String categoryName,ArrayList<Category> parents) throws InvalidObjectException {
		Repository rp = Repository.getInstance();
		Category newCategory = new Category(categoryName);
		rp.addCategory(newCategory, parents);
	}
}
