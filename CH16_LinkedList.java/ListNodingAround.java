import java.util.*; 

public class ListNodingAround { 
    public static void main(String[] args) {
	/* Create a linkedList with 5 values and print the values */  
	ListNode list = new ListNode(3, new ListNode(4, new ListNode(5, 
					new ListNode(6, new ListNode(7)))));  
	ListNode current = list; 
	while ( !(current == null) ) {
	    System.out.print(current.data + " "); 	
	    current = current.next;
	}
        System.out.println(); 

        /* Uses a stack to print the values of a linkedList in reverse */
        ListNode list2 = new ListNode(5, new ListNode(11, new ListNode(23, 
					new ListNode(88, new ListNode(2))))); 	
        Stack<Integer> stack = new Stack<>(); 
        ListNode current2 = list2; 
	System.out.print("In order: "); 
        while ( !(current2 == null) ) { 	 
	    stack.push(current2.data);
	    System.out.print(current2.data + " ");  
            current2 = current2.next; 
	}	
        System.out.print("\nReverse: ");
        while ( !stack.isEmpty() ) { 
	    System.out.print(stack.pop() + " "); 
	} 	    
	System.out.println(); 
    } 	
} 
