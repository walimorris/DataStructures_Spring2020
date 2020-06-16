/**
 * Class LinkedIntList can be used to store a list of integers
 * Program credit: Building Java Programs 5th Edition
 *
 * Assignment: Write a method called isSorted that returns true if the list 
 * is in sorted (nondecresing) order and returns false otherwise
 *
 * An empty list is considered to be sorted 
 *
 * Note: assignment method is the last method in this file 
 * 
 * @see LinkedListSorted.java: for test and client program  
 * @author Wali Morris  
 * @since 06/09/2020
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
	 ListNode previous = null; 
	 ListNode current = this.front; 
	 ListNode following = this.front;
	 while ( current != null ) { 
	     following = following.next; 
	     current.next = previous; 
	     previous = current; 
	     current = following; 
	 } 
	 this.front = previous; 
     }  

     public boolean isSorted() {
	 // returns true if list is empty or contains one element 
	 if ( this.front == null || this.size() == 1 ) { 
             return true; 
	 } else { 
             ListNode current = front;
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
}













