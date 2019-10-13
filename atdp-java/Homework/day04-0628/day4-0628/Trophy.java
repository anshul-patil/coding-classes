import java.awt.Color;
import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.Polygon;
/**
 * Write a description of class Trophy here.
 *
 * @author Anshul Patil
 * @version 1.0
 */
public class Trophy
{
    // instance variables - replace the example below with your own
    private int startx = 0;
    private int starty = 0;
    private int width = 80;
    // Prepare some colors from scratch (max=255): RGB, or RGB & alpha value
    private Color colorGold = new Color(255, 255, 153);
    private Color colorGreen = new Color(51, 204, 51);

    /**
      Constructs a trophy with a given top left corner.
      @param x the x coordinate of the top left corner
      @param y the y coordinate of the top left corner
      @param width the approximate width of the trophy; 
   */
   public Trophy(int x, int y, int w)
   {
      startx = x;
      starty = y;
      width = w;
   }

    /**
      Draws the trophy.
      @param g2 the graphics context
   */
   public void draw(Graphics2D g2)
   {
       // compute other dimensions
      int topHeight = width*5/8;
      int ellipseHeight = topHeight*7/10;
      int ellipseY = ellipseHeight;
      int leftStemX = width*3/8;
      int rightStemX = width*5/8;
      int topStemY = width*7/8;
      int bottomStemY = width*14/8;
      int strokeWidth = width/4;
      int handleWidth = width/10;
      int shrinkX = -width/8;
      int shrinkY = -topHeight*3/10;
      int translateY = topHeight + ellipseHeight/2 + bottomStemY - topStemY;
      int labelX = width/10;
      int labelY = topHeight*2/5;
      int delta = width/8;
      
      
      Rectangle topRectangle = new Rectangle(startx, starty, width, topHeight);
      Ellipse2D.Double topOval = new Ellipse2D.Double(startx, starty+ellipseY, width, ellipseHeight);
      
      // Center
      Line2D.Double leftLine = new Line2D.Double(startx+leftStemX, starty+topStemY, startx+leftStemX, starty+bottomStemY);
      Line2D.Double rightLine = new Line2D.Double(startx+rightStemX, starty+topStemY, startx+rightStemX, starty+bottomStemY);

      // Construct a polygon
      int[] xCoordsLeft = {startx+3*delta, startx+2*delta, startx+delta, startx+delta, startx+3*delta};
      int[] yCoordsLeft = {starty+9*delta, starty+9*delta, starty+8*delta, starty+11*delta, starty+11*delta};
      Polygon leftPoly = new Polygon(xCoordsLeft, yCoordsLeft, 5);
      int [] xCoordsRight = {startx+5*delta, startx+6*delta, startx+7*delta, startx+7*delta, startx+5*delta};
      int [] yCoordsRight = {starty+9*delta, starty+9*delta, starty+8*delta, starty+11*delta, starty+11*delta};
      Polygon rightPoly = new Polygon(xCoordsRight, yCoordsRight, 5);
     
      
      // Draw top
      g2.setColor(colorGold);
      g2.fill(topRectangle);
      g2.fill(topOval);
      
      // Stem Draw line Make them thick so it looks filled
      g2.setStroke(new BasicStroke(strokeWidth));
      g2.draw(leftLine);
      g2.draw(rightLine);
      
      // Handles Draw & fill polygon
      g2.setStroke(new BasicStroke(handleWidth));
      g2.draw(leftPoly);
      g2.draw(rightPoly);
      
      // Base    
      topRectangle.grow(shrinkX, shrinkY);
      topRectangle.translate(0, translateY);
      g2.draw(topRectangle);
      g2.setColor(Color.MAGENTA);
      g2.fill(topRectangle);
      
      // Winner!
      g2.setColor(Color.BLACK);
      g2.drawString("Anshul #1", startx+labelX, starty+labelY);
      
      //Base Text
      //g2.setColor(colorGreen);
      //g2.drawString("CHAMP!", startx+2*labelX, starty+translateY+labelY+labelY/2);
    }
}
