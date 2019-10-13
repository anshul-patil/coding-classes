import java.util.Scanner;
/**
 * Write a description of class AreaVolume here.
 *
 * @author Anshul Patil
 * @version 1.0
 */
public class Balloon
{
    private double radius;
    
    public Balloon()
    {
       radius = 0;
    }
    
    public double getRadius()
    {
        return radius;       
    }
    
    public void addAir(double amount)
    {
        // There might already be air inthe balloon. I am getting the volume of the exsisting air.
        double existingair = getVolume();
        double newvol = existingair + amount;
        // radius =  cuberoot(newvol/(Math.PI) * 3/4) 
        double radiusCube = (newvol/Math.PI)*3.0/4.0;
        radius = Math.pow(radiusCube, 1.0/3.0);
    }
    
    public double getVolume()
    {
        double volume = 4 * Math.PI * Math.pow(radius, 3)/3;
        return volume;
    }
    
    public double getSurfaceArea()
    {
        double sa = 4*(Math.PI)*(Math.pow(radius, 2));
        return sa;
    }
    
}
