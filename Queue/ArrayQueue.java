/**
 * Write a description of class ArrayQueue here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ArrayQueue<T> implements QueueInterface<T>
{
    private int head = 0;
    private int tail = -1;
    private int size = 0;
    private T[] q;
    
    public ArrayQueue()
    {
        q = (T[])new Object[4];  
    }
    
    // returns the logical size of the queue
    public int size()
    {
        return size;
    }
    
    // tests if this queue is empty
    public boolean empty()
    {
        return size == 0;
    }
    
    // adds an item onto the rear of this queue
    public T add(T item)
    {
        if (size == q.length)
        {
            T[] temp = (T[])new Object[size * 2];
            int t = 0;
            for (int i = head; i < q.length; i++)
            {
                temp[t] = q[i];
                t++;
            }
            for (int i = 0; i < tail; i++)
            {
                temp[t] = q[i];
                t++;
            }
            head = 0;
            tail = size - 1;
            q = temp;
        }
        q[tail + 1] = item;
        tail++;
        size++;
        if (tail == q.length - 1)
        {
            tail = -1;
        }
        return item;
    }
        
    // looks at the object at the front of this queue
    // without removing it from the queue
    public T peek() throws QueueUnderflowException
    {
        if (size == 0)
        {
            throw new QueueUnderflowException("Not enough items");
        }
        return q[head];
    }
    
    // removes the object at the front of this queue 
    // and returns that object as the value of this function
    public T remove() throws QueueUnderflowException
    {
        if (size == 0)
        {
            throw new QueueUnderflowException("Not enough items");
        }
        if (tail >= q.length)
        {
            tail = -1;
        }
        T temp = q[head];
        q[head] = null;
        head++;
        size--;
        if (head >= q.length)
        {
            head = 0;
        }
        if (size == 0)
        {
            head = 0;
            tail = -1;
        }
        
        return temp;
    }
    
    
    // removes all of the elements from this stack
    public void clear()
    {
        q = (T[])new Object[4]; 
        head = 0;
        tail = -1;
        size = 0;
    }
}
