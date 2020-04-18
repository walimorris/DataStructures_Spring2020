/**
 * Shapes acts as an interface for different shape objects such as: circles, 
 * triangles, rectangles and octagons
 *
 * Currently, this interface makes a commitment to find the area and perimeter 
 * of each shape object 
 *
 * @author Wali Morris 
 */ 

public interface Shape { 
    
    /**
     * Abstract method to find the area of a shape
     */
    public double getArea();

    /** 
     * Abstract method to find the perimeter of a shape
     */
    public double getPerimeter(); 
}  
