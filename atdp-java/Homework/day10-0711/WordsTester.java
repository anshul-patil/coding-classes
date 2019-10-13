
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
        System.out.println("Before statement");
        System.out.println(word.nthShortWord(args, 2));
    }
}
