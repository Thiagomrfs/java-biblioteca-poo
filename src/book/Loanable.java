package book;

import library.Loan;

public interface Loanable {
	void addToLoan(Loan loan);
	void removeFromLoan(Loan loan);
}
