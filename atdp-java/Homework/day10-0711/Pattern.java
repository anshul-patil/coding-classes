
/**
 * Write a description of class Patterns here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Pattern
{
   /**
      Computes the length of the longest sequence that occurs in the
      start of the left half and the end of the right half of an
      array.
      @param values an array of integer values
      @return the length of the longest end sequence
   */
   public int sameEnds(int[] values)
   {
      int length = values.length;
      int middle = length/2;
      int lsstop = middle;
      int rsstart = middle;
      if (length % 2 == 1)
      {
          rsstart++;
      }
      while (lsstop > 0)
      {
          int matched = 0;
          for (int i = 0; i < lsstop; i++)
          {
              if (values[i] == values[rsstart + i])
              {
                  matched++;
              }
          }
          if (matched == lsstop)
          {
                  return matched;
          }
          else
          {
                  lsstop--;
                  rsstart++;
          }
      }
      return 0;
   }
   public static void main(String[] args)
   {
       Pattern p = new Pattern();
       int[] input = { 1, 4, 9, 10, 11, 12, 1, 4, 9};
       int[] input1 = { 1, 4, 9, 16, 25};
       int[] input2 = { 1, 1, 1, 1};
       int save = p.sameEnds(input);
       int save1 = p.sameEnds(input1);
       int save2 = p.sameEnds(input2);
       System.out.println("Input: " + save);
       System.out.println("Input1: " + save1);
       System.out.println("Input2: " + save2);
   }
}
