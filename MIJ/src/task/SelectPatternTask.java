package task;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import repository.Repository;
import userinterface.SelectPatternPanel;
import domein.Category;
import domein.Context;
import domein.Pattern;
import domein.Problem;

public class SelectPatternTask{
	
	private ArrayList<Category> categories = new ArrayList<Category>();
	private ArrayList<Pattern> selectedPatterns = new ArrayList<Pattern>();
	private Repository rp = Repository.getInstance();
	
	public void fillCategoryCombobox(JComboBox<Object> cbCategory){
		
		Set<Category> categories = rp.getCategories();
		
		for (Category category: categories){
			cbCategory.addItem(category);
		}
		
	}
	
	public void selectPattern(String category)  {	
		for (Category c : categories) {
			if(c.getName().equalsIgnoreCase(category)){
				HashSet hSet = new HashSet();
				hSet = c.getPatterns();
				Iterator iter = hSet.iterator();
				 while(iter.hasNext()) 
			      {	
//					 hSet.getClass().getName();
			         System.out.print(iter.next());
			         iter.remove();
			      }
			}
			
			}
		
	
	}

	public void fillContexts(JComboBox<Object> cbContext, Object selectedCategory) {
		cbContext.removeAllItems();
		if(selectedCategory instanceof Category){
			for(Context context: ((Category)selectedCategory).getContexts()){
				cbContext.addItem(context);
			}

		}
	}

	public void fillProblems(JComboBox<Object> cbProblem, Object selectedContext) {
		cbProblem.removeAllItems();
		Set<Pattern> patterns = rp.getPatterns();
		for(Pattern pattern: patterns){
			if(!(pattern.getContext().isEmpty()) && pattern.getContext().get(0).equals(selectedContext)){
				for(Problem problem: pattern.getProblems()){
					cbProblem.addItem(problem);
				}
			}
		}
		
	}

	public ArrayList<String[]> getResults(Object selectedItem, Object selectedContext,
			Object selectedProblem) {
		Set<Pattern> patterns = rp.getPatterns();
		ArrayList<String[]> rtrnList = new ArrayList<String[]>();
		String[] p = new String[2];
		for(Pattern pattern: patterns){
			if(!(pattern.getContext().isEmpty()) && pattern.getContext().get(0).equals(selectedContext) && pattern.getProblems().contains(selectedProblem)){
				p[0] =  pattern.getNaam();
				p[1] = pattern.getDescription();
				rtrnList.add(p);
			}
		}
		return rtrnList;
	}

	public void showPattern(String patternName) {
		ArrayList<Pattern> pp = new ArrayList<Pattern>();
		for (Category c : categories) {
			pp = c.getPattern(patternName); 
			for (Pattern p: pp){
				p.getNaam();
				p.getConsequences();
				p.getDescription();
				p.getContext();
				System.out.println("Name" + p.getNaam() + " Description : " +  p.getDescription());
			}
		}
		
	}
}
