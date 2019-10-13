import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.*;


/**
   This program demonstrates how to install an action listener.
*/
public class InvestmentViewer
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
      JButton button = new JButton("Add Interest");
      JLabel balLabel = new JLabel();
      JLabel yearLabel = new JLabel();
      frame.add(button);
      frame.add(balLabel);
     
      JPanel panel = new JPanel();
      panel.add(button);
      panel.add(balLabel);
      panel.add(yearLabel);
      frame.add(panel);
      



      // Prepare the response for when the user clicks the button
      final EasySound sound = new EasySound("win.wav");
      final BankAccount soundPiece = new BankAccount(); // must write final for Java version 7 & before
      class ClickListener implements ActionListener { // this is an inner class, i.e., inside main method
          int count = 1;
          final BankAccount myBank = new BankAccount(1000);
          public void actionPerformed(ActionEvent event) { // override this method to respond
             sound.play();
              myBank.addInterest(10);
              balLabel.setText("Balance: $"+ myBank.getBalance());
             yearLabel.setText("Years: "+ count);
             count++;
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
