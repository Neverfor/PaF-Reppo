package repository;

public interface PersistenceFactory {
	public Writer createWriter();
	public Reader createReader();
}
