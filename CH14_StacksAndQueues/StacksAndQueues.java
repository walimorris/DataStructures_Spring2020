/** 
 * Exercise 1 : Split Stack 
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
            
/**
 * Exercise 2 : Stutter
 *
 * Write a method called stutter that accepts a stack of integers as a parameter and replaces 
 * every value in the stack with two occurrances of that values
 *
 * Preserve the original order and use a queue as auxiliary storage
 *
 * @author Wali Morris 
 * @since 05/29/2020
 */

import java.util.*;

public class Stutter {
    public static void main(String[] args) {
        int[] inputStack = {3, 7, 1, 14, 9};
        Stack<Integer> input = new Stack<>();
        for ( int num : inputStack ) {
            input.push(num);
        }
        Stack<Integer> output = stutter(input);
        System.out.println(output);
    }

    public static Stack<Integer> stutter(Stack<Integer> s) {
        Queue<Integer> aux = new LinkedList<>();
        /* pushes stack elements to queue and queue elements to stack. We want the elements to rotate to the 
         * queue twice and the stack only once in order to change the order the queue elements will push onto
         * the stack in the final empty of queue */
        for ( int i = 0; i < 2; i++ ) {         
            while ( !s.isEmpty() ) { 
                aux.add(s.pop());
            }
            /* ensures the loop breaks if the stack has been filled once and queue has been filled twice, we 
             * stop the loop here in order to push the queue elements back on to the stack in a "stutter" 
             * type duplication */
            if ( i >= 1 ) { 
                break; 
            }
            while ( !aux.isEmpty() ) { 
                s.push(aux.remove());
            }   
        } 
        // while pushing aux queue elements to stack duplicate each element 
        while ( !aux.isEmpty() ) {
            int element = aux.remove(); 
            s.push(element); 
            s.push(element);
        } 
        return s; 
    } 
}

/**
 * Exercise 3 : Copy Stack  
 *
 * Write a method called copyStack that accepts a stack of integers as a parameter and returns a copy of the 
 * original stack (a new stack with the same values as the original, stored in the same order as the original)
 *
 * Your method should create the new stack and fill it up with the same values that are stored in the original 
 * stack and when your method is done executing, the original stack must be restires to its original state 
 *
 * Use one queue as auxiliary storage
 *
 * @author Wali Morris
 * @since 05/30/2020
 */

import java.util.*;

public class CopyStack {
    public static void main(String[] args) {
        int[] stackArray = {9, 3, 5, 7, 8};
        Stack<Integer> inputStack = new Stack<>();
        for ( int i = 0; i < stackArray.length; i++ ) {
            inputStack.push(stackArray[i]);
        }
        System.out.println("Original Stack: " + inputStack);
        /* This stack is the copied stack from the copyStack method 
         * and not the original stack, although the original stack 
         * is unchanged */
        Stack<Integer> output = copyStack(inputStack);
        System.out.println("Copied Stack  : " + output);
    }
	
    public static Stack<Integer> copyStack(Stack<Integer> originalStack) {
        Stack<Integer> duplicateStack = new Stack<>();
        Queue<Integer> auxiliaryQueue = new LinkedList<>();
        /* uses the auxiliary queue to store elements of the original stack to push to
         * duplicate stack */
        while ( !originalStack.isEmpty() ) {
            auxiliaryQueue.add(originalStack.pop());
        }
        /* exchanges elements twice in order to prepare to store the duplicate stack's 
         * elements in the same sequence as the original stack elements */
        for ( int j = 0; j <= 2; j++ ) {
            while ( !auxiliaryQueue.isEmpty() ) {
                duplicateStack.push(auxiliaryQueue.remove());
            }
            while ( !duplicateStack.isEmpty() ) {
                auxiliaryQueue.add(duplicateStack.pop());
            }
        }
        /* copies the original stacks elements to duplicate stack and restores original stack */
        while ( !auxiliaryQueue.isEmpty() ) {
            int num = auxiliaryQueue.remove();
            duplicateStack.push(num);
            originalStack.push(num);
        }
        return duplicateStack;
    }
}
