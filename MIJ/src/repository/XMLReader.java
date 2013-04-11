package repository;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

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
			Repository rp = Repository.getInstance();
			rp.clear();

			HashMap<Category, String> childs = new HashMap<Category, String>();

			File file = new File(location);
			System.out.println(location);
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(file);

			doc.getDocumentElement().normalize();

			Element root = doc.getDocumentElement();
			NodeList n = root.getChildNodes();
			//categories
			for (int i = 0; i < n.getLength(); i++) {
				if (n.item(i).getNodeName().equals("Categories")) {
					NodeList n2 = n.item(i).getChildNodes();
					for (int j = 0; j < n2.getLength(); j++) {
						NamedNodeMap attributes = n2.item(j).getAttributes();
						Category c = new Category(attributes.getNamedItem("name").getNodeValue());
						//Element e = n2.item(j);
					}
				}
			}
			/*/patterns
			for (int i = 0; i < n.getLength(); i++) {
				if (n.item(i).getNodeName().equals("Patterns")) {
					System.out.println("NYI");
				}
			}*/

			/*
			 * NodeList listOfCategories =
			 * doc.getElementsByTagName("Categories"); int totalCategories =
			 * listOfCategories.getLength();
			 * System.out.println("Total number of categories: " +
			 * totalCategories);
			 * 
			 * NodeList listOfPatterns = doc.getElementsByTagName("Patterns");
			 * int totalPatterns = listOfPatterns.getLength();
			 * System.out.println("Total number of patterns: " + totalPatterns);
			 */

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	/*
	 * private String getValue(String tag, Element element) { NodeList nodes =
	 * element.getElementsByTagName(tag).item(0).getChildNodes(); Node node =
	 * (Node) nodes.item(0); return node.getNodeValue(); }
	 */

}
