
/**
 * Write a description of class StringTester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class StringTester
{
   public static void main(String[] args)
    {
        String a = new String ("anshul is awesome");
        System.out.println(a.length());
        System.out.println(a.substring(4));
        char ch1 = a.charAt(0);
        System.out.println("Charater at 4 inde is: "+ch1); 
        System.out.println("Index of i in a after 5th char:"+a.indexOf('i', 5));
        System.out.println(a.lastIndexOf( 'a' ));
        String result;
        String oresult;
        result = a.toUpperCase();
        oresult = a.toLowerCase();
        System.out.println(result);
        System.out.println(oresult);
        
    }
}
