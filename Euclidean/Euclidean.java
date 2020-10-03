/**
 * This class represents the Euclidean algoritm for calculating
 * the Greatest Common Divisor of two integers, using both recursive
 * and iterative solutions.
 * 
 * @author 
 * @version 
 */
public class Euclidean
{
    // complete the recursive version below
    public static int gcdRecursive(int m, int n)
    {
        if (m < n)
        {
            int temp = m;
            m = n;
            n = temp;
        }
        if (m % n == 0)
        {
            return n;
        }
        return gcdRecursive(n, m % n);    
    }

    // complete the iterative version below
    public static int gcdIterative(int m, int n)
    {
        while (m % n != 0)
        {
            if (m < n)
            {
            int temp = m;
            m = n;
            n = temp % n;
            }
            int temp = m;
            m = n;
            n = temp % n; 
        }
        return n;
    }
}
