import java.util.Scanner;
/**
 * Write a description of class Question1 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Question1 extends wheelOfFrtune
{
    public static void main(String[] args) {
        System.out.println("Welcome to my game show game.");
        System.out.println("The rules are:/n ");
        
        Scanner one = new Scanner(System.in);
        wheelOfFrtune two = new wheelOfFrtune();
        two.setText("Bob's dad has 5 children. 4 of the children are named Haha, Hehe, Hihi, and Hoho. What is the 5th childs name?");
        two.setAnswer("Bob");
        two.display();
        System.out.println("Give answer: ");
        String input1 = one.nextLine();
        System.out.println(two.checkAnswer(input1));
    }
}
