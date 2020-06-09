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

        /* add a value at the end of the linked list */ 
        ListNode list3 = new ListNode(12, new ListNode(2, new ListNode(10))); 
        addNode(list3, 5);
	System.out.println("adding node with value '5'"); 
	ListNode current3 = list3; 
	while ( !(current3 == null) ) { 
	    System.out.print(current3.data + " "); 
	    current3 = current3.next; 
	} 
	System.out.println(); 
    } 

    /* This method takes two parameters, a linkedList and a value to add to the end of the 
     * list. If the list has no values, then the value will be added to the list. If the 
     * list contains a certain number of elements, the list will be iterated until the last 
     * node, then the value will be appended to the end */ 
    public static void addNode(ListNode list, int value) {
	if ( list == null ) { 
	    list = new ListNode(value); 
	} else { 		
	    ListNode current = list; 
            while ( !(current.next == null) ) { 
	        current = current.next;
	    }
	    current.next = new ListNode(value); 
	}  
    } 
}     
        







