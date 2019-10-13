import java.util.Scanner;

/**
   This program simulates an elevator panel that skips the 13th floor, checking for 
   input errors.
*/
public class TestScores
{
   public static void main(String[] args)
   {  
       Scanner kBoard = new Scanner(System.in);
       int count = 0;
       System.out.print("Enter a test score: ");
       int minVal = 0;
       int maxVal = 0;

      while (kBoard.hasNextInt())
      {
         int curVal = kBoard.nextInt();
         if (count == 0) // i.e., user entered an integer 
         {
             minVal = curVal;
         }
         else if(curVal < minVal)
         {
             minVal = curVal;
         }
         
         if (count == 0) // i.e., user entered an integer 
         {
             maxVal = curVal;
         }
         else if(curVal > maxVal)
         {
             maxVal = curVal;
         }
         count = count + 1;
         System.out.print("Enter a test score: ");
      
      }
      System.out.println("The minimum value is " + minVal);
      System.out.println("The maximum value is " + maxVal);
   }
}

