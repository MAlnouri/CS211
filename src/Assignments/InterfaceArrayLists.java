/* Mahmmoud Alnouri
 * SID: 950594013
 * 3/2/2018
 * ArrayList Interface
 * This program reads data from a file and separates the people by students and teachers
 * With methods the data can be parsed to list students or teachers by age and gender
 * or to find the average age of a gender
*/
package Assignments;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.io.*;

public class InterfaceArrayLists {
	
	public static void listData(Scanner input, ArrayList<person> s, ArrayList<person> t)
			throws FileNotFoundException {
		//loops through the file
		while(input.hasNextLine()) {
			//creates new person to store their info
			person a = new person(input.next(), input.next(), input.next(), input.nextInt());
			
			if(a.occ.equals("s")) {
				//adds to student arraylist if students
				s.add(a);
			} else if(a.occ.equals("t")) {
				//adds to teacher arraylist if occupation is teacher
				t.add(a);
			}
		}
	}
	
	public static void parseAge(String g, int min, int max, ArrayList<person> list) {
		Iterator<person> iterator = list.iterator();
		if(g.equals("m")) {
			System.out.print("Data sorted by males between ages " + min + " and " + max + ": ");
		} else if(g.equals("f")) {
			System.out.print("Data sorted by females between ages " + min + " and " + max + ": ");
		}
		//loops through the arraylist
		while(iterator.hasNext()) {
			//stores the next index 
			person temp = iterator.next();
			//checks if gender is equal to requested data, then checks for age parameters
			if(temp.gender.equals(g)) {
				if(temp.age >= min && temp.age <= max) {
					//prints the name if all data meets requirements
					System.out.print(temp.name + " ");
				}
			}
		}
		//begins new line for next method call
		System.out.println();
	}
	
	public static void parseGender(String g, ArrayList<person> list) {
		Iterator<person> iterator = list.iterator();
		if(g.equals("m")) {
			System.out.print("Data sorted by males: ");
		} else if(g.equals("f")) {
			System.out.print("Data sorted by females: ");
		}
		//loops through the arraylist
		while(iterator.hasNext()) {
			//stores the next index 
			person temp = iterator.next();
			//if gender is equal to requested data, prints the name
			if(temp.gender.equals(g)) {
				System.out.print(temp.name + " ");
			}
		}
		//begins new line for next method call
		System.out.println();
	}
	
	public static int avgAge(String g, ArrayList<person> list) {
		Iterator<person> iterator = list.iterator();
		if(g.equals("m")) {
			System.out.print("Average age of males: ");
		} else if(g.equals("f")) {
			System.out.print("Average age of females: ");
		}
		//stores the total age
		int totalage = 0;
		//tracker for number of teachers/students
		int counter = 0;
		int avg;
		//loops through the arraylist
		while(iterator.hasNext()) {
			//stores the next index 
			person temp = iterator.next();
			//checks if gender is equal to requested data, then adds to total age and updates counter
			if(temp.gender.equals(g)) {
				totalage += temp.age;
				counter++;
			}
		}
		//calculates then prints and returns the average age
		avg = totalage / counter;
		System.out.println(avg);
		return avg;
	}
	
	public static void addNewPerson(String occ, String n, String g, int a, ArrayList<person> s, ArrayList<person> t)
			throws FileNotFoundException {
		//creates iterators for each arraylist
		Iterator<person> iteratorS = s.iterator();
		Iterator<person> iteratorT = t.iterator();
		//outputs the data into the text file
		PrintStream out = new PrintStream("people.txt");
		//writes all the students info to the file
		while(iteratorS.hasNext()) {
			person tempS = iteratorS.next();
			out.println(tempS.occ + " " + tempS.name + " " + tempS.gender + " " + tempS.age);
		}
		//writes all the teachers info to the file
		while(iteratorT.hasNext()) {
			person tempT = iteratorT.next();
			out.println(tempT.occ + " " + tempT.name + " " + tempT.gender + " " + tempT.age);
		}
		//prints their info and adds them to the arraylist
		out.println(occ + " " + n + " " + g + " " + a);
	}
	

	public static void main(String[] args)
			throws FileNotFoundException {
		
		Scanner console = new Scanner(new File("people.txt"));

		ArrayList <person> students = new ArrayList <person>();
		ArrayList <person> teachers = new ArrayList <person>();
		
		//adds the data to the arraylists
		listData(console, students, teachers);
		//parses the data by gender, "m" for male, "f" for female
		parseGender("m", students);
		parseGender("f", teachers);
		//separates data by a minimum age, maximum age and gender
		parseAge("m", 10, 30, students);
		parseAge("f", 30, 60, teachers);
		//separates data by male or female, and returns average age
		avgAge("m", students);
		avgAge("f", teachers);
		//adds a new person with given parameters to the data file
		//"t" or "s" for teacher/student, "m" or "f" for male/female
		addNewPerson("t", "Jackie", "f", 33, students, teachers);
		addNewPerson("s", "Mark", "m", 20, students, teachers);
	}

}
