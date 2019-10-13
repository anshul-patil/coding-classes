import java.util.Random;

/**
   This class contains utility methods for array manipulation.
*/  
public class ArrayUtil { 
   private static Random generator = new Random();

   /**
      Creates an array filled with random values.
      @param length the length of the array
      @param n the number of possible random values
      @return an array filled with length numbers between
      0 and n - 1
   */
   public static String[] randomStringArray(int length) {  
      String[] a = new String[length];      
      a[0] = "Hello";
      a[1] = "car";
      a[2] = "Doll";
      a[3] = "Bad";
      a[4] = "Four";
      a[5] = "Twice";
      a[6] = "Seven";
      a[7] = "Apple";
      a[8] = "Nine";
      a[9] = "Yolo";
      
      return a;
   }

   /**
      Swaps two entries of an array.
      @param a the array
      @param i the first position to swap
      @param j the second position to swap
   */
   public static void swap(String[] a, int i, int j) {
      String temp = a[i];
      a[i] = a[j];
      a[j] = temp;
   }
}