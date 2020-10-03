import java.util.*;
import java.io.*;
/**
 * Write a description of class WordCountListFile here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class WordCountListFile 
{
    public static void save(WordCountList list, String fileName) throws IOException{
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
        out.writeObject(list);
        out.close();
    }
    
    public static WordCountList load(String fileName) throws RuntimeException,Exception{
        Scanner scFile = new Scanner(System.in);
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
        WordCountList list = (WordCountList)in.readObject();
        return list;
    }
}
