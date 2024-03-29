
package domein;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Category {
	private HashSet<Pattern> patterns;
	private String name;
	private HashSet<Category> childs;
	private Set<Context> contexts;
	
	public Category(){}
	
	public Category(String categoryName) {
		this.name = categoryName;
		patterns = new HashSet<Pattern>();
		childs = new HashSet<Category>();
		contexts = new HashSet<Context>();
	}
	/**
	 * @return the patterns
	 */
	public HashSet<Pattern> getPatterns() {
		return patterns;
	}
	/**
	 * @param patterns the patterns to set
	 */
	public void setPatterns(HashSet<Pattern> patterns) {
		this.patterns = patterns;
	}
	
	/**
	 * 
	 * @param name of the patterns to get all patterns with the same name
	 * @return
	 */
	public ArrayList<Pattern> getPattern(String name) {
		ArrayList<Pattern> pat = new ArrayList<Pattern>();
		for (Pattern p: patterns){
			if(p.getNaam().equals(name)){
				pat.add(p);
			}
		}return pat;
	}
	
	
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the childs
	 */
	public HashSet<Category> getChilds() {
		return childs;
	}
	/**
	 * @param childs the childs to set
	 */
	public void setChilds(HashSet<Category> childs) {
		this.childs = childs;
	}
	
	/**
	 * @param child to add to set
	 */
	public void addChild(Category child) {
		this.childs.add(child);
	}
	
	/**
	 * 
	 * @param newPattern to add to category
	 */
	public void addPattern(Pattern newPattern) {
		this.patterns.add(newPattern);
		
	}
	
	
	@Override
	public String toString(){
		return name;
	}
	
	public Set<Context> getContexts() {
		return contexts;
	}
	public void setContexts(Set<Context> contexts) {
		this.contexts = contexts;
	}
	public void addContext(Context context) {
		this.contexts.add(context);
		
	}
	
	public boolean hasChilderen(){
		return !childs.isEmpty();
	}

}

