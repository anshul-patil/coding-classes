import java.util.ArrayList;
/**
 * Write a description of class MultipleChoice here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MultipleChoice extends Question
{
    // instance variables - replace the example below with your own
    private ArrayList<String> choices;
    private ArrayList<String> answer;
    
    public MultipleChoice()
    {
        choices = new ArrayList<String>();
        answer = new ArrayList<String>();
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
            answer.add(choices.size()+"");
        }
    }
    
    public boolean checkAnswer(String input)
    {
        String a = "";
        for (int i = 0; i < answer.size(); i++) {
            if (i == 0) {
                a = answer.get(i);
            } else {
                a = a + " " + answer.get(i);
            }
        }
        
        if (input.equals(a))
        {
            return true;
        }
        else
        {
            return false;
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
