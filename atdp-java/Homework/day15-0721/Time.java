import java.util.Date;
import java.util.concurrent.TimeUnit;
/**
 * Write a description of class Time here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Time
{
   public static void main(String[]  args)
   {
       
       for( ; ;)
       {
           Date now =  new Date();
           System.out.println(now);

           try
           {
               TimeUnit.SECONDS.sleep(1);
           }
           catch(InterruptedException ex)
           {
               System.out.println("Interrupted");
           }
       }
        
   }
}
