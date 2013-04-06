package repository;

public class XMLFactory implements PersistenceFactory {

	@Override
	public Writer createWriter() {
		return new XMLWriter();
	}

	@Override
	public Reader createReader() {
		return new XMLReader();
	}

	

}
