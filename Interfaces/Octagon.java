/**
 * An Octagon is an eight sided Polygon with each side being equal in length or,
 * sometimes, unequal in length
 *
 * Equal sided Octagons are considered normal Octagons and the Octagon in which 
 * this class implements
 *
 * The Octagon class implements the Shape.java Interface and currently commits
 * to finding the Area and Perimeter of an Octagon
 *
 * @author Wali Morris
 */

import java.util.*; 

public class Octagon implements Shape { 
    private double a; // represents the length of each equal side of Octagon  

    /**
     * Constructs an eight equal sided Octagon with length of sides equal to a
     * Throws Excpetion if length is less than or equal to 0
     * @param a : The length of the side 
     */
    public Octagon(double a) { 
	if ( a <= 0 ) throw new IllegalArgumentException("Invalid length of side a");  	    
        this.a = a; 
    } 

    /**
     * Equation to find the area of an eight sided normal Octagon 
     * @return Area of normal Octagon
     */
    public double getArea() { 
        return 2 * this.a * this.a * ( 1 + Math.sqrt(2)); 
    } 

    /** 
     * @return Perimeter of normal Octagon
     */
    public double getPerimeter() { 
	return 8 * this.a; 
    } 
} 
