import java.util.concurrent.ThreadLocalRandom;


/**
 * Write a description of class Array1DChecker here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Array1DChecker
{
    public static void main (String [] args)
    {
        int[] array1 = new int[12];
        int min = -20;
        int max = 90;
        for (int i = 0; i < array1.length; i++)
{
    array1[i] = ThreadLocalRandom.current().nextInt(min, max + 1);
    

}
for (int temp : array1)
{
System.out.println(temp); 
}
System.out.println("");
int a = array1[array1.length-1];
array1[array1.length-1] = array1[0]; 
array1[0] = a;
for (int j = array1.length-1; j >= 0; j--)
{
    System.out.println(array1[j]); 
    
    
    
    


  }

}
 
}
