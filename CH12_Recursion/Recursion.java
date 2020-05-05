/**
 * Example
 *
 * A try at defining a recursive method before starting Chapter 12 reading and exercises 
 * 
 * NOTE: There's a really good chapter on recursion in GEB by @Douglas R. Hofstadter
 * to read and review 
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
