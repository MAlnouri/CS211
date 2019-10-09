package Assignments;
import java.util.Scanner;

public class burger211 {
	
	public static void main(String[] args) {
		//input from user to set burger prices and franchise name
		Scanner input = new Scanner(System.in);
		
		//instantiate the class
		//console will request input for a store name, and 3 prices
		PrintMenu Menu = new PrintMenu(input.next(), input.nextDouble(), input.nextDouble(), input.nextDouble());
		input.close();
	}

}
