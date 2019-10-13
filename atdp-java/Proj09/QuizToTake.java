import java.util.Scanner;
/**
 * Write a description of class QuizToTake here.
 *
 * @author Anshul Patil
 * @version 1.0
 */
public class QuizToTake
{
    public static void main(String[] args)
 {
   Scanner kboard = new Scanner(System.in);
   
   Question q = new Question();
   q.setText("Who is the first president of the U.S.A?");
   q.setAnswer("George Washington");
   q.display();
   System.out.println("Please enter an answer: ");
   String input = kboard.nextLine();
   System.out.println(q.checkAnswer(input));
   
   ChoiceQuestion b = new ChoiceQuestion();
   b.setText("Where does the President live?");
   b.addChoice("The White House", true);
   b.addChoice("The Twin Towers", false);
   b.addChoice("A Hotel", false);
   b.addChoice("The Black House", false);
   b.display();
   System.out.println("Please enter an answer: ");
   String input1 = kboard.nextLine();
   System.out.println(b.checkAnswer(input1));
 }
}
