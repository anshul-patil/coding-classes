

/**
 * Write a description of class alarmClock here.
 *
 * @author Anshul Patil
 * @version 1.0
 */
public class alarmClock
{
  public String alarmClock(int day, boolean vacation) {
  if ( vacation == true && ( day == 0 || day == 6 ) )
   return "off";
  if ( vacation == true && ( day == 1 || day == 2 || day == 3 || day == 4 || day == 5 ) )
   return "10:00";
  if ( vacation == false && ( day == 0 || day == 6 ) )
   return "10:00";
  else return "7:00";
}
}