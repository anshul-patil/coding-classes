/**
   This class tests the CashRegisterATDP class.
*/
public class CashRegisterATDPTester
{
   public static void main(String[] args)
   {
       final double DOLLAR_VALUE = 1.0;
       final double QUARTER_VALUE = 0.25;
       final double DIME_VALUE = 0.1;
       final double NICKEL_VALUE = 0.05;
       final double PENNY_VALUE = 0.01;
       
      // FIRST PURCHASE
      // Create CashRegisterATDP object, and 
      // record price for each purchased item
      
      System.out.println("\nFIRST PURCHASE");
      
      CashRegisterATDP register = new CashRegisterATDP(); 
      register.recordPurchase(0.75);
      register.recordPurchase(1.50);
      
      // Create Coin objects, and
      // Record price for each type of coin
      
      CoinATDP dollar = new CoinATDP(DOLLAR_VALUE, "Dollar");
      register.receivePayment(2, dollar);
      CoinATDP quarter = new CoinATDP(QUARTER_VALUE, "Quarter");
      register.receivePayment(2, quarter);
      CoinATDP dime = new CoinATDP(DIME_VALUE, "Quarter");
      CoinATDP nickel = new CoinATDP(NICKEL_VALUE, "Nickel");
      CoinATDP penny = new CoinATDP(PENNY_VALUE, "Penny");
      
      
      
      
      // Calculate & display change amount, in pennies
      System.out.print("\tChange: ");
      System.out.println(register.giveChange());
      System.out.println("\tExpected change amount: 0.25");

      
      // SECOND PURCHASE
      // NOTE: Do NOT creat CashRegisterATDP object again
      // Record price for each purchased item
      
      System.out.println("\nSECOND PURCHASE");
            
      register.recordPurchase(2.25);
      register.recordPurchase(19.25);
      
      // NOTE: Do NOT creat Coin objects again
      // Record price for each type of coin
      register.receivePayment(23, dollar);
      
      
      
      
      // Calculate & display change amount, in pennies
      System.out.print("\tChange: ");
      System.out.printf("%.2f", register.giveChange());
      System.out.println("\n\tExpected change amount: 1.50");
   }
}
