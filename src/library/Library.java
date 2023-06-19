package library;

import java.io.Serializable;
import java.util.ArrayList;
import user.Employee;

public class Library implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
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
	
	public void addCategory(Category category) {
		this.categories.add(category);
	}
	
	public void removeCategory(Category category) {
		this.categories.remove(category);
	}

	public ArrayList<Category> getCategories() {
		return categories;
	}
	
	public void addEmployee(Employee instance) {
		this.employees.add(instance);
	}
	
	public void removeEmployee(Employee instance) {
		this.employees.remove(instance);
	}
	
	public ArrayList<Employee> getEmployees() {
		return employees;
	}
	
	public void saveState() {
		LibraryManager.updateLibrary(this);
	}
}
