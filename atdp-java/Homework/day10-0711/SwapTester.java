
/**
 * Write a description of class SwapTester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SwapTester
{
   /**
      Swaps two values
      @param array an array of length 2 containing the
      values to be swapped
   */
   public static void trueSwap(int[] array)
   {
      int temp = array[0];
      array[0] = array[1];
      array[1] = temp;
   }

   public static void main(String[] args)
   {
      int[] xy = new int[2];
      xy[0] = 3;
      xy[1] = 4;
      trueSwap(xy);
      System.out.println("Output : " + xy[0] + " " + xy[1]);
      System.out.println("Expected: 4 3");
   }
}
