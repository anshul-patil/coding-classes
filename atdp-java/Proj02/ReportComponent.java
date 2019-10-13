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

          img = ImageIO.read(new File("BlueJLogo.png")); // specify file name of the image here
        } 
        catch (IOException e) { 
        }

        int x = 172, y = 0;
        if (img != null && g2.drawImage(img, x, y, null));


      
      // ... HAVE YOUR CODE HERE
      
      
      
      g2.setColor(Color.BLACK);
      
   }
}
