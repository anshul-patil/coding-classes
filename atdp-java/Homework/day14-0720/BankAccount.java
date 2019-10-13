
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
    /**
     * Constructor for objects of class BankAccount starts with 0 balance
     */
    public BankAccount()
    {
        balance = 0;        
    }
    
    /**
     * Constructor for objects of class BankAccount
     * @param initialBalance balance to start the account with
     */
    public BankAccount(double initialBalance)
    {
        balance = initialBalance;
    }
    
    /**
     * Deposits money into bank account
     * 
     * @param amount the amount to deposit
     */
    public void deposit(double amount)
    {
        balance = balance + amount;
    }
    
    /**
     * Withdraws money out ot the bank account
     * 
     * @param amount the amount to withdraw
     */
    public void withdraw(double amount)
    {
        balance = balance - amount;
    }
    
    /**
     * Gets the current balance of the bank account
     * 
     * @return the current balance
     */
    public double getBalance() {
        return balance;
    }
    
    /**
     * Gives a certain percentage of raise to the employee
     * 
     * @param rate the rate at which the current balance increases
     */
    public void addInterest(double rate)
    {
        double percent = rate*0.01 + 1;
        balance = balance * percent;
    }

    //Methods
}