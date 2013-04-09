package repository;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


import org.w3c.dom.*;

import domein.Category;
import domein.Pattern;
import repository.Repository;

public class XMLReader extends Reader {

	@Override
	public boolean open(String location) {
		try {
			File file = new File(location);
			System.out.println(location);
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(file);
			 
			doc.getDocumentElement ().normalize ();
			
			
			// Search through doc and inform about 
	        System.out.println ("Root element is " + doc.getDocumentElement().getNodeName());
	        
	        NodeList listOfCategories = doc.getElementsByTagName("Categories");
            int totalCategories = listOfCategories.getLength();
            System.out.println("Total number of categories: " + totalCategories);
			
	        NodeList listOfPatterns = doc.getElementsByTagName("Patterns");
            int totalPatterns = listOfPatterns.getLength();
            System.out.println("Total number of patterns: " + totalPatterns);
			
            //Create repo
//            Repository rep = new Repository();
            
            
            //import
            /*
            for (int i = 0; i < listOfCategories.getLength(); i++) {
				Node node = listOfCategories.item(i);
				
				if (node.getNodeType() == Node.ELEMENT_NODE){
					Element element = (Element) node;
					
					Category cat = new Category();
					cat.setName(getValue("Category Name", element));
//					cat.addPattern(Pat); //(getValue("Pattern name", element));
					
					
			
					}
				}
				
				*/
            
            
            //Petterns
//    		NodeList patts = element.getElementsByTagName("Patterns");
//			for(int x = 0; x < patts.getLength(); x++){
//				Node child = patts.item(x);
//				if(child.getNodeType() == Node.ELEMENT_NODE){
//					Element operatorElement = (Element)child;
//					
//					Pattern pattern = new Pattern();
//					pattern.setType(getValue("type", operatorElement));
//					pattern.setName(getValue("name", operatorElement));
//							
//
//					repository.addPattern(Pattern newPattern, ArrayList<Category> categories);
//				}
//            
//            }
//            
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}
	
	private String getValue(String tag, Element element) {
		NodeList nodes = element.getElementsByTagName(tag).item(0).getChildNodes();
		Node node = (Node) nodes.item(0);
		return node.getNodeValue();
	}

}
