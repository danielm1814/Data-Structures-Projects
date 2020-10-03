import java.util.Scanner;
/**
 * Write a description of class Board here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Board
{
    String[][] board;
    int available;
    Scanner sc = new Scanner(System.in);
    int score = 0;
    int temp;
    int pRow = -1;
    int pCol = -1;
    
    public Board(int size)
    {
        board = new String[2 * size + 1][3 * size + 1];
        available = size * size;
        temp = available;
        create();
    }
    
    public void create()
    {
        for (int i = 0; i < board.length; i+= 2)
        {
            for (int k = 0; k < board[0].length; k+=3)
            {
                board[i][k] = "+";
        }
        }
        
        for(int i = 0; i < board.length; i+=2)
        {
            for (int k = 1; k < board[0].length; k+=3)
            {
                board[i][k] = "-";
            }
        }
        
        for(int i = 0; i < board.length; i+=2)
        {
            for (int k = 2; k < board[0].length; k+=3)
            {
                board[i][k] = "-";
            }
        }
        
        for(int i = 1; i < board.length; i+=2)
        {
            for (int k = 0; k < board[0].length; k+=3)
            {
                board[i][k] = "|";
            }
        }
        
        for(int i = 1; i < board.length; i+=2)
        {
            for (int k = 1; k < board[0].length; k+=3)
            {
                board[i][k] = "";
            }
        }
        int tracker = 1;
        for(int i = 1; i < board.length; i+=2)
        {
            for (int k = 2; k < board[0].length; k+=3)
            {
                if (tracker < 10)
                {
                board[i][k] = "0" + tracker;
            }
                else 
                {
                board[i][k] = "" + tracker;
            }
                tracker++;
            }
        }
    }
    
    public void printBoard()
    {
        for (int i = 0; i < board.length; i++)
        {
            for (int k = 0; k < board[0].length; k++)
            {
                System.out.print(board[i][k]);
            }
            System.out.println();
        }
    }
    
    public void go()
    {
        System.out.print('\u000C');
        printBoard();
        System.out.println("Score: " + score);
        System.out.println("Where do you want to go?");
        String num = sc.nextLine();
        
        for (int i = 0; i < board.length; i++)
        {
           for(int k = 0; k < board[0].length; k++)
           {
               if (board[i][k].indexOf("0") == 0 && num.length() == 1)
               {
                   num = "0" + num;
                }
               if (board[i][k].equals(num))
               {
                    if (temp == available)
                    {
                        adjustBoard();
                        board[i][k] = " K";
                        pRow = i;
                        pCol = k;
                        score++;
                        available--;
                    }
                    else if(legal(num))
                    {
                        adjustBoard();
                        board[i][k] = " K";
                        pRow = i;
                        pCol = k;
                        score++;
                        available--;
                    }
                }
            }
        }
        if (available == temp - 1)
        {
            System.out.println("Invalid input");
            go();
        }
        if (numMoves(num) > 0)
        {
            go();
        }
        else if (numMoves(num) == 0)
        {
            System.out.println("You are out of moves. Your score is " + score);
        }
        printBoard();
    }
    
    public void adjustBoard()
    {
        for (int i = 0; i < board.length; i++)
        {
            for (int k = 0; k < board[0].length; k++)
            {
                if (board[i][k].contains(" K"))
                {
                    board[i][k] = " X";
                }
            }
        }
    }
    
    public int numMoves(String num)
    {
        int row = pRow;
        int col = pCol;
        int possible = 0;
        
        if (row - 2 > 0 && col - 6 > 0)
        {
            if (board[row-2][col-6].indexOf("X") == -1 || board[row-2][col-6].indexOf("K") == -1)
            {
                possible++;
            }
        }
        if (row - 2 > 0 && col + 6 < board[0].length)
        {
            if (board[row-2][col+6].indexOf("X") == -1 || board[row-2][col+6].indexOf("K") == -1)
            {
                possible++;
            }
        }
        if (row + 2 < board.length && col + 6 < board[0].length)
        {
            if (board[row+2][col+6].indexOf("X") == -1 || board[row+2][col+6].indexOf("K") == -1)
            {
                possible++;
            }
        }
        if (row + 2 < board.length && col - 6 > 0)
        {
            if (board[row+2][col-6].indexOf("X") == -1 || board[row+2][col-6].indexOf("K") == -1)
            {
                possible++;
            }
        }
        if (row + 4 < board.length && col - 3 > 0)
        {
            if (board[row+4][col-3].indexOf("X") == -1 || board[row+4][col-3].indexOf("K") == -1)
            {
                possible++;
            }
        }
        if (row - 4 > 0 && col - 3 > 0)
        {
            if (board[row-4][col-3].indexOf("X") == -1 || board[row-4][col-3].indexOf("K") == -1)
            {
                possible++;
            }
        }
        if (row + 4 < board.length && col + 3 < board[0].length)
        {
            if (board[row+4][col+3].indexOf("X") == -1 || board[row+4][col+3].indexOf("K") == -1)
            {
                possible++;
            }
        }
        if (row - 4 > 0 && col + 3 < board[0].length)
        {
            if (board[row-4][col+3].indexOf("X") == -1 || board[row-4][col+3].indexOf("K") == -1)
            {
                possible++;
            }
        }
        return possible;
    }
    
    public boolean legal(String num)
    {
        int row = pRow;
        int col = pCol;
        
        if (row - 2 > 0 && col - 6 > 0)
        {
            if (board[row-2][col-6].equals(num))
            {
                return true;
            }
        }
        if (row - 2 > 0 && col + 6 < board[0].length)
        {
            if (board[row-2][col+6].equals(num))
            {
                return true;
            }
        }
        if (row + 2 < board.length && col + 6 < board[0].length)
        {
            if (board[row+2][col+6].equals(num))
            {
                return true;
            }
        }
        if (row + 2 < board.length && col - 6 > 0)
        {
            if (board[row+2][col-6].equals(num))
            {
                return true;
            }
        }
        if (row + 4 < board.length && col - 3 > 0)
        {
            if (board[row+4][col-3].equals(num))
            {
                return true;
            }
        }
        if (row - 4 > 0 && col - 3 > 0)
        {
            if (board[row-4][col-3].equals(num))
            {
                return true;
            }
        }
        if (row + 4 < board.length && col + 3 < board[0].length)
        {
            if (board[row+4][col+3].equals(num))
            {
                return true;
            }
        }
        if (row - 4 > 0 && col + 3 < board[0].length)
        {
            if (board[row-4][col+3].equals(num))
            {
                return true;
            }
        }
        return false;
    }
}
