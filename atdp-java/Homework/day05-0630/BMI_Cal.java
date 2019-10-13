import java.util.Scanner;
/**
 * Write a description of class BMI_Cal here.
 *
 * @author Anshul Patil
 * @version 1.0
 */
public class BMI_Cal
{
    private String name;
    private int age;
    private double weight;
    private double height;
    BMI_Cal(int numOfYears, double side, double up, String yourname) 
    {
        numOfYears = age;
        weight = side;
        height = up;
        name = yourname;
    }
    
    public double getBMI()
    {
        double wt = weight*.453592;
        double ht = height*.0254;
        double bmi = wt/(ht*ht);
        return bmi;
    }
    public static void main(String[] args)
    {
       Scanner kboard = new Scanner(System.in);
       System.out.print("Type your name: ");
       String yourname = kboard.nextLine();
       System.out.print("Type your age: ");
       int numOfYears = kboard.nextInt();
       System.out.print("Type your weight: ");
       double side = kboard.nextInt();
       System.out.print("Type your height: ");
       double up = kboard.nextInt();
       BMI_Cal calculation = new BMI_Cal(numOfYears, side, up, yourname);
       System.out.printf("Name: %s, Age: %d years, Weight: %3.2f lbs, Height: %3.2f\n", yourname, numOfYears, side, up);
       System.out.printf("BMI : %6.2f\n" ,calculation.getBMI());
    }
}
