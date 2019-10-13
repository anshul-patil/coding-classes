import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.Rectangle;
import java.awt.geom.Line2D;
import java.awt.Polygon;
import java.awt.Color;
import java.awt.BasicStroke;
import javax.swing.JComponent;
/**
 * Write a description of class Grade here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Grade extends JComponent
{
    
    // instance variables - replace the example below with your own
    private double score;
    private int starty;
    private int startx;
    /**
     * Constructor for objects of class Grade
     */
    public Grade(double points , int x, int y)
   {
        // initialise instance variables
        startx  = x;
        starty = y;
        score = points;
   }
   public double getScore()
   {
       return score;
   }
   public String letterGrade()
   {
       String grade = "";
       if (score >= 97)
       {
            grade = "A+";  
       }
       if (score >= 93 && score < 97)
       {
            grade = "A";
       }
       if (score >= 90 && score < 93)
       {
            grade = "A-";
       }
       if (score >= 87 && score < 90)
       {
            grade = "B+";
       }
       if (score >= 83 && score < 87)
       {
           grade = "B";
       }
       if (score >= 80 && score < 83)
       {
           grade = "B-";
       }
       if (score >= 65 && score < 80)
       {
           grade = "PASS";
       }
       if ( score < 65)
       {
           grade = "NO PASS";
       }
       return grade; 
   }
   
   public void paintComponent(Graphics2D g2)
   {
      // Recover Graphics2D
      g2.setColor(Color.black);
      g2.drawString("Course: SD 3735.1 - Programming in Java", startx, starty + 40);
      g2.drawString("Grade report, 7/9/2017", startx, starty + 60);
      g2.drawString("Student : Anshul Patil", startx, starty + 80);
      g2.drawString("Grade : " + getScore() + "% " + letterGrade(), startx, starty + 100);
      Rectangle sig = new Rectangle(startx , starty + 180, 200, 60);
      Rectangle date = new Rectangle(startx + 200, starty + 180 , 200, 60);

      g2.setColor(Color.black);
      g2.setStroke(new BasicStroke(1));
      g2.draw(sig);
      g2.draw(date);
      g2.drawString("Signature by parent/guardian : ", startx+5, starty + 200);
      g2.drawString("Date : ", startx + 210, starty + 200);
      
      Rectangle comments = new Rectangle(startx, starty + 275, 400, 80);
      g2.draw(comments);
      g2.drawString("Comments by Teacher: ", startx, starty + 270);
      g2.drawString("Anshul is very attentive in class, and has done well. He works", startx + 5, starty + 300);
      g2.drawString("well with in partner in class, \n and in encouraged to participate", startx + 5, starty + 315);
      g2.drawString(" more online.", startx, starty + 330);
   }
}