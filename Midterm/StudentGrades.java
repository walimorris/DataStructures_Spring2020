/**
 * Problem 2
 *
 * Given a HashMap pre-filled with student names as keys and grades as values, complete 
 * main() by reading in the name of a student, outputting their original grade, and then
 * reading in and outputting their new grade
 *
 * @author Wali Morris 
 * @since 05/24/2020
 */

import java.util.Scanner; 
import java.util.HashMap; 
import java.util.*; 

public class StudentGrades { 
    public static void main(String[] args) { 
	Scanner scnr = new Scanner(System.in); 
	String studentName;
        double studentGrade = -1;    	
	// HashMap to hold pre-filled student names and grades
	HashMap<String, Double> studentGrades = new HashMap<>(); 

	// pre-entered student's grades
	studentGrades.put("Harry Rawlins", 84.3); 
	studentGrades.put("Stephanie Kong", 91.0); 
	studentGrades.put("Shailen Tennyson", 78.6);
	studentGrades.put("Quincy Wraight", 65.4);
	studentGrades.put("Janine Antinori", 98.2);
        // read-in students name to get original grade and input new grade
	System.out.print("Enter Students Name: ");  
	studentName = scnr.nextLine();
	boolean typePass = false; // test flag for correct input of type double for studentGrade 
	System.out.print("Enter Students new grade: ");
	do { 
	    /* loops until student grade is a value 0 or greater and correct type, once these criteria
	     * are met boolean flag (typePass) becomes true and loop exits */  
	    try { 
	        studentGrade = scnr.nextDouble(); // get student's grade 
	        if ( studentGrade < 0 ) { 
	            typePass = false; // students grade is less than 0 OR type is not correct
		    System.out.print("Please enter a valid score of 0 or greater: ");  
	        } else { 
		    typePass = true; // student grade is 0 or above AND type is correct
		} 
	    /* inputting integer values for studentGrade variable is exceptable because it'll be 
	     * transformed into a double, although inputting strings would throw exception. In this
	     * case we catch this exception and allow the user to re-enter correct type for grade
	     */
	    } catch ( InputMismatchException e ) {  
		System.out.print("Please input a valid floating point number: "); 
	        scnr.next();  	
	    }  
	} while ( !typePass ); 
        // checks if studentGrades Map contains the selected student's name
	if ( studentGrades.containsKey(studentName) ) {	
            System.out.println(); 
	    // students name is in map, the original grade is written to output
	    System.out.println(studentName + "'s original grade: " + studentGrades.get(studentName));
	    studentGrades.put(studentName, studentGrade); // maps new grade to student
	    // new grade is written to output
	    System.out.println(studentName + "'s new grade: " + studentGrades.get(studentName));   
	} else { 
	    // There's no key in StudentGrades Map that matches the input 
            System.out.println("No record of student"); 
            System.exit(1); 
	} 
    } 
} 
