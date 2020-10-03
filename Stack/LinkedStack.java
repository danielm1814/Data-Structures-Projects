
/**
 * Write a description of class LinkedStack here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LinkedStack<T> implements StackInterface<T>
{
    private LLNode<T> stack;
    private int size;
    
    
    public LinkedStack()
    {
        size = 0;
        stack = new LLNode<T>(null);
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
        return stack.getInfo();
    }
    
    // removes the object at the top of this stack 
    // and returns that object as the value of this function
    public T pop() throws StackUnderflowException
    {
        if (size == 0)
        {
            throw new StackUnderflowException("There is nothing to pop");
        }
        T info = stack.getInfo();       
        stack = stack.getLink();
        size--;
        return info;
    }
    
    // pushes an item onto the top of this stack
    public T push(T item)
    {
        LLNode<T> temp = new LLNode<T>(item);
        temp.setLink(stack);
        stack = temp;
        size++;
        return stack.getInfo();
    }      
        
    // removes all of the elements from this stack
    public void clear()
    {
        stack = new LLNode<T>(null);
        size = 0;
    }
    
    // returns the 1 based position where an object is on this stack
    // note: when the method ends, the stack is the same as it was at the start
    public int search(Object o)
    {
        LLNode<T> temp = stack;
        int num = 0;
        while (temp.getLink() != null)
        {
            if (temp.getInfo().equals(o))
            {
                return num + 1;
            }
            temp = temp.getLink();
            num++;
        }
        return -1;
    }

}
