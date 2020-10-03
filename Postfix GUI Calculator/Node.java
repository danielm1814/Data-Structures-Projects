public class Node<T>
{
    private T info;
    private Node<T> link;
  
    public Node(T info)
    {
        this.info = info;
        link = null;
    }
 
    // Sets info string of this LLStringNode.
    public void setInfo(T info)
    {
        this.info = info;
    }

    // Returns info string of this LLStringNode.
    public T getInfo()
    {
        return info;
    }
 
    // Sets link of this LLStringNode.
    public void setLink(Node<T> link)
    {
        this.link = link;
    }

    // Returns link of this LLStringNode.
    public Node<T> getLink()
    {
        return link;
    }
}
 
 