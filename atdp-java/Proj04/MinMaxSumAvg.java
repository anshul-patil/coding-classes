
import java.util.Scanner;
/**
 * Write a description of class AlgorithmMinValue here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MinMaxSumAvg
{
   public static void main(String [] args)
   {
       //Please run as debugger. This program will make computer lag. WIll work in debugger.
       Scanner kboard = new Scanner(System.in);
       int i = 0;
       int sum = 0;
       double average = 0.0;
       
       int minVal = 0;
       int maxVal = 0;
       System.out.println("Type in a number: ");
       while(kboard.hasNextInt())
       {
       
           int curVal = kboard.nextInt();
           
           
           
           if (i==0)
           {
               minVal = curVal;
               maxVal = curVal;
               
            }
            
            if (curVal > minVal)
            {
                minVal = minVal;
                
            }
           else if (minVal >= curVal)
           {
               minVal = curVal;
               
            }
            
            if (maxVal >= curVal)
           {
               maxVal = maxVal;
               
            }
            else if (maxVal < curVal)
           {
               maxVal = curVal;
               
            }
            sum += curVal;
           i++;
            System.out.println("Type in a number: ");
          
        }
 System.out.println("The minimum integer is " + minVal);
 System.out.println("The maximum integer is " + maxVal);
 System.out.println("The sum is " + sum);
 average = (double)sum/(double)(i);
 System.out.println("The average is " + average);
 
   String quit = kboard.next();
 
   if (quit.equals("Q")) 
   {
              System.out.println("Bye");
              
             
          }
    }
    
   
    }

