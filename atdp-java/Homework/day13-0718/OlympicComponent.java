import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.Rectangle;
import java.awt.geom.Line2D;
import java.awt.Polygon;
import java.awt.Color;
import java.awt.BasicStroke;
import javax.swing.JComponent;
import java.util.Random;

/*
   A component that draws two rectangles.
*/
public class OlympicComponent extends JComponent
{  
   public void paintComponent(Graphics g)
   {
      // Recover Graphics2D
      Graphics2D g2 = (Graphics2D) g;
      
      int radius = 10;
      OlympicLogo logo = new OlympicLogo(75, 75, radius);
      logo.draw(g2);
      
      // Coordinates of bottom-right corner
      int right = getWidth(); // the width of the view
      int bot = getHeight();  // the height of the view
      radius = 25;
     
      Random randGen = new Random(); // create object for random number generator
     
      double x = randGen.nextInt(right - radius * 2);
      double y = randGen.nextInt(bot/3) + bot/3 - radius;
       
      OlympicLogo logo1 = new OlympicLogo(x, y, radius);
      logo1.draw(g2);
      
      radius = 30;               // the length of the car - note: do NOT declare again
      x = getWidth() - radius * 5;    
      y = getHeight() - radius * 4;
      OlympicLogo logo2 = new OlympicLogo(x, y, radius);
      logo2.draw(g2);
      
   }
}
