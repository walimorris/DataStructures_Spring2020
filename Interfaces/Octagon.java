/**
 * An Octagon is an eight sided Polygon with each side being equal in length or,
 * sometimes, unequal in length and therefore its area can not be computed
 *
 * Equal sided Octagons are considered regular Octagons, has a formaula to compute
 * its area and is the Octagon type this class implements
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
     * @param a : The length of the side 
     */
    public Octagon(double a) { 
	if ( a <= 0 ) throw new IllegalArgumentException("Invalid length of side a");  	    
        this.a = a; 
    } 

    /** 
     * @return Area of regular Octagon
     */
    public double getArea() { 
        return 2 * this.a * this.a * ( 1 + Math.sqrt(2)); 
    } 

    /** 
     * @return Perimeter of regular Octagon
     */
    public double getPerimeter() { 
	return 8 * this.a; 
    } 
} 
