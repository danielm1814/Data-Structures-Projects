import java.util.*;
import java.awt.*;
import javax.swing.*;

public class ChessBoard {
    // Instance variables. PAY ATTENTION TO THE FIRST TWO
    int size;
    char[][] board;
    int queen = 0;
    boolean s = false;
    // board[i][j] == 'X' if there's a queen on it or 'O' otherwise.
    
    // Solving modes (step and fast)
    enum Mode { STEP, FAST }
    Mode mode;
    
    // Delay between steps if using STEP mode (in milliseconds)
    int delay;
    
    // Used for displaying the solution
    ChessPanel drawPanel;

    // Constructor.
    /**
     * Constructs an object that solves the N Queens Problem.
     * @param n the number of queens to be placed on an n by n board
     */
    public ChessBoard (int size, boolean showSteps, int delay) 
    {
        // Build the board. Initially empty: board[i][j] == 'O'.
        this.size = size;
        board = new char [size][size];
        for (int i=0; i<size; i++) {
            for (int j=0; j<size; j++) {
                board[i][j] = 'O';
            }
        }
        
        if(showSteps)
            this.mode = Mode.STEP;
        else
            this.mode = Mode.FAST;
        
        if(mode == Mode.STEP)
            display();
        
        this.delay = delay;
    }

    /**
     * Kicks off the recursion to solve the N Queens Problem.
     */
    public void solve()
    {
        placeQueen(0);
    }
    
    /**
     * Attempts to place the qth queen on the board.
     * Precondition: 0 <= q < size
     * @param q row index of next queen to place
     * @returns true if non-attacking queens were placed in all rows;
     *          false otherwise.
     *
     * This queen needs to be placed in row q.  The only question is
     * which column she will be in.  placeQueen needs to try each column
     * in turn.  Whenever it finds a column that could work, it puts the
     * queen there and then recurses to place the rest of the queens.
     */
    private boolean placeQueen(int q)
    {   
        if (q < size)
        {
            for (int i = 0; i < size; i++)
            {
                if (!isForbidden(q, i))
                {
                    addQueen(q, i);
                    queen++;
                    boolean stop = placeQueen(q+1);
                    if (queen >= size)
                    {
                        s = true;
                        break;
                    }
                    if (stop && !s)
                    {
                        removeQueen(q, i);
                        queen--;
                        return true;
                    }
                    else if (!stop && !s)
                    {
                        removeQueen(q, i);
                        queen--;
                    }
                }
            }
        }
        
        return false;
    }
    
    /**
     * Determines whether a queen can or cannot be placed at the specified
     * location.
     * @param row the row of the location to test
     * @param col the column of the location to test
     * @returns false if this location is not attached by any queen
     *               above it (with a smaller row).  ie there is no queen
     *               in the same column or either diagonal;
     *          true otherwise.
     *
     * isForbidden verifies that another queen can attack this
     * location.  Note that when this method is called, only queens
     * in previous rows have been placed.
     */
    public boolean isForbidden (int row, int col)
    {
        int r, c;
        r = row;
        c = col;
        if (c < 0 || c >= size || r < 0 || r >= size)
        {
            return false;
        }
        
        // check all locations directly above location (write your code below)
        for (int i = 0; i < row; i++)
        {
            if (board[i][col] == 'X')
            {
                return true;
            }
        }
        // check all locations up and to the right location (diagonal)
        c = col;
        for (int i = row; i >= 0; i--)
        {
            if (board[i][c] == 'X')
            {
                return true;
            }
            if (c > 0)
            {
                c--;
            }
            else
            {
                break;
            }
            
        }
        // check all locations up and to the left of location (diagonal - similar to the above example)
        c = col;
        for (int i = row; i >= 0; i--)
        {
            if (board[i][c] == 'X')
            {
                return true;
            }
            if (c < size - 1)
            {
                c++;
            }
            else
            {
                break;
            }
        }
        // passed all the tests, so return false
        return false;
    }

    /**
     * Adds a queen at the specified location and re-shows the world.
     * Precondition: location is valid location in grid
     * @param row the row of the location where the queen should be placed
     * @param col the column of the location where the queen should be placed
     */
    public void addQueen (int row, int col)
    {
        if(mode == Mode.STEP)
            try {Thread.sleep(delay);} catch (InterruptedException e){}
        
        board[row][col] = 'X';
        if(mode == Mode.STEP) {
            drawPanel.board = copyBoard();
            
            drawPanel.repaint();
            drawPanel.revalidate();
        }
    }

    /**
     * Removes a queen at the specified location and re-shows the world.
     * Precondition: location is valid location in grid
     * @param row the row of the location where the queen should be removed
     * @param col the column of the location where the queen should be removed
     */
    public void removeQueen (int row, int col)
    {
        if(mode == Mode.STEP)
            try {Thread.sleep(delay);} catch (InterruptedException e){}
        
        board[row][col] = 'O';
        if(mode == Mode.STEP) {
            drawPanel.board = copyBoard();
            
            drawPanel.repaint();
            drawPanel.revalidate();
        }
    }

    /**
     * Displays the solution.
     */
    public void display ()
    {
        // Make the frame and set some of its parameters:
        JFrame f = new JFrame ();
        f.setSize (300,300);
        f.setTitle ("N Queens problem");
        
        // Terminates program if closed
        f.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

        // Create our extension of the JPanel:
        drawPanel = new ChessPanel ();

        // We'll need to pass on the data:
        drawPanel.size = size;
        drawPanel.board = copyBoard();

        // Add this to the frame. Notice the strange syntax.
        f.getContentPane().add (drawPanel);

        // Bring up the frame.
        f.setVisible (true);
    }
    
    /**
     * Makes a copy of the entire board for GUI usage.
     * @returns a copy of the board instance variable
     */
    private char[][] copyBoard ()
    {
        char board2[][] = new char[size][size];
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                board2[i][j] = board[i][j];
        
        return board2;
    }
}

/**
 * Separate ChessPanel class for updating 
 * components and displaying the solution.
 */
class ChessPanel extends JPanel {
    int size;
    char[][] board;

    public void paintComponent (Graphics g)
    {
        // This is required.
        super.paintComponent (g);

        // First, compute the minimum dimension. The board size can't be larger.
        Dimension D = this.getSize();
        int minD = D.height;
        if (D.width < minD) {
            minD = D.width;
        }

        // This is the size of each square.
        int cellSize = minD / size;

        // We'll draw an image for each queen.
        ImageTool im = new ImageTool ();
        Image queen = im.readImageFile ("queen.jpg");

        // Now draw the chessboard.
        boolean isWhite = true;
        for (int i=0; i<size; i++) {
            for (int j=0; j<size; j++) {

                // Compute top-left.
                int topLeftX = j*cellSize;
                int topLeftY = i*cellSize;

                if (! isWhite) {
                    // For black (gray) squares:
                    g.setColor (Color.gray);
                    g.fillRect (topLeftX, topLeftY, cellSize, cellSize);
                }
                g.setColor (Color.black);
                g.drawRect (topLeftX, topLeftY, cellSize, cellSize);

                // Alternate between black and white, except for end-of-row.
                if (j < size-1) {
                    isWhite = !isWhite;
                }

                if (board[i][j] == 'X') {
                    // Draw the queen image.
                    g.drawImage (queen, topLeftX+1, topLeftY+1, cellSize-2, cellSize-2, null);
                }

            } // inner-for
        } // outer-for
    }
}