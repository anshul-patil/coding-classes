import java.util.Scanner;

public class HollePrinter
{
    public static void main(String[] args)
    {
        Scanner kboard = new Scanner(System.in);
        System.out.print("Enter any word: "); 
        String word = kboard.nextLine(); 
        word = word.replace("o","\u263A");
        word = word.replace("e","o");
        word = word.replace("\u263A","e");
        System.out.println("replaced word: "+ word);
        
        word = "Hello World";
        String expectedWord = "Holle Werld";
        word = word.replace("o","\u263A");
        word = word.replace("e","o");
        word = word.replace("\u263A","e");
        System.out.println("expected replaced word: "+ word);
        System.out.println("actual replaced word: "+ expectedWord);
    }
}