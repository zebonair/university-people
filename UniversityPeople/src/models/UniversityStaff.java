package models;
//This is our UniversityStaff class, using keyword extends class UniversityStaff inherit methods from Employee class
public class UniversityStaff extends Employee {
	private String title;//declared private string variable called title 
	
	public UniversityStaff() {
		//calling default constructor of parent class
		super();
		//this is used to denote that the instance variable title is used and here title is declared as empty string
		this.title = "";
	}
	//constructor with three parameters
	public UniversityStaff(String firstname, String lastname, String title) {
		super(firstname, lastname, 0);
		//setting attribute salary with passed parameter salary 
		this.title = title;
	}
	//getter reads the value of title, as we can see getter always return a variable
	public String getTitle() {
		return title;
	}
	//setter sets(updates) value of title, setter is declared as void, because setter returns nothing
	public void setTitle(String title) {
		this.title = title;
	}
}
