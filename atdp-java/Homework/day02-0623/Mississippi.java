/**
 * Have a brief conversation with the user.
 * 
 * @author Anh Nguyen 
 * @version Summer 2016
 */

import java.util.Scanner;

public class Mississippi
{
    public static void main(String[] args)
    {
            String river = "Mississippi";
            river = river.replace("i","ii");
            System.out.println(river);
            System.out.println("length: " + river.length());
            
            river = river.replace("ss","s");
            System.out.println(river);
            System.out.print("length: " +river.length());    
    }
}