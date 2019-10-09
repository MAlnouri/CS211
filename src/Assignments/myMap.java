package Assignments;

//Extra points: used hashmap to store and retrieve data

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import javax.swing.JButton;

class school {
	String ID;
	String code;
	String name;
	String address;
	String city;
	String state;
	String zip;
	String lat;
	String lon;
}

public class myMap {
	
	static String title;
	static String latitude;
	static String longitude;
	static int zoom;
	static int width;
	static int height;
	static int scale;
	static String type;
	static String mark;
	
	public static void main(String[] args)
			throws FileNotFoundException {
		bigData();
		new mapGUI(title, latitude, longitude, zoom, width, height, scale, type, mark);
	}
	
	static void bigData()
			throws FileNotFoundException {
		//scans the bigdata file
		Scanner input = new Scanner(new File("data.txt"));
	
		//consumes first line
		input.nextLine();
		//stores the data in the hashmap
		HashMap <Integer, school> schools = new HashMap <Integer, school>();
		//ArrayList <school> schools = new ArrayList <school>();
		//splits the data and adds it to the arraylist
		int a = 0;
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
			//stores the info in the array
			schools.put(a, s);
			//schools.add(s);
			a++;
		}
		//System.out.println(schools.get(4).name);
		
		title="List of Nearby Schools";
		width = 800;
		height = 800;
		//Seattle set to map center
		latitude = "47.606209";
		longitude = "-122.332071";
		zoom = 11;
		scale = 1;
		type = "roadmap";
		
		int i = 0;
		while(i < schools.size()) {
			//System.out.println(schools.get(i).name);
			mark+="&markers=color:red%7Clabel:" + i + "%7C" + schools.get(i).lat + "," + schools.get(i).lon;
			//JButton m = new JButton(mark+="&markers=color:red%7Clabel:" + i + "%7C" + schools.get(i).lat + "," + schools.get(i).lon);
			//mark+= new JButton("&markers=color:red%7Clabel:" + i + "%7C" + schools.get(i).lat + "," + schools.get(i).lon);
			i++;
		}
	}
}