/**
   This class tests the CashRegister3 class.
*/
public class CashRegisterTester3
{
   public static void main(String[] args)
   {
       final double DOLLAR_VALUE = 1.0;
       final double QUARTER_VALUE = 0.25;
       final double DIME_VALUE = 0.1;
       final double NICKEL_VALUE = 0.05;
       final double PENNY_VALUE = 0.01;

      // FIRST PURCHASE
      // Create CashRegister3 object, and 
      // record price for each purchased item
      
      System.out.println("\nFIRST PURCHASE");
      
      CashRegisterATDP register = new CashRegisterATDP();

      register.recordPurchase(24.37);
      register.recordPurchase(15.91);
      register.recordPurchase(3.48);
      
      // Create Coin objects, and
      // Record price for each type of coin
      
      CoinATDP dollar = new CoinATDP(DOLLAR_VALUE, "Dollar");
      register.receivePayment(50, dollar);
      CoinATDP quarter = new CoinATDP(QUARTER_VALUE, "Quarter");
      register.receivePayment(3, quarter);
      CoinATDP dime = new CoinATDP(DIME_VALUE, "Dime");
      register.receivePayment(6, dime);
      CoinATDP nickel = new CoinATDP(NICKEL_VALUE, "Nickel");
      register.receivePayment(4, nickel);
      CoinATDP penny = new CoinATDP(PENNY_VALUE, "Penny");
      register.receivePayment(5, penny);
      
      // Get receipt info
      double[] vals1 = register.getReceiptVals();
      System.out.printf("\tReceipt: \n\t  a) Number of items: %3d\n\t  b) Total  \t$%7.2f\n\t  c) Payment\t$%7.2f\n\t  d) Change\t$%7.2f\n",
            (int)vals1[0], vals1[1], vals1[2], vals1[3]);

      System.out.print("\tChange: ");
      int[] counts1 = register.giveChange();
      System.out.printf("\n\t  e) %3d dollars", counts1[0]);
      System.out.printf("\n\t  f) %3d quarters", counts1[1]);
      System.out.printf("\n\t  g) %3d dimes", counts1[2]);
      System.out.printf("\n\t  h) %3d nickels", counts1[3]);
      System.out.printf("\n\t  i) %3d pennies\n", counts1[4]);

      // SECOND PURCHASE
      // NOTE: Do NOT creat CashRegister3 object again
      // Record price for each purchased item
      
      System.out.println("\nSECOND PURCHASE");
      
      register.recordPurchase(14.52);
      register.recordPurchase(2.37);
      
      register.receivePayment(20, dollar);
      register.receivePayment(2, quarter);
      register.receivePayment(6, dime);
      register.receivePayment(2, nickel);
      register.receivePayment(7, penny);
      
      // Get receipt info
      double[] vals2 = register.getReceiptVals();
      System.out.printf("\tReceipt: \n\t  a) Number of items: %3d\n\t  b) Total  \t$%7.2f\n\t  c) Payment\t$%7.2f\n\t  d) Change\t$%7.2f\n",
            (int)vals2[0], vals2[1], vals2[2], vals2[3]);
                
      System.out.print("\tChange: ");
      int[] counts2 = register.giveChange();
      System.out.printf("\n\t  e) %3d dollars", counts2[0]);
      System.out.printf("\n\t  f) %3d quarters", counts2[1]);
      System.out.printf("\n\t  g) %3d dimes", counts2[2]);
      System.out.printf("\n\t  h) %3d nickels", counts2[3]);
      System.out.printf("\n\t  i) %3d pennies\n", counts2[4]);
   }
}
