
/**
 * Write a description of class Numbers here.
 *
 * @author Anshul Patil
 * @version 1.0
 */
public class Numbers
{
   /**
      Counts the number of digits with value 7 in a given number
      @param n any non-negative number
      @return the number of digits with value 7 in the decimal representation of n
   */
   public int countSevens(int n)
   {
      int remain = 0;
      int answer = 0;
      int count = 0;
      while (n > 0)
      {
          remain = n % 10;
          if(remain == 7)
          {
              count = count + 1;
          }
          answer = n / 10;
          n = answer;
      }
      return count;
   }
   public static void main(String[] args)
   {
       Numbers num = new Numbers();
       System.out.println(num.countSevens(6));
   }
}
