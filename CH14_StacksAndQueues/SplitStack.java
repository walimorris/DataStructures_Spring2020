/** 
 * Split Stack 
 *
 * Write a method called splitStack that accepts a stack of integers as a parameter and rearanges 
 * its elements so that all the negatives appear on the bottom of the stack and all the nonnegatives 
 * appear on the top
 *
 * If after this method is called you were to pop numbers off the stack, you would first get all the 
 * nonnegative numbers and then get all the negative numbers
 *
 * It does not matter what order the numbers appear in as long as all the negatives appear lower in 
 * the stack than all the nonnegatives 
 *
 * @author Wali Morris 
 * @since 05/27/2020
 */ 

import java.util.*; 

public class SplitStack { 
    public static void main(String[] args) {
	Stack<Integer> input = new Stack<>();
        int[] inputNumbers = {3, -5, 1, 2, -4}; 
 
	/* pushes elements from array into stack */ 
        for ( int number : inputNumbers ) { 
	    input.push(number); 
	} 	    
        Stack<Integer> output = splitStack(input); 
	System.out.println(input + " -> " + output); 
    }	

    public static Stack<Integer> splitStack(Stack<Integer> s) {  
	Queue<Integer> q = new LinkedList<>(); 
	while ( !s.isEmpty() ) { // sends all elements in stack to queue
	    q.add(s.pop()); 
	}
	/* iterates the queue and sends all negative elements to stack, so negatives will 
	 * pop from stack after all positives, if element is positive add back into the 
	 * queue */ 
	int oldQueueSize = q.size(); 
        for ( int i = 0; i < oldQueueSize; i++ ) { 
	    int num = q.remove(); 
            if ( num < 0 ) { 
	        s.push(num); 
	    } else { 
                q.add(num); 
	    } 
	}
	/* all positives remaining in the queue is pushed onto the stack, making it so all 
	 * positives will be popped off the stack first, followed by negatives */ 
        while ( !q.isEmpty() )	{ 
	    s.push(q.remove()); 
	}  
	return s; 
    } 
} 
            
    

