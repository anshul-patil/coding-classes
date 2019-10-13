
/**
 * Write a description of class CenterLetter here.
 *
 * @author Anshul PAtil
 * @version 1.0
 */
public class Words
{
   /**
      Gets the middle character or character pair from this word 
      when possible.
      @param word a word
      @return the middle character (if the word length is odd) or
      middle two characters (if it is even), or the empty string if 
      the word is empty, or null if it is null.
   */
   public String getMiddle(String word)
   {
       if(word == null)
       {
           return null;
       }
       if(word.length() == 0)
       {
            String noWords ="";
            return noWords;
       }
       int num = word.length()/2;
       int num1 = word.length()/2 - 1;
       if(word.length()%2 == 0)
       {
            String even = word.substring(num1, num1 + 2);
            return even;
       }
       else
       {
           String odd = word.substring(num, num + 1);
           return odd;
       }
   }
   public static void main (String[] args)
   {
      Words word = new Words();
      System.out.println("Middle for Anshul is [" + word.getMiddle("Anshul") + "]");
      System.out.println("Middle for null is [" + word.getMiddle(null) + "]");
      System.out.println("Middle for Anshu is [" + word.getMiddle("Anshu") + "]");
      System.out.println("Middle for empty is [" + word.getMiddle("") + "]");
   }
}

