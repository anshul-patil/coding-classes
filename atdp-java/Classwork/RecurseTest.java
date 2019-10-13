
/**
 * Write a description of class RecurseTest here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class RecurseTest
{
    // instance variables - replace the example below with your own

    /**
     * Constructor for objects of class RecurseTest
     */
    public void method1(int x)
    {
        // initialise instance variables
        if (x == 0)
        {
            System.out.println("Returning with x = 0");
            return;
        }
        System.out.println(x);
        x--;
        method1(x);
        System.out.println("finished with " + x);
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public static void main(String[] y)
    {
        // put your code here
        RecurseTest r = new RecurseTest();
        r.method1(1);
    }
}
