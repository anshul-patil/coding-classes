
/**
 * Write a description of class BankAccount here.
 *
 * @author (Anshul Patil)
 * @version (1.0)
 */
public class BankAccount
{
    //Fields
    private double balance;
   
    //Constructors
    
    public BankAccount()
    {
        balance = 0;        
    }
    public BankAccount(double initialBalance)
    {
        balance = initialBalance;
    }
    public void deposit(double amount)
    {
        balance = balance + amount;
    }
    public void withdraw(double amount)
    {
        balance = balance - amount;
    }
    public double getBalance() {
        return balance;
    }
    public void addInterest(double rate)
    {
        double percent = rate*0.01 + 1;
        balance = balance * percent;
    }

    //Methods
}