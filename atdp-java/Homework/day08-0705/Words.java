import java.util.Scanner;
/**
 * Write a description of class Words here.
 *
 * @author Anshul P
 * @version 1.0
 */
public class Words
{
   /**
      Computes a string that repeats every letter 't' in the original string.
      @param s any string
      @return a string with the same characters as s, except that every letter 't' is repeated
   */
   public String stutter(String s)
   {
       int i;
       String result = "";
       for (i = 0; i < s.length (); i++)
       {
           char ch = s.charAt(i);
           result = result + ch;
           if(ch == 't')
           {
               result = result + ch ;  
           }
       }
       return result;
   }
   public static void main(String[] args)
   {
       Words word = new Words();
       System.out.println(word.stutter("tester"));
       
   }
}
