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

/**
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

/** 
 * Exercise 6 
 *
 * Write a method countUnique that accepts a list of integers as a parameter and
 * returns the number of unique integer values in the list
 *
 * Use a set as auxiliary storage to help you solve this problem
 *
 * @author Wali Morris 
 * @since 04/30/2020
 */

import java.util.*;

public class CountUnique {
    public static void main(String[] args) {
        List<Integer> input = new LinkedList<>(
                      List.of(3, 7, 3, -1, 2, 3, 7, 2,
                              15, 15, 4, 3, 10, 11, 2));
        int output = countUnique(input);
        System.out.println(input + " has " + output + " unique numbers.");
    }

    public static int countUnique(List<Integer> list) {
        if ( list.size() == 0 ) {
            return 0;
        }
        /* HashSet eliminates all duplicates from the list and returns the 
         * number of unique integers only */
        Set<Integer> set = new HashSet<>(list);
        return set.size();
    }
}

/**
 * Exercise 7 
 *
 * Write a method countCommon that accepts two lists of integers as parameter
 * and returns the number of unique integers that occur in both lists
 *
 * Use one or more sets as storage to help you solve this problem 
 *
 * @author Wali Morris 
 * @since 04/30/2020
 */

import java.util.*;

public class CountCommon {
    public static void main(String[] args) {
        List<Integer> input1 = new LinkedList<>(
                        List.of(3, 7, 3, -1, 2, 3, 7, 2, 15, 15));
        List<Integer> input2 = new LinkedList<>(
                        List.of(-5, 15, 2, -1, 7, 15, 36));
        int output = countCommon(input1, input2);
        System.out.println("There are " + output + " unique integers in both lists");
    }

    public static int countCommon(List<Integer> A, List<Integer> B) {
        /* return 0 if any list is empty */
        if ( A.size() == 0 || B.size() == 0 ) {
            return 0;
        }
        /* creates a set containing the elements of list A, then called a method to 
         * retain only the numbers that also exists in list B. If no numbers are the
         * same 0 is returned */
        Set<Integer> commonSet = new HashSet<>(A);
        commonSet.retainAll(B);
        return commonSet.size();
    }
}

/**
 * Exercise 8 
 * 
 * Write a method maxLength that accepts a set of strings as parameter and that returns 
 * the length of the longest string in the list
 *
 * If the method is passed an empty set, it should return 0
 *
 * @author Wali Morris 
 * @since 04/29/2020
 */

import java.util.*;

public class MaxLength {
    public static void main(String[] args) {
        Set<String> input = new HashSet<>(
                        List.of("hello", "from", "the", "otherside",
                                "I've", "must", "of", "called", "a",
                                "dozen", "times"));
        int output = maxLength(input);
        System.out.println("Longest word length: " + output);
    }

    public static int maxLength(Set<String> set) {
        if ( set.size() == 0 ) {
            return 0;
        }
        int max = 0;
        /* iterates the set and gives max the value of the longest word 
         * found so far */
        for ( String word : set ) { 
            if ( word.length() > max ) { 
                max = word.length(); 
            } 
        } 
        return max; 
    } 
}

/**
 * Exercise 9 
 *
 * Write a method called hasOdd that accepts a set of integers as a parameter and 
 * returns true if the set contains at least one odd integer and false otherwise
 *
 * If passed an empty set the method will return false
 *
 * Note: This method is written so both Tree and HashSets can be utilized
 * Utilizing a TreeSet is great because of the natural ordering, so odd 
 * numbers will be found much quicker 
 *
 * @author Wali Morris
 * @since 04/29/2020
 */

import java.util.*;

public class HasOdd {
    public static void main(String[] args) {
        Set<Integer> input = new HashSet<>(
                        List.of(32, 56, 66, 12, 14, 13, 55, 88, 44,
                                10, 18));
        boolean output = hasOdd(input);
        System.out.println(input + " contains odd element: " + output);
    }

    public static boolean hasOdd(Set<Integer> set) {
        if ( set.size() == 0 ) {
            return false;
        }
        /* In the case the parameter Set is not a TreeSet, in order to find odd numbers
         * more quickly, we'll send any elements from the parameter Set to set2 which 
         * is a TreeSet */
        Set<Integer> set2 = new TreeSet<>(set);
        for ( Integer num : set2 ) {
            if ( !(num % 2 == 0) ) {
                return true; // found odd number
            }
        }
        return false; // no odd numbers found in Set
    }
}

/**
 * Exercise 10
 *
 * Write a method called removeEvenLength that accepts a set of strings as a 
 * parameter and that removes all of the strings of even length from the set
 *
 * @author Wali Morris 
 * @since 04/30/2020
 */

import java.util.*;

public class RemoveEvenLength {
    public static void main(String[] args) {
        Set<String> input = new HashSet<>();
        input.add("to");
        input.add("be");
        input.add("or");
        input.add("not");
        input.add("too");
        input.add("bee");
        input.add("that");
        input.add("is");
        input.add("the");
        input.add("question");
        Set<String> output = removeEvenLength(input);
        System.out.println(output);
    }
	
    public static Set<String> removeEvenLength(Set<String> set) {
        if ( set.size() == 0 ) {
            throw new IllegalArgumentException("Set cannot be empty");
        }
        /* Using iterator object, remove strings of odd length from the set */
        Iterator<String> iter = set.iterator();
        while ( iter.hasNext() ) {
            if ( !(iter.next().length() % 2 == 0) ) {
                iter.remove();
            }
        }
        return set;
    }
}

/**
 * Exercise 11
 *
 * Write a mthod called symmetricSetDifference that accepts two Sets as parameters
 * and returns a new Set containing their symmetric set difference - the set of 
 * elements contained in either of the two sets but not in both
 *
 * @author Wali Morris 
 * @since 04/30/2020
 */

import java.util.*;

public class SymmetricSetDifference {
    public static void main(String[] args) {
        Set<Integer> input1 = new HashSet<>(
                       List.of(1, 4, 7, 9));
        Set<Integer> input2 = new HashSet<>(
                       List.of(2, 4, 5, 6, 7));
        Set<Integer> output = symmetricSetDifference(input1, input2);
        System.out.println("Integers unique to each set: " + output);
    }
	
    public static Set<Integer> symmetricSetDifference(Set<Integer> A,
                    Set<Integer> B) {

        Set<Integer> C = new HashSet<>(); // holds unique values from both sets
        /* returns empty set C if both A and B are empty */     
        if ( A.size() == 0 && B.size() == 0 ) {
            return C; 
        /* returns all values in set B if set A is empty */
        } else if ( A.size() == 0 && !(B.size() == 0) ) { 
            return B; 
        } else {
            /* returns all values in set A if set B is empty */
            if ( !(A.size() == 0) && B.size() == 0 ) { 
                return A; 
            }
        }
        /* The next sequence of statements creates a Set (tempA) to later remove 
         * the values in Set B that Set A also contains. Once these values are 
         * removed from each set (A and B), all the unique values from both Set A 
         * and B will be added to Set C */
        Set<Integer> tempA = new HashSet<>(A); // holds Set A to test against Set B
        A.removeAll(B); B.removeAll(tempA); C.addAll(A); C.addAll(B);
        return C;
    }
}

/**
 * Exercise 12 
 *
 * Write a method contains3 that accepts a list of strings as a parameter and returns true if any single
 * string occurs at least 3 times in the list, and false otherwise
 *
 * Use a Map as auxiliary storage
 *
 * @author Wali Morris
 * @since 05/01/2020
 */

import java.util.*;

public class Contains3 {
    public static void main(String[] args) {
        List<String> input = new LinkedList<>(
                        List.of("Cincinnati", "Newark", "Cincinnati",
                                "Newark", "Stafford", "Cincinnati"));
        boolean output = contains3(input);
        System.out.println(input + " contains 3 of the same string: " + output);
    }
    
    public static boolean contains3(List<String> list) {
        Map<String, Integer> map = new HashMap<>();
        for ( String word: list ) {
            /* if map contains word increment its count */
            if ( map.containsKey(word) ) {
                int count = map.get(word);
                map.put(word, count + 1);
                /* if this decision has been processed and count is 2 then this word will 
                 * be incremented to 3, return true at this point */
                if ( count == 2 ) {
                    return true;
                }
            } else {
                map.put(word, 1); // new word, add to map and begin count as 1
            }
        }
        return false; // map does not contain 3 of the same string
    }
}

/**
 * Exercise Reverse.java
 *
 * Write a method reverse that accepts a Map from integers to strings as a 
 * parameter and returns a new Map of strings to integers that is the orginal's
 * "reverse"
 *
 * The reverse of a Map is defined here to be a new Map that uses the values 
 * from the original as its keys and the keys from the original as its values
 *
 * In other words, if the original Map has pairs (k1, v) and (k2, v) the new 
 * Map must contain either the pair (v, k1) or (v, k2)
 *
 * @author Wali Morris 
 * @since 05/03/2020
 */

import java.util.*;

public class Reverse {
    public static void main(String[] args) {
        Map<Integer, String> input = new HashMap<>();
        input.put(41, "Marty");
        input.put(81, "Sue");
        input.put(17, "Ed");
        input.put(31, "Dave");
        input.put(56, "Ed");
        input.put(3, "Marty");
        input.put(29, "Ed");
        Map<String, Integer> output = reverse(input);
        System.out.println("Reverse: " + output);
    }
    
    /* Creates a new Map to store reverse key value types. Iterates a Set of all keys where 
     * original Set's int key becomes value and String value becomes key in new Map. If the 
     * new Map already contains a key from the original Map, it will not be added to the new 
     * Map. If the new Map does not contain the type String key, it'll be added.
     */
    public static Map<String, Integer> reverse(Map<Integer, String> map) {
        Map<String, Integer> map2 = new HashMap<>(); 
        for ( Integer num : map.keySet() ) { // iterate the Set of all keys     
            int value = num; 
            String key = map.get(value);
            if ( !(map2.containsKey(key)) ) { 
                map2.put(key, value); 
            } 
        }           
        return map2;    
    } 
}

/**
 * Exercise MaxOccurrences
 *
 * Write a method maxOccurrences that accepts a List of integers as a parameter 
 * and returns the number of times the most frequently occuring integer (mode)
 * occurs in the list
 *
 * Solve this problem using a Map as auxiliary storage and if the List is 
 * empty return 0 
 *
 * @author Wali Morris 
 * @since 05/03/2020
 */

import java.util.*;

public class MaxOccurrences {
    public static void main(String[] args) {
        List<Integer> input = new LinkedList<>(
                        List.of(2, 2, 2, 4, 5, 6, 8, 8, 10, 11));
        int output = maxOccurrences(input);
        System.out.println("Mode occurs " + output + " times.");
    }

    public static int maxOccurrences(List<Integer> list) {
        if ( list.isEmpty() ) {
            return 0;
        }
        /* iterate the list and increment every integer that has been seen, 
         * if an integer has not been seen add it to the map with a starting
         * count of 1 */
        Map<Integer, Integer> map = new HashMap<>();
        for ( Integer num : list ) {
            if ( map.containsKey(num))  {
                int count = map.get(num);
                map.put(num, count + 1);
            } else {
                map.put(num, 1);
            }
        }
        /* returns the max integer value from map */
        int mode = Collections.max(map.values());
        return mode;
    }
}

/**
 * Exercise Intersect 
 *
 * Write a method called intersect that thats two Maps of strings to integers as
 * parameters and that returns a new Map whose contents are the intersection of
 * the two
 *
 * The intersection of two Maps is defined here as the set of keys and values 
 * that exists in both maps
 *
 * @author Wali Morris
 * @since 03/04/2020
 */

import java.util.*;

public class Intersect {
    public static void main(String[] args) {
        Map<String, Integer> input1 = new HashMap<>();
        Map<String, Integer> input2 = new HashMap<>();
        input1.put("Janet", 87);
        input1.put("Logan", 62);
        input1.put("Whitaker", 46);
        input1.put("Alyssa", 100);
        input1.put("Stephanie", 80);
        input1.put("Jeff", 88);
        input1.put("Kim", 52);
        input1.put("Sylvia", 95);
        input2.put("Logan", 62);
        input2.put("Kim", 52);
        input2.put("Whitaker", 52);
        input2.put("Jeff", 88);
        input2.put("Stephanie", 80);
        input2.put("Brian", 60);
        input2.put("Lisa", 83);
        input2.put("Sylvia", 87);
        Map<String, Integer> output = intersect(input1, input2);
        System.out.println(output);
    }
	
    public static Map<String, Integer> intersect(Map<String, Integer> map1,
                    Map<String, Integer> map2) {

        Map<String, Integer> map3 = new HashMap<>();
        if ( map1.isEmpty() || map2.isEmpty() ) {
            return map3; // if any map is empty return empty map3 
        }
        /* iterate map1 keys and check if map2 also contains this key. If the 
         * key exists in map2, evaluate the the values and if they are a match
         * append both key : value to map3 */
        for ( String word : map1.keySet() ) {
            if ( map2.containsKey(word) ) {
                int value = map2.get(word);
                if ( map2.get(word).equals(map1.get(word)) ) {
                    map3.put(word, value);
                }
            }
        }
        return map3;
    }
}
