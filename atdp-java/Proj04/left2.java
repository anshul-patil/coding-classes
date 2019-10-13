
/**
 * Write a description of class left2 here.
 *
 * @author Anshul Patil
 * @version 1.0
 */
public class left2
{
   public String left2(String str) {
  int length = str.length();
  String firstTwo = str.substring(0,2);
  String lastFew = str.substring(2, length);
  return lastFew + firstTwo;
}
}
