/**
 * Class LinkedIntList can be used to store a list of integers
 * Program credit: Building Java Programs 5th Edition
 *
 * Assignment : Write a method called hasTwoConsecutive that returns whether or not a 
 * list of integers has two adjacent numbers that are consecutive integers (true if 
 * such a pair exists and false otherwise)
 *
 * Note: assignment method is the last method in this file 
 * 
 * @see LinkedListSorted.java and ListNodingAround.java: for test and client programs
 * These files can be found in github repository DS_Spring2020/CH16_LinkedList
 *
 * @author Wali Morris<walimmorris@gmail.com>  
 * @since 06/19/2020
 */ 

public class LinkedIntList { 
    private ListNode front; 

    // post: constructs an empty list
    public LinkedIntList() { 
	front = null; 
    } 

    public int size() { 
    	int count = 0; 
	ListNode current = this.front; 
	while ( !(current == null) ) { 
	    current = current.next; 
	    count++; 
	} 
	return count; 
    } 

    public int get(int index) { 
	return nodeAt(index).data; 
    }

    public void add(int value) { 
       	if (front == null) { 
            front = new ListNode(value); 
	 } else { 
            ListNode current = front; 
	    while (current.next != null) { 
	        current = current.next;  
	    } 
	    current.next = new ListNode(value); 
	 } 
    } 

    public void add(int index, int value) { 
	 if (index == 0) {  
             front = new ListNode(value, front); 
	 } else {  
             ListNode current = nodeAt(index - 1);
	     current.next = new ListNode(value, current.next); 
	 } 
     }

     public void remove(int index) {
   	 if (index == 0) {
             front = front.next;
	 } else {
             ListNode current = nodeAt(index - 1);
             current.next = current.next.next;
	 }
     }

     private ListNode nodeAt(int index) { 
         ListNode current = front;
	 for (int i = 0; i < index; i++) { 
             current = current.next; 
	 } 
	 return current; 
     } 

     public String toString() { 
	 if (front == null) { 
             return "[]"; 
	 } else { 
             String result = "[" + front.data; 
	     ListNode current = front.next; 
	     while (current != null) { 
	         result += ", " + current.data; 
		 current = current.next; 
	     }
	     result += "]";
	     return result; 
	 } 
     } 

     public void reverseList() { 
	 /**
	  * Uses three pointers, one to previous node, one to current node, 
	  * and one to the next node(following)
	  *
	  * Naturally to reverse the node, each reference should be inverted to 
	  * point to the previous node
	  */
	 ListNode previous = null;  
	 ListNode current = this.front; 
	 ListNode following = this.front;
	 while ( current != null ) { 
	     following = following.next; // following becomes the next right, to reserve the link 
	     current.next = previous; // current node now references previous node
	     previous = current; // previous now moves to current node
	     current = following; // current now moves to following 
	 } 
	 /* At the end of this rotation previous will be the last node in the list 
	  * therefore we should begin here */ 
	 this.front = previous; 
     }  

     public boolean isSorted() {
	 // returns true if list is empty or contains one element 
	 if ( this.front == null || this.size() == 1 ) { 
             return true; 
	 } else { 
             ListNode current = this.front;
	     /* iterates LinkedIntList until null verifying, at every node, that 
	      * the next data element ahead of it is larger */     
	     while ( current.next != null ) { 
		 // current data element is larger than next
                 if ( current.data > current.next.data ) {
	             return false; 
		 } 
		 // go to next node
		 current = current.next; 
	     } 
	 } 
	 return true; 
     } 

     public boolean hasTwoConsecutive() {
	 // returns false for empty lists and lists that contains' one element  
	 if ( this.front == null || this.size() == 1 ) { 
             return false; 
	 } 
	 ListNode current = this.front; 
	 // stop before the last node to escape a NullPointerException 
	 while ( current.next != null ) { 
	     // checks the next nodes data element to current nodes data element 
             if ( current.next.data == current.data + 1 ) { 
		 // if next nodes data element is consecutive return true
                 return true; 
	     } 
	     // node data elements are not consecutive, go to next node 
	     current = current.next; 
	 } 
	 return false; 
     } 
} 
