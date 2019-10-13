import java.util.Scanner;
/**
 * Write a description of class Tester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class AppointmentTester
{
    public static void main(String[]args)
    {
        // instance variables - replace the example below with your own
        Daily a = new Daily("brush teeth");
        Monthly m = new Monthly("jog a mile", 10);
        OneTime o = new OneTime("Birthday Party", 5, 7, 2017);
 
        System.out.println(a);
        System.out.println(m);
        System.out.println(o);
        
        boolean dailyOccurs = a.occursOn(2016, 5, 5);
        boolean monthlyOccurs = m.occursOn(2016, 5, 10);
        boolean monthlyNotOccurs = m.occursOn(2016, 5, 9);
        boolean oneTimeOccurs = o.occursOn(2017, 7, 5);
        boolean oneTimeNotOccurs = o.occursOn(2016, 5, 9);
        
        
        System.out.println("Daily Occurs = " + dailyOccurs);
        System.out.println("Monthly Occurs = " + monthlyOccurs);
        System.out.println("Monthly Doesn't Occurs = " + monthlyNotOccurs);
        System.out.println("One Time Occurs = " + oneTimeOccurs);
        System.out.println("One Time Doesn't Occurs = " + oneTimeNotOccurs);
        
        
    }
}
