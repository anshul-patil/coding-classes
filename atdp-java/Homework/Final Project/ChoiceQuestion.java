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
            setAnswer(choices.size());
        }
    }
    
    public void display()
    {
       super.display();
       int ans = getAnswer();
       
       for (int i = 0; i < choices.size(); i++)
       {
           System.out.printf("< %d: %20s >", i + 1, choices.get(i));
               
           if ((i + 1)%2 == 0)
           {
               System.out.println("");
           }
           else
           {
               System.out.print("\t\t");
           }
       }
       System.out.println("");
       //System.out.println("Answer : " + this.getAnswer()); 
    }
    
    public void applyLifeLine()
    {
       int ans = getAnswer() - 1; // convert from number to index
       int pickOther = ans+1;
       if (pickOther >= choices.size())
       {
           pickOther = ans - 1;
       }
       
       for (int i = 0; i < choices.size(); i++)
       {
           if (i != ans && i != pickOther)
           {
               choices.set(i, "   ");
           }
       }
    }
    
}

