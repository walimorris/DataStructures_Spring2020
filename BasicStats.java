/**
 * Basic statistics on input data
 *
 * Start with an input list of values read from STDIN: Compute and output the count, 
 * minimum, maximum, mean, and median of the valid input values, as well as an error
 * count 
 *
 * For the mean and median, round and display the results to the nearest hundredth 
 *
 * @author Wali Morris 
 * @since 06/19/2020
 */ 

import java.util.Scanner; 
import java.util.*; 

public class BasicStats { 
    public static void main(String[] args) { 
	Scanner scanner = new Scanner(System.in); 
	List<Integer> stats = new ArrayList<>();
        int data = 0, error = 0; 
	
	/* The outer loop continues to read valid data points, as integers, until -1 is read into STDIN. 
	 * On valid inputs, exiting with -1 will still output statistics and 'N/A' if that stat does not 
	 * exist */ 
	while ( !(data == -1) ) {
            boolean pass = false;
	    System.out.print("Enter data(-1 to end program): ");
	    
	    /* The inner loop continues until a valid data value is input into STDIN, an error message will 
	     * appear to inform the user of any errors. This process is confirmed by the boolean flag 'pass'. 
	     * The user has the option to completely end the program inputting -2 only on error rounds, this 
	     * This will fully end the program and will not output statistics */   
	    while( pass == false || data == -2 ) { 
                try {
		    pass = true; 	
                    data = scanner.nextInt();  
		    if ( data == -2 ) { 
	                System.exit(0); 
		    }
	        } catch ( InputMismatchException e ) {
		    error++; 
		    pass = false; 
		    System.out.print("Error! Please enter an integer(-2 to end program): ");  
                    scanner.next(); 
		}  
	    } 		
	    if ( data < 0 && data != -1 ) { 
                error++; // records error as any number less than 0 but not -1
	    } else { 	
		/* any valid integer 0 or greater will be added to ArrayList */ 
	        if ( data >= 0 ) {	    
                    stats.add(data);
		}
	    }
	}
        System.out.println(stats); 	
        basicStats(stats, error);  
    } 

    public static void basicStats(List<Integer> stats, int errors) {
	int count; 
	float meanCount = 0, medianCount;   
	String minimum, maximum, mean, median; 
        String none = "n/a"; 	
	switch ( stats.size() ) { 
		case 0: // reads in an empty list 
		    count = 0; 
		    minimum = none; 
		    maximum = none; 
		    mean = none;
		    median = none;  
		    break; 
	       case 1: // reads in a list containing 1 element 
		    count = 1; 
                    minimum = Integer.toString(stats.get(0)); 
		    maximum = minimum; 
		    mean = none; 
		    median = none; 
		    break; 
	       default: 
		    /* sorts list to compute statistics, converts numeric values to type String
		     * and reports statistics with errors */ 
                   Collections.sort(stats);  
	           count = stats.size(); 
	           minimum = Integer.toString(Collections.min(stats)); 
	           maximum = Integer.toString(Collections.max(stats));   
	           for ( Integer num : stats ) { 
	               meanCount += num; 
		   } 
	           meanCount /= count;
		   /* uses meanCount to convert float to string with 2 trailing decimal places */ 
		   mean = String.format("%.02f", meanCount);    
	           if ( !(count % 2 == 0) ) { 
		       /* case: total count of data points are odd */
	               medianCount = stats.get(count / 2);
		       /* uses meanCount to convert float to string with 2 trailing decimals places */ 
		       median = String.format("%.02f", medianCount);  
		   } else {  
	               /* case: total count of data points are even */
                       medianCount = ((stats.get(count / 2 ) + stats.get((count / 2) + 1 )) / 2); 
	               median = (String) String.format("%.02f",  medianCount);
		   }
	}   
        System.out.println("Count: " + count + "\n" + "Minimum: " + minimum + "\n" +
			   "Maximum: " + maximum + "\n" + "Mean: " + mean + 
			   "\n" + "Median: " + median + "\n" + "Errors: " + errors);  
    } 
}     
