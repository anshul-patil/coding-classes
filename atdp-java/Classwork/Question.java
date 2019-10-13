
/**
 * Write a description of class Question here.
 *
 * @author Anshul Patil
 * @version 1.0
 */
public class Question
{
    // instance variables - replace the example below with your own
    private String text;
    private String answer;
    public Question()
    {
        text = "";
        answer = "";
    }
    
    public void setText(String t)
    {
         text = t;
    }
    
    public void setAnswer(String a)
    {
        answer = a;
    }
    
    public boolean checkAnswer(String input)
    {
        // System.out.println(input + " == " + answer);
        if (input.equals(answer))
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
        System.out.println(text);
    }
}
