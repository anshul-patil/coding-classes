import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import java.util.Random;

/**
 * This component draws a few cars.
 * @author C. Horstmann, modified by A. Nguyen
 * @version 2.0
*/
public class CarComponent extends JComponent
{
   private static final int CAR_X = 20;
   private static final int CAR_Y = 20;
   private static final int CAR_LEN = 100;

   private Car myCar;
   public CarComponent()
   {
       myCar = new Car(CAR_X, CAR_Y, CAR_LEN);
   }
   public void paintComponent(Graphics g)
   {  
      Graphics2D g2 = (Graphics2D) g;
      
      myCar.draw(g2);
   }
   
   public void moveCar(int dx, int dy)
   {
       myCar.translate(dx, dy);
       repaint();
   }
}
