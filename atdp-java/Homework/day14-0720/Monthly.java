import java.util.Scanner;
/**
 * Write a description of class Monthly here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Monthly extends Appointment
{
    // instance variables - replace the example below with your own
    int date;
    /**
     * Constructor for objects of class Monthly
     */
    public Monthly()
    {
        // initialise instance variables
        date = 0;
    }
    
    public Monthly(String input, int day)
    {
        super(input);
        date = day;
    }

    public Monthly(Scanner kboard)
    {
       super(kboard); 
       System.out.println("Enter a day: ");
       date = kboard.nextInt();
       
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
        if(date == day)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public String toString()
    {
        return super.toString() + "\n" + "Monthly on the " + date;
    }
}
