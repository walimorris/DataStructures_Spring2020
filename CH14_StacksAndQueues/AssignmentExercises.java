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
