import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.DecimalFormat;

public class BMIViewer extends JFrame implements ActionListener
{
  // These are fields (& not local variables in the contructor), 
  // so that we can use them in actionPerformed 
  public static final int GRID_ROW_CT = 5;
  public static final int GRID_COL_CT = 2;  
  public static final int GRID_HOR_GAP = 5;    
  public static final int GRID_VERT_GAP = 5; 
  public static final int GRID_HT = 60;   
  
  private JTextField inputLbs, inputInches, displayBmi, displayBmiEval;
  private JRadioButton adult, child;
  private JButton calcB, resetB;
  
  private BMICalculator bmiCalc = new BMICalculator();

  public BMIViewer()
  { 
    super("BMI, >= 20 years old");
              
    // The variables that are not used in actionPerformed are declared as
    // local variables here in the contructor
    
    // Prep a group of 2 radio buttons
    adult = new JRadioButton("Adult (> 20 years)", true);
    child = new JRadioButton("Pregnant or child", false);  
    ButtonGroup twoButtonGrp = new ButtonGroup();
    twoButtonGrp.add(adult);
    twoButtonGrp.add(child);    
    
    // Prep labels (right-justified) & input texts
    JLabel labelLbs = new JLabel("Weight (lbs):", SwingConstants.RIGHT);
    inputLbs = new JTextField(5);
    JLabel labelInches = new JLabel("Height (inches):", SwingConstants.RIGHT);
    inputInches = new JTextField(5);
    JLabel labelBmi = new JLabel("BMI = ", SwingConstants.RIGHT);
    displayBmi = new JTextField(5);
    displayBmi.setEditable(false); // for display only; not for user input
    JLabel labelBmiEval = new JLabel("Evaluation = ", SwingConstants.RIGHT);
    displayBmiEval = new JTextField(5); // BMI evaluation
    displayBmiEval.setEditable(false); // for display only; not for user input
    
    // Prep buttons
    calcB = new JButton("Calculate");
    calcB.addActionListener(this);
    
    resetB = new JButton("Reset");
    resetB.addActionListener(this);
    
    
    Container c = getContentPane();
    c.setBackground(Color.white);
      
    // Prepare grid layout at the center 
    JPanel panel1 = new JPanel();
    panel1.setLayout(new GridLayout(GRID_ROW_CT, GRID_COL_CT, GRID_HOR_GAP, GRID_VERT_GAP)); 
    panel1.add(adult);
    panel1.add(child);
    panel1.add(labelLbs);
    panel1.add(inputLbs);
    panel1.add(labelInches);
    panel1.add(inputInches);
    panel1.add(labelBmi);
    panel1.add(displayBmi);
    panel1.add(labelBmiEval);
    panel1.add(displayBmiEval);
    c.add(panel1, BorderLayout.CENTER);

    // Prepare 2 button at the bottom 
    JPanel panel2 = new JPanel();
    panel2.setLayout(new GridLayout(1, 2, 4, 4)); // 1 row by 2 cols, with hor. & vert. gaps of 8
    panel2.add(calcB);
    panel2.add(resetB);
    c.add(panel2, BorderLayout.SOUTH);  
  }

  public void actionPerformed(ActionEvent e)
  {
      Object obj = e.getSource();
      if (obj instanceof JButton) {
          JButton b = (JButton)obj;
          
          if (b == calcB) {
            double bmiNum = 0.0;
            char personType;
            if (adult.isSelected())
              personType = 'A';
            else
              personType = 'C';
            bmiCalc.setAgeGrp(personType);

            if (personType == 'A') {
                int lbs = 0;
                int inches = 0;
                // Get weight
                String inputStr = inputLbs.getText();
                if (inputStr.length() > 0)
                    lbs = Integer.parseInt(inputStr.trim());
                // Get height
                inputStr = inputInches.getText();
                if (inputStr.length() > 0)
                    inches = Integer.parseInt(inputStr.trim());
                // Save weight & height, and calculate BMI 
                if (lbs > 0 && inches > 0) {
                    bmiCalc.setWt(lbs);
                    bmiCalc.setHt(inches);
                    bmiNum = bmiCalc.getBMIVal();
                }
                // Display BMI value, formatted
                DecimalFormat df = new DecimalFormat("00.0");
                displayBmi.setText(df.format(bmiNum));
            }
            // Display the description/evaluation
            displayBmiEval.setText(bmiCalc.getBMIEval());
            
            // Show dialog box
            if (personType == 'C') {
                JOptionPane.showMessageDialog(null, "The BMI for this category cannot be calculated");
            }
            
          }
          else if (b == resetB) {
            displayBmi.setText("");
            displayBmiEval.setText("");
          }
        }
    }
    
    
  public static void main(String[] args) {
      BMIViewer w = new BMIViewer();
      w.setBounds(300, 300, GRID_ROW_CT * GRID_HT, 200);
      w.setDefaultCloseOperation(EXIT_ON_CLOSE);
      w.setVisible(true);
  }
}