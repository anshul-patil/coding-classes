/*
 * R 1.13
 */
public class BankBalance
{
    public static void main(String[] args)
    {
        double rate = 0.005;
        double withdraw = 500;
        double months = 0;
        double balance = 10000;
        double newBalance;
        while (balance > 0)
        {
            newBalance = balance*(1+rate) - withdraw;
            balance = newBalance;
            months = months + 1;
        }
        System.out.println("All done in " + months);
    }
}