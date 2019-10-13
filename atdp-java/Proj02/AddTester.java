import java.awt.Rectangle;

/**
   Constructs a Rectangle object and then computes and prints its area.
*/
public class AddTester
{  
   public static void main(String[] args)
   {  
      Rectangle box = new Rectangle(10, 20, 50, 70);
      box.add(5,10);
		
      System.out.println("Actual Location: " + box);
      System.out.println("Expected Location: (5,10,55,80)");
   }
}
