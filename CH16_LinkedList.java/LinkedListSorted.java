/** 
 * LinkedListSorted Client Program 
 *
 * A client program to test the LinkedIntList class
 * @see LinkedIntList.java
 *
 * @author Wali Morris 
 */ 

import java.util.*; 

public class LinkedListSorted { 
    public static void main(String[] args) { 
	LinkedIntList list = new LinkedIntList(); 
	list.add(5); 
	list.add(6); 
	list.add(7); 
        boolean sortedList = list.isSorted(); 
        System.out.println(list.toString() + " is sorted: " + sortedList);
	
	// adds extra elements to list and checks if it's sorted 
	list.add(4); 
	list.add(10); 
	list.add(22); 
	boolean sortedList2 = list.isSorted(); 
	System.out.println(list.toString() + " is sorted: " + sortedList2);

        // creates an empty list to verify empty lists are sorted 
	LinkedIntList list2 = new LinkedIntList(); 
        boolean sortedList3 = list2.isSorted(); 
        System.out.println(list2.toString() + " is sorted: " + sortedList3);
        
        // adds one element to list2 to verify linkedlist with one element is sorted
	list2.add(1); 
        boolean sortedList4 = list2.isSorted(); 
        System.out.println(list2.toString() + " is sorted: " + sortedList4); 	
    } 
}     
