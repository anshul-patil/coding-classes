import java.util.Scanner;
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
    private int answer;
    
    public Question()
    {
        text = "";
        answer = 0;
    }
    
    public void setText(String t)
    {
         text = t;
    }
    
    public void setAnswer(int a)
    {
        answer = a;
    }
    public int getAnswer()
    {
        return answer;
    }
    
    public boolean checkAnswer(int input)
    {
        // System.out.println(input + " == " + answer);
        if (input == answer)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public void applyLifeLine()
    {
    }
    
    public void display()
    {
        System.out.println(text);
        System.out.println("");
    }
    
    public int getUserAnswer(Scanner kboard)
    {
        System.out.print("Please enter an answer or enter 0 for lifeline (50:50): ");
        int input1 = kboard.nextInt();
        return input1;
    }
}
