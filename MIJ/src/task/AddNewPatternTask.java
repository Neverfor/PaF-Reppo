package task;

import java.util.Set;

import javax.swing.JComboBox;
import javax.swing.JFrame;

import repository.Repository;
import domein.Category;

public class AddNewPatternTask extends JFrame{
	
	public void fillCategoryCombobox(JComboBox<Category> cb){
		Repository rp = Repository.getInstance();
		Set<Category> categories = rp.getCategories();
		
		for (Category category: categories){
			cb.addItem(category);
		}
		
	}
}
