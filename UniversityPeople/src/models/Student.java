package models;

import java.util.List;
//This is our Student class, using keyword extends class Student inherit methods from Person class
public class Student extends Person {
	private List<String> chosenCourses;//declared list of string called chosenCourses
	
	public Student() {
		//calling default constructor of parent class
		super();
		//declared value of chosenCourses as null
		this.chosenCourses = null;
	}
	//construcor with two string parameters
	public Student(String firstname, String lastname) {
		super(firstname, lastname);
	}
	//getter used for reading chosenCourses
	public List<String> getChosenCourses() {
		return chosenCourses;
	}
	//setter used for setting value of chosenCourses
	public void setChosenCourses(List<String> chosenCourses) {
		this.chosenCourses = chosenCourses;
	}

	//have to override/implement parent method because it is abstract
	//methods which prints what person is doing in this case person is Student, so it will print I study on console
	public void printWhatIdo() {
		System.out.println("I study.");
	}

}
