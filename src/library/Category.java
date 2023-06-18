package library;

import java.io.Serializable;
import java.util.ArrayList;
import book.Book;
import book.Ebook;
import book.PhysicalBook;

public class Category implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	private ArrayList<Book> books = new ArrayList<Book>();

	public Category(String name) {
		super();
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void addBook(PhysicalBook instance) {
		this.books.add(instance);
	}
	
	public void removeBook(PhysicalBook instance) {
		this.books.remove(instance);
	}
	
	public void addBook(Ebook instance) {
		this.books.add(instance);
	}
	
	public void removeBook(Ebook instance) {
		this.books.remove(instance);
	}

	public ArrayList<Book> getBooks() {
		return books;
	}
	
	
}
