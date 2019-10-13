import java.util.Scanner;
/**
 * Write a description of class integersTwoTester here.
 *
 * @author Anshul Patil
 * @version 1.0
 */
public class integersTwoTester
{
   public static void main (String[] args)
   {
       Scanner kboard = new Scanner(System.in);
       
       integersTwo numbers = new integersTwo(5, 12);
       System.out.println("Sum:        " + numbers.getSum());
       System.out.println("Difference: " + numbers.getDifference());
       System.out.println("Product:    " + numbers.getProduct());
       System.out.println("Average:    " + numbers.getAverage());
       System.out.println("Distance:   " + numbers.getDistance());
       System.out.println("Maximum:    " + numbers.getMaximum());
       System.out.println("Minimum:    " + numbers.getMinimum());
       
       System.out.print("Type the first number: ");
       int first = kboard.nextInt();
       System.out.print("Type the second number: ");
       int second = kboard.nextInt();
       integersTwo usernumbers = new integersTwo(first, second);
       System.out.println("Sum:        " + usernumbers.getSum());
       System.out.println("Difference: " + usernumbers.getDifference());
       System.out.println("Product:    " + usernumbers.getProduct());
       System.out.println("Average:    " + usernumbers.getAverage());
       System.out.println("Distance:   " + usernumbers.getDistance());
       System.out.println("Maximum:    " + usernumbers.getMaximum());
       System.out.println("Minimum:    " + usernumbers.getMinimum());
       
    }
}
