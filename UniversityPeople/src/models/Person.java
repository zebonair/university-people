package models;

import java.util.List;

//Abstract class because it should be base class for all types
public abstract class Person {
	private String firstname; //variable firstname 
	private String lastname; //variable lastname
	private List<String> hobbies; //list hobbies

	//value of firstname and lastname declared as empty string
	public Person() {
		this.firstname = "";
		this.lastname = "";
	}
	// construct a new person with given fields
	public Person(String firstname, String lastname) {
		this.firstname = firstname;
		this.lastname = lastname;
	}
	//getter is used for reading the value of variable firstname
	public String getFirstname() {
		return firstname;
	}
	//setter is used for updating the value of variable firstname
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	//getter is used for reading the value of variable lastname	
	public String getLastname() {
		return lastname;
	}
	//setter is used for updating the value of variable lastname	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	//getter is used for reading the value of list of hobbies
	public List<String> getHobbies() {
		return hobbies;
	}
	//setter is used for updating the value of list of hobbies
	public void setHobbies(List<String> hobbies) {
		this.hobbies = hobbies;
	}
	
	//using abstract on a method means that child class has to implement that method
	public abstract void printWhatIdo();
}
