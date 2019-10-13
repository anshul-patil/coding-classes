import java.util.ArrayList;
public class Words
{
   /**
      Returns the nth short word (length <= 3) in an array.
      @param words an array of strings
      @param n an integer > 0
      @return the nth short word in words, or the empty string if there is
      no such word
   */
   public ArrayList<String> shortWords(String[] words)
   { 
       ArrayList<String> allshort = new ArrayList<String>();
       for (int i = 0; i < words.length; i++)
        {
            String s = words[i];
            if (s.length() <= 3)
            {
                allshort.add(s);
            }
        }
    return allshort;

   }
}
