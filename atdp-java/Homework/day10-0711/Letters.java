
/**
 * Write a description of class Letters here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Letters
{
   /**
      Counts the frequencies of letters A-Za-z in a string
      @param str a string
      @return an array of 26 counts. The i-th count is the number of occurrences
      of 'A' + i or 'a' + i.
   */
   public int[] letterFrequencies(String str)
   {
      int[] counts = new int[26];
      for (int i = 0; i < str.length (); i++)
      {
          char ch = str.charAt(i);
          if (ch == 'a' || ch == 'A')
          {
             counts[0]++; 
          }
          if (ch == 'b' || ch == 'C')
          {
             counts[1]++; 
          }
          if (ch == 'c' || ch == 'D')
          {
             counts[2]++; 
          }
          if (ch == 'd' || ch == 'D')
          {
             counts[3]++; 
          }
          if (ch == 'e' || ch == 'E')
          {
             counts[4]++; 
          }
          if (ch == 'f' || ch == 'F')
          {
             counts[5]++; 
          }
          if (ch == 'g' || ch == 'G')
          {
             counts[6]++; 
          }
          if (ch == 'h' || ch == 'H')
          {
             counts[7]++; 
          }
          if (ch == 'i' || ch == 'I')
          {
             counts[8]++; 
          }
          if (ch == 'j' || ch == 'J')
          {
             counts[9]++; 
          }
          if (ch == 'k' || ch == 'K')
          {
             counts[10]++; 
          }
          if (ch == 'l' || ch == 'L')
          {
             counts[11]++; 
          }
          if (ch == 'm' || ch == 'M')
          {
             counts[12]++; 
          }
          if (ch == 'n' || ch == 'N')
          {
             counts[13]++; 
          }
          if (ch == 'o' || ch == 'O')
          {
             counts[14]++; 
          }
          if (ch == 'p' || ch == 'P')
          {
             counts[15]++; 
          }
          if (ch == 'q' || ch == 'Q')
          {
             counts[16]++; 
          }
          if (ch == 'r' || ch == 'R')
          {
             counts[17]++; 
          }
          if (ch == 's' || ch == 'S')
          {
             counts[18]++; 
          }
          if (ch == 't' || ch == 'T')
          {
             counts[19]++; 
          }
          if (ch == 'u' || ch == 'U')
          {
             counts[20]++; 
          }
          if (ch == 'v' || ch == 'V')
          {
             counts[21]++; 
          }
          if (ch == 'w' || ch == 'W')
          {
             counts[22]++; 
          }
          if (ch == 'x' || ch == 'X')
          {
             counts[23]++; 
          }
          if (ch == 'y' || ch == 'Y')
          {
             counts[24]++; 
          }
          if (ch == 'z' || ch == 'Z')
          {
             counts[25]++; 
          }
      }
 
      return counts;
   }
   public static void main(String[] args)
   {
       Letters letter = new Letters();
       int[] save = letter.letterFrequencies("My Name Is Anshul");
       System.out.println("Counts of A-Z are listed below as count[0]-count[25]: ");
       for(int i = 0; i < save.length; i++)
       {
           System.out.println("count[" + i + "] = " + save[i]);
       }
       
   }
}
