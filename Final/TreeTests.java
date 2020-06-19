/**
 * A short client program to test the countEmpty() method of IntTree.java Class
 *
 * @author Wali Morris
 * @since 06/19/2020
 */ 

public class TreeTests { 
    public static void main(String[] args) { 
	// builds a sequential IntTree with max = 6 and shows visual 
	IntTree reference1 = new IntTree(6);
        reference1.printSideways();
        int missingBranches1 = reference1.countEmpty(); 
        System.out.println("Missing Branches = " + missingBranches1);

	// builds a sequential IntTree with max = 17 and shows visual 
	IntTree reference2 = new IntTree(13); 
        reference2.printSideways();
        int missingBranches2 = reference2.countEmpty(); 
        System.out.println("Missing Branches = " + missingBranches2); 	
    }
}
