/**
 * A class to keep track of an employee's asset
*/
public class AssetRecorder
{
   public static void main(String[] args)
   {
       double salary = 5000;
       Employee muLan = new Employee("Pha Mu Lan", salary);
       System.out.println("After new: salary = " + muLan.getSalary());
       System.out.println("... expected: 5000"); 
       
       BankAccount muLanChking = new BankAccount(muLan.getSalary() / 2); // save half of salary
       System.out.println("After new: balance = " + muLanChking.getBalance());
       System.out.println("... expected: 2500"); 
       
       muLanChking.withdraw(200); // to go shopping
       System.out.println("After withdraw: balance = " + muLanChking.getBalance());
       System.out.println("... expected: 2300"); 
       
       muLan.raiseSalary(10); // got a raise
       System.out.println("After raiseSalary: salary = " + muLan.getSalary());
       System.out.println("... expected: 5500"); 
      
       muLanChking.deposit(muLan.getSalary() / 2); // save half of new salary
       System.out.println("After deposit: balance = " + muLanChking.getBalance());
       System.out.println("... expected: 5050");
      
       muLanChking.withdraw(muLanChking.getBalance() / 5); // to buy a device
       System.out.println("After withdraw: balance = " + muLanChking.getBalance());
       System.out.println("... expected: 4040"); 

   }
}
