
/**
 * Write a description of class middleThree here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class middleThree
{
   public String middleThree(String str) {
  int length = str.length();
  int formula = (length -3)/2;
  String threeletter = str.substring(formula, length - formula);
  return threeletter;
}

}
