
/**
 * Employee class that stores the employee name and the current salary
 *
 * @author Anshul Patil
 * @version 1.0
 */
public class Employee
{
   // instance variables - name and the salary
   private String name; 
   private double salary;
   /**
     * Constructor for objects of class Employee
     * @param employeeName name of the employee
     * @param currentSalary salary of the employee
     */
    public Employee(String employeeName, double currentSalary)
   {
       name = employeeName;
       salary = currentSalary;
   }
   
   /**
     * Get the name of the Employee
     * 
     * @return name of the Employee
     */
   public String getName()
   {
       return name;
   }
   
   /**
     * Get the current salary of the Employee
     *
     * @return the current salary of the Employee
     */
   public double getSalary()
   {
       return salary;
   }
   
    /**
     * Raises the current salary of the Employee
     *
     * @param byPercent the percentage of the raise 
     */
   public void raiseSalary(double byPercent)
   {
       double raise = (byPercent/100) * salary;
       salary = salary + raise;
   }
}
