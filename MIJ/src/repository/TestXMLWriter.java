package repository;

import java.io.File;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;

import org.w3c.dom.*;

public class TestXMLWriter {

	public static void main(String argv[]) {

		try {

			DocumentBuilderFactory docFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			// Document info
			Document doc = docBuilder.newDocument();

			// Eerste root
			Element rootElement = doc.createElement("Category");
			doc.appendChild(rootElement);

			// Tweede root
			Element pattern = doc.createElement("Patterns");
			rootElement.appendChild(pattern);

			// set attribute voor Pattern
			Attr attr = doc.createAttribute("Naam");
			attr.setValue("Creational");
			pattern.setAttributeNode(attr);

			// of ->>>> pattern.setAttribute("id", "1");

			// Pattern naam elementen
			Element name = doc.createElement("firstname");
			name.appendChild(doc.createTextNode("yong"));
			pattern.appendChild(name);

			// Pattern problem elementen
			Element problem = doc.createElement("lastname");
			problem.appendChild(doc.createTextNode("mook kim"));
			pattern.appendChild(problem);

			// Pattern consequences elementen
			Element consequence = doc.createElement("nickname");
			consequence.appendChild(doc.createTextNode("mkyong"));
			pattern.appendChild(consequence);

			// Pattern diagram elementen
			Element diagram = doc.createElement("drawing");
			diagram.appendChild(doc.createTextNode("AB02lD239SDJAK923#9982"));
			pattern.appendChild(diagram);

			// schrijven naar xml
			TransformerFactory transformerFactory = TransformerFactory
					.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("C:\\file.xml"));

			// Output to console for testing
			// StreamResult result = new StreamResult(System.out);

			transformer.transform(source, result);

			System.out.println("File saved!");

		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (TransformerException tfe) {
			tfe.printStackTrace();
		}
	}
}