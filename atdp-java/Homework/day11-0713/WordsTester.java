 import java.util.ArrayList;
/**
 * Write a description of class WordsTester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class WordsTester
{
    public static void main(String[] args)
    {
        Words word = new Words();
        String[] input = {"Mary", "had", "a", "little", "lamb"};
        System.out.println("All short words");
        System.out.println(word.shortWords(input));
        ArrayList<String> save = word.shortWords(input);
        String aWord;
        for ( int i =0; i < save.size();i++)
        {
            aWord = save.get(i);
            System.out.println(aWord);
        }
        
        
    }
}
