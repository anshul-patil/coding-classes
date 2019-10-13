import java.util.Scanner;
/**
 * Write a description of class EasterSunday here.
 *
 * @author Anshul Patil
 * @version 1.0
 */
public class EasterSunday
{  
    private int y;
    public EasterSunday(int year)
    {
        y = year;
    }
    public void computeEaster()
    {
        int a = Math.floorMod(y, 19);
        int b = y / 100;
        int c = Math.floorMod(y, 100);
        int d = b / 4;
        int e = Math.floorMod(b, 4);
        int g = (8 * b + 13) / 25;
        int h = Math.floorMod(19 * a + b -d -g + 15, 30);
        int j = c / b;
        int k = Math.floorMod(c, b);
        int m = (a + 11 * h) / 319;
        int r = Math.floorMod(2 * e + 2 * j - k - h + m + 32, 7);
        int n = (h - m + r + 90) / 25;
        int p = Math.floorMod(h - m + r + n + 19, 32);
       
        
        System.out.printf("Year: %d, Easter Month: %d, Easter Day: %d\n", y, n, p);
        System.out.printf("a = %d, b = %d, c = %d, d = %d, e = %d\n", a, b, c, d, e);
        System.out.printf("g = %d, h = %d, j = %d, k = %d, m = %d, r = %d\n", g, h, j, k, m, r);
    }
    
    
    
    public static void main(String[] args)
    {
        EasterSunday day = new EasterSunday(2001);
        day.computeEaster();
        Scanner kboard = new Scanner(System.in);
        System.out.print("Type a year: ");
        int year = kboard.nextInt();
        EasterSunday day1 = new EasterSunday(year);
        day1.computeEaster();
    }
}
