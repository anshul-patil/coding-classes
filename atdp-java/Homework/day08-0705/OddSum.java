import java.util.Scanner;

/**
   Computes a sum of odd integers between two bounds. 
   Input: a, the lower bound (may be odd or even).
   Input: b, the upper bound (may be odd or even).
   Output: sum of odd integers between a and b (inclusive).
*/
public class OddSum
{
   public static void main(String[] args)
   {
      // Read values for a and b
      Scanner in = new Scanner(System.in);
      System.out.println("Type in 2 numbers: ");
      int a = in.nextInt();
      int b = in.nextInt();

      int num = a;
      int num1 = b;

      int sum = 0;

       while (num <= num1) {
           if (num % 2 != 0) {
               sum += num;
            }
           num ++;
        }

      System.out.println(sum);
   }
}
