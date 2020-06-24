// The kitchen light uses an instance of the LightSwitch Data Type

import java.util.*; 

public class KitchenLight { 
    public static void main(String[] args) {

	Scanner console = new Scanner(System.in); 

	LightSwitch kitchenLight = new LightSwitch(); 
	System.out.println("Kitchen light status: " + kitchenLight.getStatus()); 
	System.out.println("You have walked into the kitchen and the light is off."); 
	System.out.println("Would you like to turn on the light...\n");
        System.out.print("Type (0) for 'no' and (1) for 'yes' ->  "); 
        int setSwitch = console.nextInt();
	kitchenLight.setStatus(setSwitch); 
	System.out.println("Kitchen light status: " + kitchenLight.getStatus()); 
    } 
} 
        	

