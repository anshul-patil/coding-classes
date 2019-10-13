import java.util.Scanner;
import java.util.ArrayList;
/**
 * The Quiz is made and is shown to the user to take
 *
 * @author Vivek VIjaykumar
 * @version 1.0
 */
public class QuizToTakeWLst
{
   public static void main(String [] args)
   {
       ArrayList<Question> q1 = new ArrayList<Question>();
       Scanner kbaord = new Scanner(System.in);
       Question question1 = new Question();
       question1.setText("Who is the creator of Java? Answer with their full name");
       question1.setAnswer("James Gosling");
       
       q1.add(question1);
       

       ChoiceQuestion question2 = new ChoiceQuestion();
       question2.setText("Who is the first president of the USA?");
       question2.addChoice("Washington",true);
       question2.addChoice("Madison",false);
       question2.addChoice("Trump",false);
       question2.addChoice("Jefferson",false);
       q1.add(question2);
       
       MultipleChoice question = new MultipleChoice();
       question.setText("Who are in the Warriors's starting lineup. Select all that apply. Put a comma between each option in numerical order. ");
       question.addChoice("Curry",true);
       question.addChoice("Durant",true);
       question.addChoice("McGee",false);
       question.addChoice("Barnes",false);
       
       q1.add(question);
       
       NumericQuestion question3 = new NumericQuestion();
       question3.setText("What is 7 *5?");
       question3.setAnswer("35");
       
       q1.add(question3);
      
       for (int i = 0; i < q1.size(); i++)
       {
           q1.get(i);
           q1.get(i).display();
           String response = kbaord.nextLine();
       
       System.out.println(q1.get(i).checkAnswer(response));
           
        }
       
       
}
}
