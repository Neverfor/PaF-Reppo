package repository;

import java.util.ArrayList;
import java.util.HashSet;

import domein.*;

public class Repository {


	private HashSet<Category> categories;
	private HashSet<Pattern> patterns;
	private PersistenceFactory persistenceType;
	
	/**
	 * Adds category to Repository's list of categories.
	 * @param newCategory
	 * @param parents list with parents
	 */
	public void addCategory(Category newCategory, ArrayList<Category> parents){
		if(parents != null){
			for(Category category: this.categories){
				//TODO: to get this contains() working we might need to override the equals() of Category, not tested yet
				if(!parents.contains(category)) 
					throw new IllegalArgumentException("Parent category not found in repository");				
				category.addChild(newCategory);
			}
		}else{
			this.categories.add(newCategory);
		}
	}
	
	/**
	 * Adds pattern to the list of patterns and to his categories
	 * @param newPattern
	 * @param categories list of catogies to put the pattern in
	 */
	//TODO: list of patterns might not be needed, filling it as redounded anyway
	public void addPattern(Pattern newPattern, ArrayList<Category> categories){	
		if(!this.patterns.add(newPattern))
			throw new IllegalArgumentException("Pattern was already defined in repository");
		for(Category category: categories){
			if(category.getPatterns().contains(newPattern))
				throw new IllegalArgumentException("Pattern was already part of " + category.getName());
			category.addPattern(newPattern);
		}
	}
}
