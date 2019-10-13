import java.util.ArrayList;
/**
 * Write a description of class ChoiceQuestion here.
 *
 * @author (your name)
 * @version (a version number or a date)
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
     * @param correct true
     */
    public void addChoice(String choice, boolean correct)
    {
        choices.add(choice);
        if (correct)
        {
            setAnswer(choices.size() +"");
        }
    }
    
    public void display()
    {
       super.display();
       for (int  i = 0; i < choices.size(); i++)
       {
           System.out.println(i + 1 + ":" + choices.get(i));
       }
     }
}

