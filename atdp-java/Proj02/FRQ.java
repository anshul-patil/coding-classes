import java.awt.Rectangle;

/**
 * Write a description of class FRQ here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FRQ
{
public static void main (String args[])
{
    Rectangle rec = new Rectangle(5, 5, 50,23);
    System.out.println("Original width is," + rec.getWidth());
    System.out.println("Original hength is,"+ rec.getHeight());
    System.out.println("The area of the Rectangle is, " + rec.getWidth() * rec.getHeight());
    System.out.println("The new width is "+rec.getWidth()*2 +"and the height is still"+ rec.getHeight());
    System.out.println("The new length is "+rec.getHeight()*2+"and the width is back to "+rec.getWidth());
    
    
    //doesn't compile
    //missing "+" operators for printing
    //doesn't complete task with built in functions
    //15/20
    //~Ivan
    

    
    

}
}