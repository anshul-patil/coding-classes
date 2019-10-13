import java.util.ArrayList;
/**
 * Helps to generate a multiple-choice question.
 *
 * @author Anshul Patil
 * @version 1.0
 */
public class ChoiceQuestion extends Question
{
    // instance variables - replace the example below with your own
    private ArrayList<String> choices;
    
    public ChoiceQuestion()
    {
        choices = new ArrayList<String>();
    }
    /**
     * Adds an answer choice to this question
     * @param choice the choice to add
     * @param correct to check if the answer is true or false
     */
    public void addChoice(String choice, boolean correct)
    {
        choices.add(choice);
        if (correct)
        {
            
            setAnswer(choice.indexOf(choice)+ 1 +"");
        }
    }
    
    /**
     * Displays the question
     */
    public void display()
    {
       int x = choices.size(); 
       super.display();
       for (int  i = 0; i < choices.size(); i++)
       {
           System.out.println(i + 1 + ":" + choices.get(i));
       }
        }
}

