
/**
 * Write a description of class tester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class tester
{
    public static void main(String[] args)
    {
        ArrayQueue q = new ArrayQueue<Integer>();
        q.add(1);
        System.out.println(q.peek());
        q.add(2);
        System.out.println(q.peek());
        q.add(3);
        System.out.println(q.peek());
        q.add(4);
        System.out.println(q.peek());
        q = new ArrayQueue<Integer>();
        for (int i = 1; i < 17; i++)
        {
            q.add(i);
        }
        for (int i = 0; i < 16; i++)
        {
            System.out.println(q.remove());
        }
    }
}
