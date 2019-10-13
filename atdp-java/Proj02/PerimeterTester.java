
import java.awt.Rectangle;

/**
   Constructs a Rectangle object and then computes and prints its area.
*/
public class PerimeterTester
{  
   public static void main(String[] args)
   {  
      Rectangle r1 = new Rectangle(10, 20, 50, 70);
      double perimeter = r1.getWidth() + r1.getHeight() +r1.getWidth() + r1.getHeight();
		
      System.out.println("Perimeter: " + perimeter);
      System.out.println("Expected: 240");
   }
}
