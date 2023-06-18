package library;

import java.io.Serializable;
import java.time.LocalDate;
import user.User;
import java.util.ArrayList;
import book.PhysicalBook;

public class Loan implements Serializable {
	private static final long serialVersionUID = 1L;
	private Library library;
	private User user;
	private LocalDate loanDate;
	private LocalDate expirationDate;
	private ArrayList<PhysicalBook> books = new ArrayList<PhysicalBook>();
	
	public Loan(Library library, User user, LocalDate loanDate, LocalDate expirationDate) {
		super();
		this.library = library;
		this.user = user;
		this.loanDate = loanDate;
		this.expirationDate = expirationDate;
		
		this.user.addLoan(this);
	}

	public Library getLibrary() {
		return library;
	}

	public User getClient() {
		return user;
	}

	public LocalDate getLoanDate() {
		return loanDate;
	}

	public LocalDate getExpirationDate() {
		return expirationDate;
	}
	
	public boolean isExpired() {
		LocalDate today = LocalDate.now();
		return today.isAfter(this.expirationDate);
	}
	
	public void addBook(PhysicalBook instance) {
		this.books.add(instance);
	}
	
	public void removeBook(PhysicalBook instance) {
		this.books.remove(instance);
	}

	public ArrayList<PhysicalBook> getBooks() {
		return books;
	}
	
}
