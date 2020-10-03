/**
 * This RingBuffer object . . .
 * 
 * @author  
 * @version 
 */
public class RingBuffer 
{
    private LLNode head;
    private LLNode tail;
    private int size;
    private int capacity;
    
    public RingBuffer(int capacity)
    {
        head = null;
        tail = null;
        size = 0;
        this.capacity = capacity;
        while (!isFull())
        {
            add(0);
        }
    }

    public int size()
    {
        return size;
    }
    
    public boolean isEmpty()
    {
        return size == 0;
    }
    
    public boolean isFull()
    {
        return size == capacity;
    }
    
    public void add(double value) throws QueueOverflowException
    {
        if (isFull())
        {
            throw new QueueOverflowException("Too many items");
        }
        
        LLNode temp = new LLNode(value);
        if (head == null)
        {
            head = temp;
            tail = temp;
            size++;
        }
        else
        {
            tail.setLink(temp);
            tail = temp;
            size++;
        }
    }
    
    public double peek() throws QueueUnderflowException
    {
        if (size == 0)
        {
            throw new QueueUnderflowException("Not enough items");
        }
        return head.getInfo();
    }
    
    public double remove()
    {
        if (size == 0)
        {
            throw new QueueUnderflowException("Not enough items");
        }
        LLNode temp = head;
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
    
    // a simple test of the constructor and methods in RingBuffer
    public static void main(String[] args) 
    {
        int capacity = 100;
        RingBuffer buffer = new RingBuffer(capacity);  
        for (int i = 1; i <= capacity; i++) 
            buffer.add(i);
      
        double t = buffer.remove();
        buffer.add(t);
        System.out.println("Size after wrap-around is " + buffer.size());
        while (buffer.size() >= 2) 
        {
            double x = buffer.remove();
            double y = buffer.remove();
            buffer.add(x + y);
        }
        System.out.println(buffer.peek());
    }

}
