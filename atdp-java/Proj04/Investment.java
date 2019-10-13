
/**
 * Write a description of class Investment here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Investment
{
    // instance variables - replace the example below with your own
    private int years;
    private double initBal;
    private double rate;

    /**
     * Constructor for objects of class Investment
     */
    public Investment(double begBal, double intRate)
    {
        years = 0;
        initBal = begBal;
        rate = intRate;
    }

    /**
     * Methods
     * 
     */
    public void waitForBalance(double targetBal)
    {
        years = 0;
        double curBal = initBal;
        while(curBal < targetBal) {
            curBal += curBal * rate;
            years++;
        }
    }
    
    public int getYears() {
        return years;
    } 
}
