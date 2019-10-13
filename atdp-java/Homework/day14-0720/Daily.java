import java.util.Scanner;
/**
 * Write a description of class Daily here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Daily extends Appointment
{
    public Daily(String input)
    {
        super(input);
    }
    
    public Daily(Scanner kboard)
    {
       super(kboard);
        
       System.out.println(this);
        
    }
    /**
     * Checks if it's the specified date
     *
     * @param year the year of the date
     * @param month the month of the date
     * @param day the day of the date
     * @return true
     */
    public boolean occursOn(int year, int month, int day)
    {
        // put your code here
        return true;
    }
    
    public String toString()
    {
        return super.toString() + "\n" + "Daily";
    }
}
