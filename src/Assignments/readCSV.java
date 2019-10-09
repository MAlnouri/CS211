package Assignments;

import java.io.*;
import java.util.*;

public class readCSV{

	public static void main(String[] args)
			throws FileNotFoundException {
		
		Scanner input = new Scanner(new File("test.txt"));
		
		//consumes first line
		input.nextLine();
		
		//ArrayList <school> schools = new ArrayList <school>();
		HashMap <Integer, school> schools = new HashMap <Integer, school>();
		
		while (input.hasNext()) {
			
			String line = input.nextLine();
			//splits data separated by tabs
			String[] details = line.split("	");
			
			
			
			school s = new school();
			s.ID = details[0];
			s.code = details[1];
			s.name = details[2];
			s.address = details[3];
			s.city = details[4];
			s.state = details[5];
			s.zip = details[6];
			s.lat = details[7];
			s.lon = details[8];
			
			schools.put(Integer.valueOf(s.ID), s);
			//schools.add(s.ID, s);
			
			}
		//System.out.println(schools.get(4).name);
		//System.out.println(schools.get());
		}
	}