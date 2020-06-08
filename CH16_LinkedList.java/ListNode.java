/** 
 * ListNode is a class for storing a single node of a linked list
 * This node class is for a list of integers
 */

public class ListNode { 
    public int data; 
    public ListNode next; 

    public ListNode() { 
	this(0, null); 
    } 

    public ListNode(int data) { 
	this(data, null); 
    } 

    public ListNode(int data, ListNode next) { 
	this.data = data; 
	this.next = next; 
    } 
} 
