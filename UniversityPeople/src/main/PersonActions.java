package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import models.Assistant;
import models.Cleaner;
import models.Employee;
import models.Headmaster;
import models.Person;
import models.Student;
import models.Teacher;
import models.UniversityStaff;

public class PersonActions {
	
	
	Scanner userInput = new Scanner(System.in); 
	
	/* Creating new object people through object model: 
	(1) Student, (2) Cleaner, (3) Teacher, (4) Assistant, (5) Headmaster*/
	public Person createNewPerson(int choice) {
		
		//Switch case to chose type
		switch (choice) {
		case 1:
			return this.createStudent();
		case 2:
			return this.createCleaner();
		case 3:
			return this.createTeacher();
		case 4:
			return this.createAssistant();
		case 5:
			return this.createHeadmaster();
		}
	
		return null;
	}
	
	//Print method
	public void printDataAboutPerson(Person person) {
		System.out.println("Type: " + person.getClass().getSimpleName()); //Returns the simple name of the underlying class
		System.out.println("Firstname: " + person.getFirstname()); //Gets first name
		System.out.println("Lastname: " + person.getLastname()); //Gets last name 
		System.out.println("Hobbies: " + this.getListOfStringsAsString(person.getHobbies())); //Gets list of hobbies as string
		
		
		//Testing if objects are instance of their superclasses, then GETS additional parameters/attributes
		//All types have their unique parameter
		if(person instanceof Student) {
			Student student = (Student) person; //Creates student
			System.out.println("Attending courses: " + this.getListOfStringsAsString(student.getChosenCourses())); //Gets list of courses 
		}
			
		if(person instanceof Employee) {
			Employee employee = (Employee) person;
			System.out.println("Salary: " + employee.getSalary());  //Gets employee salary
		}
		
		if(person instanceof UniversityStaff) {
			UniversityStaff staff = (UniversityStaff) person;
			System.out.println("Title: " + staff.getTitle()); //Gets staff title 
		}
		
		if(person instanceof Teacher) {
			Teacher teacher = (Teacher) person;
			System.out.println("Teaching courses: " + this.getListOfStringsAsString(teacher.getTeachingCourses())); //Gets list of courses they teach as string
		}
		
		if(person instanceof Assistant) {
			Assistant assitant = (Assistant) person;
			System.out.println("Assisting courses: " + this.getListOfStringsAsString(assitant.getCourses())); //Gets list of courses they assist teaching as string
		}
	}
	
	//Method for creating a list for multiple entries (e.g. hobbies, courses...) 
	private String getListOfStringsAsString(List<String> listOfStrings) {

		String stringData = ""; //Initializing variable with empty string
		if(listOfStrings != null) { //Check if list is empty
			for (int i = 0; i < listOfStrings.size(); i++) {// Increments/Creates space for more entries
				if(i == 0) { // Checks if the entry is first in list
					stringData = listOfStrings.get(i); //If list starts from 0 it will get the first entry 
				} else {
					stringData += ", " + listOfStrings.get(i); //If it's not from 0, it will add a comma before every other entry
				}
			}
		}
		return stringData;
		
	}
	
	//Methods for creating objects from user input
	
	private Student createStudent() {
		Student newStudent = new Student(); //Creating new student 
		
		//We enclose a portion of program in which an exception may occur during runtime.
		try { 
			//Adds user input data derived from a given method
			newStudent = (Student) this.addPersonDataFromInput(newStudent);
			newStudent = this.addStudentDataFromInput(newStudent); 
			
			return newStudent;
		} catch (Exception e) { //Declaring type of an exception that it is going to catch and handle. Can be runtime, compiler or user entry error.
			System.out.println("An error appeared while creating a student."); //User gets notified in case of an error 
			userInput.nextLine(); //If exception occurs during user input, the cursor jumps to the next line
			return null;
		}
	}
	
	private Cleaner createCleaner() {
		Cleaner newCleaner = new Cleaner(); //Creating a cleaner
		try {
			//Adds user input data derived from a given method
			newCleaner = (Cleaner) this.addPersonDataFromInput(newCleaner); 
			newCleaner = (Cleaner) this.addEmployeeDataFromInput(newCleaner); 
			newCleaner = this.addCleanerDataFromInput(newCleaner); 
			
			return newCleaner;
		} catch (Exception e) {
			System.out.println("An error appeared while creating a cleaner.");
			userInput.nextLine();
			return null;
		}
	}
	
	private Headmaster createHeadmaster() {
		Headmaster newHeadmaster = new Headmaster();
		try {
			//Adds user input data derived from a given method
			newHeadmaster = (Headmaster) this.addPersonDataFromInput(newHeadmaster);
			newHeadmaster = (Headmaster) this.addEmployeeDataFromInput(newHeadmaster);
			newHeadmaster = (Headmaster) this.addStaffDataFromInput(newHeadmaster); 
			newHeadmaster = this.addHeadmasterDataFromInput(newHeadmaster);
			
			return newHeadmaster;
		} catch (Exception e) {
			System.out.println("An error appeared while creating a headmaster.");
			userInput.nextLine();
			return null;
		}
	}
	
	private Teacher createTeacher() {
		Teacher newTeacher = new Teacher();
		try {
			//Adds user input data derived from a given method
			newTeacher = (Teacher) this.addPersonDataFromInput(newTeacher);
			newTeacher = (Teacher) this.addEmployeeDataFromInput(newTeacher);
			newTeacher = (Teacher) this.addStaffDataFromInput(newTeacher);
			newTeacher = this.addTeacherDataFromInput(newTeacher); 
			
			return newTeacher;
		} catch (Exception e) {
			System.out.println("An error appeared while creating a teacher.");
			userInput.nextLine();
			return null;
		}
	}
	
	private Assistant createAssistant() {
		Assistant newAssistant = new Assistant();
		try {
			//Adds user input data derived from a given method
			newAssistant = (Assistant) this.addPersonDataFromInput(newAssistant);
			newAssistant = (Assistant) this.addEmployeeDataFromInput(newAssistant);
			newAssistant = (Assistant) this.addStaffDataFromInput(newAssistant);
			newAssistant = this.addAssistantDataFromInput(newAssistant); 
			
			return newAssistant;
		} catch (Exception e) {
			System.out.println("An error appeared while creating an assistant.");
			userInput.nextLine();
			return null;
		}
	}
	
	//Throwing checked exceptions by the method in case of an error, user gets notified 
	//User enters data for Person attributes
	private Person addPersonDataFromInput(Person person) throws Exception  { 
		System.out.print("Please insert the firstname:");
		String firstname = userInput.nextLine();
		System.out.print("Please insert the lastname:");
		String lastname = userInput.nextLine();

		System.out.println("Which hobbies does the person have?");
		List<String> hobbies = this.createListofStringsFromInput("hobby"); 
		
		//Main attributes setters
		person.setFirstname(firstname);
		person.setLastname(lastname);
		person.setHobbies(hobbies);
		
		return person;
	}
	
	//User setting custom attributes for different faculty members
	private Student addStudentDataFromInput(Student student) throws Exception { 
		System.out.println("Which courses does the student attend?");
		List<String> courses = this.createListofStringsFromInput("course");
		
		student.setChosenCourses(courses);
		return student;
	}
	
	
	private Person addEmployeeDataFromInput(Employee employee) throws Exception {
		System.out.print("Please insert the salary (e.g. 15,30): ");
		// Parsing because of: https://stackoverflow.com/a/13102066/9182064
		double salary = Double.parseDouble(userInput.nextLine());
		
		employee.setSalary(salary);
		
		return employee;
	}
	
	private Cleaner addCleanerDataFromInput(Cleaner cleaner) throws Exception {
		// Placeholder if cleaner gets any attributes - no current attributes
		
		
		return cleaner;
	}
	
	private UniversityStaff addStaffDataFromInput(UniversityStaff staff) throws Exception {
		System.out.print("Please insert the title: "); 
		String title = userInput.nextLine();
		
		staff.setTitle(title);
		
		return staff;
	}
	
	private Headmaster addHeadmasterDataFromInput(Headmaster headmaster) throws Exception {
		// Placeholder if headmaster gets any attributes - no current attributes
		
		return headmaster;
	}
	
	private Teacher addTeacherDataFromInput(Teacher teacher) throws Exception {
		System.out.println("Which courses are assigned to the teacher?");
		List<String> courses = this.createListofStringsFromInput("course"); //Creates list of courses
		
		teacher.setTeachingCourses(courses);
		
		return teacher;
	}
	
	private Assistant addAssistantDataFromInput(Assistant assistant) throws Exception {
		System.out.println("On which courses he assist?");
		List<String> courses = this.createListofStringsFromInput("course"); 
		
		assistant.setCourses(courses);
		
		return assistant;
	}

	//Creating list depending on what user inputs
	//@param type: contains the type which is shown to the user (e.g. hobby, course etc.)
	private List<String> createListofStringsFromInput(String type) {
		List<String> createdList = new ArrayList<String>(); //New list
		String line = ""; //String can be left empty
		do {
			//User adding type 
			System.out.print("Please add a " + type + " ('0' = quit):");
			line = userInput.nextLine();
			if(!line.equals("0")) {
				createdList.add(line); //Adds list if entry not 0
			}
		} while(!line.equals("0"));
		
		return createdList;
	}
}
