import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.Rectangle;
import java.awt.geom.Line2D;
import java.awt.Polygon;
import java.awt.Color;
import java.awt.BasicStroke;
import javax.swing.JComponent;
import java.awt.geom.Ellipse2D.Double;
/**
 * Write a description of class Circle here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Circle extends Ellipse2D.Double
{
    /**
     * Constructor for objects of class Circle
     */
    public Circle(double cx, double cy, double radius)
    {
        // initialise instance variables
        super(cx, cy, 2 * radius, 2 * radius); 
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public double getRadius()
    {
        // put your code here
        return width / 2;
    }
    
    public void draw(Graphics2D g2)
    {
       g2.draw(this);
    }
    
    public void translate (double dx, double dy)
    {
        x = x+dx;
        y = y+dy;
    }
}
