
/**
 * Write a description of class NumericQuestion here.
 *
 * @author Anshul Patil
 * @version 1.0
 */
public class NumericQuestion extends Question
{
    // instance variables - replace the example below with your own
    private double answer;
    
    public NumericQuestion()
    {
        answer = 0;
    }
    
    public void setAnswer(double a)
    {
        answer = a;
    }
    
    public boolean checkAnswer(double input)
    {
        if (Math.abs(input - answer) <= 0.01 )
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
}
