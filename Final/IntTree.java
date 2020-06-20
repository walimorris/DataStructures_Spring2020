/** 
 * Credit: Building Java Programs 5th Edition 
 *
 * Exercise 7 : isFull
 *
 * Write a method called isFull that returns true if a binary tree is full 
 * and false if it is not
 *
 * A full binary tree is one which every node has 0 or 2 children
 *
 * Note: isFull() method is the last method in this file 
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

    public boolean isFull() { 
	return isFull(overallRoot); 
    } 

    /* At any time if a subtree has only one branch, return false. If a tree
     * has no branches or has two, continue */ 
    private boolean isFull(IntTreeNode root) { 
        if ( root == null ) { 
	    return true; 
	} else if ( root.left == null && root.right != null ) { 
            return false; 
	} else if ( root.left != null && root.right == null ) { 
	    return false; 
	} else { 
	    /* checks left root and right root, if any branch(right or left) is null
	     * return false */ 
	    return isFull(root.left) && isFull(root.right); 
	} 
    } 
} 
