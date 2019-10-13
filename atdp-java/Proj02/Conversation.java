/**
 * Have a brief conversation with the user.
 * 
 * @author Anh Nguyen 
 * @version Summer 2016
 */

import java.util.Scanner;

public class Conversation
{
  public static void main(String[] args)
  {
    Scanner kboard = new Scanner(System.in); // Create keyboard object to get input from user
    
    System.out.print("What is your name? "); // Ask user
    String name = kboard.nextLine();         // Accept answer from user
    
    System.out.println("Hello, " + name);
    System.out.println("Welcome to Java!");
    
    System.out.print("\nHow old are you? "); // Ask user
    int age = kboard.nextInt();              // Accept answer from user

    int numOfYrs = 10;
    int futureAge = numOfYrs + age;
    System.out.println("In " + numOfYrs + " years, you will be " + futureAge);    
        
    System.out.print("\nHow far away is your house (in miles)? "); // Ask user
    double dist = kboard.nextDouble();              // Accept answer from user
    System.out.println("Just confirming that your house is " + dist + " miles from school");    
    
    String bye = "\nThat's all. Thank you!"; // This is how a String variable is assigned
    System.out.println(bye);
    
    kboard.close(); // Done using the keyboard
  }
}
