package domein;

import java.util.HashSet;

public class Category {
	private HashSet<Pattern> patterns;
	private String name;
	private Category childs;
	
	
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
	public Category getChilds() {
		return childs;
	}
	/**
	 * @param childs the childs to set
	 */
	public void setChilds(Category childs) {
		this.childs = childs;
	}
	
	public void addChild(Category child) {
		this.childs.addChild(child);
	}

}
