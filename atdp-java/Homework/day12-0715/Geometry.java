import java.util.Scanner;
/**
 * Write a description of class AreaVolume here.
 *
 * @author Anshul Patil
 * @version 1.0
 */
public class Geometry
{
    private static final double PI = Math.PI;
   
    public static double cubeVolume(double h)
    {
        return Math.pow(h,3);
    }
    
    public static double cubeSurface(double h)
    {
        return Math.pow(h,2)*6;
    }
    
    public static double sphereVolume(double r)
    {
        return 4/3*PI*Math.pow(r, 3);
    }
    
    public static double sphereSurface(double r)
    {
        return 4*PI*Math.pow(r, 2);
    }
    
    public static double cylinderVolume(double r, double h)
    {
        return PI*Math.pow(r, 2) * h;
    }
    
    public static double cylinderSurface(double r, double h)
    {
        return 2*PI*r*h+ 2*PI*Math.pow(r, 2);
    }
    
    public static double coneVolume(double r, double h)
    {
        return PI*Math.pow(r, 2) *(h/3);
    }
    
    public static double coneSurface(double r, double h)
    {
        return PI*r*(r+Math.sqrt(Math.pow(h, 2) + Math.pow(r, 2)));
    }
    
    public static void main(String[] args)
    {
        Scanner kboard = new Scanner(System.in);
        
        
        System.out.print("Type any number for the radius: ");
        double radius = kboard.nextDouble();
        System.out.print("Type any number for the height: ");
        double height = kboard.nextDouble();
        System.out.printf("Cube: For height = %4.2f volume = %4.2f\n", height, Geometry.cubeVolume(height));
        System.out.printf("Cube: For height = %4.2f surface area = %4.2f\n", height, Geometry.cubeSurface(height));
        System.out.printf("Sphere: For radius = %4.2f volume = %4.2f\n", radius, Geometry.sphereVolume(radius));
        System.out.printf("Sphere: For radius = %4.2f surface area = %4.2f\n", radius, Geometry.sphereSurface(radius));
        System.out.printf("Cylinder: For height = %4.2f, radius = %4.2f, volume = %4.2f\n", height, radius, Geometry.cylinderVolume(radius, height));
        System.out.printf("Cylinder: For height = %4.2f, radius = %4.2f, surface area = %4.2f\n", height, radius, Geometry.cylinderSurface(radius, height));
        System.out.printf("Cone: For height = %4.2f, radius = %4.2f, volume = %4.2f\n", height, radius, Geometry.coneVolume(radius, height));
        System.out.printf("Cone: For height = %4.2f, radius = %4.2f, surface area = %4.2f\n", height, radius, Geometry.coneSurface(radius, height));
    }
    
}

    

