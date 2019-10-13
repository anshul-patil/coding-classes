import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import java.util.Random;
import java.awt.Color;
import java.awt.Rectangle;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

/**
   This component draws stars.
*/
public class ReportComponent extends JComponent
{
   public void paintComponent(Graphics g)
   {
      Graphics2D g2 = (Graphics2D) g;
      
      // The following is for you to place things in the right place
      // Delete these rectangles before you finalize your image
      
      g2.setColor(Color.LIGHT_GRAY);
      g2.draw(new Rectangle(0, 0, 480, 700)); // paper
      g2.draw(new Rectangle(0, 450, 480, 250)); // leave this area blank (for teacher)
      
      
      // Show image at top-right area
      BufferedImage img = null; 
      try {

          img = ImageIO.read(new File("Trophy.png")); // specify file name of the image here
        } 
        catch (IOException e) { 
        }

      int x = 375, y = 5;
      if (img != null && g2.drawImage(img, x, y, null));


      
      x = 90;
      y = 30;
      Logo component = new Logo(x, y);
      component.paintComponent(g2);
      x = 60;
      y = 90;
      
      Grade score = new Grade(88, x, y);
      score.paintComponent(g2);
      g2.setColor(Color.BLACK);
      
   }
}
