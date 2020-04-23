/**
 * Exercise 1 
 * 
 * Write a method called averageVowels that takes an ArrayList of Strings as a 
 * parameter and returns the average number of vowel characters ( a, e, i, o, u)
 * in all Strings in the List
 *
 * If your method is passed an empty String it should return 0.0
 *
 * @author Wali Morris
 * @since  04/20/2020
 */

import java.util.*; 

public class AverageVowels { 
    public static void main(String[] args) { 
	ArrayList<String> input = new ArrayList<>(
			List.of("Building", "Java", "Programs"));
        double output = averageVowels(input); 
        System.out.println("Average number of Vowels: " + output); 
    } 

    public static double averageVowels(ArrayList<String> list) { 
	double base = 0.0; 
	if ( list.size() == 0 ) { 
	    return base; 
	}
	double vowelCount = 0.0; 
	for ( int i = 0; i < list.size(); i++ ) { 
	    double strBase = list.get(i).length(); // get the length of each word 
            base += strBase; // and sum the length of every word as base
            for ( int j = 0; j < list.get(i).length(); j++ ) {
	        char s = list.get(i).charAt(j); // view every letter of every word, is it a vowel?
	        if ( s == 'a' || s == 'e' || s == 'i' || s == 'o' || s == 'u' ) {
		    vowelCount++; // found vowel, increase vowelCount
		} 
	    } 
	} 
        return vowelCount / base; // return average count of vowels
    } 
}     
	        	    
/**
 * Exercise 2 
 *
 * Write a method called swapPairs that switches the order of values in an ArrayList
 * of Strings in a pairwise fashion
 *
 * Your method should switch the order of the first two values, then switch the order 
 * of the next two, and so on
 *
 * If the number of elements is odd, the method should not remove the final method
 *
 * @author Wali Morris
 * @since  04/20/2020
 */

import java.util.*;

public class SwapPairs {
    public static void main(String[] args) {
        ArrayList<String> input = new ArrayList<>(
                        List.of("to", "be", "or", "not", "to", "be", "Hamlet"));

        System.out.print(input + " -------> ");
        swapPairs(input);
    }

    public static void swapPairs(ArrayList<String> list) {
        int i = 0;
        int jumps = 0;
        while ( jumps < list.size() / 2 ) {
            String temp = list.get(i); // holds string in current pos in temp  
            list.set(i, list.get(i+1)); // puts next String in place of current
            list.set(i+1, temp); // swaps i+1 for i 
            i += 2; // skip one place
            jumps++;
        }
        System.out.println(list);
    }
}

/**
 * Exercise 3
 *
 * Write a method called removeEvenLength that takes an ArrayList of 
 * Strings as parameter and removes all of the strings of even length
 * from the list
 *
 * @author Wali Morris 
 * @since  04/20/2020
 */

import java.util.*;

public class RemoveEvenLength {
    public static void main(String[] args) {
        ArrayList<String> input = new ArrayList<>(
                        List.of("Aquafina", "water", "is", "nice", "and", "cold"));

        System.out.print(input + " --------> ");
        removeEvenLength(input);
    }

    public static void removeEvenLength(ArrayList<String> list) {
        for ( int i = list.size() - 1; i >= 0; i-- ) { // begin at last word
            String word = list.get(i);
            if ( word.length() % 2 == 0 ) {
                list.remove(i); // word is even, delete it  
            }
        }
        System.out.println(list);
    }
}

/**
 * Exercise 4
 *
 * Write a method called doubleList that takes an ArrayList of strings as a
 * parameter and replaces every string with two of that same string. 
 *
 * @author Wali Morris 
 * @since 04/20/2020
 */

import java.util.*;

public class DoubleList {
    public static void main(String[] args) {
        ArrayList<String> input = new ArrayList<>(
                        List.of("How", "are", "you", "today"));
        doubleList(input);
    }

    public static void doubleList(ArrayList<String> list) {
        for (int i = 0; i < list.size(); i+=2 ) {
            String clone = list.get(i);
            /* adds the current cloned String to next position, then skips one pos */
            list.add(i+1, clone);
        }
        System.out.println(list);
    }
}

/** 
 * Exercise 5
 *
 * Write a method called scaleByK that takes an ArrayList of integers as a 
 * parameter and replaces every integer of value K with K copies of itself
 *
 * Zero and negative numbers should be removed from the list by this method 
 *
 * @author Wali Morris 
 * @since 04/21/2020
 */

import java.util.*;

public class ScaleByK {
    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>(
                        List.of(4, 1, 2, 0, 3, 9, 5, 10));
        System.out.print(input + " -----> ");
        scaleByK(input);
    } 
	
    /* Taking advantage of iterating backwards in the list allows for duplicates to be placed at the 
     * current position, shifting the original and each placed duplicate number to the right to make 
     * room for the new duplicate taking its place while also keeping track of the position in the 
     * loop. Ready to go to next(left) position after the duplicates have been added. Note that k in 
     * the nested loop represents the number of times a number should be appended. Because the number 
     * already exist in the list, it should be appended k-1 times. 
     */
    public static void scaleByK(ArrayList<Integer> numberList) {
        for( int i = numberList.size()-1; i >= 0; i-- ) {
            int k = numberList.get(i);
            if ( k > 0 ) { // is k (num at current pos) greater than 0?
                for ( int j = 0; j < k-1; j++ ) {
                    numberList.add(i, k); // yes? add k: k-1 times 
                }
            } else {
                numberList.remove(numberList.get(i)); // no? delete k 
            }
        }
        System.out.println(numberList);
    }
}

/**
 * Exercise 6
 *
 * Write a method called minToFront that takes an ArrayList of integers as a 
 * parameter and moves the minimum value in the list to the front, otherwise 
 * preserving the order of the elements
 *
 * NOTE: Does this method assume all integers are unique, if not what is the 
 * case for minimum values that are in the list multiple times?  
 *
 * @author Wali Morris 
 * @since 04/21/2020
 */

import java.util.*;

public class MinToFront {
    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>(
                        List.of(3, 8, 92, 4, 2, 17, 9, 5, 11, 0, -3));
        System.out.print(input + " -----> ");
        minToFront(input);
    }

    public static void minToFront(ArrayList<Integer> list) {
        // list(0) begins as minimum integer until a smaller value is found    
        int min = list.get(0), i = 0, index = 0;
        for ( Integer num : list ) {
            if ( num < min ) { // num smaller than min?
                min = num; // yes, num becomes min
                index = i; // record index of min 
            }
            i++; // go to next
        }
        list.remove(index); // remove min at its index from list 
        list.add(0, min); // append min integer to front 
        System.out.println(list);
    }
}

/**
 * Exercise 7 
 *
 * Write a method called removeDuplicates that takes as a parameter a sorted 
 * ArrayList of strings and eliminates any duplicates from the list 
 *
 * Values will be sorted and all duplicates will be grouped together
 *
 * Assume that the ArrayList contains only String values
 *
 * @author Wali Morris 
 * @since 04/21/2020
 */

import java.util.*;

public class RemoveDuplicates {
    public static void main(String[] args) {
        ArrayList<String> input = new ArrayList<>(
                        List.of("be", "be", "is", "not", "or", "question",
                                "that", "the", "to", "to"));
        System.out.print(input + " -----> ");
        removeDuplicates(input);
    }

    /* Iterating from the last String object in the list allows our loop pointer 
     * to keep it's place while deleting the duplicate, if there is one, in front 
     * ( to the left) of its current String object. After that delection, the loop 
     * pointer moves to the next position to the left and repeats this process.
     */
    public static void removeDuplicates(ArrayList<String> list) {
        if ( list.size() == 0 ) {
            System.out.println(list);
        } else {
            for (int i = list.size()-1; i > 0; i-- ) {
                if ( list.get(i-1).equals(list.get(i)) ) {
                    list.remove(list.get(i-1));
                }
            }
        }
        System.out.println(list);
    }
}

/**
 * Exercise 8 
 *
 * Write a method called removeZeroes that takes as a parameter an ArrayList of 
 * integers and eliminates any occurrances of the number 0 from the list
 *
 * Note: This uses the ArrayList indexOf() method although there are numerous 
 * different solutions 
 *
 * @author Wali Morris 
 * @since 04/21/2020
 */

import java.util.*;

public class RemoveZeroes {
    public static void main(String[] args) {
        ArrayList<Integer> input1 = new ArrayList<>(
                        List.of(0, 7, 2, 0, 0, 4, 0));
        ArrayList<Integer> input2 = new ArrayList<>(
                        List.of(1, 7, 2, 3, 5, 4, 6));
        ArrayList<Integer> input3 = new ArrayList<>();
        System.out.print(input1 + " -----> ");
        removeZeroes(input1);
        System.out.print(input2 + " -----> ");
        removeZeroes(input2);
        System.out.print(input3 + " -----> ");
        removeZeroes(input3);
    }
	
    public static void removeZeroes(ArrayList<Integer> list) {
        if( !(list.contains(0))) {
            // prints lists that do not contain a 0 as is, including empty lists
            System.out.println(list);
        } else {
            /* while a list contains a 0, remove the first instance of 0. Does not need 
             * to iterate the entire list. Stops and prints the list once there are no 
             * longer any 0's */
            while ( list.contains(0) ) {
                list.remove(list.indexOf(0));
            }
            System.out.println(list);
        }
    }
}

/**
 * Exercise 9 
 *
 * Write a method called rangeBetweenZeroes that takes as a parameter an ArrayList
 * of integers and returns the number of indexes apart the two farthest occurances
 * of the number 0 are
 *
 * NOTE: This method is inclusive of the index of each 0, that is, each instance of 
 * zero corresponds to an index and we should count that index as a distance from 
 * the next 0 and also count the last instance of 0
 *
 * @author Wali Morris 
 * @since 04/21/2020
 */

import java.util.*;

public class RangeBetweenZeroes {
    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>(
                        List.of(7, 2, 0, 0, 4, 0, 9, 0, 6, 4, 8));
        int output = rangeBetweenZeroes(input);
        System.out.println("Range between zeroes: " + output);
    }

    /* if the first index of zero equals the last index of zero we know this index refers
     * to the same instance of 0 and therefore only 1 zero in the list. In the instance of 
     * multiple 0s we return the last index - first index + 1(to account for the first instance)
     */
    public static int rangeBetweenZeroes(ArrayList<Integer> list) {
        if ( !(list.contains(0))) { return 0; }
        else if ( list.indexOf(0) == list.lastIndexOf(0)) { return 1; }
        else return list.lastIndexOf(0) - list.indexOf(0) + 1;
    }
}