
/**
 * Write a description of class Tester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Tester
{
    public static void main(String[] args) throws StackUnderflowException
    {
        LinkedStack t = new LinkedStack();
        for (int i = 0; i < 10; i++)
        {
            t.push(i);
        }
        for (int i = 0; i < 10; i++)
        {
            System.out.println(t.search(i));
        }
    }
}
