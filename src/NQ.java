/*Citations.
 * Programming Interview: N Queens Problem (Backtracking)
 * https://www.youtube.com/watch?v=p4_QnaTIxkQ
 * 
 * This was a great explanation of the problem.
 * https://developers.google.com/optimization/puzzles/queens
 * 
 * "Introduction to programming in Java by Sedgewick and Wayne"
 * Chapter 2 - Recursions. 
 */

import java.util.*;
public class NQ {

	protected static Scanner myScanner;
	protected static int numOfSolutins;

	public static void main(String[] args) {
		
		

		int n = 0;
		int[] boardN = null;

		myScanner = new Scanner(System.in);
		//First let's get the number of queens.
		System.out.print("Hi, please enter the number of queens. ");
		try {
			n  = myScanner.nextInt();
		} catch(Exception e) {
			//Just any kind of exception.
			System.out.println("Oops. Try again. " + e );
		} finally {
			//We should close this no matter what. Right? :)
			myScanner.close();
		}
		
		long startTime = System.currentTimeMillis();

		//Ok now let's first create a board.
		//In the array the index will the rows 
		//And the values will be the placed queens. 
		//boardN[1] = 3 would mean that the queen is 
		//2nd row and 3rd column.
		boardN = new int[n];

		placeQ(boardN, 0);
		
		System.out.println("Total number of solutions: " + 
							numOfSolutins);
		
		long estimatedTime = System.currentTimeMillis() - startTime;
		
		//To convert to seconds divide by 1'000'000'000.
		System.out.println("Time: " + estimatedTime + " nanoseconds");
	}

	public static void placeQ(int[] arrN, int n1 ) {
		int numOfQ = arrN.length;

		//If all the queens are placed then we can print.
		if (n1 == numOfQ) {
			printResult(arrN);
		} else {

			for (int i = 0; i < numOfQ; i++) {
				//Place a queen.
				arrN[n1] = i;
				//Now make sure it's in the right place.
				if(checkPlace(arrN, n1)) {
					//Backtrack.
					placeQ(arrN, n1 + 1);
				}//End of if.
			}//End of for.
		}//End of else.
	}//End of the function.
	//I found this way of checking in the recursions chapter
	//of "Introduction to programming in Java by Sedgewick and Wayne"
	//It had a similar N-Queens exercise and some hints. :)
	public static boolean checkPlace(int[] arrN, int n1) {
		for (int i = 0; i < n1; i++) {
			if(arrN[i] == arrN[n1]) {
				//Check the column.
				return false;
			}
			if ((arrN[i] - arrN[n1]) == (n1 - i)) {
				//Check the major diagonal.
				return false;
			}
			if ((arrN[n1] - arrN[i]) == (n1 - i)) {
				//Check minor.
				return false;
			}
		}
		//If there is not conflict return true.
		return true;
	}
	public static void printResult(int[] arrN) {
		//This method is pretty straight forward. 
		for (int i = 0; i < arrN.length; i++) {
			for (int j = 0; j < arrN.length; j++) {
				if (arrN[i] == j) {
					System.out.print(" Q ");

				} else {
					System.out.print(" - ");
				}
			}
			System.out.println();

		}
		numOfSolutins += 1;
		System.out.println("Solution #: " + numOfSolutins);
		System.out.println();
	}

}
