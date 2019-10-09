/* Mahmmoud Alnouri
 * SID: 950594013
 * m.alnouri@bellevuecollege.edu
 * 3/10/2018
 * Priority Queue
 * This program uses arraylist methods to simulate a min-heap priority queue
 * The arraylist adds and removes randomly generated elements and sorts
 * itself through bubbling up/down nodes and heap ordering
*/

package Assignments;
import java.util.ArrayList;
import java.util.Random;

public class PriorityQueue {

	public static void main(String[] args) {
		Random r = new Random();
		//stores boolean to check if tree is empty
		boolean empty = true;
		//stores boolean to check if tree is sorted
		boolean sorted;
		//arraylist to store values as heap tree
		ArrayList<Integer> tree = new ArrayList<Integer>();
		
		for(int node = 1; node <= 30; node++) {
			//if heap tree size is less than 1, tree is empty
			if(tree.size() < 1) {
				empty = true;
			//else tree is not empty
			} else {
				empty = false;
			}
			//generates random number between 0-1 (inclusive)
			int rand = r.nextInt(2);
			//if random number is 0
			if(rand == 0) {
				//generates new random number between 1-100 (inclusive)
				int rand2 = r.nextInt(100) + 1;
				//adds the number to the tree
				tree.add(rand2);
				//sorts the arraylist
				sorted = false;
				int k = tree.size() - 1;
				//compares the new element to the node above and moves it until the tree is sorted
				while(!sorted) {
					//if reached top of the tree, then tree is sorted
					if(k == 0) {
						sorted = true;
					//if the new value is less than the node above, swaps the nodes
					} else if(k == 1 && tree.get(1) < tree.get(0)) {
						int temp = tree.get(1);
						tree.set(1, tree.get(0));
						tree.set(0, temp);
					} else if(tree.get(k) < tree.get(k / 2)) {
						int temp = tree.get((k / 2));
						tree.set((k / 2), tree.get(k));
						tree.set(k, temp);
					//otherwise tree is sorted
					} else {
						sorted = true;
					}
					//adjust k to continue loop through nodes
					k = (k / 2);
				}
				//prints the arraylist
				System.out.print(node + " Add " + rand2 + ": ");
				System.out.println(tree);
			}
			//if random number is 1 and heap tree is not empty
			if(rand == 1 && !empty) {
				System.out.print(node + " Remove " + tree.get(0) + ": ");
				//removes min from the tree and replaces with last node
				tree.set(0, tree.get(tree.size() - 1));
				tree.remove(tree.size() - 1);
				//sorts the arraylist
				sorted = false;
				int k = 0;
				//compares the top node to the nodes below and moves it until tree is sorted
				while(!sorted) {
					//if the node is at the end of the tree, the tree is sorted
					if((k * 2) + 1 > tree.size() - 1) {
						sorted = true;
					//if the node is greater than left node below, swaps them
					} else if(tree.size() - 1 > (k * 2) + 1 && tree.get(k) > tree.get((k * 2) + 1)) {
						int temp = tree.get(k);
						tree.set(k, tree.get((k * 2) + 1));
						tree.set((k * 2) + 1, temp);
						//adjusts k for next loop
						k = (k * 2) + 1;
					//if the node is greater than right node below, swaps them
					} else if(tree.size() - 1 > (k * 2) + 2 && tree.get(k) > tree.get((k * 2) + 2)) {
						int temp = tree.get(k);
						tree.set(k, tree.get((k * 2) + 2));
						tree.set((k * 2) + 2, temp);
						//adjusts k for next loop
						k = (k * 2) + 2;
					//otherwise the tree is sorted
					} else {
						sorted = true;
					}
					//checks sort of both sides of the tree
					k = 0;
					//loops through the tree
					while(k < tree.size()) {
						//sorts left node of tree
						if(tree.size() - 1 > (k * 2) + 1 && tree.get(k) > tree.get((k * 2) + 1)) {
							int temp = tree.get(k);
							tree.set(k, tree.get((k * 2) + 1));
							tree.set((k * 2) + 1, temp);
						}
						//sorts right node of tree
						if(tree.size() - 1 > (k * 2) + 2 && tree.get(k) > tree.get((k * 2) + 2)) {
							int temp = tree.get(k);
							tree.set(k, tree.get((k * 2) + 2));
							tree.set((k * 2) + 2, temp);
						}
						//sorts if tree has only 2 nodes
						if(tree.size() == 2 && tree.get(0) > tree.get(1)) {
							int temp = tree.get(1);
							tree.set(1, tree.get(0));
							tree.set(0, temp);
						}
						//adjusts k for next loop
						k = (k * 2) + 1;
					}
					
				}
				//if tree is empty, prints empty tree
				if(tree.size() == 0) {
					empty = true;
					System.out.println("[]");
				} else {
					//prints the arraylist
					System.out.println(tree);
				}
			//if tree is empty and tries to remove, lowers the node once
			} else if(empty && rand == 1) {
				node--;
			}
			
		}

	}

}
