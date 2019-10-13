  
/**
 * Write a description of class Numbers here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Numbers
{
   /**
      Computes a sum of even integers 
      @param a the lower bound (may be odd or even)
      @param b the upper bound (may be odd or even)
      @return the sum of even integers between a and b (inclusive).
   */
   public static int evenSum(int a, int b)
   {
       int num = a;
       int num1 = b;

       int sum = 0;

       while (num <= num1) {
           if (num % 2 == 0) {
               sum += num;
            }
           num ++;
        }
       return sum;
        }    
   }
