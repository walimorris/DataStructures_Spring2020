/** 
 * Credit: Building Java Programs 5th Edition 
 *
 * Exercise 2 : countEmpty 
 *
 * Write a method called countEmpty that returns the number of empty branches in a tree
 * An empty tree is considered to have on empty branch(the tree itself)
 *
 * For empty trees, your methods should count the total number of empty branches among
 * the nodes of the tree
 *
 * Note: countEmpty() method is the last method in this file 
 *
 * @author Wali Morris
 * @since 06/19/2020
 */  

public class IntTree { 
    private IntTreeNode overallRoot; 

    public IntTree(int max) { 
	this.overallRoot = buildTree(1, max); 
    } 

    private IntTreeNode buildTree(int n, int max) { 
        if ( n > max ) { 
	    return null; 
	} else { 
	    IntTreeNode left = buildTree(2 * n, max);  
            IntTreeNode right = buildTree(2 * n + 1, max); 
	    return new IntTreeNode(n, left, right); 
	} 
    }

    public void printPreorder() { 
	System.out.print("preorder: "); 
        printPreorder(overallRoot); 
        System.out.println(); 
    } 

    private void printPreorder(IntTreeNode root) { 
	if ( root != null ) {
	    System.out.print(" " + root.data); 
            printPreorder(root.left); 
            printPreorder(root.right); 
	} 
    }

    public void printInorder() { 
	System.out.print("in order: "); 
        printInorder(overallRoot); 
        System.out.println(); 
    } 

    private void printInorder(IntTreeNode root) {
	if (root != null ) {  
	    printInorder(root.left); 
            System.out.print(" " + root.data); 
            printInorder(root.right); 
	} 
    } 

    public void printPostorder() { 
	System.out.print("Post order: "); 
        printPostorder(overallRoot); 
        System.out.println(); 
    } 

    private void printPostorder(IntTreeNode root) { 
	if ( root != null ) { 
	    printPostorder(root.left); 
            printPostorder(root.right);
            System.out.print(" " + root.data); 
	} 
    }     

    public void printSideways() { 
	printSideways(overallRoot, 0); 
    } 

    private void printSideways(IntTreeNode root, int level) { 
        if ( root != null ) { 
	    printSideways(root.right, level + 1); 
	    for ( int i = 0; i < level; i++ ) { 
	        System.out.print("   "); 
	    } 
	    System.out.println(root.data); 
	    printSideways(root.left, level + 1); 
	} 
    }

    public int countEmpty() {
	// case: empty Tree return 1
	if ( this.overallRoot == null ) { 
	    return 1; 
	} 
	return countEmpty(overallRoot); 
    }

    private int countEmpty(IntTreeNode root) {
	if ( root == null ) { 
	    return 0;
	// case: left/right branch are empty add 2
	} else if ( root.left == null && root.right == null ) { 
	    return 2 + countEmpty(root.left) + countEmpty(root.right);
	// case: left branch is not empty, right branch is empty add 1 
	} else if ( root.left != null && root.right == null ) { 
	    return 1 + countEmpty(root.left) + countEmpty(root.right);
	// case: left benach is empty, right branch is not empty add 1
	} else if (root.left == null && root.right != null ) { 
	    return 1 + countEmpty(root.left) + countEmpty(root.right);
	// case: left branch and right branch do not add, continue search 
	} else {
            return countEmpty(root.right) + countEmpty(root.left); 
	}
    } 
} 

