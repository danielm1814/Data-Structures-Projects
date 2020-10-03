
/**
 * Write a description of class SquareMatrix here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SquareMatrix implements SquareMatrixInterface
{
    private int[][] matrix;
    private int size;
    
    /**
     * Constructor for objects of class SquareMatrix
     * @param integer n
     */
    public SquareMatrix(int n)
    {
        matrix = new int[n][n];
        size = n;
    }
    
    /**
     * Constructor for objects of class SquareMatrix
     * @param 2D Array n
     */
    public SquareMatrix(int[][] n)
    {
        matrix = n;
        size = n.length;
    }
    
    //Returns the size (n) of the matrix
    public int getSize()
    {
        return size;
    }
    
    //Sets the value of a specific element in the array.
    public void setValue(int row, int column, int value)
    {
        matrix[row][column] = value;
    }
    
    //Gets the value of a specific element in the array.
    public int getValue(int row, int column)
    {
        return matrix[row][column];
    }
    
    //Sets all elements in the array to the given value.
    public void fillValue(int value)
    {
        for (int i = 0; i < matrix.length; i++)
        {
            for (int k = 0; k < matrix[0].length; k++)
            {
                matrix[i][k] = value;
            }
        }
    }
    
    //Sets all elements in the array to zero.
    public void makeZero()
    {
        for (int i = 0; i < size; i++)
        {
            for (int k = 0; k < size; k++)
            {
                matrix[i][k] = 0;
            }
        }
    }
    
    //Provides a text representation of the array elements.
    public String toString()
    {
        String result = "";
        for (int i = 0; i < size; i++)
        {
            for (int k = 0; k < size; k++)
            {
                result = result + matrix[i][k] + " ";
            }
        }
        return result;
    }
    
    //Adds the elements of this SquareMatrix and the other SquareMatrix 
    //together,giving the result as new SquareMatrix object.
    public SquareMatrix add(SquareMatrix other)
    {
        SquareMatrix temp = new SquareMatrix(size);
        for (int i = 0; i < size; i++)
        {
            for (int k = 0; k < size; k++)
            {
                temp.setValue(i,k,matrix[i][k] + other.getValue(i,k));
            }
        }
        return temp;
    }
    
    //Subtracts the elements of this Square Matrix from the other 
    //SquareMatrix, giving the result as a new SquareMatrix object.
    public SquareMatrix subtract(SquareMatrix other)
    {
        SquareMatrix temp = new SquareMatrix(size);
        for (int i = 0; i < size; i++)
        {
            for (int k = 0; k < size; k++)
            {
                temp.setValue(i,k,matrix[i][k] - other.getValue(i,k));
            }
        }
        return temp;
    }
    
    //Creates a new SquareMatrix object that is a copy 
    //(clone, not alias) of the existing SquareMatrix object.
    public SquareMatrix copy()
    {
        SquareMatrix temp = new SquareMatrix(size);
        for (int i = 0; i < size; i++)
        {
            for (int k = 0; k < size; k++)
            {
                temp.setValue(i,k,getValue(i,k));
            }
        }
        return temp;
    }
}
