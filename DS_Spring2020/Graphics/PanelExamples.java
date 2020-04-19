/** 
 * Example Representing a Drawing Panel object 
 *
 * The Drawing Panel object keeps track of the overall image, 
 * but the actual drawing is done with an object of type 
 * Graphics
 *
 * Examples and notes below 
 *
 * @author Wali Morris
 */

import java.util.*; 
import java.awt.*; 

public class PanelExamples { 
    public static void main(String[] args) { 
        // takes (width, height) parameters, this is just the "view" which makes the window
	DrawingPanel panel = new DrawingPanel(400, 400);  
	
	/* DrawingPanel obj has method setBackground(Color c) that takes object 
	 * of type Color and sets the panels background */ 	
	panel.setBackground(Color.CYAN); 
	
	// calls the panel with graphics on screen
        Graphics brush = panel.getGraphics();
        
	// String to draw on the panel 
	String msg = "A neat Drawing Panel"; 
	
	/* draws the String message of the screen(String msg, x, y)
	 * x, y = lower left corner of String msg */		
	brush.drawString(msg, 100, 50);

       /* save an image in this programs directory, in which below
	* we can load the image to an Image obj */ 
       Image img = panel.loadImage("smiley.jpeg");

       /* to draw this smiley image to panel, use drawImage() method from 
	* Graphics obj, place the image at (x, y) coordinates and also pass 
	* the DrawingPanel obj as parameter 
	*/  
       brush.drawImage(img, 50, 50, panel);        
    } 
}     
