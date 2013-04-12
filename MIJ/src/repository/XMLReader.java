package repository;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.*;

import domein.Category;
import domein.Consequences;
import domein.Context;
import domein.Diagram;
import domein.Pattern;
import domein.Problem;
import repository.Repository;

public class XMLReader extends Reader {

	@Override
	public boolean open(String location) {
		try {
			Repository rp = Repository.getInstance();
			rp.clear();

			HashMap<Category, ArrayList<String>> childs = new HashMap<Category, ArrayList<String>>();
			HashMap<Category, ArrayList<String>> patterns = new HashMap<Category, ArrayList<String>>();

			File file = new File(location);
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(file);

			doc.getDocumentElement().normalize();

			Element root = doc.getDocumentElement();
			NodeList n = root.getChildNodes();
			// categories
			for (int i = 0; i < n.getLength(); i++) {
				if (n.item(i).getNodeName().equals("Categories")) {
					NodeList n2 = n.item(i).getChildNodes();
					for (int j = 0; j < n2.getLength(); j++) {
						NamedNodeMap attributes = n2.item(j).getAttributes();

						Category c = new Category(attributes.getNamedItem(
								"name").getNodeValue());
						rp.addCategory(c, null);

						Element e = (Element) n2.item(j);
						NodeList nodechilds = e
								.getElementsByTagName("Category");
						NodeList nodepatterns = e
								.getElementsByTagName("Pattern");

						for (int t = 0; t < nodechilds.getLength(); t++) {
							attributes = nodechilds.item(t).getAttributes();
							if (!childs.containsKey(c)) {
								childs.put(c, new ArrayList<String>());
							}
							childs.get(c).add(
									attributes.getNamedItem("name")
											.getNodeValue());
						}

						for (int t = 0; t < nodepatterns.getLength(); t++) {
							attributes = nodepatterns.item(t).getAttributes();
							if (!patterns.containsKey(c)) {
								patterns.put(c, new ArrayList<String>());
							}
							patterns.get(c).add(
									attributes.getNamedItem("name")
											.getNodeValue());
						}
					}
				}
			}

			// patterns
			for (int i = 0; i < n.getLength(); i++) {
				if (n.item(i).getNodeName().equals("Patterns")) {
					NodeList n2 = n.item(i).getChildNodes();
					for (int j = 0; j < n2.getLength(); j++) {
						NamedNodeMap attributes = n2.item(j).getAttributes();

						Pattern p = new Pattern();
						p.setNaam(attributes.getNamedItem("name")
								.getNodeValue());
						p.setSolution(attributes.getNamedItem("description")
								.getNodeValue());

						Element e = (Element) n2.item(j);
						NodeList nodecontexts = e
								.getElementsByTagName("Context");
						NodeList nodeproblems = e
								.getElementsByTagName("Problem");
						NodeList nodeConsequences = e
								.getElementsByTagName("Consequence");
						NodeList nodeimg = e.getElementsByTagName("image");
						
						for (int t = 0; t < nodeimg.getLength(); t++) {
							attributes = nodeimg.item(t).getAttributes();
							Diagram d = new Diagram(attributes.getNamedItem("name").getNodeValue(),attributes.getNamedItem("location").getNodeValue());
							p.setDiagram(d);
						} 

						for (int t = 0; t < nodecontexts.getLength(); t++) {
							p.addContext(new Context(nodecontexts.item(t)
									.getTextContent()));
						}
						for (int t = 0; t < nodeproblems.getLength(); t++) {
							p.addProblem(new Problem(nodeproblems.item(t)
									.getTextContent()));
						}

						for (int t = 0; t < nodeConsequences.getLength(); t++) {
							p.addConsequence(new Consequences(nodeConsequences
									.item(t).getAttributes()
									.getNamedItem("ConsequenceType")
									.getNodeValue(), nodeConsequences.item(t)
									.getTextContent()));
						}

						ArrayList<Category> cate = new ArrayList<Category>();
						for (Map.Entry<Category, ArrayList<String>> entry : patterns
								.entrySet()) {
							for (String s : entry.getValue()) {
								if (s.equals(p.getNaam())) {
									cate.add(entry.getKey());
								}
							}
						}
						rp.addPattern(p, cate);
					}
				}
			}

			for (Map.Entry<Category, ArrayList<String>> entry : childs
					.entrySet()) {
				for (String s : entry.getValue()) {
					for (Category c : rp.getCategories()) {
						if (s.equals(c.getName())) {
							entry.getKey().addChild(c);
						}
					}
				}
			}

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

}
