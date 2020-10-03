
/**
 * Write a description of class IncDate here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class IncDate
{
    private Date first;
    private int days;
    
    public IncDate(int m, int d, int y)
    {
        first = new Date (m, d, y);
    }
    
    public void increment()
    {
        days = first.lilian();
        days++;
        first = first.inverseLilian(days);
    }
    
    public void increment(int day)
    {
        days = first.lilian();
        days += day;
        first = first.inverseLilian(days);
    }
    
    public String toString()
    {
        return first.toString();
    }
}
