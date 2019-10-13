
/**
 * Write a description of class Numbers here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Numbers
{
   /**
      Computes the number of even an=d odd values in a given array
      @param values an array of integer values
      @return an array of length 2 whose 0 entry contains the count
      of even elements and whose 1 entry contains the count of odd
      values
   */
   public int[] evenOdds(int[] values)
   {
          int countere = 0;
          int countero = 0;
          for (int i = 0; i < values.length; i++)
          {
              int x = values [i];
              if ( x % 2 == 0)
              {
                  countere++;
                  
              }
              else
              {
                  countero++;
              }
          }
          int[] xy = new int [2];
          xy[0] = countere;
          xy[1] = countero;
          return xy;
        }
       public static void main(String[] args)
       {
           Numbers number = new Numbers();
           int[] input = {12, 15, 12, 13, 74, 82};
           int[] save = number.evenOdds(input);
           System.out.println("Number of evens : " +  save[0] + "\nNumbers of odds: " + save[1]);
       }
  }

