
/**
 * Write a description of class nonStart here.
 *
 * @author Anshul Patil
 * @version 1.0
 */
public class nonStart
{
public String nonStart(String a, String b) {
  int FirstWordLength = a.length(); 
  String FirstWord= a.substring(1, FirstWordLength); 
 
  int SecondWordLength= b.length(); 
  String SecondWord= b.substring(1, SecondWordLength); 
  return FirstWord + SecondWord;
  
}
}