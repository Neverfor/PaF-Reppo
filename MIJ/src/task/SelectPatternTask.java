package task;

import java.io.InvalidObjectException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.swing.JComboBox;
import javax.swing.JFrame;


import repository.Repository;
import domein.Category;
import domein.Consequences;
import domein.Context;
import domein.Pattern;
import domein.Problem;

public class SelectPatternTask extends JFrame{
	
	private ArrayList<Category> categories = new ArrayList<Category>();
	private ArrayList<Pattern> selectedPatterns = new ArrayList<Pattern>();
	
	public void fillCategoryCombobox(JComboBox<Category> cb){
		Repository rp = Repository.getInstance();
		Set<Category> categories = rp.getCategories();
		
		for (Category category: categories){
			cb.addItem(category);
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
			         System.out.print(iter.next());
			         iter.remove();
			      }
			}
			
			}
		
	
	}
}
