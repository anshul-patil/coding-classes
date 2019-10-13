/**
   A class for executing binary searches in an array.
*/
public class BinarySearcher
{  
   /**
      Finds a value in a range of a sorted array - this is a recursive method
      @param a the array in which to search
      @param low the low index of the range
      @param high the high index of the range
      @param value the value to find
      @return the index at which the value occurs, or -1
      if it does not occur in the array
   */
   public static int search(String[] a, int low, int high, String value)
   {  
      if (low <= high)
      {
         int mid = (low + high) / 2;

         if (a[mid].equalsIgnoreCase(value)) {
            return mid;
         }
         else if (a[mid].compareToIgnoreCase(value)< 0) {
            return search(a, mid + 1, high, value);
         }
         else {
            return search(a, low, mid - 1, value);
         }         
      }
      else {
         return -1;
      }
   }
}
