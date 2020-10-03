/**
 * This GuitarString object . . .
 * 
 * @author  
 * @version 
 */
public class GuitarString 
{
    private RingBuffer buffer;
    private int ticks = 0;
    
    public GuitarString(double frequency) 
    {
        double d = 44100/frequency;
        buffer = new RingBuffer((int)(d+.5));
    }

    public GuitarString(double[] array) 
    {
        buffer = new RingBuffer(array.length);
        for (double value: array)
        {
            buffer.add(value);
        }
    }

    public void pluck() 
    {
        int size = buffer.size();
        
        for (int i = 0; i < size; i++)
        {
            buffer.remove();
            buffer.add(Math.random() -.5);
        }
    }

    // advance the simulation one time step
    public void tic() 
    {
        double first = buffer.remove();
        double second = buffer.peek();
        double avg = (first + second)/2;
        avg = avg * .994;
        buffer.add(avg);
        ticks++;
    }

    // return the current sample
    public double sample() 
    {
        return buffer.peek();
    }

    // return number of times tic was called
    public int time() 
    {
        return ticks;
    }

    public static void main(String[] args) 
    {
        double[] samples = { .2, .4, .5, .3, -.2, .4, .3, .0, -.1, -.3 };  
        GuitarString testString = new GuitarString(samples);
        for (int i = 0; i < 25; i++) 
        {
            int t = testString.time();
            double sample = testString.sample();
            System.out.printf("%6d %8.4f\n", t, sample);
            testString.tic();
        }
    }
}
