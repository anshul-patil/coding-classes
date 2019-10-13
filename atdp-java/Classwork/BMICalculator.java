/*
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.DecimalFormat;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.DecimalFormat;
*/

public class BMICalculator {
    final static double KG_IN_1_LB = 0.454;
    final static double M_IN_1_IN = 0.0254;
    
    private int wtInLbs;
    private int htInInches;
    private char personType;

    public BMICalculator()
    { 
      wtInLbs = 0;
      htInInches = 0;
      personType = 'A';
    }
    
    public void setWt(int wt) {
      wtInLbs = wt;
    }
    
    public void setHt(int ht) {
      htInInches = ht;
    }

    public void setAgeGrp(char grp) {
      personType = grp;
    }
    
    public double getBMIVal() {
        double kg = KG_IN_1_LB * wtInLbs;
        double m = M_IN_1_IN * htInInches;
        return kg / (m * m);
    }
    
    public String getBMIEval() {
        String eval = "";
        
        if (personType == 'C') {
            eval = "Not available";
        }
        else {
            double bmiNum = getBMIVal();
            if (bmiNum >= 30.0) {
                eval = "Obese";
            }
            else if (bmiNum >= 25.0) {
                eval = "Overweight";
            }
            else if (bmiNum >= 18.5) {
                eval = "Healthy Weight";
            }
            else if (bmiNum >= 0.1) {
                eval = "Underweight";
            }
            else {
                eval = "Incorrect weight & height";
            }
        }
        return eval;
    }
}

