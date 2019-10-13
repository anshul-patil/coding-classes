/**
 * Have a brief conversation with the user.
 * 
 * @author Anh Nguyen 
 * @version Summer 2016
 */

import java.util.Scanner;

public class ReplaceTester
{
    public static void main(String[] args)
    {
        Scanner kboard = new Scanner(System.in);
        System.out.print("Enter any word: "); 
        String word = kboard.nextLine(); 
        word = word.replace("i","!");
        word = word.replace("s","$");
        System.out.println("replaced word: "+ word);
        
        word = "Mississippi";
        String expectedWord = "M!$$!$$!pp!";
        word = word.replace("i","!");
        word = word.replace("s","$");
        System.out.println("actual replaced word: "+ word);
        System.out.println("expected replaced word: "+ expectedWord);
    }
}