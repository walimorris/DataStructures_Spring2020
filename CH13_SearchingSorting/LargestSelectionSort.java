/**
 * Building Java Programs 5th Edition Chapter 13
 *
 * Exercise 4 : 
 *
 * This algorithm belongs to the complexity class O(N) because N represents the number 
 * of elements in list.length and processes each element in list N times; we can predict 
 * that time becomes much slower as the input size increases
 *
 * Exercise 5 : 
 * 
 * Although this algorithm divides the number of iterations N by 2, I want to say the time 
 * complexity is 0(N/2). It seems that O(N) and O(N/2) have the same linear growth rate so 
 * I would say this algorithm's time complexity would be the same as O(N). 
 * 
 * Exercise 18
 *
 * Write a modified version of the selection sort algorithm that selects the largest element
 * each time and moves it to the end of the array, rather than selecting the smallest element 
 * and moving it to the beginning
 *
 * Will this algorithm be faster than the standard selection sort? What will its complexity
 * class be?
 * 
 * This modified Selection Sort algorithm is no faster or slower than the standard Selection 
 * Sort algorithm and still has a time complexity of 0(N^2) as it uses a nested loop and we 
 * can predict the time to quadruple as the input doubles
 *
 *
 * @author Wali Morris
 * @since 05/15/2020
 */ 

import java.util.*; 

public class LargestSelectionSort {
    public static void main(String[] args) {
	int[] input1 = {12, 1, 4, 22, 14, 7, 8, 10, 13, 19, 20};
        System.out.print(Arrays.toString(input1) + " -> "); 	
	modifiedSelectionSort(input1); 
        System.out.println(Arrays.toString(input1)); 
    } 

    public static void modifiedSelectionSort(int[] arr) {
        for ( int i = 0; i < arr.length; i++ ) {
            for ( int j = i + 1; j < arr.length; j++ ) { // get next number 
                if ( arr[i] > arr[j] ) { // current is larger than next?
		    /* current number arr[i] is larger, swap larger to right */ 
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            } 
        }
    }
}
