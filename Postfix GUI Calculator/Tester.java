
/**
 * Write a description of class Tester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Tester
{
    public static void main(String[] args)
    {
        PostfixEvaluator e = new PostfixEvaluator();
        System.out.println(e.isInteger("10"));
        System.out.println(e.isInteger("hi"));
        System.out.println(e.isInteger("1"));
        System.out.println(e.isInteger("2"));
        
    }
}
