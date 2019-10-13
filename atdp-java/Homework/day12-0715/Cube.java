
/**
 * Write a description of class Cube here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Cube
{
    // instance variables - replace the example below with your own
    private double height;

    /**
     * Constructor for objects of class Cube
     */
    public Cube(double h)
    {
        // initialise instance variables
        height = h;
    }

    public double getVolume()
    {
        return Math.pow(height,3);
    }
    
    public double getSurface()
    {
        return Math.pow(height,2)*6;
    }
}
