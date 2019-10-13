import java.awt.Rectangle;

/**
   Constructs a Rectangle object and then computes and prints its area.
*/
public class FourRectanglePrinter
{  
   public static void main(String[] args)
   {  
      Rectangle box = new Rectangle(10, 20, 50, 70);
      System.out.println(box);
      box.setLocation(50,0);
	System.out.println(box);
	box.setLocation(0,70);
	System.out.println(box);
	box.setLocation(50,70);
	System.out.println(box);
   }
}
