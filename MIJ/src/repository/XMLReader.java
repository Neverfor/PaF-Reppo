package repository;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

public class XMLReader extends Reader {

	@Override
	public boolean open(String location) {
		try {
			File file = new File(location);
			System.out.println(location);
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(file);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

}
