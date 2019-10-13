import java.awt.Component;
import java.awt.Dimension;
import java.awt.Event;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
 
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.KeyStroke;
 
public class SwingPrinter extends JFrame {
    /** adapted from Java Tips
     * http://www.java-tips.org/java-se-tips-100019/106-java-awt-print/2296-how-to-print-swing-components.html
     */
    
  public static void main(String[] args) {
    new SwingPrinter();
  }
 
  private PageFormat mPageFormat;
 
  public SwingPrinter() {
    super("SwingPrinter v1.0");
    createUI();
    PrinterJob pj = PrinterJob.getPrinterJob();
    mPageFormat = pj.defaultPage();
    setVisible(true);
  }
 
  protected void createUI() {
    setSize(480, 700);
    center();
 
    // Add the menu bar.
    JMenuBar mb = new JMenuBar();
    JMenu file = new JMenu("File", true);
    file.add(new FilePrintAction()).setAccelerator(
        KeyStroke.getKeyStroke(KeyEvent.VK_P, Event.CTRL_MASK));
    file.add(new FilePageSetupAction()).setAccelerator(
        KeyStroke.getKeyStroke(KeyEvent.VK_P, Event.CTRL_MASK
            | Event.SHIFT_MASK));
    file.addSeparator();
    file.add(new FileQuitAction()).setAccelerator(
        KeyStroke.getKeyStroke(KeyEvent.VK_Q, Event.CTRL_MASK));
    mb.add(file);
    setJMenuBar(mb);
 
    // Add the contents of the window.
    getContentPane().add(new ReportComponent());
 
    // Exit the application when the window is closed.
    
    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
  }
 
  protected void center() {
    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    Dimension us = getSize();
    int x = (screen.width - us.width) / 2;
    int y = (screen.height - us.height) / 2;
    setLocation(x, y);
  }
  
  public class FilePageSetupAction extends AbstractAction {
    public FilePageSetupAction() {
      super("Page setup...");
    }
 
    public void actionPerformed(ActionEvent ae) {
      PrinterJob pj = PrinterJob.getPrinterJob();
      mPageFormat = pj.pageDialog(mPageFormat);
    }
  }
  
  public class FilePrintAction extends AbstractAction {
    public FilePrintAction() {
      super("Print");
    }
 
    public void actionPerformed(ActionEvent ae) {
      PrinterJob pj = PrinterJob.getPrinterJob();
      ComponentPrintable cp = new ComponentPrintable(getContentPane());
      pj.setPrintable(cp, mPageFormat);
      if (pj.printDialog()) {
        try {
          pj.print();
        } 
        catch (PrinterException e) {
          System.out.println(e);
        }
      }
    }
  }
  
  public class FileQuitAction extends AbstractAction {
    public FileQuitAction() {
      super("Quit");
    }
 
    public void actionPerformed(ActionEvent ae) {
      System.exit(0);
    }
  }
  
}
