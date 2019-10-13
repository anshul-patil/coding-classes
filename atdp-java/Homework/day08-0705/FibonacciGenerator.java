
/**
 * Write a description of class Fibonacci here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FibonacciGenerator
{
   int n1;
   int n2; 
   int n;

   /**
      Construct a FibonacciGenerator object to generate a Fibonacci number.
   */
   public FibonacciGenerator()
   {
       n1 = 1;
       n2 = 1;
       n = 0;
   }

   /**
      Method used to calculate a fibonacci number.
      @return fNew the fibonacci number
   */
   public int nextNumber()
   {
      n++;
      if (n == 1)
      {
          return n1;
      }
      else if (n == 2)
      {
          return n2;
      }
      else
      {
          int n3 = n1 + n2;
          n1 = n2;
          n2 = n3;
          return n3;
      }
   }
}


