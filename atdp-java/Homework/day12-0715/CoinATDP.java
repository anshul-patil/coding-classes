
/**
 * This class represents one kind of coin, with a value and name.
 * 
 * @author A. Nguyen 
 * @version 1.0
 */
public class CoinATDP {
    // fields
    private double value; // name of the coin; e.g., dollar, quarter, etc.
    private String name; // value, in dollars, of the coin; 1.0, .25, etc.
    
    // constructor
    public CoinATDP (double aValue, String aName) {
        name = aName;
        value = aValue;
    }
    
    // methods
    public double getValue() {
         return value;
    }
    
    public String getName() {
         return name;}
}
