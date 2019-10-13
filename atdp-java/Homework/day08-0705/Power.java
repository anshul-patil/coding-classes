import java.util.Scanner;

/**
   Computes x^n (x raised to the nth power). Although the value
   of x can be positive or negative, the value of the integer n
   should be non-negative.

   Input: x, the double value to be raised to the nth power.
   Input: n, the integer value to which x is to be raised.
   Output: x^n -- the value of x raised to the nth power.
*/
public class Power
{
   public static void main(String[] args)
   {
      System.out.println("Enter two numbers, the first is the base and the second is the exponent: ");
       Scanner in = new Scanner(System.in);
      double x = in.nextDouble();
      int n = in.nextInt();
      int i;
      if (n < 0)
      {
          System.out.println("n has to be positive");
      }
      double power = 1.0;
      for (i = 0; i < n; i++)
      {
           power = power * x;
      }

      System.out.println(power);
   }
}
