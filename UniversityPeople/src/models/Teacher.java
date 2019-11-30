package models;

import java.util.List;
//This is our Teacher class, using keyword extends class Teacher inherit methods from UniversityStaff class
public class Teacher extends UniversityStaff {
	private List<String> teachingCourses; //declared list of strings teachingCourses
	
	public Teacher() {
		//calling default constructor of parent class
		super();
		//here we gave the list of strings value of null,this is used to denote that the instance variable teachingCourses is used
		this.teachingCourses = null;
	}
	//constructor with two parameters
	public Teacher(String firstname, String lastname) {
		super(firstname, lastname, "Prof.");
	}
	//getter used for reading value from teachingCourses
	public List<String> getTeachingCourses() {
		return teachingCourses;
	}
	//setter is used for setting or updating list of teachingCourses
	public void setTeachingCourses(List<String> teachingCourses) {
		this.teachingCourses = teachingCourses;
	}

	//have to override/implement parent method because it is abstract
	public void printWhatIdo() {
		System.out.println("I teach.");
	}

}
