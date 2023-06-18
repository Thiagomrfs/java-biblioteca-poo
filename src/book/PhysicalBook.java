package book;

import library.Loan;

public class PhysicalBook 
extends Book
implements Loanable 
{
	private BookStates conservationState;

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
		// TODO add to loan
	}
	
	public void removeFromLoan(Loan loan) {
		// TODO remove from loan
	}
	
	
}
