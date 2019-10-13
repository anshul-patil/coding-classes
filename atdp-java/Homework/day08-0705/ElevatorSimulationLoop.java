import java.util.Scanner;

/**
   This program simulates an elevator panel that skips the 13th floor, checking for 
   input errors.
*/
public class ElevatorSimulationLoop
{
   public static void main(String[] args)
   {  
    Scanner kBoard = new Scanner(System.in);
      System.out.print("Which floor do you want to go to? (1-20, except 13 or q): ");
      int reqFloor;
      while (kBoard.hasNextInt())
      {
         reqFloor = kBoard.nextInt(); 
         if (reqFloor >=1 && reqFloor <= 12) // i.e., user entered an integer 
         {
             System.out.println("The elevator will travel to the actual floor # " + reqFloor);
         }
         else if(reqFloor >=14 && reqFloor <= 20)
         {
             reqFloor = reqFloor - 1;
             System.out.println("The elevator will travel to the actual floor # " + reqFloor);
         }
         else
         {
             System.out.println("NOTE: The floor must be between 1 and 20.");
         }
         System.out.print("Which floor do you want to go to? (1-20, except 13 or q): ");
      }
      String answer = kBoard.next();
      if(answer.compareTo("q") == 0)
      {
          System.out.println("Bye");
      }
      else
      {
          System.out.println("Goodbye");
      }
   }
}
