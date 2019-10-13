import java.util.Scanner;
/**
 * Write a description of class AreaVolume here.
 *
 * @author Anshul Patil
 * @version 1.0
 */
public class AreaVolume
{
    private double radius;
    private static final double PI = 3.141592653589798462643383;
    
    public AreaVolume(double measurement)
    {
       radius = measurement;
    }
    
    public double getRadius()
    {
        return radius;
        
    }
    
    public double getCircumference()
    {
        double circumference = (2*(PI))*(radius);
        return circumference;
    }
    
    public double getArea()
    {
        double area = (PI)*((radius)*(radius));
        return area;
    }
    
    public double getVolume()
    {
        double volume = 4/3*(PI)*((radius)*(radius)*(radius));
        return volume;
    }
    
    public double getSurfaceArea()
    {
        double sa = 4*(PI)*((radius)*(radius));
        return sa;
    }
    
    
    public static void main(String[] args)
    {
        Scanner kboard = new Scanner(System.in);
        
        
        System.out.print("Type any number for the radius: ");
        double radius = kboard.nextDouble();
        AreaVolume converter = new AreaVolume(radius);
        System.out.printf("For radius = %4.2f area = %4.2f\n", radius, converter.getArea());
        System.out.printf("For radius = %4.2f circumference = %4.2f\n", radius, converter.getCircumference());
        System.out.printf("For radius = %4.2f volume = %4.2f\n", radius, converter.getVolume());
        System.out.printf("For radius = %4.2f surface area = %4.2f\n", radius, converter.getSurfaceArea());        
    }
    
}
