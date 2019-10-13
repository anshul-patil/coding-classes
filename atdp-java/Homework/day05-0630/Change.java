import java.util.Scanner;
/**
 * Write a description of class integersTwo here.
 *
 * @author Anshul Patil
 * @version 1.0
 */
public class Change
{
    private int amountreceived; //How much they give you
    private int amountdue; //price
    public static final int DOLLAR_VALUE = 100;
    public static final int QUARTER_VALUE = 25;
    public static final int DIME_VALUE = 10;
    public static final int NICKEL_VALUE = 5;
    public static final int PENNY_VALUE = 1;
    
    

    public Change(int due, int received)
    {
        amountreceived = received;
        amountdue = due;
    }
    
  
    public void displayChange()
    {
        int change = amountreceived - amountdue;
        int numdollars = change/DOLLAR_VALUE;
        change = change - numdollars*DOLLAR_VALUE;
        int numquarters = change/QUARTER_VALUE;
        change = change - numquarters*QUARTER_VALUE;
        int numdimes = change/DIME_VALUE;
        change = change - numdimes*DIME_VALUE;
        int numnickels = change/NICKEL_VALUE;
        change = change - numnickels*NICKEL_VALUE;
        int numpennies = change;
        
        System.out.printf("amountdue = %d, amountreceived = %d\n", amountdue, amountreceived);
        System.out.printf("change = %d dollars, %d quarters, %d dimes, %d nickels, %d pennies\n", numdollars, numquarters, numdimes, numnickels, numpennies);
    }
    
   public static void main(String[] args)
   {
       Scanner kboard = new Scanner(System.in);
       System.out.print("Type the price(in cents) of the item: ");
       int due = kboard.nextInt();
       System.out.print("Type the amount(in cents) you are giving: ");
       int receive = kboard.nextInt();
       Change change = new Change(due, receive);
       change.displayChange();
    }
}
