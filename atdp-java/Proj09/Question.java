
/**
 * The Question class generates a question.
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
    /**
     * Sets the question to something
     * @param t sets text to the input
     */
    public void setText(String t)
    {
         text = t;
    }
    
   /**
    * Sets the answer to something
    * @param a sets the answer to a certain string
    */
    public void setAnswer(String a)
    {
        answer = a;
    }
    
    /**
     * Checks to see if answer is right
     * @param input gets the input from the user
     */
    public boolean checkAnswer(String input)
    {
        if (input.equals(answer))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    /**
     * Displays the question.
     */
    public void display()
    {
        System.out.println( text);
    }
}
