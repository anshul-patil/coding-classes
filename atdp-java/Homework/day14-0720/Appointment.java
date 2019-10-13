import java.util.Scanner;
/**
 * Write a description of class Appointment here.
 *
 * @author Anshul Patil
 * @version 1.0
 */
public abstract class Appointment
{
    // instance variables - replace the example below with your own
    String description;

    /**
     * Constructor for objects of class Appointment
     */
    public Appointment()
    {
        // initialise instance variables
        description = "";
    }

    public Appointment(String input)
    {
        description = input;
    }
    
    public Appointment(Scanner kboard)
    {
        System.out.println("Enter Description: ");
        description = kboard.nextLine();
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void setDescription(String input)
    {
        // put your code here
        description = input;
    }
    
    public abstract boolean occursOn(int year, int month, int day);
    
    public String toString()
    {
       return "Description: " + description;
    }
}
