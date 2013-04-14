package repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import domein.Category;
import domein.Pattern;

public class Repository {


	private Map<String, Category> categories;
	private Map<String, Pattern> patterns;
	private Config config = new Config();
	
	private static Repository _instance = null;
	
	
	private Repository () {
		categories = new HashMap<String, Category>();
		patterns = new HashMap<String, Pattern>();
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
		if (!this.categories.containsKey(newCategory.getName())) {
			this.categories.put(newCategory.getName(),newCategory);
		}
	}
	
	/**
	 * Adds pattern to the list of patterns and to his categories
	 * @param newPattern
	 * @param categories list of categories to put the pattern in
	 */
	//TODO: list of patterns might not be needed, filling it as redundant anyway
	public void addPattern(Pattern newPattern, ArrayList<Category> categories){	
		if(this.patterns.containsKey(newPattern.getNaam()))
			throw new IllegalArgumentException("Pattern was already defined in repository");
		this.patterns.put(newPattern.getNaam(), newPattern);
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

	public Map<String, Category> getCategories() {
		return categories; 
	}

	/**
	 * Returns all patterns
	 * @return Set<Pattern>
	 */
	public Map<String, Pattern> getPatterns() {
		return patterns; 
	}
	
	public Category getCategory(String categoryName) {
		return categories.get(categoryName);
	}
	
	public Pattern getPattern(String patternName) {
		return patterns.get(patternName);
	}
	
	public PersistenceFactory getPersistanceFactory(){
		Class<?> c = null;
		try {
			c = Class.forName("repository." + config.getPersistanceType() + "Factory");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			return (PersistenceFactory) c.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void clear(){
		patterns.clear();
		categories.clear();
	}
	
	public Config getConfig() {
		return config;
	}


}


