import java.util.Scanner;
/**
 * Write a description of class Game here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Game
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int size = 0;
        while (size > 9 || size < 3)
        {
        System.out.println("How big do you want the board to be?(2 = 2x2 board)");
        size = sc.nextInt();
        if (size > 9 || size < 3)
        {
            System.out.println("That size is invalid.");
        }
    }
        Board b = new Board(size);
        b.go();
    }
}
