
/**
 * Write a description of class BankAccountTester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BankAccountTester
{
    public static void main(String[] args)
  {BankAccount dadssavings = new BankAccount(1000);
  dadssavings.withdraw(500);
  dadssavings.withdraw(400);
  System.out.println("The final balance is "+dadssavings.getBalance());
  dadssavings.addInterest(10);
  System.out.println("Expected: 110");
  System.out.println("Actual: " + dadssavings.getBalance());
}  
}
