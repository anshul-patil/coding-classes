
/**
 * Write a description of class BalloonTester here.
 *
 * @author Anshul Patil
 * @version 1.0
 */
public class BalloonTester
{
    public static void main(String[] args)
    {
        Balloon balloon = new Balloon();
        balloon.addAir(100);
        System.out.printf("For radius = %4.2f volume = %4.2f\n", balloon.getRadius(), balloon.getVolume());
        System.out.printf("For radius = %4.2f surface area = %4.2f\n", balloon.getRadius(), balloon.getSurfaceArea());        
        balloon.addAir(100);
        System.out.printf("For radius = %4.2f volume = %4.2f\n", balloon.getRadius(), balloon.getVolume());
        System.out.printf("For radius = %4.2f surface area = %4.2f\n", balloon.getRadius(), balloon.getSurfaceArea());        
    }
}
