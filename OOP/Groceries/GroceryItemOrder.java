/**
 * GroceryItemList represents a request to purchase a particular item in a given quantity 
 *
 * @author Wali Morris
 * @since 06/14/2020
 */ 

/**
 * GroceryItemOrder requires a name, quantity and price per unit of that item 
 */ 
public class GroceryItemOrder { 
    private String name; 
    private int quantity;
    private double pricePerUnit; 

    /**
     * @param : name The name of the requested item 
     * @param : quantity how many of the requested item
     * @param : pricePerUnit the cost of one of the requested item 
     */ 
    public GroceryItemOrder(String name, int quantity, double pricePerUnit) { 
	this.name = name; 
	this.quantity = quantity; 
	this.pricePerUnit = pricePerUnit; 
    } 

    /**
     * @return the total cost of one item by the quantity 
     */ 
    public double getCost() { 
	return this.quantity * this.pricePerUnit; 
    } 

    /** 
     * Sets the quantity for a certain item 
     */ 
    public void setQuantity(int quantity) { 
	this.quantity = quantity; 
    }
} 
