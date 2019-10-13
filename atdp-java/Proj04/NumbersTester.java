import java.util.Scanner;
/**
 * Write a description of class NumbersTester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class NumbersTester extends Numbers
{
   public static void main(String[] args)
   {
       Scanner input = new Scanner(System.in);
       System.out.println("Please enter two numbers");
       int num = input.nextInt();
       int num1 = input.nextInt();
       Numbers NUMBERS = new Numbers();
       System.out.println(Numbers.evenSum(num, num1));
       
   }
}
