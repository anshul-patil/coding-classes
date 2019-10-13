
/**
 * Write a description of class Cube here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Cylinder
{
    // instance variables - replace the example below with your own
    private double radius;
    private double height;
    private static final double PI = Math.PI;
    /**
     * Constructor for objects of class Cube
     */
    public Cylinder(double r, double h)
    {
        // initialise instance variables
        radius = r;
        height = h;
    }

    public double getVolume()
    {
        return PI*Math.pow(radius, 2) * height;
    }
    
    public double getSurface()
    {
        return 2*PI*radius*height+ 2*PI*Math.pow(radius, 2);
    }
}
