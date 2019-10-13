
/**
 * Write a description of class EmployeeTester here.
 *
 * @author Anshul
 * @version 1.0
 */
public class EmployeeTester
{
   public static void main(String[] args)
   {
       Employee harry = new Employee("Hacker, Harry", 50000);
       harry.raiseSalary(10);//Harry gets a 10% raise
       System.out.println("The final salary of " + harry.getName() + " is: " + harry.getSalary());
       System.out.println("... Expected: 55000");
    }
}
