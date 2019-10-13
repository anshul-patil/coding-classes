import java.util.Scanner;
/**
 * Write a description of class E4_6 here.
 *
 * @author Anshul Patil
 * @version 1.0
 */
public class LengthConverter
{
    private double meters;
    
    
    public LengthConverter(double measurement)
    {
       meters = measurement;
    }
    
    public double getMeters()
    {
        return meters;
        
    }
    
    public double getMiles()
    {
        double miles = meters*0.000621371;
        return miles;
    }
    
    public double getFeet()
    {
        double feet = meters*3.28084;
        return feet;
    }
    
    public double getInches()
    {
        double inches = meters*39.3701;
        return inches;
    }
    
    
    public static void main(String[] args)
    {
        Scanner kboard = new Scanner(System.in);
        
        
        System.out.print("Type any number for the amount of meters: ");
        double meters = kboard.nextDouble();
        LengthConverter converter = new LengthConverter(meters);
        System.out.println(meters + " meters are equivalent to " + converter.getMiles() + " miles");
        System.out.println(meters + " meters are equivalent to " + converter.getFeet() + " feet");
        System.out.println(meters + " meters are equivalent to " + converter.getInches() + " inches");
    }
}
