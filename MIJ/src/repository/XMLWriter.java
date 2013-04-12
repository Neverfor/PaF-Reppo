package repository;

import java.io.File;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;

import org.w3c.dom.*;

import domein.Category;
import domein.Consequences;
import domein.Context;
import domein.Pattern;
import domein.Problem;

public class XMLWriter extends Writer {

	@Override
	public boolean save(String filename) {

		try {

			DocumentBuilderFactory docFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			Document doc = docBuilder.newDocument();

			Element rootElement = doc.createElement("Repository");
			doc.appendChild(rootElement);

			Element categories = doc.createElement("Categories");
			rootElement.appendChild(categories);

			for (Category c : Repository.getInstance().getCategories().values()) {
				Element category = doc.createElement("Category");
				category.setAttribute("name", c.getName());
				categories.appendChild(category);

				Element patterns = doc.createElement("Patterns");
				category.appendChild(patterns);
				for (Pattern p : c.getPatterns()) {
					Element pattern = doc.createElement("Pattern");
					pattern.setAttribute("name", p.getNaam());
					patterns.appendChild(pattern);
				}

				Element Childs = doc.createElement("Categories");
				category.appendChild(Childs);
				for (Category chi : c.getChilds()) {
					Element child = doc.createElement("Category");
					child.setAttribute("name", chi.getName());
					Childs.appendChild(child);
				}
			}

			Element patterns = doc.createElement("Patterns");
			rootElement.appendChild(patterns);

			for (Pattern p : Repository.getInstance().getPatterns().values()) {
				Element pattern = doc.createElement("Pattern");
				pattern.setAttribute("name", p.getNaam());
				patterns.appendChild(pattern);

				Element contexts = doc.createElement("Contexts");
				pattern.appendChild(contexts);
				for (Context c : p.getContext()) {
					Element context = doc.createElement("Context");
					context.setTextContent(c.toString());
					contexts.appendChild(context);
				}

				Element problems = doc.createElement("Problems");
				pattern.appendChild(problems);
				for (Problem prob : p.getProblems()) {
					Element problem = doc.createElement("Problem");
					problem.setTextContent(prob.toString());
					problems.appendChild(problem);
				}

				Element consequences = doc.createElement("Consequences");
				pattern.appendChild(consequences);
				for (Consequences c : p.getConsequences()) {
					Element consequence = doc.createElement("Consequence");
					consequence.setAttribute("ConsequenceType", c.getConsequenceType());
					consequence.setTextContent(c.getConsequence());
					consequences.appendChild(consequence);
				}
			}
			TransformerFactory transformerFactory = TransformerFactory
					.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(filename));

			transformer.transform(source, result);
			return true;

		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (TransformerException tfe) {
			tfe.printStackTrace();
		}
		return false;
	}
}