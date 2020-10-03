import java.io.FileNotFoundException;
import java.util.Scanner;

public class EvilHangmanMain
{
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Pick a Category");
        System.out.println("1. Animals");
        System.out.println("2. Boy Names");
        System.out.println("3. Girl Names");
        System.out.println("4. Test");
        System.out.println("5. Dictionary");
        System.out.println("Which category number do you want to play? ");
        int cat = sc.nextInt();
        if (cat == 1)
        {
            EvilHangman evil = new EvilHangman("Animals.txt", false);
            evil.playGame();
        }
        if (cat == 2)
        {
            EvilHangman evil = new EvilHangman("Boys Names.txt", false);
            evil.playGame();
        }
        if (cat == 3)
        {
            EvilHangman evil = new EvilHangman("Girls Names.txt", false);
            evil.playGame();
        }
        if (cat == 4)
        {
            EvilHangman evil = new EvilHangman("test.txt", false);
            evil.playGame();
        }
        if (cat == 5)
        {
        EvilHangman evil = new EvilHangman("dictionary.txt", false);
        evil.playGame();
    }
    }
}
