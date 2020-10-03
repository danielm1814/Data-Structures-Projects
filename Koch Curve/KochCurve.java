/**
 * Write a description of class KochCurve here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class KochCurve
{
    StandardPen pen = new StandardPen();
    public void center()
    {
        pen.home();
    }
    
    
    public void drawKC(int level, int length, int d)
    {
        pen.down();
        if (level == 0)
        {
            pen.setDirection(d);
            pen.move(length);
        }
        else
        {
            pen.setDirection(0);
            drawKC(level - 1, length/3, d);
            pen.setDirection(60);
            drawKC(level - 1, length/3, d + 60);
            pen.setDirection(300);
            drawKC(level - 1, length/3, d + 300);
            pen.setDirection(0);
            drawKC(level - 1, length/3, d);
        }
    }
}
