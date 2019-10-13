import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JComponent;
import java.util.ArrayList;

/**
   This component displays a rectangle that can be moved. 
*/
public class RectangleComponent2 extends JComponent
{
   private static final int BOX_X = 100;
   private static final int BOX_Y = 100;
   private static final int BOX_WIDTH = 20;
   private static final int BOX_HEIGHT = 30;
   ArrayList<Rectangle> stuff = new ArrayList<Rectangle>();


   

   public RectangleComponent2()
   {  
      // The rectangle that the paintComponent method draws 
      Rectangle box;
      box = new Rectangle(BOX_X, BOX_Y, BOX_WIDTH, BOX_HEIGHT); 
      stuff.add(box);
   }

   public void paintComponent(Graphics g)
   {  
      Graphics2D g2 = (Graphics2D) g;
      for (int i = 0; i < stuff.size();i++)
      {
          g2.draw(stuff.get(i));
      }
   }

   /**
      Moves the rectangle to the given location.
      @param x the x-position of the new location
      @param y the y-position of the new location
   */
   public void addRectangle(int x, int y)
   {
      Rectangle box;
      box = new Rectangle(x, y, BOX_WIDTH, BOX_HEIGHT); 
      stuff.add(box);
      repaint();
   }
}
