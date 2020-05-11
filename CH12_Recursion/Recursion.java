/**
 * Example from book
 *
 * @author Wali Morris 
 * @since 05/05/2020
 */

import java.util.*; 

public class RecursionExample { 
    public static void main(String[] args) { 
	toZero(100); 
    } 

    public static void toZero(int x) {  
	if ( x >= 0 ) { // recursive case
	    System.out.println(x); 	  	
	    toZero(x - 1); 
	}	    
    }  
}     

/**
 * Exercise 2 
 *
 * Write a method called writeNums that takes an integer n as a parameter and prints to the console
 * the first n integers starting with 1 in sequential order, seperated by commas
 *
 * @author Wali Morris 
 * @since 05/06/2020
 */

import java.util.*;

public class WriteNums {
    public static void main(String[] args) {
        writeNums(5);
        System.out.println();
        writeNums(12);
        System.out.println();
    }

    public static void writeNums(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("Argument less than 1 error");
        } else if ( n < 2 ) { // base case: once 1 is reached, print 1 and unravel nums 
            System.out.print(n);
        /* recursive case: each num stacks on top of the other and once num reaches 1, the top
         * num(2) to the bottom num(12) will be printed to console */
        } else {
            writeNums(n-1);
            System.out.print(", " + n);
        }
    }
}
