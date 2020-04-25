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

/**
 * Exercise 10 
 *
 * Write a method called removeInRange that accepts three parameters, an ArrayList of 
 * strings, a beginning string, and an ending string and removes from the list any of 
 * strings that fall alphabetically between the start and end strings
 *
 * You may assume that the start string alphabetically precedes the ending string
 *
 * @author Wali Morris 
 * @since 04/22/2020
 */

import java.util.*;

public class RemoveInRange {
    public static void main(String[] args) {
        ArrayList<String> inputStrings = new ArrayList<>(
                        List.of("to", "be", "or", "not", "to", "be",
                                "that", "is", "the", "question"));
        String begin = "free", end = "rich";
        System.out.print(inputStrings + " -----> ");
        removeInRange(inputStrings, begin, end);
    }

    /* This method initializes the beginning and end strings' first characters as the range 
     * in which to compare all other strings in the ArrayList. Taking advantage of char type 
     * which has increasing integer value. In this case, if any strings in the ArrayList has 
     * a first letter with a value between the beginning and end strings, it'll be removed. 
     */
    public static void removeInRange(ArrayList<String> list, String beg, String end) {
        /* all String types are converted to lowercase */
        char firstRange = Character.toLowerCase(beg.charAt(0));
        char lastRange = Character.toLowerCase(end.charAt(0));
        for ( int i = list.size() -1; i >= 0; i-- ) {
            char current = Character.toLowerCase(list.get(i).charAt(0));
            if ( current > firstRange && current < lastRange ) {
                list.remove(list.get(i));
            }
        }
        System.out.println(list);
    }
}

/**
 * Exercise 11 
 *
 * Write a method called stutter that accepts an ArrayLIst of strings and an integer k as 
 * parameters and replaces every string with k copies of that string
 *
 * NOTE: In this program if k is 0 or negative, ArrayLists are cleared 
 *
 * @author Wali Morris 
 * @since 04/23/2020
 */

import java.util.*;

public class Stutter {
    public static void main(String[] args) {
        ArrayList<String> input = new ArrayList<>(
                        List.of("how", "are", "you"));
        ArrayList<String> input2 = new ArrayList<>(
                List.of("welcome", "aboard", "captain"));
        int x = 4, y = 0;
        System.out.print(input + " -----> ");
        stutter(input, x);
        System.out.print(input2 + " -----> ");
        stutter(input2, y);
    }
	
    public static void stutter(ArrayList<String> list, int k) {
        if ( k <= 0 ) {
            list.clear();// k is 0 or less, clear list 
            System.out.println(list);
        } else {
            for (int i = 0; i < list.size(); i += k ) {
                String duplicate = list.get(i); // record the string 
                for ( int j = 0; j < k-1; j++ ) { // append duplicate k-1 times 
                    list.add(i+1, duplicate);
                }
            }
            System.out.println(list);
        }
    }
}

/**
 * Exercise 12 
 *
 * Write a method called markLength4 that accepts an ArrayList of strings as a parameter 
 * and that places a string of four asterisks "****" in front of every string of length 4
 *
 * @author Wali Morris 
 * @since 04/23/2020
 */

import java.util.*;

public class MarkLength4 {
    public static void main(String[] args) {
        ArrayList<String> input = new ArrayList<>(
                        List.of("this", "is", "lots", "of", "fun",
                                "for", "Java", "programmers"));
        System.out.print(input + " ----- > ");
        markLength4(input);
    }

    public static void markLength4(ArrayList<String> list) {
        for (int i = 0; i < list.size(); i++ ) {
            if ( list.get(i).length() == 4 ) { // string is 4 characters long? 
                list.add(i+1, list.get(i)); // push it to right 
                list.set(i, '"' + "****" + '"'); // add 4 asterisks in it's old index
                i++; // skip to next string in list 
            }
        }
        System.out.println(list);
    }
}

/**
 * Exercise 13 
 *
 * Write a method called reverse3 that accepts an ArrayList of integer values as a parameter 
 * and reverses each successive sequence of three values in the list
 *
 * If the list has extra values that are not part of a sequence of three, those values are 
 * unchanged 
 *
 * Note: consider the loop for the reverse3 method: the loop will increment only one position, 
 * so if a sequence of three have been flipped and the loop points to the next value after the 
 * flip; this next value plus the sequence of three could possibly fill the case of yet another
 * flip
 *
 * @author Wali Morris 
 * @since 04/23/2020
 */

import java.util.*;

public class Reverse3 {
    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>(
                        List.of(3, 9, 2, 43, 7, 26, 29, -8, 10, 11));
        System.out.print(input + " -----> ");
        reverse3(input);
    }

    public static void reverse3(ArrayList<Integer> list) {
        for (int i = 0; i < list.size()-1; i++) {
            /* for every iteration, check the current integer value and the next two, take
             * into consideration that the middle value in a sequence is unchanged
             */
            if ( list.get(i) < list.get(i+1) && list.get(i+1) < list.get(i+2) ) { // is there a sequence?  
                int temp = list.get(i); // store the value of the first integer in sequence
                list.set(i, list.get(i+2)); // set the first value as the third value in sequence
                list.set(i+2, temp); // set the third value as the first 
            }
        }
        System.out.println(list);
    }
}

/**
 * Exercise 14 
 *
 * Write a method called removeShorterString that accepts an ArrayList of strings as a parameter and 
 * removes from each pair of values the shorter string in the pair
 *
 * If the list is of odd length the final element is unchanged
 *
 * Note: If two elements are of equal length, the second element is removed
 *
 * @author Wali Morris 
 * @since 04/24/2020 
 */

import java.util.*;

public class RemoveShorterString {
    public static void main(String[] args) {
        ArrayList<String> input1 = new ArrayList<>(
                        List.of("four", "score", "and", "seven", "years",
                                "ago", "our"));
        ArrayList<String> input2 = new ArrayList<>(
                        List.of("while", "loops", "are", "useful"));
        System.out.print(input1 + " -----> ");
        removeShorterString(input1);
        System.out.print(input2 + " -----> ");
        removeShorterString(input2);
    }
    /* We know based on the size on an ArrayList that N/2 elements will be removed. So 
     * until this condition is met, continue to compare elements and delete the shorter
     * element. If two elements are of equal length, the second element is deleted. 
     */
    public static void removeShorterString(ArrayList<String> list) {
        if ( list.size() == 0 ) {
            System.out.println(list);
        } else {
            for ( int i = 0; i < list.size() / 2 + 1; i++ ) {
                if ( list.get(i).length() < list.get(i+1).length() ) {
                    list.remove(list.get(i));
                } else {
                    list.remove(list.get(i+1));
                }
            }
            System.out.println(list);
        }
    }
}

/**
 * Exercise 15 
 *
 * Write a method called filterRange that accepts an ArrayList of Integers and two integer 
 * values min and max as parameters and removes all elements whose values are in the range 
 * min through max ( inclusive )
 *
 * If no elements in the range min-max are found in the list, or if the list is initially 
 * empty, the list's contents are unchanged
 *
 * NOTE: This exercise asks to remove values in the range from min-max; if a value in the 
 * list is between the two numbers it is deleted but it does not mean the values at the 
 * indexes min-max will be deleted
 *
 * @author Wali Morris 
 * @since 04/24/2020
 */

import java.util.*;

public class FilterRange {
    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>(
                        List.of(4, 7, 9, 2, 7, 7, 5, 3, 5, 1,
                                7, 8, 6, 7));
        int xMin = 5, xMax = 7;
        System.out.print(input + " -----> ");
        filterRange(input, xMin, xMax);
    }
    
    /* Takes an ArrayList of integers, a low number(min) and high number(max) and 
     * deletes any integer in the list that is between min and max (inclusive), 
     * begins at the last value in the list
     */
    public static void filterRange(ArrayList<Integer> list, int min, int max) {
        if ( list.size() == 0 ) {
            System.out.println(list); // empty list, print list to output  
        } else {
            for (int i = list.size() - 1; i >= 0; i--) { // begin at last element in list
                if ( list.get(i).compareTo(min) >= 0 && list.get(i).compareTo(max) <= 0 ) { 
                    // element is between min and max?  
                    list.remove(list.get(i)); // delete element 
                }
            }
            System.out.println(list);
        }
    }
}

/**
 * Exercise 16 
 *
 * Write a method called clump that accepts an ArrayList of strings as a parameter and replaces
 * each pair of strings with a single string that consists of the two original strings in 
 * parenthesis seperated by a space
 *
 * If the list is of odd length, the final element is unchanged
 *
 * @author Wali Morris 
 * @since 04/24/2020
 */

import java.util.*;

public class Clump {
    public static void main(String[] args) {
        ArrayList<String> input1 = new ArrayList<>( // odd length list
                        List.of("four", "score", "and", "seven", "years",
                                "ago", "our"));
        ArrayList<String> input2 = new ArrayList<>( // even length list 
                        List.of("four", "score", "and", "seven", "years",
                                "ago"));
        ArrayList<String> input3 = new ArrayList<>(); // list with 1 String
        input3.add("four");
        ArrayList<String> input4 = new ArrayList<>( // list with 2 strings
                        List.of("four", "score"));

        System.out.print(input1 + " -----> ");
        clump(input1);
        System.out.print(input2 + " -----> ");
        clump(input2);
        System.out.print(input3 + " -----> ");
        clump(input3);
        System.out.print(input4 + " -----> ");
        clump(input4);
    }
    
    /* This method iterates a list and combines two strings by concatenating element at 
     * list(i) and element at list(i+1), sets the combined element at list(i) and deletes 
     * the extra element at list(i+1). We know combining elements and reaching the end of 
     * the list will only take list/2 iterations of the loop. Prints the ilist of combined 
     * elements around parentheses
     */
    public static void clump(ArrayList<String> list) {
        if (list.size() <= 1) {
            System.out.println(list); // print list as is if it contains 1 string or less 
        } else {
            for ( int i = 0; i < list.size() / 2+1; i++ ) {
                String combinedStr = "(";
                String first = list.get(i), second = list.get(i+1);
                combinedStr += first + " " +  second + ")"; // concatenate i and i+1
                list.set(i, combinedStr); // set new combined String at list(i)
                list.remove(i+1); // remove the access element at list(i+1)     
            }
            System.out.println(list);
        }
    }
}
