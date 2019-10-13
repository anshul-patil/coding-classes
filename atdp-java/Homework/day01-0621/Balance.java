public class Balance
{
    public static void main(String [] args)
 	{
 	    double balance = 1000;
 	    double interest = 0.05;
 	    double balanceYear1 = balance + balance*interest;
 	    double balanceYear2 = balanceYear1 + balanceYear1*interest;
 	    double balanceYear3 = balanceYear2 + balanceYear2*interest;
 	    System.out.println("Year 1:"+ balanceYear1);
 	    System.out.println("Year 2:"+ balanceYear2);
 	    System.out.println("Year 3:"+ balanceYear3);
 	}
}
