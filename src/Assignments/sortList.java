package Assignments;

//program reads file of students, adds to arraylist
//and prints out male/female list of students

import java.util.*;
import java.io.*;

class person1 {
	 String id;
	 String name;
	 String gender;
	 int age;
	}

public class sortList {

 public static void main(String[] args) throws FileNotFoundException {
   
     Scanner input = new Scanner(new File("student.txt"));
     ArrayList<person1> studentList = new ArrayList<>();
     int test = 0;
     while(input.hasNextLine()) {
         //creates a local person class
         person1 temp = new person1();
    	 //stores values read from text file
    	 temp.id = input.next();
    	 temp.name = input.next();
    	 temp.gender = input.next();
    	 temp.age = input.nextInt();
    	 //adds person values to arraylist
    	 studentList.add(temp);
       }
     //creates strings to hold values of male/female student lists
     String male = "Male Student List:\n";
     String female = "Female Student List:\n";
     //loops through the arraylist
     	for (int i = 0; i < studentList.size(); i++){
     		//if gender is male, adds name to male string list
     		if(studentList.get(i).gender.equalsIgnoreCase("m")) {
     			male = male + studentList.get(i).name + "\n";
     		//else if gender is male, adds name to female string list
     		} else if(studentList.get(i).gender.equalsIgnoreCase("f")) {
     			female = female + studentList.get(i).name + "\n";
     		}
     	} 
     	//prints the student lists after finished checking array
     	System.out.println(male);
     	System.out.println(female);
	}
}
