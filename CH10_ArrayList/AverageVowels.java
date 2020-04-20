/**
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
	        	    
