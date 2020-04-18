/** 
 * This class implementation of a Circle object is originally from the textbook
 * Building Java Programs: A Back to Basics Approach, 5th edition
 *
 * This class is used as an extension of exercise 15, writing a Octagon class
 * that implements the Shape.java interface
 */ 

// Represents circular shapes.
public class Circle implements Shape {
    private double radius;
 
    // constructs a new circle with the given radius
    public Circle(double radius) {
        this.radius = radius;
    }
    
    // returns the area of this circle
    public double getArea() {
        return Math.PI * radius * radius;
    }
      
    // returns the perimeter of this circle
    public double getPerimeter() {
        return 2.0 * Math.PI * radius; 
    } 
} 
