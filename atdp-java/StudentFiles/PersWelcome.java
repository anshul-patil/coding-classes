/** Ask for the user's name from the console window, and show a personal welcome message
 * in the console window.
 * 
 */

import java.util.Scanner;

public class PersWelcome
{
  public static void main(String[] args)
  {
    Scanner kboard = new Scanner(System.in);
    System.out.print("What is your first name? ");
    String firstName = kboard.nextLine();
    System.out.print("What is your last name? ");
    String lastName = kboard.nextLine();
    System.out.println("Hello, " + firstName + " " + lastName);
    System.out.println("Welcome to ATDP!");
    kboard.close();
  }
}
