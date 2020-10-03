
/**
 * Write a description of interface SquareMatrixInterface here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public interface SquareMatrixInterface
{
    //Returns the size (n) of the matrix
    int getSize();
    
    //Sets the value of a specific element in the array.
    void setValue(int row, int column, int value);
    
    //Gets the value of a specific element in the array.
    int getValue(int row, int column);
    
    //Sets all elements in the array to the given value.
    void fillValue(int value);
    
    //Sets all elements in the array to zero.
    void makeZero();
    
    //Provides a text representation of the array elements.
    String toString();
    
    //Adds the elements of this SquareMatrix and the other SquareMatrix 
    //together,giving the result as new SquareMatrix object.
    SquareMatrix add(SquareMatrix one);
    
    //Subtracts the elements of this Square Matrix from the other 
    //SquareMatrix, giving the result as a new SquareMatrix object.
    SquareMatrix subtract(SquareMatrix one);
    
    //Creates a new SquareMatrix object that is a copy 
    //(clone, not alias) of the existing SquareMatrix object.
    SquareMatrix copy();
}
