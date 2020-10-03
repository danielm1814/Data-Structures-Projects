/**
 * This GuitarHero object . . .
 * 
 * @author  
 * @version 
 */
public class GuitarHero
{
    public static void main (String[] args)
    {
        String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
        GuitarString[] keys = new GuitarString[37];
        for (int i = 0; i < keys.length; i++)
        {
            keys[i] = new GuitarString(440 * Math.pow(1.05956, i-24));
        }

        

        // the main input loop
        while (true) 
        {
            // check if the user has typed a key, and, if so, process it
            if (StdDraw.hasNextKeyTyped()) 
            {
                // the user types this character
                char key = StdDraw.nextKeyTyped();
                for (int i = 0; i < keys.length; i++)
                {
                    if (key == keyboard.charAt(i))
                    {
                        keys[i].pluck();
                    }
                }
            }

            // compute the superposition of the samples
            double sample = 0;
            for (int i = 0; i < keys.length; i++)
            {
                sample += keys[i].sample();
            }

            // send the result to standard audio
            StdAudio.play(sample);

            // advance the simulation of each guitar string by one step
            for (int i = 0; i < keys.length; i++)
            {
                keys[i].tic();
            }
        }
    }
}
