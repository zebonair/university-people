package models;
//This is our Headmaster class, using keyword extends class Headmaster inherit methods from UniversityStaff class
public class Headmaster extends UniversityStaff {
	
	public Headmaster() {
		//calling default constructor of parent class
		super();
	}
	//constructor with three parameters
	public Headmaster(String firstname, String lastname) {
		//calling constructor of parent class and passing parameters
		super(firstname, lastname, "Dir.");
	}

}
