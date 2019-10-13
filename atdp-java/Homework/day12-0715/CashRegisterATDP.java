/**
* A cash register totals up sales and computes change due.
* @author A. Nguyen 
* @version 1.0
*/
public class CashRegisterATDP
{
   private double purchase;
   private double payment;
   private int count;
   private CoinATDP[] coinArr = new CoinATDP[5];
   
   static final double DOLLAR_VALUE = 1.0;
   static final double QUARTER_VALUE = 0.25;
   static final double DIME_VALUE = 0.1;
   static final double NICKEL_VALUE = 0.05;
   static final double PENNY_VALUE = 0.01;
   /**
      Constructs a cash register with no money in it.
   */
   public CashRegisterATDP()
   {
      purchase = 0;
      payment = 0;
      count = 0;
      coinArr[0] = new CoinATDP(DOLLAR_VALUE, "Dollar");
      coinArr[1] = new CoinATDP(QUARTER_VALUE, "Quarter");
      coinArr[2] = new CoinATDP(DIME_VALUE, "Dime");
      coinArr[3] = new CoinATDP(NICKEL_VALUE, "Nickel");
      coinArr[4] = new CoinATDP(PENNY_VALUE, "Penny");
      
   }

   /**
      Records the purchase price of an item.
      @param amount the price of the purchased item
   */
   public void recordPurchase(double amount)
   {
      purchase += amount;
      count++;
   }
   

   /**
      Record (part of) the payment, per coin type, and accumlate into total payment
      @param count number of coins received
      @param coinType the coin received
   */
   public void receivePayment(int count, CoinATDP coinType) 
    {
          double paid = count *  coinType.getValue();
          payment+=paid;
    }
   
   /**
      Computes the change due and resets the machine for the next customer.
      @return the change due to the customer
   */
   public int[]giveChange()
   {
      int[] change = new int[5];
      double moneygivenback = (payment - purchase);
      for (int i = 0; i < 5; i++)
      {
          change[i] = (int) (moneygivenback / coinArr[i].getValue());
          moneygivenback = moneygivenback - change[i]*coinArr[i].getValue();
      }
      payment = 0;
      purchase = 0;
      count = 0;
      return change;
   }
   
   public double[]getReceiptVals()
   {
       double[] receiptVals = new double[4];
       receiptVals[0] = count;
       receiptVals[1] = purchase;
       receiptVals[2] = payment;
       receiptVals[3] = payment - purchase;
       return receiptVals;
   }
}
