package library;

import java.io.Serializable;
import java.time.LocalDate;
import user.User;
import user.UserManager;

import java.util.ArrayList;
import book.Book;
import book.Ebook;

public class Loan implements Serializable {
	private static final long serialVersionUID = 1L;
	private Library library;
	private User user;
	private LocalDate loanDate;
	private LocalDate expirationDate;
	private ArrayList<Book> books = new ArrayList<Book>();
	
	public Loan(Library library, User user, LocalDate loanDate, LocalDate expirationDate) {
		super();
		this.library = library;
		this.user = user;
		this.loanDate = loanDate;
		this.expirationDate = expirationDate;
		
		this.user.addLoan(this);
		save();
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
	
	public void addBook(Book instance) {
		this.books.add(instance);
		save();
	}
	
	public void removeBook(Book instance) {
		this.books.remove(instance);
		save();
	}

	public ArrayList<Book> getBooks() {
		return books;
	}
	
	public void printLoanedBooks() {
		for (Book book: books) {
			System.out.print("   -> ");
			System.out.println(book.getTitle() + " by " + book.getAuthor() + ".");
			if (book instanceof Ebook) System.out.print("	Download link: " + ((Ebook) book).getDownloadUrl());
		}
	}
	
	public void save() {
		if (!books.isEmpty()) UserManager.updateUser(this.user);
	}
	
}
