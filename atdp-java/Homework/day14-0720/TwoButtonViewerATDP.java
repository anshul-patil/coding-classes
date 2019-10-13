import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.*;


/**
   This program demonstrates how to install an action listener.
*/
public class TwoButtonViewerATDP
{  
   // Decide the dimension of the window
   private static final int FRAME_WIDTH = 400; // 100
   private static final int FRAME_HEIGHT = 240; // 60

   public static void main(String[] args)
   {
      // Prepare the window
       JFrame frame = new JFrame();
      int counter = 0;
      // Prepare the button & add it to the window
      JButton button = new JButton("Click me!");
      JButton button2 = new JButton("Hit me :)!");
      frame.add(button);
      frame.add(button2);
     
      JPanel panel = new JPanel();
      panel.add(button);
      panel.add(button2);
      frame.add(panel);



      // Prepare the response for when the user clicks the button
      final EasySound soundPiece = new EasySound("bells.wav"); // must write final for Java version 7 & before
      class ClickListener implements ActionListener { // this is an inner class, i.e., inside main method
          int counter = 0;
          public void actionPerformed(ActionEvent event) { // override this method to respond
              soundPiece.play();
              
              counter++;
              
              System.out.println("Button was clicked " +counter +" times");
            }
        }

      // Link the listener to the button
      ActionListener listener = new ClickListener();
      ActionListener listener2 = new ClickListener();
      button.addActionListener(listener);
      button2.addActionListener(listener2);

      frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
}
