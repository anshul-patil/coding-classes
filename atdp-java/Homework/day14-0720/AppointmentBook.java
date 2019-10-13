import java.util.Scanner;
import java.util.ArrayList;
/**
 * Write a description of class AppointmentBook here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class AppointmentBook
{
    // instance variables - replace the example below with your own
    public static void main(String[]args)
    {
        Scanner kboard = new Scanner(System.in);
        boolean keepGoing = true;
        ArrayList<Appointment> appointments = new ArrayList<Appointment>();
        
        while (keepGoing)
        {
            System.out.println("Appointments: (F)ind, (A)dd, or (Q)uit: ");
            String input = kboard.nextLine(); 
            
            if (input.equals("A") || input.equals("a"))
            {
                System.out.println("Enter type [(D)aily, (M)onthly, (O)netime]: ");
                input = kboard.nextLine();
                if (input.equals("D") || input.equals("d"))
                {
                    Daily d = new Daily(kboard);
                    appointments.add(d);
                }
                else if(input.equals("M") || input.equals("m"))
                {
                    Monthly m = new Monthly(kboard);
                    appointments.add(m);
                }
                else if (input.equals("O") || input.equals("o"))
                {
                    OneTime o = new OneTime(kboard);
                    appointments.add(o);
                }    
            }
            else if(input.equals("F") || input.equals("f"))
            {
                System.out.println("Enter a date (like 7 29 2016) to search: ");
                int month = kboard.nextInt();
                int day = kboard.nextInt();
                int year = kboard.nextInt();
                System.out.println("Your appointments on: " +  month + "/" + day + "/" + year);
                for (int i = 0; i < appointments.size(); i++)
                {
                    Appointment a = appointments.get(i);
                    if (a.occursOn(year, month, day))
                    {
                        System.out.println(appointments.get(i));
                    }
                }
            }
            else if(input.equals("P") || input.equals("p"))
            {
                for (int i = 0; i < appointments.size(); i++)
                {
                    System.out.println(appointments.get(i));
                }
            }
            else if (input.equals("Q") || input.equals("q"))
            {
                System.out.println("bye");
                keepGoing = false;
            }
        }
    }
}
