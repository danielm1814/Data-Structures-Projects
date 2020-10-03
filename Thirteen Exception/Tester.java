import java.util.Scanner;
/**
 * Write a description of class Tester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Tester
{
    public static void main(String[] args) throws ThirteenException{
        Scanner sc = new Scanner(System.in);
        boolean yes = true;
        while (yes){
            System.out.println("Input a String: ");
            String test = sc.nextLine();
           if (test.length() == 13)
           {
              throw new ThirteenException("Incorrect Input. I'm Rattled!");
           }
           else
           {
               System.out.println("That string has a length " + test.length());
            }
           }
           
        }
    }
