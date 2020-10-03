import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Main.java 
 *
 * @author:
 * Assignment #:
 * 
 * Brief Program Description:
 * 
 *
 */

public class Main 
{
   private static Scanner in;
   
   public static void main(String[] args)
   {
       in = new Scanner(System.in);
       
       int n = getBoardSize();
       boolean showSteps = getShowSteps();
       int delay;
       
       if(showSteps)
            delay = getDelay();
       else
            delay = 0;
            
       ChessBoard board = new ChessBoard(n, showSteps, delay);
       board.solve();
       
       if(!showSteps)
            board.display();
   }
   
   private static int getBoardSize()
   {
       System.out.print("Enter board size or enter \"0\" for random size: ");
       int result = -2;
       
       while(true) {
           try {
              result = in.nextInt();
           } catch(InputMismatchException ex) {}
           
           if(result == 0)
                result = (int)(Math.random() * 4 + 6);
           
           if(result > 0)
                break;
           
           System.out.println("Please enter a valid integer.");
       }
       
       return result;
   }
   
   private static boolean getShowSteps()
   {
       System.out.print("Enter \"fast\" for quick solution or \"step\" for each step to be displayed individually: ");
       String result = "";
       
       while(true) {
           try {
              result = in.nextLine();
           } catch(InputMismatchException ex) {}
           
           if(result.toLowerCase().equals("fast")) {
               return false;
           }
           
           if(result.toLowerCase().equals("step")) {
               return true;
           }
           
           System.out.println("Please enter either \"fast\" or \"step\".");
       }
   }
   
   private static int getDelay()
   {
       System.out.print("Enter delay between moves (in milliseconds) or enter \"-1\" for default: ");
       int result = -2;
       
       while(true) {
           try {
              result = in.nextInt();
           } catch(InputMismatchException ex) {}
           
           if(result == -1)
                result = 500;
           
           if(result > 0)
                break;
           
           System.out.println("Please enter a valid integer.");
       }
       
       return result;
   }
}
