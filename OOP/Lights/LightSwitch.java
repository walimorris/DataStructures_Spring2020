/**
 * A Light Switch has two operations on and off which will be represented by 1 and 0, respectively
 *
 * Add a light percentage ?
 *
 * @author Wali Morris<walimmorris@gmail.com>
 * @since 06/23/2020
 * @see KitchenLight.java : for example using a LightSwitch object
 */

public class LightSwitch { 
    private int status;  

    /**
     * A new instance of a LightSwitch always begins in the off position, clients can switch 
     * between off and on there after 
     */
    public LightSwitch() {
	this.status = 0; 
    } 

    /**
     * Switches LightSwitch to on status 
     */
    public void switchOn() { 
	this.status = 1; 
    } 

    /**
     * Switches LightSwitch to off status
     */
    public void switchOff() { 
	this.status = 0;
    }
    
    /**
     * Allows client to set the kitchen light status 
     * @param num : should be either 0 for off and 1 for on 
     * @throws IllegalArgumentException : for any number that's not 0 or 1
     */ 
    public void setStatus(int num) { 
	if ( num < 0 || num > 1 ) { 
	    throw new IllegalArgumentException("Switch can either be on(1) or off(0)"); 
	} else if ( num == 1 ) { 
	    this.switchOn(); 
	} else { 
            this.switchOff(); 
	} 
    } 	

    /**
     * @return The LightSwitch staus "on" or "off" 
     */
    public String getStatus() {
	if ( this.status == 0 ) { 
	    return "Off"; 
	} 
	return "On"; 
    } 
}    
