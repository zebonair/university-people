package models;

import java.util.List;
//This is our Assistant class, using keyword extends class Assistant inherit methods from UniversityStaff class
public class Assistant extends UniversityStaff {
	private List<String> courses; //declared list of string called courses
	
	public Assistant() {
		//calling default constructor of parent class
		super();
	}
	//constructor with two parameters
	public Assistant(String firstname, String lastname) {
		super(firstname, lastname, "Assistant");
	}
	//getter used to return the variable(to read courses of Assistant)
	public List<String> getCourses() {
		return courses;
	}
	//used to set (update) courses 
	public void setCourses(List<String> courses) {
		this.courses = courses;
	}

}
