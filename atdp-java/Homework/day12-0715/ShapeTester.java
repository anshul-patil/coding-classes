import java.util.Scanner;
/**
 * Write a description of class Tester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ShapeTester
{
    public static void main(String[] args)
    {
        Scanner kboard = new Scanner(System.in);
        
        
        System.out.print("Type any number for the radius: ");
        double radius = kboard.nextDouble();
        System.out.print("Type any number for the height: ");
        double height = kboard.nextDouble();
        Cube c = new Cube(height);
        System.out.printf("Cube: For height = %4.2f volume = %4.2f\n", height, c.getVolume());
        System.out.printf("Cube: For height = %4.2f surface area = %4.2f\n", height, c.getSurface());
        Sphere s = new Sphere(radius);
        System.out.printf("Sphere: For radius = %4.2f volume = %4.2f\n", radius, s.getVolume());
        System.out.printf("Sphere: For radius = %4.2f surface area = %4.2f\n", radius, s.getSurface());
        Cylinder cy = new Cylinder(radius, height);
        System.out.printf("Cylinder: For height = %4.2f, radius = %4.2f, volume = %4.2f\n", height, radius, cy.getVolume());
        System.out.printf("Cylinder: For height = %4.2f, radius = %4.2f, surface area = %4.2f\n", height, radius, cy.getSurface());
        Cone co = new Cone(radius, height);
        System.out.printf("Cone: For height = %4.2f, radius = %4.2f, volume = %4.2f\n", height, radius, co.getVolume());
        System.out.printf("Cone: For height = %4.2f, radius = %4.2f, surface area = %4.2f\n", height, radius, co.getSurface());
    }
}
