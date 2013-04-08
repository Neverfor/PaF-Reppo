package repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import domein.*;

public class Repository {


	private HashSet<Category> categories = new HashSet<Category>();
	private HashSet<Pattern> patterns = new HashSet<Pattern>();
	private Config config = new Config();
	
	private static Repository _instance = null;
	
	
	private Repository () {
		categories = new HashSet<Category>();
		patterns = new HashSet<Pattern>();
	}
	
	public static Repository getInstance(){
		if (_instance == null){
			createInstance ();
		}
        return _instance;
	}
	
	private synchronized static void createInstance () {
        if (_instance == null) _instance = new Repository ();
    }
	
	/**
	 * Adds category to Repository's list of categories.
	 * @param newCategory
	 * @param parents list with parents
	 */
	public void addCategory(Category newCategory, ArrayList<Category> parents){
		if (parents != null) {
			for (Category category : parents) {
				getCategory(category.getName()).addChild(newCategory);
			}
		}
		if (!this.categories.contains(newCategory)) {
			this.categories.add(newCategory);
		}
	}
	
	/**
	 * Adds pattern to the list of patterns and to his categories
	 * @param newPattern
	 * @param categories list of categories to put the pattern in
	 */
	//TODO: list of patterns might not be needed, filling it as redundant anyway
	public void addPattern(Pattern newPattern, ArrayList<Category> categories){	
		if(!this.patterns.add(newPattern))
			throw new IllegalArgumentException("Pattern was already defined in repository");
		for(Category category: categories){
			if(category.getPatterns().contains(newPattern))
				throw new IllegalArgumentException("Pattern was already part of " + category.getName());
			category.addPattern(newPattern);
		}
	}
	
	/**
	 * Returns all categories
	 * @return Set<Category>
	 */

	public Set<Category> getCategories() {
		return categories; 
	}

	/**
	 * Returns all patterns
	 * @return Set<Pattern>
	 */
	public Set<Pattern> getPatterns() {
		return patterns; 
	}
	
	public Category getCategory(String categoryName) {
		for (Category c : categories) {
			if (c.getName().equals(categoryName)) {
				return c;
			}
		}
		return null;
	}
	
	public PersistenceFactory getPersistanceFactory(){
		Class<?> c = null;
		try {
			c = Class.forName("repository." + config.getPersistanceType() + "Factory");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			return (PersistenceFactory) c.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public Config getConfig() {
		return config;
	}


}


