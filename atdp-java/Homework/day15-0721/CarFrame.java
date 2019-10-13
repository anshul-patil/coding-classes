import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.Timer;

/** 	 	 	 	 	 	
   This frame contains a moving rectangle.
*/
public class CarFrame extends JFrame {
   private static final int FRAME_WIDTH = 800;
   private static final int FRAME_HEIGHT = 200;

   private CarComponent scene;

   // Prep the listener to respond
   class TimerListener implements ActionListener {
      public void actionPerformed(ActionEvent event) {
         scene.moveCar(5, 0);
      }
   }

   public CarFrame() {
      // Prep the scene & add to the window frame (self)
      scene = new CarComponent();
      add(scene);

      setSize(FRAME_WIDTH, FRAME_HEIGHT);
      
      // Prepare a listener & connect to the timer
      ActionListener listener = new TimerListener();
      final int DELAY = 100; // Milliseconds between timer ticks
      Timer t = new Timer(DELAY, listener);
      t.start();      
   }
}
