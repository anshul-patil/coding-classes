/**
   This program computes how long it takes for an investment
   to double.
*/
public class InvestmentRunner
{
   public static void main(String[] args)
   {
      final double INITIAL_BALANCE = 100000;
      final double RATE = 0.09;
      int multiple = (int) (Math.random() * 20 + 1);
      Investment invest = new Investment(INITIAL_BALANCE, RATE);
      double target = multiple * INITIAL_BALANCE;
      invest.waitForBalance(target);
      int years = invest.getYears();
      System.out.println("INITIAL_BALANCE, target = "
                            + INITIAL_BALANCE + ", " + target);
      System.out.println("After " + years + " years, at interest rate " + RATE
                        + ", the investment will be " 
                        +  multiple + " times the initial amount.");
   }   
}
