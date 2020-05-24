/**
 * Write a void method selectionSortDescendTrace() that takes in an integer array
 * and sorts the array into descending order
 *
 * The method should use nested loops and output the array after each iteration of 
 * the outer loop, thus outputting the array N - 1 times (where N is the size) 
 *
 * Complete main() to read in a list of up to 10 positive integers (ending in -1) 
 * and then call the selectionSortDescendTrace() method 
 *
 * @author Wali Morris 
 * @since 05/24/2020
 */ 

import java.util.*; 

public class DescendingOrder { 
    public static void main(String[] args) { 
	Scanner scnr = new Scanner(System.in); 

	int input = 0, i = 0; 
	int numElements = 0; 
	int[] numbers = new int[10]; 

	/* while inputting integers, if integer is -1, stop the loop. The loop 
	 * will also exit if 10 integers have been selected */ 
	while ( !(input == -1 || i == 10) ) { 
	    System.out.print("Enter an integer: "); 	
	    input = scnr.nextInt(); 
	    if ( !(input == -1) ) { // if -1 has not been written 
	        numbers[i] = input; // input the written integer to number array at index i
		numElements++; // count number of elements in array so far
		i++; // increment i to keep track of index 
	    }	 
	} 	
        selectionSortDescendTrace(numbers, numElements);  
    } 

    public static void selectionSortDescendTrace(int[] numbers, int numElements) {
	for (int i = 0; i < numElements; i++ ) { // begins with first element in array
            for ( int j = i + 1; j < numElements; j++ ) { // j points to next element to the right of i 
                if ( numbers[i] < numbers[j] ) { // if j is greater than i
		    /* swap j (larger number) to the beginning of array and i (smaller number) to the end */ 	
		    int temp = numbers[i];
	            numbers[i] = numbers[j]; 
	            numbers[j] = temp; 
		} 
	    } 
	    /* creates a visual output to view the array as larger numbers are moved to the 
	     * beginning of array and smaller numbers are moved to the end */ 
	    String arrayElements = ""; 
	    arrayElements += numbers[0]; 
            for ( int k = 1; k < numElements; k++ ) { 
	        arrayElements += " " + numbers[k]; 
	    } 
	    /* Prints the elements of the numbers array every iteration, showing the next largest 
	     * number at the beginning */ 
            System.out.println(arrayElements); 
	}	    
    } 
}     
	        	    
	

