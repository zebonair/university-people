package models;
//This is our Cleaner class, using keyword extends class Cleaner inherit methods from Employee class
public class Cleaner extends Employee {
	
	public Cleaner() {
		//calling default constructor of parent class
		super();
	}
	//constructor with two parameters
	public Cleaner(String firstname, String lastname) {
	 //we gave parameters to constructor super
		super(firstname, lastname, 0);
	}

}
