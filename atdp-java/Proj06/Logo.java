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
public class Logo extends JComponent
{ 
   private int startx = 100;
   private int starty = 55;
   public Logo(int x, int y)
   {
       startx = x;
       starty = y;
   }
   public void paintComponent(Graphics g)
   {
      // Recover Graphics2D
      Graphics2D g2 = (Graphics2D) g;
      
      // Show the boundary for the image
      //g2.setColor(Color.LIGHT_GRAY);
      //Rectangle boundary = new Rectangle(0, 0, 300, 360);
      //g2.fill(boundary);
      
      
      // Prepare some colors from scratch (max=255): RGB, or RGB & alpha value
      Color lightBlue = new Color(66, 200, 244);
      
      
      Rectangle topRectangle = new Rectangle(startx - 5, starty - 10, 10, 55);
      Rectangle topRectanglet = new Rectangle(startx - 13, starty, 25, 10);
      Rectangle aRectangle = new Rectangle (startx - 30, starty, 5, 45); 
      Rectangle pRectangle = new Rectangle (startx + 80, starty, 5, 55); 
      Ellipse2D.Double topOval = new Ellipse2D.Double(startx - 70, starty, 45, 45);
      Ellipse2D.Double dOval = new Ellipse2D.Double(startx + 20, starty, 45, 45);
      Rectangle topRectangled = new Rectangle(startx + 60, starty - 10, 5, 55);
      Ellipse2D.Double pOval = new Ellipse2D.Double(startx + 80, starty, 45, 45);
      
      
      // Draw top
      g2.setColor(lightBlue);
      g2.fill(topRectangle);
      g2.setColor(lightBlue);
      g2.draw(topOval);
      g2.draw(topRectanglet);
      g2.draw(dOval);
      g2.draw(topRectangled);
      g2.draw(pOval);
      g2.draw(pRectangle);
      g2.fill(aRectangle);
      g2.fill(topOval);
      g2.fill(topRectanglet);
      g2.fill(dOval);
      g2.fill(topRectangled);
      g2.fill(pOval);
      g2.fill(pRectangle);

      
      // Stem Draw line Make them thick so it looks filled
      g2.setStroke(new BasicStroke(20));
      
      // Base    
      topRectangle.grow(-10, -15);
      topRectangle.translate(0, 130);
      g2.draw(topRectangle);
      g2.setColor(Color.MAGENTA);
      g2.fill(topRectangle);
      
      
      
   }
}
