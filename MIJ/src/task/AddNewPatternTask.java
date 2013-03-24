package task;

import java.util.Set;

import javax.swing.JComboBox;

import repository.Repository;
import domein.Category;

public class AddNewPatternTask{
	
	public void fillCategoryCombobox(JComboBox<Object> cbCategories){
		Repository rp = Repository.getInstance();
		Set<Category> categories = rp.getCategories();
		
		for (Category category: categories){
			cbCategories.addItem(category);
		}
		
	}
}
