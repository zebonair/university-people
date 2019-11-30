package models;
//This is our Employee class, using keyword extends class Employee inherit methods from Person class
public class Employee extends Person {

	private double salary;
	
	public Employee() {
		//calling default constructor of parent class
		super();
		//giving the value of private double salary , it is 0 for beggining
		this.salary = 0;
	}
	//parameterized constructor Employee, here we additional parameter
	public Employee(String firstname, String lastname, double salary) {
		//we gave two parameters to constructor super
		super(firstname, lastname);
		//setting attribute salary with passed parameter salary 
		this.salary = salary;
	}
	//getter which is used for reading salary of Employee
	public double getSalary() {
		return salary;
	}
	//setter which is used in our application for updating value of salary
	public void setSalary(double salary) {
		this.salary = salary;
	}
	//use to print on console 
	public void printWhatIdo() {
		System.out.println("I work.");
	}

}
