import java.util.Scanner;
 import javax.swing.JOptionPane;
 	
 public class RestaurantBill
 {
 	public static void main(String [] args)
 	{
 		double charge;
 		double tax = 0.0675;
 		double tipRate = 0.15;
 		double people = 4;
 		double totalWithTax;
 		double taxAmount;
 		double tipAmount;
 		double totalAmount;
 		double payperperson;
 		
 		Scanner keyboard = new Scanner(System.in);
 		
 		//ask for charge from the user
 		System.out.println("What is the charge for your meal?");
 		charge = keyboard.nextDouble();
 		
 		//calculate the charge and the tip
 		taxAmount = charge * tax;
 		totalWithTax = charge + taxAmount;
 		tipAmount = charge * tipRate;
 		totalAmount = tipAmount + totalWithTax;
 		payperperson = totalAmount/people;
 		
 		
 		//Display it back to the user
 		System.out.println("meal: $" + charge);
 		System.out.println("people: " + people);
 		System.out.println("tax: $" + taxAmount);
 		System.out.println("meal + tax: $" + totalWithTax);
 		System.out.println("tip: $" + tipAmount);
 		System.out.println("meal + tax + tip: $" + totalAmount);
 		System.out.println("The pay per person is $" + payperperson);
 		
 		
 		
 			
 	}
 }