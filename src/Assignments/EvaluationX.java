/* Mahmmoud Alnouri
 * SID: 950594013
 * 2/23/2018
 * Expression Evaluation Part 1
 * This program reads an array of string expressions and evaluates
 * them using stack push and pop functionality
*/
package Assignments;

import java.util.ArrayList;

public class EvaluationX {
	
	public static int pushed = 0;
	public static int popped = 0;
	public static char[] stack = {' ',' ',' ',' ',' ',' ',' ',' ',' ',' '};
	public static int stackPointer;
	
	public static void eval(String s) {
		
		for(int i = 0; i < s.length(); i++) {
			//stores the current char in the string
			char a = s.charAt(i);
			//stores char as in int
			int b = Character.getNumericValue(a);
			
			if(a == '{' || a == '(') {
				//pushes the stack if open bracket/parentheses
				pushed++;
				push(s, i);
			}else if(a == '}' || a == ')') {
				//pops the stack if open bracket/parentheses
				popped++;
				pop(s, i);
			}else if(a == ' ') {
				//do nothing if space
			}else if(b >= 0 && b <= 9) {
				//if the char is a single digit number
			}
			
		}
		
	}
	
	public static void push(String s, int z) {
		for(int i = z; i < s.length(); i++) {
			//stores the current char in the string
			char a = s.charAt(i);
			//stores char as in int
			int b = Character.getNumericValue(a);
			
			if(a == '{' || a == '(') {
				//pushes the stack if open bracket/parentheses
				pushed++;
				push(s, i);
			}else if(a == '}' || a == ')') {
				//pops the stack if open bracket/parentheses
				popped++;
				pop(s, i);
			}else if(a == ' ') {
				//do nothing if space
			}else if(b >= 0 && b <= 9) {
				//if the char is a single digit number, pushes it to the stack
				stack[stackPointer] = a;
				stackPointer++;
			}else if(a == '+' || a == '*') {
				//if the char is an operand, pushes it to the stack
				stack[stackPointer] = a;
			}
		}
	}
	
	public static void pop(String s, int z) {
		for(int i = z; i < s.length(); i++) {
			
		}
	}
	
	public static void stackCheck() {
		boolean empty = false;
		//checks each index of the stack and returns if stack is empty or not
		//stack is empty is all chars in the array are spaces
		for(int i = 0; i < stack.length - 1; i++) {
			if(stack[i] != ' ') {
				empty = false;
			} else {
				empty = true;
			}
		}
		if(empty) {
			System.out.println("The Stack is empty.");
		} else {
			System.out.println("The Stack is not empty.");
		}
	}

	public static void main(String[] args) {
		
		String[] A = new String[5];
		
		A[0] = "{ 1 + 3 * { 2 - 1 ) }";
		A[1] = "( 1 + 3 * { 2 – 1 ) }";
		//A[2] = "( 1 + 3 * { 2 – 1 ) }";
		//A[3] = "( 1 + 3 * { 2 – 1 ) }";
		A[4] = "( 1 + 3 * ( 2 – 1 ) (";
		
		//String a = "test123";
		//int b = a.charAt(5);
		char[] test = new char[10];
		test[0] = 'a';
		test[1] = '+';
		System.out.println(test[2]);
		//System.out.println(Character.getNumericValue(a.charAt(5)));
		
	}
}
