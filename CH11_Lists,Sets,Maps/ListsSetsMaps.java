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

/**
 * Exercise 2 
 *
 * Write a method called alternate that accepts two Lists as its parameters and returns a new List
 * containing alternating elements from the two lists, in order: first element from first list, 
 * second element from second list, etc
 *
 * If the lists do not contain the same number of elements, the remaining elements from the longer 
 * list should be placed consecutively at the end. 
 *
 * @author Wali Morris 
 * @since 04/27/2020 
 */

import java.util.*;

public class Alternate {
    public static void main(String[] args) {
        List<Integer> input1 = new LinkedList<>(
                        List.of(1, 2, 3, 4, 5));
        List<Integer> input2 = new LinkedList<>(
                        List.of(6, 7, 8, 9, 10, 11, 12));
        System.out.print(input1 + " + " + input2 + " -> ");
        List<Integer> output1 = alternate(input1, input2);
        System.out.println(output1); // input1 and input2
        List<Integer> input3 = new LinkedList<>(
                        List.of(1, 2, 3, 4, 5, 6, 7, 8));
        List<Integer> input4 = new LinkedList<>(
                        List.of(9, 10, 11, 12));
        System.out.print(input3 + " + " + input4 + " -> ");
        List<Integer> output2 = alternate(input3, input4);
        System.out.println(output2); // input3 and input4
        List<Integer> input5 = new LinkedList<>(
                        List.of(1, 2, 3, 4, 5, 6));
        List<Integer> input6 = new LinkedList<>(
                        List.of(7, 8, 9, 10, 11, 12));
        System.out.print(input5 + " + " + input6 + " -> ");
        List<Integer> output3 = alternate(input5, input6);
        System.out.println(output3);
    }
	
    public static List<Integer> alternate(List<Integer> list1,
                    List<Integer> list2) {
        /* each element in Lists will be appended to numbers list */
        List<Integer> numbers = new LinkedList<>();
        /* Until either list is empty, alternate appending number from list1 then 
         * list2. Once any list becomes empty, the alternating of numbers and this
         * loop stops */
        while (!list1.isEmpty() && !list2.isEmpty() ) {
            int num1 = list1.remove(0);
            int num2 = list2.remove(0);
            numbers.add(num1);
            numbers.add(num2);
        }
        /* check to see which list is empty and append the non-empty list to the end 
         * of numbers list. If both list are empty, there is nothing to append and 
         * numbers is returned */
        if ( list1.isEmpty() ) {
            numbers.addAll(list2);
        } else {
            numbers.addAll(list1);
        }
        return numbers;
    }
}

/**
 * Exercise 3 
 *
 * Write a method called removeInRange that accepts four parameters: a LinkedList, an element value
 * a starting index, and an ending index
 *
 * The method's bahavior is to remove all occurrences of the given element that appears in the list
 * between the starting index (inclusive) and the ending index (exclusive)
 *
 * Other values and occurrences of the given value that appear outside the given index range are
 * not affected. 
 *
 * @author Wali Morris 
 * @since 04/28/2020
 */

import java.util.*;

public class RemoveInRange {
    public static void main(String[] args) {
        List<Integer> input1 = new LinkedList<>(
                        List.of(0, 0, 2, 0, 4, 0, 6, 0, 8, 0, 10, 0,
                                12, 0, 14, 0, 16));
        System.out.print(input1 + " -> ");
        List<Integer> output1 = removeInRange(input1, 0, 5, 13);
        System.out.println(output1);
    }
	
    public static List<Integer> removeInRange(List<Integer> list, int element,
                    int start, int end) {
       
	if ( list.isEmpty() ) {
            return list;
        }
        int count = 0; // reports the index
        Iterator<Integer> iter = list.iterator();
        while ( iter.hasNext() && count < end ) { // until end index is reached(exclusive) 
            int current = iter.next(); // get current value
            /* ignore any values before start index, once count reaches start index: if 
             * value is the element being searched than delete it */
            if ( count >= start && current == element ) {
                iter.remove();
            }
            count++;
        }
        return list;
    }
}

**
 * Exercise 4
 *
 * Write a method called partition that accepts a list of integers and an integer value E as its 
 * parameter and rearranges (paritions) the list so that all the elements with values less than 
 * E occur before all elements with values greater than E
 *
 * The exact order of the elements is unimportant, so long as all elements less than E appear 
 * before all elements greater than E
 *
 * Note: You can assume that the list contains no duplicates and does not contain the value E
 *
 * @author Wali Morris 
 * @since 04/28/2020
 */

import java.util.*;

public class Partition {
    public static void main(String[] args) {
        List<Integer> input = new LinkedList<>(
                        List.of(15, 1, 6, 12, -3, 4, 8, 21,
                                2, 30, -1, 9));
        System.out.print(input + " -> ");
        List<Integer> output = partition(input, 5);
        System.out.println(output);
    }
	
    /* Iterates list and removes all elements greater than E and stores this element into 
     * another list2. Once iteration completes, appends all elements greater than E to the 
     * original list
     */
    public static List<Integer> partition(List<Integer> list, int E) {
        List<Integer> list2 = new LinkedList<>();
        Iterator<Integer> iter = list.iterator();
        while ( iter.hasNext() ) {
            int current = iter.next();
            if ( current > E ) {
                iter.remove();
                list2.add(current);
            }
        }
        list.addAll(list2);
        return list;
    }
}

/**
 * Exercise 5
 *
 * Write a method called sortAndRemoveDuplicates that accepts a list of integers as its parameter
 * and rearranges the list's elements into sorted ascending order, as well as removing all duplicate
 * values from the list 
 *
 * Use a Set as part of your solution
 *
 * @author Wali Morris 
 * @since 04/28/2020
 */

import java.util.*;

public class SortAndRemoveDuplicates {
    public static void main(String[] args) {
        List<Integer> input = new LinkedList<>(
                        List.of(7, 4, -9, 4, 15, 8, 27, 11,
                                -5, 32, -9, -9));
        System.out.print(input + " -> ");
        List<Integer> output = sortAndRemoveDuplicates(input);
        System.out.println(output);
    }

    public static List<Integer> sortAndRemoveDuplicates(List<Integer> list) {
        if ( list.size() <= 0 ) {
            throw new IllegalArgumentException("List is Empty");
        }
        /* Creates a Set and removes all duplicates from list */
        Set<Integer> list2 = new HashSet<>(list);
        /* Converts non-duplicate Set back to a list */
        List<Integer> list3 = new LinkedList<>(list2);
        Collections.sort(list3); // sorts list 
        return list3;
    }
}
