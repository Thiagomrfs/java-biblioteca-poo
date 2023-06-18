package library;

import java.util.ArrayList;
import user.Employee;

public class Library {
	private String name;
	private static int booksOnStock;
	private ArrayList<Category> categories = new ArrayList<Category>();
	private ArrayList<Employee> employees = new ArrayList<Employee>();
	
	public Library(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getStock() {
		return Library.booksOnStock;
	}

	public void increaseStock() {
		Library.booksOnStock += 1;
	}
	
	public void addCategory(Category category) {
		this.categories.add(category);
	}
	
	public void removeCategory(Category category) {
		this.categories.remove(category);
	}

	public ArrayList<Category> getCategories() {
		return categories;
	}
	
	public void addBook(Employee instance) {
		this.employees.add(instance);
	}
	
	public void removeBook(Employee instance) {
		this.employees.remove(instance);
	}
	
}
