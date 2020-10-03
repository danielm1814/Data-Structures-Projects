
/**
 * Write a description of class ArrayStack here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ArrayStack<T> implements StackInterface<T>
{
    private T[] stack;
    private int size;
    
    
    public ArrayStack()
    {
        size = 0;
        stack = (T[])new Object[4];
    }
    
    // returns the logical size of the stack
    public int size()
    {
        return size;
    }
    
    // tests if this stack is empty
    public boolean empty()
    {
        return size == 0;
    }
    
    // looks at the object at the top of this stack
    // without removing it from the stack
    public T peek() throws StackUnderflowException
    {
        if (size == 0)
        {
            throw new StackUnderflowException("There is nothing to peek at");
        }
        return stack[size - 1];
    }
    
    // removes the object at the top of this stack 
    // and returns that object as the value of this function
    public T pop() throws StackUnderflowException
    {
        if (size == 0)
        {
            throw new StackUnderflowException("There is nothing to pop");
        }
        T removed = stack[size - 1];
        stack[size - 1] = null;
        size--;
        if (size <= stack.length/4.0)
        {
            T[] temp = (T[])new Object[stack.length/2];
            for (int i = 0; i < size; i++)
            {
                temp[i] = stack[i];
            }
            stack = temp;
        }
        return removed;
    }
    
    // pushes an item onto the top of this stack
    public T push(T item)
    {
        if (stack.length > size)
        {
            stack[size] = item;
            size++;
        }
        if(stack.length == size)
        {
            T[] temp = (T[]) new Object[stack.length * 2];
            for (int i = 0; i < size; i++)
            {
                temp[i] = stack[i];
            }
            stack = temp;
        }
        return stack[size-1];
    }      
        
    // removes all of the elements from this stack
    public void clear()
    {
        stack = (T[]) new Object[4];
        size = 0;
    }
    
    // returns the 1 based position where an object is on this stack
    // note: when the method ends, the stack is the same as it was at the start
    public int search(Object o)
    {
        for (int i = 0; i < size; i++)
        {
            if (stack[i].equals(o))
            {
                return size - i;
            }
        }
        return -1;
    }

}
