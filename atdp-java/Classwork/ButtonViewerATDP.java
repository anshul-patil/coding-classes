import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
   This program demonstrates how to install an action listener.
*/
public class ButtonViewerATDP
{  
   // Decide the dimension of the window
   private static final int FRAME_WIDTH = 200; // 100
   private static final int FRAME_HEIGHT = 120; // 60

   public static void main(String[] args)
   {
      // Prepare the window
       JFrame frame = new JFrame();
      
      // Prepare the button & add it to the window
      JButton button = new JButton("Click me!");
      frame.add(button);

      // Prepare the response for when the user clicks the button
      final EasySound soundPiece = new EasySound("bells.wav"); // must write final for Java version 7 & before
      class ClickListener implements ActionListener { // this is an inner class, i.e., inside main method
          public void actionPerformed(ActionEvent event) { // override this method to respond
              soundPiece.play();
              System.out.println("Button was clicked");
            }
        }

      // Link the listener to the button
      ActionListener listener = new ClickListener();
      button.addActionListener(listener);

      frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
}
