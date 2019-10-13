import java.util.Scanner;
/**
 * Write a description of class Swapper here.
 *
 * @author Anshul Patil
 * @version 1.0
 */
public class Swapper
{
    public static void main(String[] args)
    {
        Scanner kboard = new Scanner(System.in);
        System.out.print("Type a full name[first then last]: ");
        String firstname = kboard.next();
        String lastname = kboard.next();
        System.out.printf("Name: %s, %s ", lastname, firstname);
    }
}
