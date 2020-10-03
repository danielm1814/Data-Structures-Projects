public class LLNode
{
    private double info;
    private LLNode link;
  
    public LLNode(double info)
    {
        this.info = info;
        link = null;
    }
 
    // Sets info string of this LLStringNode.
    public void setInfo(double info)
    {
        this.info = info;
    }

    // Returns info string of this LLStringNode.
    public double getInfo()
    {
        return info;
    }
 
    // Sets link of this LLStringNode.
    public void setLink(LLNode link)
    {
        this.link = link;
    }

    // Returns link of this LLStringNode.
    public LLNode getLink()
    {
        return link;
    }
}
 
 