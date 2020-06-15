import java.util.*; 

public class PurchasingGrocery { 
    public static void main(String[] args) { 
        // Creates a new GroceryList and adds each item to list
	GroceryList groceryList = new GroceryList(); 
        groceryList.add(new GroceryItemOrder("Apples", 5, 1.33));
        groceryList.add(new GroceryItemOrder("Milk", 2, 5.75)); 
        groceryList.add(new GroceryItemOrder("Bread", 1, 3.99));	
        groceryList.add(new GroceryItemOrder("Cheese", 1, 2.49));	
        groceryList.add(new GroceryItemOrder("Orange Juice", 2, 5.99));	

	// return the total cost of groceryList
	double totalSpendings = groceryList.getTotalCost(); 
	System.out.println("Total Cost of groceryList: $" + groceryList.getTotalCost());  	
		
    } 
}     
