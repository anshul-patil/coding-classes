
import javax.swing.JFrame;

public class ShapeViewer
{
   public static void main(String[] args)
   {
      JFrame frame = new JFrame();

      frame.setSize(500, 600);
      frame.setTitle("Shapes");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      //Logo component = new Logo(120, 80);
      //frame.add(component);
      
      Trophy trophy = new Trophy(350, 80, 50);
      frame.add(trophy);

      frame.setVisible(true);
   }
}
