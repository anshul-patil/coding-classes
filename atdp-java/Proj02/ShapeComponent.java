import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.Rectangle;
import java.awt.geom.Line2D;
import java.awt.Polygon;
import java.awt.Color;
import java.awt.BasicStroke;
import javax.swing.JComponent;

/*
   A component that draws two rectangles.
*/
public class ShapeComponent extends JComponent
{  
   public void paintComponent(Graphics g)
   {
      // Recover Graphics2D
      Graphics2D g2 = (Graphics2D) g;
      
      // Show the boundary for the image
      g2.setColor(Color.LIGHT_GRAY);
      Rectangle boundary = new Rectangle(0, 0, 300, 360);
      g2.fill(boundary);
      
      
      // Prepare some colors from scratch (max=255): RGB, or RGB & alpha value
      Color colorGold = new Color(255, 255, 153);
      Color colorGreen = new Color(51, 204, 51);
      
      // Lets draw a trophy
      // top is rectangle + ellipse
      // stem is two lines
      // base is rectangle
      // handles are polygons
      // text is Anshul #1
      
      //top
      int startx = 120; //120
      int starty = 75;
      Rectangle topRectangle = new Rectangle(startx, starty, 80, 50);
      Ellipse2D.Double topOval = new Ellipse2D.Double(startx, starty+32, 80, 35);
      
      // Center
      Line2D.Double leftLine = new Line2D.Double(startx+30, starty+68, startx+30, starty+140);
      Line2D.Double rightLine = new Line2D.Double(startx+50, starty+68, startx+50, starty+140);

      // Construct a polygon
      int[] xCoordsLeft = {startx+30, startx+20, startx+10, startx+10, startx+30};
      int[] yCoordsLeft = {starty+90, starty+90, starty+80, starty+110, starty+110};
      Polygon leftPoly = new Polygon(xCoordsLeft, yCoordsLeft, 5);
      int [] xCoordsRight = {startx+50, startx+60, startx+70, startx+70, startx+50};
      int [] yCoordsRight = {starty+90, starty+90, starty+80, starty+110, starty+110};
      Polygon rightPoly = new Polygon(xCoordsRight, yCoordsRight, 5);
     
      
      // Draw top
      g2.setColor(colorGold);
      g2.fill(topRectangle);
      g2.fill(topOval);
      
      // Stem Draw line Make them thick so it looks filled
      g2.setStroke(new BasicStroke(20));
      g2.draw(leftLine);
      g2.draw(rightLine);
      
      // Handles Draw & fill polygon
      g2.setStroke(new BasicStroke(8));
      g2.draw(leftPoly);
      g2.draw(rightPoly);
      
      // Base    
      topRectangle.grow(-10, -15);
      topRectangle.translate(0, 130);
      g2.draw(topRectangle);
      g2.setColor(Color.MAGENTA);
      g2.fill(topRectangle);
      
      // Winner!
      g2.setColor(Color.BLACK);
      g2.drawString("Anshul #1", startx+8, starty+20);
      
      // Title: My Trophy
      g2.setColor(Color.ORANGE);
      g2.drawString("MY TROPHY", startx+8, starty-20);
      
      //Base Text
      g2.setColor(colorGreen);
      g2.drawString("CHAMP!", startx+15, starty+160);
      
      
   }
}
