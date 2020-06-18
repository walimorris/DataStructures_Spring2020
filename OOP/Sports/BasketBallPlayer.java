/**
 * Basketball player inherits from the Athlete class with the addition of recording
 * a players vertical jump (the world record is 63.5 inches) and a players shot 
 * percentage 
 *
 * @author Wali Morris<walimmorris@gmail.com>
 * @since 06/18/2020
 */ 

public class BasketBallPlayer extends Athlete { 
    private double vertical; 
    private double shotPercentage;  

    public BasketBallPlayer(String firstName, String lastName, long salary, int number, 
		    double vertical, double shotPercentage) { 
	super(firstName, lastName, salary, number); 
	this.vertical = vertical; 
	this.shotPercentage = shotPercentage;
    } 

    public void setVertical(double vertical) {
	if ( vertical < 0 || vertical > 80.5) { 
	    throw new IllegalArgumentException("Impossible vertical, not on the moon"); 
	} 	    
	this.vertical = vertical; 
    } 

    public void setShotPercentage(double shotPercentage) { 
	 this.shotPercentage = shotPercentage; 
    } 

    public double getVertical() { 
	return this.vertical; 
    } 

    public double getShotPercentage() { 
	return this.shotPercentage; 
    }

    public String getStats() { 
	StringBuilder vertical = new StringBuilder(Double.toString(this.vertical)); 
	StringBuilder shot = new StringBuilder(Double.toString(this.shotPercentage)); 
	String stats = "Vertical: " + vertical.toString() + "| Shot Percentage: " + shot.toString(); 
        return stats; 
    } 

    public String printStats() { 
	return "Player: " + super.getName() + "| Salary: " + super.getSalary() + 
	       "| Jersey: " + super.getNumber() + "| "  + this.getStats(); 	
    } 
}     
			        
