/**
 * Exercise1 
 *
 * Modify the Sieve Program to make two optimizations
 *
 * Instead of storing all integers up to the maximum in the numbers list, 
 * store only 2 and all odd numbers from 3 upward
 *
 * Write code to ensure that if the first number in the numbers list ever
 * reaches the square root of the maximum, all remaining values from the 
 * numbers list are moved into the primes list. 
 *
 * @author Wali Morris 
 * @since 04/27/2020
 */ 

import java.util.*; 

public class ModifiedSieve { 
    public static void main(String[] args) {
        System.out.println("This program returns a list of Prime numbers.");  
	// receieve max number from keyboard insert
	Scanner keyboard = new Scanner(System.in); 
	System.out.print("Please enter max number: "); 
	int max = keyboard.nextInt(); 

	// if max is less than 2: prints message, exits program 
	if (max < 2) { 
	    System.out.println("No Prime Numbers less than 2, goodbye!"); 
	    System.exit(1); 
	} 
        List<Integer> output = sieve(max); 
        System.out.println(output); 

        // close scanner
	keyboard.close(); 
    } 

    public static List<Integer> sieve(int max) {	    
	/* store only 2 and odd numbers, up to max in a numbers list */ 
        List<Integer> numbers = new LinkedList<>();
        List<Integer> primes = new LinkedList<>(); 	
        for (int i = 2; i <= max; i++) {
	    if( i == 2 || !(i % 2 == 0)) { 
	        numbers.add(i);
	    } 
	}

        /* process numbers list, remove numbers that are a multiples of front element, 
	 * if the square root of the front number is seen than process the remaining 
	 * elements in number list with no checks
	 */
        while ( !numbers.isEmpty() ) { 
	    int front = numbers.remove(0); // get front first element in numbers list	    
            primes.add(front); 
	    if ( front == Math.sqrt(max)) { // element equals square root of max?
		    // add rest of numbers list to primes and return primes
		    primes.addAll(numbers); 
		    return primes;
	    }
	    // remove multiples of this element from rest of numbers list
	    Iterator<Integer> iter = numbers.iterator(); 
	    while ( iter.hasNext() ) { 
                int current = iter.next();  
		if ( current % front == 0) { // remove element if its a multiple of front
		    iter.remove();
		}
	    }
	}
        return primes; 
    } 
}     
