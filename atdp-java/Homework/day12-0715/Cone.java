
/**
 * Write a description of class Cube here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Cone
{
    // instance variables - replace the example below with your own
    private double radius;
    private double height;
    private static final double PI = Math.PI;
    /**
     * Constructor for objects of class Cube
     */
    public Cone(double r, double h)
    {
        // initialise instance variables
        radius = r;
        height = h;
    }

    public double getVolume()
    {
        return PI*Math.pow(radius, 2) *(height/3);
    }
    
    public double getSurface()
    {
        return PI*radius*(radius+Math.sqrt(Math.pow(height, 2) + Math.pow(radius, 2)));
    }
}
