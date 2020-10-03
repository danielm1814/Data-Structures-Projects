
/**
 * This ArrayStringLog object represents a StringLog ADT implemented as
 * a String array using the EnhancedStringLogInterface.
 * 
 * @author  
 * @version 
 */
public class ArrayStringLog implements EnhancedStringLogInterface
{
    // Instance variables
    private String[] log;
    private String name;
    private int size;
    
    // Create a new String array with a capacity of 4 elements
    // and assign values to instance variables.
    public ArrayStringLog(String name)
    {
        this.name = name;
        log = new String[4];
        size = 0;
    }

    // Returns the name of this StringLog.
    public String getName()
    {
        return name;
    }

    // Returns the logical size of this StringLog.
    public int size()
    {
        return size;
    }
    
    // Returns true if this list contains no elements.
    public boolean isEmpty()
    {
        return size() == 0;
    }
    
    // Returns true if this list is completely full.
    public boolean isFull()
    {
        return size() == log.length;
    }

    // Appends the specified element to the end of this list.
    public void add(String element)
    {
        if (isFull())
        {
            String[] temp = new String[size*2];
            for (int i = 0; i < log.length; i++)
            {
                temp[i] = log[i];
            }
            log = temp;
        }
        for (int i = 0; i < log.length; i++)
           {
               if (log[i] == null)
               {
                   log[i] = element;
                   size++;
                   break;
                }
            }
    }
  
    // Returns the element at the specified position in this list.
    public String get(int index)
    {
        return log[index];
    }
    
    // Returns the index of the first occurance of the specified element
    // in this list, or -1 if this list does not contain the element.
    public int indexOf(String element)
    {
        int slot = -1;
        for (int i = 0; i < log.length; i++)
        {
            if (log[i] != null && log[i].equals(element))
            {
                slot = i;
                break;
            }
        }
        return slot;
    }
    
    // Returns true if this list contains the specified element.
    public boolean contains(String element)
    {
        for (int i = 0; i < log.length; i++)
        {
            if (log[i] != null && log[i].equals(element))
            {
                return true;
            }
        }
        return false;
    }
    
    // Returns a formatted string representation of this StringLog.
    public String toString()
    {
        String result = "Log: " + name + "\n";
        for (int i = 0; i < size; i++)
        {
            result += (i + 1) + ". " + log[i] + "\n";
        }
        return result;
    }
    
    // Replaces the element at the specified position in this list
    // with the specified element.  Returns what was at that location
    public String set(int index, String element)
    {
        String former = log[index];
        log[index] = element;
        return former;
    }
    
    // Inserts the specified element at the specified position in this list.
    public void add(int index, String element)
    {
        if (isFull())
        {
            String[] temp = new String[size*2];
            for (int i = 0; i < log.length; i++)
            {
                temp[i] = log[i];
            }
            log = temp;
        }
        for (int i = size + 1; i > index; i--)
           {
               log[i] = log[i-1];
            }
        log[index] = element;
        size++;
    }
    
    // Removes the element at the specified position in this list, and
    // returns the element that was removed.  Any unused array elements
    // are set to null.
    public String remove(int index)
    {
        String removed = log[index];
        for (int i = index; i < log.length - 1; i++)
        {
            log[i] = log[i + 1];
        }
        log[log.length - 1] = null;
        size--;
        if(size <= log.length / 4)
        {
            String[] temp = new String[log.length/2];
            for (int i = 0; i < size; i++)
            {
                temp[i] = log[i];
            }
            log = temp;
        }
        return removed;
    }
    
    // Removes the first occurance of the specified element from this
    // list, if it is present.  Returns true if element was found (and 
    // removed), false otherwise.
    public boolean remove(String element)
    {
        int index = -1;
        for (int i = 0; i < log.length; i++)
        {
            if (log[i] != null && log[i].equals(element))
            {
                index = i;
                break;
            }
        }
        if (index > -1)
        {
        String r = remove(index);
        }
        return index > -1;
    }
    
    // Removes all of the elements from this list.
    public void clear()
    {
        while(size > 0)
        {
            log[size] = null;
            size--;
        }
        log = new String[4];
    }
}
