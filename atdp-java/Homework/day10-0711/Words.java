
public class Words
{
   /**
      Returns the nth short word (length <= 3) in an array.
      @param words an array of strings
      @param n an integer > 0
      @return the nth short word in words, or the empty string if there is
      no such word
   */
   public String nthShortWord(String[] words, int n)
   {
       int counter = 0; 
       for (int i = 0; i < words.length; i++)
        {
            String s = words[i];
            if (s.length() <= 3)
            {
                counter++;
                if(counter == n)
                {
                    return s;
                }
    
            }
        }
    return "";

   }
}
