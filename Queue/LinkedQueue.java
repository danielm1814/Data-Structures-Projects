
/**
 * Write a description of class LinkedQueue here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LinkedQueue<T> implements QueueInterface<T>
{
    private LLNode<T> head;
    private LLNode<T> tail;
    private int size;
    
    public LinkedQueue()
    {
        head = null;
        tail = null;
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
        LLNode<T> temp = new LLNode<T>(item);
        if (head == null)
        {
            head = temp;
            tail = temp;
            size++;
            return tail.getInfo();
        }
        tail.setLink(temp);
        tail = temp;
        size++;
        return tail.getInfo();
    }
        
    // looks at the object at the front of this queue
    // without removing it from the queue
    public T peek() throws QueueUnderflowException
    {
        if (size == 0)
        {
            throw new QueueUnderflowException("Not enough items");
        }
        return head.getInfo();
    }
    
    // removes the object at the front of this queue 
    // and returns that object as the value of this function
    public T remove() throws QueueUnderflowException
    {
        if (size == 0)
        {
            throw new QueueUnderflowException("Not enough items");
        }
        LLNode<T> temp = head;
        if (size == 1)
        {
            head = null;
            tail = null;
            size--;
        }
        else
        {
            head = head.getLink();
            size--;
        }
        return temp.getInfo();
    }
    
    // removes all of the elements from this stack
    public void clear()
    {
        head = null;
        tail = null;
        size = 0;
    }
}
