/** 
 *  A Drawing using of "MickeyBox":
 *
 *  1) A large red square with a line through the middle
 *  2) Two blue circles, top left and top right
 *  3) Yellow DrawingPanel background 
 *
 *  @author Wali Morris<walimmorris@gmail.com> 
 *  @since April 13 2020
 */ 

import java.awt.*; 
import java.util.*; 

public class MickeyBox { 
    public static void main(String[] args) { 
	int width = 220; 
	int height = 150; 
	DrawingPanel panel = new DrawingPanel(width, height); 
	panel.setBackground(Color.YELLOW);
	Graphics brush = panel.getGraphics();
        drawEars(brush, Color.BLUE, 50, 25, 40, 40);
        
        /* top left point of square(face) is in center of left circle whose width = 40 
	 * and height = 40. From this information, say squares coordinates are x(50)+20, 
	 * y(25)+20. The top right point of square must be in the center of right ear 
	 * whose left top point is 80 pixels apart from the left ear. Say face has width 
	 * and height of 80. 
	 */ 	
	drawFace(brush, Color.RED, Color.BLACK, 70, 45, 80, 80); 
    } 
    
    /* This function takes Graphics obj, fill Color, x-y coordinates with width and height */ 
    public static void drawEars(Graphics brush, Color c, int x, int  y, 
		               int width, int height) { 

	brush.setColor(c); 
	brush.fillOval(x, y, width, height); // left ear
	brush.drawOval(x, y, width, height); 
	brush.fillOval(x+(width*2), y, width, height); // right ear 80 pixels apart horizontally 
	brush.drawOval(x+(width*2), y, width, height);
    }
    /* This function takes Graphics obj, shape fill color, line fill color, x-y coordinates
     * width and height of square(Mickey's face)
     */
    public static void drawFace(Graphics brush, Color c, Color line, int x, 
		                int y, int width, int height) { 
	
	brush.setColor(c);   
	brush.fillRect(x, y, width, height); 
	brush.drawRect(x, y, width, height); 
	brush.setColor(line);
        
	/* The line remains on the same horizontal coordinate, here being evenly divided by the 
	 * height of the square and summed to it's y-coordinate to lower to the middle of the 
	 * square. The point of x2 has sum x1 + width to connect point1(x1,y1) to point2(x2, y2)
	 */ 	
	brush.drawLine(x, y+(height/2), x+width, y+(height/2));  
    } 
} 
         
