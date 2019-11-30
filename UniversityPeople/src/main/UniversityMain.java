package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Class imports
import models.Assistant;
import models.Cleaner;
import models.Employee;
import models.Headmaster;
import models.Person;
import models.Student;
import models.Teacher;
import models.UniversityStaff;

public class UniversityMain {

	public static void main(String[] args) {
		
		List<Person> peopleInUniversity = new ArrayList<Person>(); //Using generics to enable classes and methods to be parameters
		PersonActions personActions = new PersonActions(); //Creating object PersonActions
		Scanner userInputScanner = new Scanner(System.in); //Using Java utility scanner
		int userInput = -1; //Default value 
		
		System.out.println("Welcome User.");
		System.out.println("With us you can manage your own list of people from a university.");
		
		peopleInUniversity = createExampleData(); //Premade university members
		
		do {
			System.out.println("What would you like to do? Pick a choice:");
			System.out.println("(1) Insert new person.");
			System.out.println("(2) Update person.");
			System.out.println("(3) Delete person.");
			System.out.println("(4) Show all people.");
			System.out.println("(0) Quit the program.");
			System.out.print("Your choice: ");
			
			
			//Enclosing a portion of program in which an exception may occur during runtime.
			try {
				userInput = userInputScanner.nextInt(); // Checks user input for an integer
			} catch(Exception e) {  // Declaring type of exception that it is going to catch and handle.
				userInput = -1; // If exception occurs, the userInput is set to default 
				userInputScanner.nextLine(); // If an exception occurs, the cursor is set to a new line 
			}
			
			//Selection - checks for user choice
			if(userInput == 1) {// Add new person
				System.out.println("Which person would you like to add?");
				System.out.println("(1) Student, (2) Cleaner, (3) Teacher, (4) Assistant, (5) Headmaster, (0 or any other) Nobody, cancel and go back.");
				System.out.print("Your choice: ");
				try {
					int choice = userInputScanner.nextInt(); //checks for integer in user input
					if(choice >= 1 && choice <= 5) {
						Person newPerson = personActions.createNewPerson(choice); //Creating person object depending on the user's choice 
						if(newPerson != null) {
							peopleInUniversity.add(newPerson); //Adding new person to the list of university people
							System.out.println("Person added successfully!"); //User gets notified when the person is created successfully 
						}
					}
				} catch(Exception e) { // In case user puts invalid input
					userInputScanner.nextLine(); // Jump to next line
					System.out.println("Please insert a number!"); 
				}
			}
			
			if(userInput == 2) { //Update Person entry
				System.out.println("\n==================");
				for (int i = 0; i < peopleInUniversity.size(); i++) { //Printing out the names of the people from the list peopleInUniversity 
					System.out.println(i + ". " + peopleInUniversity.get(i).getFirstname() + " " + peopleInUniversity.get(i).getLastname()); 
				}
				System.out.println("==================\n");
				System.out.println("Which entry would you like to update?");
				System.out.print("Your choice: ");
				try {
					int entryChosen = userInputScanner.nextInt(); //User input
					if(entryChosen >= 0 && entryChosen < peopleInUniversity.size()) { //Checks if list contains chosen entry
						
						//Displaying options for changing the person attributes
						System.out.println("Select the new type.");
						System.out.println("(1) Student, (2) Cleaner, (3) Teacher, (4) Assistant, (5) Headmaster, (0 or any other) Nobody, cancel and go back.");
						System.out.print("Your choice: ");
						int choice = userInputScanner.nextInt();
						if(choice >= 1 && choice <= 5) {
							Person newPerson = personActions.createNewPerson(choice); //Creating new person to update old person
							if(newPerson != null) {
								peopleInUniversity.set(entryChosen, newPerson);  //Replacing old person with new person
								System.out.println("Person updated successfully!");
							}
						}
					}
				} catch(Exception e) { //In case of invalid input
					userInputScanner.nextLine();
					System.out.println("Please insert a number!");
				}
			}
			
			//Delete person option
			if(userInput == 3) {
				// Print index and names of people
				System.out.println("\n==================");
				for (int i = 0; i < peopleInUniversity.size(); i++) { //Goes through list displaying only names of faculty members
					System.out.println(i + ". " + peopleInUniversity.get(i).getFirstname() + " " + peopleInUniversity.get(i).getLastname());
				}
				System.out.println("==================\n");
				System.out.println("Which entry would you like to remove?");
				System.out.print("Your choice: ");
				try {
					int entryChosen = userInputScanner.nextInt(); //User input
					if(entryChosen >= 0 && entryChosen < peopleInUniversity.size()) { //Checks if list contains chosen entry
						peopleInUniversity.remove(entryChosen); //Remove person from list
						System.out.println("Person removed successfully!");
					}
				} catch(Exception e) { //In case of invalid input
					userInputScanner.nextLine();
					System.out.println("Please insert a number!");
				}
			}
			
			//Print peopleInUniversity option
			if(userInput == 4) {
				System.out.println();
				System.out.println("======= Printing data about people =======");
				for (Person person : peopleInUniversity) { 								
					personActions.printDataAboutPerson(person); //Printing all data about the person
					System.out.println("-----------------------");
				}
				System.out.println("==========================================");
				System.out.println();
			}
			
		}
		while (userInput != 0);
		
		userInputScanner.close(); //Close scanner on application shut down
	}
	
	//Premade university people
	public static List<Person> createExampleData() {
		List<Person> examplePeople = new ArrayList<Person>();

		Student amina = new Student("Amina", "Idrizovic"); //Type - Name - Last Name
		List<String> attendingCourses = new ArrayList<String>(); //Empty list of courses
		attendingCourses.add("Software Course"); //New course added
		attendingCourses.add("Hardware Course"); //New course added
		amina.setChosenCourses(attendingCourses); //Setting added courses
		
		Assistant nadza = new Assistant("Nadza", "Niksic");
		List<String> assistingCourses = new ArrayList<String>();
		assistingCourses.add("Management Course");
		assistingCourses.add("Hardware Course");
		nadza.setCourses(assistingCourses);
		nadza.setSalary(439.76); //Setting salary
		
		Cleaner emir = new Cleaner("Emir", "Muratcaus");
		List<String> hobbies = new ArrayList<String>();
		hobbies.add("Gaming");
		hobbies.add("Reading"); //Setting hobbies 
		emir.setHobbies(hobbies);
		emir.setSalary(99.99);
		
		Headmaster armin = new Headmaster("Armin", "Hodzic");
		armin.setSalary(543.18);
		
		Teacher ajra = new Teacher("Ajra", "Hiros");
		List<String> teachingCourses = new ArrayList<String>();
		teachingCourses.add("Software Course");
		teachingCourses.add("Management Course");
		ajra.setTeachingCourses(teachingCourses);
		ajra.setSalary(451.28);
		
		//Adding faculty members in examplePeople list
		examplePeople.add(amina);
		examplePeople.add(nadza);
		examplePeople.add(emir);
		examplePeople.add(armin);
		examplePeople.add(ajra);
		
		return examplePeople;
	}

}
