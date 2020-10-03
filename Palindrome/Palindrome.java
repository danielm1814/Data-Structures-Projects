import java.util.Stack;
/**
 * Write a description of class Palindrome here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Palindrome
{
   public static boolean isPalindrome(String s)
   {
       String str = "";
        //work with one token (word) at a time
        //punctuation marks or spaces not included
       for (int i = 0; i < s.length(); i++)
       {
           if (!s.substring(i, i+1).equals(" ") && !s.substring(i, i+1).equals(".") && !s.substring(i, i+1).equals(",")
           && !s.substring(i, i+1).equals(";") && !s.substring(i, i+1).equals(":") && !s.substring(i, i+1).equals("'")
           && !s.substring(i, i+1).equals("?") && !s.substring(i, i+1).equals("\t") && !s.substring(i, i+1).equals("\n") &&
           !s.substring(i, i+1).equals("\r"))
           {
               str = str + s.substring(i, i+1);
            }
       }
       String s2 = "";
       Stack temp = new Stack();
       for (int i = 0; i < str.length(); i++)
       {
           temp.add(str.substring(i,i+1));
        }
        for (int i = 0; i < str.length(); i++)
       {
           s2 += temp.pop();
        }
       
       return s2.equalsIgnoreCase(str);
    }

}
