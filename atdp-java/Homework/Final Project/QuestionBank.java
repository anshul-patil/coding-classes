import java.util.ArrayList;
import java.util.Random;
/**
 * Write a description of class QuestionBank here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class QuestionBank
{
    // instance variables - replace the example below with your own
    private ArrayList<Question> questions;

    /**
     * Constructor for objects of class QuestionBank
     */
    public QuestionBank()
    {
        // initialise instance variables
        questions = new ArrayList<Question>();
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void addQuestion(Question q)
    {
        questions.add(q);
    }
    
    public Question getQuestion()
    {
         Random randGen = new Random(); // create object for random number generator
         int i = randGen.nextInt(questions.size());
         return questions.get(i);
    }
    
    public int numQuestions()
    {
        return questions.size();
    }
}
