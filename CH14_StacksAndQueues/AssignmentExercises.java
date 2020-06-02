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
 * Exercise 8 : isPalindrome
 *
 * Write a method called isPalindrome that accepts a queue of integers as a parameter and returns 
 * true if the numbers in the queue are the same in reverse order
 *
 * The empty queue should be considered a palindrome
 *
 * Your method must restore the parameter queue to its original state before returning 
 *
 * Use one stack as auxiliary storage 
 *
 * @author Wali Morris
 * @since 05/29/2020
 */

import java.util.*;

public class Palindrome {
    public static void main(String[] args) {
        int[] inputArray1 = { 3, 8, 17, 9, 17, 8, 3 };
        int[] inputArray2 = { 3, 17, 9, 4, 17, 3 };
        Queue<Integer> queue1 = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();
        for ( int num : inputArray1 ) {
            queue1.add(num);
        }
        for ( int num : inputArray2 ) {
           queue2.add(num);
        }
        boolean output1 = isPalindrome(queue1);
        boolean output2 = isPalindrome(queue2);
        System.out.println(queue1 + " is palindrome: " + output1);
        System.out.println(queue2 + " is palindrome: " + output2);

    }

    public static boolean isPalindrome(Queue<Integer> queue) {
        if ( queue.size() == 0 ) {
            return true;
        }
        Stack<Integer> auxiliaryStack = new Stack<>();
        int originalQueueSize = queue.size();
        /* iterate through the queue, remove each element, push the element onto the 
         * auxiliary stack, add element back to the queue restoring original state */
        for ( int i = 0; i < originalQueueSize; i++ ) {
            int num = queue.remove();
            auxiliaryStack.push(num);
            queue.add(num);
        }
        /* Iterate the queue, elements removed will be added back to the end. Elements 
         * from the auxiliary stack will be popped and examined against the queue elements. 
         * If the elements do not match, palindrome becomes false. To keep the queue at it's 
         * original state the loop must complete */
        boolean palindrome = true;
        for (int j = 0; j < originalQueueSize; j++ ) {
            int queueElement = queue.remove();
            if ( !(queueElement == auxiliaryStack.pop()) ) {
                palindrome = false;
            }
            queue.add(queueElement);
        }
        return palindrome;
    }
}
