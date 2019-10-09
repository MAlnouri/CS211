/* Mahmmoud Alnouri
 * SID: 950594013
 * 2/23/2018
 * Expression Evaluation Part 1
 * This program reads an array of string expressions and evaluates
 * them using stack push and pop functionality
*/
package Assignments;

import java.util.Arrays;

public class Evaluation1 {
	
	public static int pushed = 0;
	public static int popped = 0;
	public static char[] stack = new char[10];
	public static int stackPointer;
	
	public static void eval(String s, int z) {
		//fills the array with empty spaces
		Arrays.fill(stack, ' ');
		//resets global variables to 0
		stackPointer = 0;
		pushed = 0;
		popped = 0;
		if(z < 10) {
			for(int i = z; i < s.length(); i++) {
				//stores the current char in the string
				char a = s.charAt(i);
				//stores char as in int
				int b = Character.getNumericValue(a);
				
				if(a == '{' || a == '(') {
					//pushes the stack if open bracket/parentheses
					pushed++;
					push(s, i + 1);
				}else if(a == '}' || a == ')') {
					//pops the stack if open bracket/parentheses
					popped++;
					pop(s, i + 1);
				}else if(a == ' ') {
					//do nothing if space
				}else if(b >= 0 && b <= 9) {
					//if the char is a single digit number
				}
			}
		} else {
			System.out.println("Reached end of string");
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
				push(s, i + 1);
				i = s.length();
			}else if(a == '}' || a == ')') {
				//pops the stack if open bracket/parentheses
				popped++;
				pop(s, i + 1);
				i = s.length();
			}else if(a == ' ') {
				//do nothing if space
			}else if(b >= 0 && b <= 9) {
				//if the char is a single digit number, pushes it to the stack
				stack[stackPointer] = a;
				stackPointer++;
				System.out.println(Arrays.toString(stack));
			}else if(a == '+' || a == '*') {
				//if the char is an operand, pushes it to the stack
				stack[stackPointer] = a;
				stackPointer++;
				System.out.println(Arrays.toString(stack));
			}
		}
	}
	
	public static void pop(String s, int z) {
		int result;
		if(pushed >= popped) {
			//pops the operand and integers from the stack and empties their values
			char pop1 = stack[stackPointer - 1];
			char popOp = stack[stackPointer - 2];
			char pop2 = stack[stackPointer - 3];
			stack[stackPointer - 1] = ' ';
			System.out.println(Arrays.toString(stack));
			stack[stackPointer - 2] = ' ';
			System.out.println(Arrays.toString(stack));
			stack[stackPointer - 3] = ' ';
			System.out.println(Arrays.toString(stack));
			stackPointer-=3;
			if(popOp == '+') {
				//performs operation and prints the result
				result = Character.getNumericValue(pop1) + Character.getNumericValue(pop2);
				System.out.println(result);
			} else if(popOp == '*') {
				//performs operation and prints the result
				result = Character.getNumericValue(pop1) * Character.getNumericValue(pop2);
				System.out.println(result);
			}
			
		} else {
			//prints error if missing
			System.out.println("Error: '}' or ')' expected");
		}
		//if(stackCheck()) {
			//if stack is not empty, continues evaluation
			//else terminates
			//eval(s, z + 1);
		//}
	}
	
	public static boolean stackCheck() {
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
			return empty;
		} else {
			System.out.println("The Stack is not empty.");
			return empty;
		}
	}

	public static void main(String[] args) {
		
		String[] A = new String[5];
		
		A[0] = "( 1 + 2 ( 2 + 3 ))";
		A[1] = "{ 3 + 3 ( 3 + 2 )}";
		A[2] = "{ 1 + 1 { 1 + 4 )}";
		A[3] = "( 3 + 1 ( 2 + 1 )}";
		A[4] = "( 1 + 6 } { 2 + 2 ";
		
		//eval method should choose an array value and int of 0 for the loop
		eval(A[0], 0);
		eval(A[1], 0);
		eval(A[2], 0);
		eval(A[3], 0);
		eval(A[4], 0);
		
	}
}
