/**
 * A short program to illustrate finding the area and perimeter of a normal Octagon 
 * object 
 *
 * To illustrate programming with interfaces there are also  Circle objects 
 * in the array of shapes.
 *
 * @author Wali Morris 
 */ 

import java.util.*; 

public class ShapesMain { 
    public static void main(String[] args) { 
	Shape[] shapes = new Shape[5]; 
	shapes[0] = new Octagon(7); 
	shapes[1] = new Octagon(10); 
	shapes[2] = new Octagon(6);
	shapes[3] = new Circle(22); 
	shapes[4] = new Circle(12); 
        
        for (Shape obj: shapes ) {
	    if (obj instanceof Octagon) {
	        System.out.print("Octagon: ");
	    } else { 
                System.out.print("Circle: "); 
	    } 		
	    System.out.println("Area: " + obj.getArea() + " " + 
		               "Perimeter: " + obj.getPerimeter());
	}
    } 
}     

