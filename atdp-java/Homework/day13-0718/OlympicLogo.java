import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.BasicStroke;
/**
 * Write a description of class OlympicLogo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class OlympicLogo extends Circle
{
    // instance variables - replace the example below with your ow
    private int ringThickness;
    /**
     * Constructor for objects of class OlympicLogo
     */
    public OlympicLogo(double cx, double cy, double radius)
    {
        // initialise instance variables
        super(cx, cy, radius);
        ringThickness = (int) radius/5;
    }

    public void draw(Graphics2D g2)
    {
       double middleX = x;
       double middleY = y;
       double radius = getRadius();
       double spacing = radius/5;
       
       g2.setStroke(new BasicStroke(ringThickness));
       
       g2.setColor(Color.black);
       super.draw(g2); //black circle
       
       translate( - radius * 2 - spacing , 0);
       g2.setColor(Color.blue);
       super.draw(g2); //blue circle
       
       translate(radius * 4 + spacing * 2, 0);
       g2.setColor(Color.red);
       super.draw(g2); //red circle
       
       translate(- radius -(spacing/2), radius);
       g2.setColor(Color.green);
       super.draw(g2); //green circle
       
       translate(-radius * 2 - spacing, 0);
       g2.setColor(Color.yellow);
       super.draw(g2); //yellow circle
    }
    
}
