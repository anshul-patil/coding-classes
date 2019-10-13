import java.util.Scanner;
/**
 * Write a description of class Exercises54 here.
 *
 * @author Anshul Patil
 * @version 1.0
 */


public class Exercise54
{
    public static void main(String[] args)
   {  
     Scanner kBoard = new Scanner(System.in);
      System.out.println("Enter three numbers : ");
      double firstNum =  kBoard.nextDouble(); 
      double secondNum= kBoard.nextDouble(); 
      double thirdNum= kBoard.nextDouble(); 
     
   if (firstNum == secondNum && secondNum == thirdNum) {
       System.out.println("All the same"); 
    }
   else if (firstNum != secondNum && firstNum != thirdNum && secondNum != thirdNum) {
       System.out.println("All different"); 
    }
    else {
        System.out.println("neither"); 
    }
       
     
      
     
}

}
