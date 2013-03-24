package repository;


import java.io.File;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
 
import org.w3c.dom.*;

import domein.Category;

 
public class XMLWriter extends Writer{
 
	public  void saveToXML(String xml,Repository rp) {
 
	  try {
 
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
 
//		 Document info
		Document doc = docBuilder.newDocument();
		
//		Eerste root
		Element rootElement = doc.createElement("Repository");
		doc.appendChild(rootElement);
		
		Element categories = doc.createElement("Categories");
		rootElement.appendChild(categories);
		
		for (Category c : Repository.getInstance().getCategories()){
			Element category = doc.createElement("Category");
			category.setAttribute("name", c.getName());
			categories.appendChild(category);
		}
 
//		 schrijven naar xml
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File("C:\\file.xml"));
 
//		 Output to console for testing
//		 StreamResult result = new StreamResult(System.out);
 
		transformer.transform(source, result);
 
		System.out.println("File saved!");
 
	  } catch (ParserConfigurationException pce) {
		pce.printStackTrace();
	  } catch (TransformerException tfe) {
		tfe.printStackTrace();
	  }
	}
}