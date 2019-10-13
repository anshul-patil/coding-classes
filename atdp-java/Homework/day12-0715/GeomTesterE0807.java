import java.util.Scanner;

public class GeomTesterE0807
{
   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      System.out.println("Enter radius (for sphere, cylinder, cone; not for cube): ");
      double radius = in.nextDouble();
      System.out.println("Enter height (for cube, cylinder, cone; not for sphere): ");
      double height = in.nextDouble();

      Cube cube = new Cube(height);
      Sphere sphere = new Sphere(radius);
      Cylinder cylinder = new Cylinder(radius, height);
      Cone cone = new Cone(radius, height);

      System.out.printf("\na) Cube volume:      %,8.2f", cube.getVolume());
      System.out.printf("\nb) Cube surface:     %,8.2f",cube.getSurface());
      System.out.printf("\nc) Sphere volume:    %,8.2f", sphere.getVolume());
      System.out.printf("\nd) Sphere surface:   %,8.2f",sphere.getSurface());
      System.out.printf("\ne) Cylinder volume:  %,8.2f",cylinder.getVolume());
      System.out.printf("\nf) Cylinder surface: %,8.2f",cylinder.getSurface());
      System.out.printf("\ng) Cone volume:      %,8.2f",cone.getVolume());
      System.out.printf("\nh) Cone surface:     %,8.2f",cone.getSurface());
   }
}
