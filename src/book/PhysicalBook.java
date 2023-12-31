package book;

import library.Loan;

public class PhysicalBook 
extends Book
{
	private static final long serialVersionUID = 1L;
	private BookStates conservationState;
	
	public PhysicalBook(String title, String author, String isbn, int pageCount) {
		super(title, author, isbn, pageCount);
		this.conservationState = BookStates.EXCELLENT;
	}

	public PhysicalBook(String title, String author, String isbn, int pageCount, BookStates conservationState) {
		super(title, author, isbn, pageCount);
		this.conservationState = conservationState;
	}

	public BookStates getConservationState() {
		return conservationState;
	}

	public void setConservationState(BookStates conservationState) {
		this.conservationState = conservationState;
	}
	
	public void addToLoan(Loan loan) {
		System.out.println("-> Loaning book: " + getTitle() + ".");
		loan.addBook(this);
	}
	
	public void removeFromLoan(Loan loan) {
		loan.removeBook(this);
	}
	
}
