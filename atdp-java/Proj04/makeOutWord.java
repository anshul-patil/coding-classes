
/**
 * Write a description of class makeOutWord here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class makeOutWord {
public String makeOutWord(String out, String word) {
  String begOfOut = out.substring(0,2);
  String EndOfOut= out.substring(2,4);
  return begOfOut + word + EndOfOut; 
}
}

