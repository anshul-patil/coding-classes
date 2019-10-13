import java.util.Scanner;
/**
 * Write a description of class Empolyee here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Employee
{
   private double salary;
   private static final int OVERTIME_THRESHOLD = 40;

   /**
      Constructs an employee with a given salary
      @param anHourlySalary the hourly salary of this employee
   */
   public Employee(double anHourlySalary)
   {
      salary = anHourlySalary;
   }

   /**
      Computes the wage for a given week.
      @param hoursWorked the hours worked in the week
      @return the wage earned in that week, taking overtime into account
   */
   public double weeklyWage(int hoursWorked)
   {
       int regularHours = OVERTIME_THRESHOLD;
       int overtimeHours = hoursWorked - OVERTIME_THRESHOLD;
       
       if(overtimeHours < 0)
       {
           overtimeHours = 0;
           regularHours = hoursWorked;
       }
       double wage = salary*regularHours + 1.5*overtimeHours*salary;
       return wage;

   }
   public static double check(double hourlyWage, int hoursWorked)
   {
      Employee emily = new Employee(hourlyWage); // $10/hour
      return emily.weeklyWage(hoursWorked);
   }
   public static void main(String[] args)
   {
       Scanner kboard = new Scanner(System.in);
       System.out.println("What is your wage per hour(in dollars) ? :");
       double wage = kboard.nextDouble();
       System.out.println("Enter the hours worked : ");
       int hoursWorked = kboard.nextInt();
       
       
       System.out.println("The wage for $" + wage + " per hour is $" + check(wage, hoursWorked) + " in all");
   }
}

