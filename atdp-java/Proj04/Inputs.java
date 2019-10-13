
/**
 * Write a description of class Inputs here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Inputs
{
   /**
      Gets the choice that the user provided, or null if the 
      user didn't provide a valid choice.
      @param input the user input
      @param maxChoice the maximum valid choice, e.g. "D" if there
      are four choices.
      @return the user input if it was a valid choice (i.e. length 1
      and between "A" and maxChoice), null otherwise
   */
   public String getChoice(String input, String maxChoice)
   {
      if(input == null)
      {
          return null;
      }
      if(input.length() == 1)
      {
          if("A".compareTo(input) <= 0 && (maxChoice.compareTo(input)) >= 0)
          {
              return input;
          }
          else
          {
              return null;
          }
      }
      else
      {
          return null;
      }

   }
   public static void main(String[] args)
   {
      Inputs word = new Inputs();
      System.out.println("Choice(A, D) is [" + word.getChoice("A", "D") + "]");
      System.out.println("Choice(E, D) is [" + word.getChoice("E", "D") + "]");
      System.out.println("Choice(E, E) is [" + word.getChoice("E", "E") + "]");
      System.out.println("Choice(AB, D) is [" + word.getChoice("AB", "D") + "]");
      System.out.println("Choice(, D) is [" + word.getChoice("", "D") + "]");
     
   }
}