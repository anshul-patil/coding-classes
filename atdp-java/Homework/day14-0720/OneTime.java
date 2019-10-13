import java.util.Scanner;
/**
 * Write a description of class OneTime here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class OneTime extends Appointment
{
    // instance variables - replace the example below with your own
    private int year;
    private int month;
    private int day;

    /**
     * Constructor for objects of class OneTime
     */
    public OneTime()
    {
        // initialise instance variables
        year = 0;
        month = 0;
        day = 0;
    }

    public OneTime(String input, int day ,int month, int year)
    {
        super(input);
        this.year = year;
        this.month = month;
        this.day = day;
    }
    
    public OneTime(Scanner kboard)
    {
       super(kboard);
       System.out.println("Enter a day: ");
       day = kboard.nextInt();
       System.out.println("Enter a month: ");
       month = kboard.nextInt();
       System.out.println("Enter a year: ");
       year = kboard.nextInt();
       
       System.out.println(this);
    }
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public boolean occursOn(int year, int month, int day)
    {
        // put your code here
        if( this.day == day && this.month == month && this.year == year)
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
        return super.toString() + "\n" + "Only once on "+ year + "/" + month + "/" + day;
    }
}
