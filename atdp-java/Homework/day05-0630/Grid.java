
/**
 * Write a description of class Grid here.
 *
 * @author Anshul Patil
 * @version 1.0
 */
public class Grid
{
    private static final String comb = "+--+--+--+\n|  |  |  |";
    private static final String bottom = "+--+--+--+";
    public Grid()
    { 
    }
    public String getComb()
    {
        return comb;
    }
    public String getBottom()
    {
        return bottom;
    }
    public static void main(String[] args)
    {
        Grid p = new Grid();
        System.out.println(p.getComb());
        System.out.println(p.getComb());
        System.out.println(p.getComb());
        System.out.println(p.getBottom());       
    }
}
