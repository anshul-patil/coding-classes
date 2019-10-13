
/**
 * Write a description of class CashRegisterTester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CashRegisterTester
{
   public static void main(String[] args)
   {
       CashRegister register = new CashRegister();
       
       register.recordPurchase(0.75);
       register.recordPurchase(1.50);
       register.receivePayment(2, 0, 5, 0, 0);
       System.out.print("Change: ");
       System.out.println(register.giveChange());
       System.out.println("Expected: 0.25");
       
       register.recordPurchase(2.25);
       register.recordPurchase(19.25);
       register.receivePayment(23, 2, 0, 0, 0);
       System.out.print("Change: ");
       System.out.println(register.giveChange());
       System.out.println("Expected: 2.0");
       System.out.println(register);
       System.out.println(register.toString());
       
   }
 
}
