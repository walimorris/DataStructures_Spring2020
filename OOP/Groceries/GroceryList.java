/**
 * Class GroceryList represents a list of items to buy from the market that uses an ArrayList as 
 * the underlying data structure to store grocery items and keep track if its size (the number
 * of items on the list)
 *
 * The GroceryList can contain as many items as neeeded
 *
 * @author Wali Morris
 * @since  06/14/2020
 */ 

import java.util.*; 

public class GroceryList { 
    private List<GroceryItemOrder> list;  

    /**
     * Creates a new empty GroceryList with zero items that allows unlimited amount of items
     */ 
    public GroceryList() { 
	this.list = new ArrayList<GroceryItemOrder>(); 
    } 

    /**
     * @param item : A item consisting of name, quantity, price per unit 
     * The item will be added to the list
     */ 
    public void add(GroceryItemOrder item) { 
	this.list.add(item);
    }	

    /**
     * @return the total cost of all items in list
     */
    public double getTotalCost() {
	double finalCost = 0.0; 
	for (int i = 0; i < this.getSize(); i++ ) { 	
	    finalCost += this.list.get(i).getCost();   
	} 
	return finalCost; 
    }

    /**
     * @return current size of groceryList
     */
    public int getSize() { 
	return this.list.size(); 
    } 
} 

	 
	

        
