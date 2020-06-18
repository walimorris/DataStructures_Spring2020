/**
 * The Athlete Class allows the creation of individual athletes regardless
 * of their persepctive sport
 *
 * These athletes will have common statistics including their name, number and 
 * salary 
 *
 * @author Wali Morris<walimmorris@gmail.com>
 * @since 06/18/2020
 */

import java.lang.StringBuilder; 

public class Athlete { 
    private String firstName; 
    private String lastName; 
    private long salary; 
    private int number; 

    public Athlete(String firstName, String lastName) {
        this(firstName, lastName, 0, 0);
    }

    public Athlete(String firstName, String lastName, long salary, 
		    int number) {
	if ( number < 0 || number > 99 ) { 
	    throw new IllegalArgumentException("invalid number"); 
	} 	    
	this.firstName = firstName; 
	this.lastName = lastName; 
	this.salary = salary; 
	this.number = number; 
    }  

    public void setSalary(long salary) { 
	this.salary = salary; 
    } 

    public void setNumber(int number) { 
	if ( number < 0 || number > 99 ) { 
	    throw new IllegalArgumentException("invalid number"); 
	} 
        this.number = number; 
    } 

    public String getName() { 
	StringBuilder firstname = new StringBuilder(this.firstName); 
        StringBuilder lastname = new StringBuilder(this.lastName); 
        return firstname.toString() + " " + lastname.toString(); 
    }

    public long getSalary() { 
	return this.salary; 
    } 

    public int getNumber() { 
	return this.number; 
    } 
}     

