package user;

public class Employee extends User {
	private static final long serialVersionUID = 1L;
	private double salary;
	
	public Employee(String name, String cpf, double salary) {
		super(name, cpf);
		this.salary = salary;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
}
