/**
 * Write a description of class integersTwo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class integersTwo
{
    private int first;
    private int second;
    
    /**
     * Constructs two numbers of no value
     */
    public integersTwo(int one, int two)
    {
        first = one;
        second = two;
    }
    
    /**
     * Get the sum of the two numbers
     * @return sum adds the two numbers with each other to get the sum
     */
    public int getSum()
    {
        int sum = first + second;
        return sum;
        
    }
    /**
     * Get the difference between the two numbers
     * @return difference get the difference between the two numbers
     */
    public int getDifference()
    {
        int difference = first - second;
        return difference;
    }
    /**
     * Get the product of the two numbers 
     * @return product multiplies the two number to get the product
     */
    public int getProduct()
    {
        int product = first*second;
        return product;
    }
    /**
     * Get the average of the two numbers
     * @return average adds both numbers and divides them by 2
     */
    public double getAverage()
    {
        double average = (first + second)/2.0;
        return average;
    }
    public int getDistance()
    {
        int difference = getDifference();
        return Math.abs(difference);
    }
    public int getMaximum()
    {
        return Math.max(first, second);
    }
    public int getMinimum()
    {
        return Math.min(first, second);
    }
}
