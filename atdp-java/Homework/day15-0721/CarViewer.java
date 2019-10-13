import javax.swing.JFrame;

/** 	 	 	 	 	 	
   This program moves the rectangle. sect9
*/
public class CarViewer
{
   public static void main(String[] args)
   {
      JFrame frame = new CarFrame();
      frame.setTitle("A Moving Car");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
}
