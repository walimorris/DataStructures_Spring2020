/** 
 * Write a program that lists all ways people can line up for a photo (all permutations 
 * of a list of Strings) 
 *
 * The program will read in a list of one word names (until - 1), and use a recursive 
 * method to create and output all possible orderings of those names, one ordering per 
 * line
 *
 * @author Wali Morris 
 * @since 05/24/2020 
 */ 

import java.util.Scanner; 
import java.util.ArrayList;  

public class PhotoLineups { 
    public static void main(String[] args) { 
	Scanner scnr = new Scanner(System.in); 
	ArrayList<String> nameList = new ArrayList<>(); 
	ArrayList<String> permList = new ArrayList<>(); 
	String name; 
	System.out.print("Enter names seperated by space(-1 to quit): ");
        name = scnr.next(); 	
	while ( !name.equals("-1")) {
	    nameList.add(name); 	
	    name = scnr.next();  
	} 
        allPermutations(permList, nameList);
    }	

    public static void allPermutations(ArrayList<String> permList, ArrayList<String> nameList) {  
	if ( nameList.size() == 0 ) {
	    System.out.print(permList.get(0)); 
	    for ( int i = 1; i < permList.size(); i++ ) {
                System.out.print(" " + permList.get(i)); 
	    }
            System.out.println(); 	    
	} else { 
            for ( int i = 0; i < nameList.size(); i++ ) { 
                ArrayList<String> newPerms = new ArrayList<String>(permList); 
                newPerms.add(nameList.get(i)); 
                ArrayList<String> newNames = new ArrayList<String>(nameList); 
                newNames.remove(i); 
                allPermutations(newPerms, newNames);
	    }
	}
    }
}    
