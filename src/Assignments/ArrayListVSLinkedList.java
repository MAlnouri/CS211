/* Mahmmoud Alnouri
 * SID: 950594013
 * 3/2/2018
 * ArrayLists VS LinkedLists
 * This program compares the time it takes for arraylists and linkedlists
 * to perform the same methods and then draws the times as graphs
*/

package Assignments;
import java.util.*;
import javax.swing.*;
import java.awt.*;



public class ArrayListVSLinkedList {
	
	static ArrayList<Integer> listA = new ArrayList<>();
	static ArrayList<Integer> sortA = new ArrayList<>();
	static LinkedList<Integer> listL = new LinkedList<>();
	static LinkedList<Integer> sortL = new LinkedList<>();
	
	//stores start and end times
	static double startTime, endTime;
	//time for arraylist add
	static double timeALadd;
	//time for linkedlist add
	static double timeLLadd;
	//time for arraylist get
	static double timeALget;
	//time for linkedlist get
	static double timeLLget;
	//time for arraylist remove
	static double timeALremove;
	//time for linkedlist remove
	static double timeLLremove;
	//time for arraylist sort
	static double timeALsort;
	//time for linkedlist sort
	static double timeLLsort;
	
	//adds 10k values(between 0-9999) to an empty list
	public static void add() {
		//sets starting time to current system time
		startTime = System.nanoTime();
		for(int i = 0; i < 10000; i++) {
			//adds 10000 values to the arraylist
			listA.add((int)(Math.random() * 10000));
		}
		//sets end time to current system time
		endTime = System.nanoTime();
		//stores and prints the time taken to execute
		timeALadd = (endTime - startTime) / 1000000000;
		//System.out.println("ALadd Execution time: " + timeALadd + " seconds");
		
		//repeats process for the linkedlist
		startTime = System.nanoTime();
		for(int i = 0; i < 10000; i++) {
			//adds 10000 values to the arraylist
			listL.add((int)(Math.random() * 10000));
		}
		endTime = System.nanoTime();
		timeLLadd = (endTime - startTime) / 1000000000;
		//System.out.println("LLadd Execution time: " + timeLLadd + " seconds");
	}
	
	//gets 1000 values from the list by randomly generated indexes
	public static void get()  {
		startTime = System.nanoTime();
		for(int i = 0; i < 1000; i++) {
			//gets 1000 values from the arraylist
			listA.get((int)(Math.random() * 10000));
		}
		endTime = System.nanoTime();
		timeALget = (endTime - startTime) / 1000000000;
		//System.out.println("ALget Execution time: " + timeALget + " seconds");
		
		startTime = System.nanoTime();
		for(int i = 0; i < 1000; i++) {
			//gets 1000 values from the linkedlist
			listL.get((int)(Math.random() * 10000));
		}
		endTime = System.nanoTime();
		timeLLget = (endTime - startTime) / 1000000000;
		//System.out.println("LLget Execution time: " + timeLLget + " seconds");
	}
	
	//removes 1000 values from the list by randomly generated indexes
	public static void remove()  {
		startTime = System.nanoTime();
		for(int i = 0; i < 1000; i++) {
			//removes 1000 values from the arraylist
			listA.remove((int)((Math.random() * 1000)));
		}
		endTime = System.nanoTime();
		timeALremove = (endTime - startTime) / 1000000000;
		//System.out.println("ALremove Execution time: " + timeALremove + " seconds");
		
		startTime = System.nanoTime();
		for(int i = 0; i < 1000; i++) {
			//removes 1000 values from the linkedlist
			listL.remove((int)((Math.random() * 1000)));
		}
		endTime = System.nanoTime();
		timeLLremove = (endTime - startTime) / 1000000000;
		//System.out.println("LLremove Execution time: " + timeLLremove + " seconds");
	}
	
	//creates another list and sorts the values
	public static void sort()  {
		//iterators for each list
		Iterator<Integer> iteratorAL = listA.iterator();
		Iterator<Integer> iteratorLL = listL.iterator();
		
		startTime = System.nanoTime();
		//loops through the arraylist
		while(iteratorAL.hasNext()) {
			//adds the value to the new arraylist
			sortA.add(iteratorAL.next());
		}
		//sorts the arraylist
		Collections.sort(sortA);
		endTime = System.nanoTime();
		timeALsort = (endTime - startTime) / 1000000000;
		//System.out.println("ALsort Execution time: " + timeALsort + " seconds");
		
		startTime = System.nanoTime();
		//loops through the linkedlist
		while(iteratorLL.hasNext()) {
			//adds the value to the new arraylist
			sortL.add(iteratorLL.next());
		}
		//sorts the arraylist
		Collections.sort(sortL);
		endTime = System.nanoTime();
		timeLLsort = (endTime - startTime) / 1000000000;
		//System.out.println("LLsort Execution time: " + timeLLsort + " seconds");
	}

	public static void main(String[] args) {
		
		add();
		new barFrame(timeALadd);
		new barFrame(timeLLadd);
		get();
		new barFrame(timeALget);
		new barFrame(timeLLget);
		remove();
		new barFrame(timeLLremove);
		new barFrame(timeLLremove);
		sort();
		new barFrame(timeALsort);
		new barFrame(timeLLsort);
	}

}
