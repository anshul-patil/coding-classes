
/**
 * Test class Balloon.
 *
 * @author A. Nguyen
 * @version 1.0
 */
public class BalloonTesterATDP
{
    public static void main(String[] args){
        Balloon balloon = new Balloon();
        
        balloon.addAir(150);
        System.out.print("\nVolume: \t");
        System.out.printf("%6.2f " , balloon.getVolume());
        System.out.print("\nSurface area: \t");
        System.out.printf("%6.2f ", balloon.getSurfaceArea());
        System.out.print("\nRadius: \t");
        System.out.printf("%6.2f ", balloon.getRadius());
        
        balloon.addAir(270);
        System.out.print("\n\nVolume: \t");
        System.out.printf("%6.2f " , balloon.getVolume());
        System.out.print("\nSurface area: \t");
        System.out.printf("%6.2f ", balloon.getSurfaceArea());
        System.out.print("\nRadius: \t");
        System.out.printf("%6.2f ", balloon.getRadius());

    }
}
