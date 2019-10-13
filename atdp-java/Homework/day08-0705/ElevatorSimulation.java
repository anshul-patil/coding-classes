import java.util.Scanner;

/**
   This program simulates an elevator panel that skips the 13th floor, checking for 
   input errors.
*/
public class ElevatorSimulation
{
   public static void main(String[] args)
   {  
      Scanner kBoard = new Scanner(System.in);
      System.out.print("Which floor do you want to go to? (1-20, except 13): ");
      int reqFloor;
      if (kBoard.hasNextInt())
      {
         reqFloor = kBoard.nextInt(); 
         if (reqFloor >=1 && reqFloor <= 12) // i.e., user entered an integer 
         {
             System.out.println("You are now at floor number #" + reqFloor);
         }
         else if(reqFloor >=14 && reqFloor <= 20)
         {
             reqFloor = reqFloor - 1;
             System.out.println("You are now at floor number #" + reqFloor);
         }
         else
         {
             System.out.println(reqFloor + " isn't a valid floor");
         }
         
      }
      else
      {
          System.out.println("Please type in a number"); 
      }

   }
}
