
import java.util.Scanner;

public class SquareBoard
{
   private String[][] board;
   private int length;

   /**
      Constructs an empty square game board.
      @param sideLength the length of each side
   */
   public SquareBoard(int sideLength)
   {
      length = sideLength;
      board = new String[length][length];
      // Fill with spaces
      for (int i = 0; i < length; i++)
         for (int j = 0; j < length; j++)
            board[i][j] = " ";
   }

   /**
      Creates a string representation of the board, such as
      |x o|
      | x |
      | o |.
      @return the string representation
   */
   public String toString()
   {
      String r = "";
      for (int i = 0; i < length; i++)
      {
         r = r + "|";
         for (int j = 0; j < length; j++)
            r = r + board[i][j];
         r = r + "|\n";
      }
      return r;
   }   

   /**
      Fills the diagonals of this square board with "*" strings.
   */
   public void fillDiagonals()
   {
      for (int i = 0; i < length; i++)
      {
          for ( int j = 0; j < length; j++)
          {
              if ( i==j ) 
              {
                  board[i][j] = "*";
              }
              if ( i + j == length - 1)
              {
                  board[i][j] = "*";
              }
          }
        }
      
   }
   
   // This method is used to check your work.

   public static void main(String[] args)
   {
      System.out.println("Type the size of the array");
      Scanner in = new Scanner(System.in);
      int n = in.nextInt();   
      SquareBoard board = new SquareBoard(n);
      board.fillDiagonals();
      System.out.println(board.toString());
   }
}
