
/**
 * Write a description of class Cube here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Sphere
{
    // instance variables - replace the example below with your own
    private double radius;
    private static final double PI = Math.PI;
    /**
     * Constructor for objects of class Cube
     */
    public Sphere(double r)
    {
        // initialise instance variables
        radius = r;
    }

    public double getVolume()
    {
        return 4/3*PI*Math.pow(radius, 3);
    }
    
    public double getSurface()
    {
        return 4*PI*Math.pow(radius, 2);
    }
}
