package user;

import java.io.Serializable;
import java.util.ArrayList;

import library.Loan;

public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	private String cpf;
	private boolean credited;
	private ArrayList<Loan> loans = new ArrayList<Loan>();
	
	public User(String name, String cpf) {
		super();
		this.name = name;
		this.cpf = cpf;
		this.credited = true;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public boolean isCredited() {
		return credited;
	}

	public void setCredited(boolean credited) {
		this.credited = credited;
	}
	
	public ArrayList<Loan> getExpiredLoans() {
		return new ArrayList<Loan>();
	}
	
	public void addLoan(Loan loan) {
		this.loans.add(loan);
	}
	
	public void printLoans() {
		System.out.println(name + "'s loans:");
		for (Loan loan : loans) {
			System.out.println(
				"- Loan on " + loan.getLoanDate()
				+ " to " + loan.getExpirationDate()
				+ (loan.isExpired() ? "(Expired)" : "")
			);
			loan.printLoanedBooks();
        }
	}
	
	@Override
	public boolean equals(Object o) {
	    if (this == o) return true;
	    if (o == null || getClass() != o.getClass()) return false;
	    User user = (User) o;
	    return cpf.equals(user.getCpf());
	}
	
}
