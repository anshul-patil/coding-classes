import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

/**
 * This class is for a simple car (including drawing) that can be positioned anywhere on the screen,
 * and of any size.
 * 
 * @author C. Horstmann, modified by A. Nguyen
 * @verion 1.0
*/
public class Car
{
   private int xLeft;
   private int yTop;
   private int delta;

   /**
      Constructs a car with a given top left corner.
      @param x the x coordinate of the top left corner
      @param y the y coordinate of the top left corner
      @param approxLen the approximate length of the car; the car's height if half of the length
   */
   public Car(int x, int y, int approxLen)
   {
      xLeft = x;
      yTop = y;
      delta = approxLen / 6;
   }

   /**
      Draws the car.
      @param g2 the graphics context
   */
   public void draw(Graphics2D g2)
   {
      // The car body
       Rectangle body = new Rectangle(xLeft, yTop + delta, delta*6, delta);      
      
      // The 2 tires
      Ellipse2D.Double frontTire = new Ellipse2D.Double(xLeft + delta, yTop + delta*2, delta, delta);
      Ellipse2D.Double rearTire = new Ellipse2D.Double(xLeft + delta*4, yTop + delta*2, delta, delta);

      // The point at the bottom of the front windshield
      Point2D.Double r1 = new Point2D.Double(xLeft + delta, yTop + delta);
      // The  point at the front of the roof
      Point2D.Double r2 = new Point2D.Double(xLeft + delta*2, yTop);
      // The  point at the rear of the roof
      Point2D.Double r3 = new Point2D.Double(xLeft + delta*4, yTop);
      // The  point at the bottom of the rear windshield
      Point2D.Double r4 = new Point2D.Double(xLeft + delta*5, yTop + delta);

      // The lines for front windshield, roof, & rear windshield
      Line2D.Double frontWindshield = new Line2D.Double(r1, r2);
      Line2D.Double roofTop = new Line2D.Double(r2, r3);
      Line2D.Double rearWindshield = new Line2D.Double(r3, r4);
   
     // Draw the entire car
      g2.draw(body);
      g2.draw(frontTire);
      g2.draw(rearTire);
      g2.draw(frontWindshield);      
      g2.draw(roofTop);      
      g2.draw(rearWindshield);      
   }
}
