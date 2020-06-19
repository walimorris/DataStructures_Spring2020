/**
 * Exercise 5 : Equals 
 *
 * Write a method called equals that accepts two stacks of integers as parameters and returns true if 
 * the two stacks store exactly the same sequence of integer values in the same order 
 *
 * Your method must restore the two stacks to their original state before returning 
 *
 * Use one stack as auxiliary storage
 *
 * @author Wali Morris 
 * @since 06/18/2020
 */ 

import java.util.*; 

public class Equals { 
    public static void main(String[] args) { 
	Stack<Integer> input1 = new Stack<>(); // Stack 1: 0 1 2 3 4 5 6 7 8 9  
	Stack<Integer> input2 = new Stack<>(); // Stack 1: 0 1 2 3 4 5 6 7 8 9
	Stack<Integer> input3 = new Stack<>(); // Stack 3: 0 2 4 6 8
	Stack<Integer> input4 = new Stack<>(); // Stack 4: 10 11 12 13 14 15 16 17 18 19 20
        Stack<Integer> input5 = new Stack<>(); // Stack 5: 3
        Stack<Integer> input6 = new Stack<>(); // Stack 6: 4
	Stack<Integer> input7 = new Stack<>(); // empty
	Stack<Integer> input8 = new Stack<>(); // empty
	for ( int i = 0; i < 10; i++ ) { 
	    input1.push(i); 
	    input2.push(i);
	    if ( i % 2 == 0 ) { 
                input3.push(i);
	    }	
	} 
	for (int i = 10; i < 21; i++ ) { 
	    input4.push(i); 
	}  
	input5.add(3); 
	input6.add(4); 
	boolean output1 = equals(input1, input2); // should test to true
        boolean output2 = equals(input1, input3); // should test to false
	boolean output3 = equals(input2, input4); // should test to false 
	boolean output4 = equals(input5, input6); // should test to false 
	boolean output5 = equals(input7, input8); // should test to true
        System.out.println(input1 + " & " + input2 + " is equal: " + output1); 
        System.out.println(input1 + " & " + input3 + " is equal: " + output2);
        System.out.println(input2 + " & " + input4 + " is equal: " + output3);
        System.out.println(input5 + " & " + input6 + " is equal: " + output4);
        System.out.println(input7 + " & " + input8 + " is equal: " + output5);	
    } 

    /* This method initializes a boolean flag 'stacksAreEqual' to true and if Stacks x and y are of 
     * the same size, records the original size of both stacks. Both stack elements are then rotated 
     * within for the duration of their original size. If any element from either stack is different, 
     * stacksAreEqual becomes false 
     * */ 
    public static boolean equals(Stack<Integer> x, Stack<Integer> y) {
	/* if x and y have unequal size, return false */
	if ( !(x.size() == y.size()) ) { 
	    return false;
	/* empty x and y stacks returns true */  
	} else { 
	    if ( x.size() == 0 && y.size() == 0) { 
                return true;
	    }	
	}  	    
	final int size = x.size(); 
	boolean stacksAreEqual = true; 
	int i = 0; 	
	while ( !(i == size) ) { 
	    int elementX = x.pop(); 
	    int elementY = y.pop(); 
	    if ( elementX != elementY ) {
                stacksAreEqual = false; 
	    }  
            x.push(elementX);
	    y.push(elementY);
	    i++;	
	}  
        return stacksAreEqual; 
    } 
}     	
