
/**
 * This LinkedLog object represents a Log ADT implemented as
 * a LinkedList using the EnhancedLogInterface.
 * 
 * @author 
 * @version 
 */
public class LinkedLog<T> implements EnhancedLogInterface<T>
{
    private LLNode<T> log;
    private String name;
    private int size;

    public LinkedLog(String name)
    {
        this.name = name;
        size = 0;
        log = null;
    }
    
    // returns the name of this StringLog
    public String getName()
    {
        return name;
    }

    // returns the logical size of this StringLog
    public int size()
    {
        return size;
    }
    
    // returns true if this list contains no elements
    public boolean isEmpty()
    {
        return size == 0;
    }
    
    // returns true if this list is completely full
    public boolean isFull()
    {
        return false;
    }

    // appends the specified element to the end of this list
    public void add(T element)
    {
        LLNode temp = log;
        if (log == null)
        {
            log = new LLNode(element);
        }
        else
        {
            while(temp.getLink() != null)
            {
                temp = temp.getLink();
            }   
            temp.setLink(new LLNode(element));
        }
        size++;
    }
  
    // returns the element at the specified position in this list
    public T get(int index)
    {
        LLNode temp = log;
        for (int i = 0; i < index; i++)
        {
            temp = temp.getLink();
        }
        return (T)temp.getInfo();
    }
    
    // returns the index of the first occurance of the specified element
    // in this list, or -1 if this list does not contain the element
    public int indexOf(T element)
    {
        int num = 0;
        LLNode temp = log;
        while (temp != null)
        {
            if (temp.getInfo().equals(element))
            {
                return num;
            }
            temp = temp.getLink();
            num++;
        }
        return -1;
    }
    
    // returns true if this list contains the specified element
    public boolean contains(T element)
    {
        LLNode temp = log;
        while (temp.getLink() != null)
        {
            if (temp.getInfo().equals(element))
            {
                return true;
            }
            temp = temp.getLink();
        }
        if (temp.getInfo().equals(element))
        {
            return true;
        }
        return false;
    }
    
    // returns a formatted string representation of this StringLog
    public String toString()
    {
        String result = "Log: " + name + "\n";
        LLNode<T> curNode = log;
        int count = 0;
    
        while (curNode != null)
        {
            count++;
            result += count + ". " + curNode.getInfo() + "\n";
            curNode = curNode.getLink();
        }
        return result;
    }
    
    // replaces the element at the specified position in this list
    // with the specified element
    public T set(int index, T element)
    {
        LLNode temp = log;
        LLNode temps = new LLNode(element);
        for (int i = 0; i < index - 1; i++)
        {
            temp = temp.getLink();
        }
        T elements = (T)temp.getLink().getInfo();
        temps.setLink(temp.getLink().getLink());
        temp.setLink(temps);
        return elements;
    }
    
    // inserts the specified element at the specified position in this list
    public void add(int index, T element)
    {
        LLNode temp = log;
        LLNode temps = new LLNode(element);
        int num = 0;
        for (int i = 0; i < index - 1; i++)
        {
            temp = temp.getLink();
        }
        temps.setLink(temp.getLink());
        temp.setLink(temps);
        size++;
    }
    
    // removes the element at the specified position in this list
    public T remove(int index)
    {
        LLNode temp = log;
        if (index == 0)
        {
            T element = log.getInfo();
            log = log.getLink();
            size--;
            return element;
        }   
        for (int i = 0; i < index - 1; i++)
        {
            temp = temp.getLink();
        }
        T element = (T)temp.getLink().getInfo();
        temp.setLink(temp.getLink().getLink());
        size--;
        return element;
    }
    
    // removes the first occurance of the specified element from this
    // list, if it is present
    public boolean remove(T element)
    {
        if (contains(element))
        {
            remove(indexOf(element));
            return true;
        }
        return false;
    }
        
    // removes all of the elements from this list
    public void clear()
    {
        log = new LLNode(log.getInfo());
        size = 0;
    }
}
