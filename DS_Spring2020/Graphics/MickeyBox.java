/** 
 *  A Drawing of "MickeyBox":
 *
 *  1) A large red square with a line through the middle
 *  2) Two blue circles, top left and top right
 *  3) Yellow DrawingPanel background 
 *
 *  @author Wali Morris
 *  @since April 13 2020
 */ 

import java.awt.*; 
import java.util.*; 

public class MickeyBox {
    public static void main(String[] args) {
        DrawingPanel panel = new DrawingPanel(220, 150);
        Graphics g = panel.getGraphics();
        g.setColor(Color.YELLOW); 
        g.fillRect(0, 0, 220, 150);// fills window with yellow background  
        g.setColor(Color.BLUE);
        g.fillOval(50, 25, 40, 40);// fills first ear color blue
        g.fillOval(130, 25, 40, 40); // fills second ear collor blue, x-coordinate 80 pixels right
        g.setColor(Color.RED);
	
	/* top left pt of sq(face) is in center of left circle whose width = 40 and height = 40. Face
	 * coordinates are x(50)+20, y(25)+20. Top right point of square must be in the center of right 
	 * ear whose left top point is 80 pxs apart from the left ear. Face has width and height of 80 */
        g.fillRect(70, 45, 80, 80); 
        g.setColor(Color.BLACK);
	
        /* lines x-coordinate remains same as face, y1 = face's y coordinate + width/2. x2 = x1 + width as 
	 * y2 = face's y coordinate + width/2 */ 
        g.drawLine(70, 85, 150, 85);
    }
}
