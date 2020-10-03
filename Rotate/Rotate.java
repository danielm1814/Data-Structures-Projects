
/**
 * Rotate.java  
 *
 * @author:
 * Assignment #:
 * 
 * Brief Program Description:
 * 
 *
 */
public class Rotate
{
    public Rotate ()
    {
        
    }
    
    public static int[][] rotateArray(int[][] size)
    {
        int[][] arr = new int[size.length][size.length];
        for (int i = 0; i < size.length; i++)
        {
            for (int n = 0; n < size.length; n++)
            {
                arr[i][n] = size[size.length - n - 1][i];
            }   
        }
       return arr;
    }
}
