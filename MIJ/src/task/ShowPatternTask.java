package task;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
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

public class ShowPatternTask{
	
	private ArrayList<Category> categories = new ArrayList<Category>();
	private ArrayList<Pattern> selectedPatterns = new ArrayList<Pattern>();
	private Repository rp = Repository.getInstance();		

	public Collection<String> getCategories(){
		return rp.getCategories().keySet();
	}


	public String showPatternInfo(String patternName) {
		String s = " DOG";
		int i = 0;
		for (Pattern p : selectedPatterns){
			if (p.getNaam() == patternName) {
				i = i++;
//				s += "\n " + i + " result" + p.getNaam() + "  \n consequences: " + p.getConsequences() + " \n context: " + p.getContext();
			}
		}
		return s;
	}

	
	
//	public void showPattern(String patternName) {
//		HashSet<Pattern> patterns = new HashSet<Pattern>();
//		for (Category c : categories) {  
//			for (Pattern p: patterns){
//				p.getNaam();
//				p.getConsequences();
//				p.getDescription();
//				p.getContext();
//				System.out.println("Name" + p.getNaam() + " Description : " +  p.getDescription());
//				
//			}
//		}
//	}
}
