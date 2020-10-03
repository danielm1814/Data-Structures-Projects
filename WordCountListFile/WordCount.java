import java.io.*;
/**
 * WordCount.java  
 *
 * @author:
 * Assignment #:
 * 
 * Brief Program Description:
 * 
 *
 */
public class WordCount implements Comparable<WordCount>, Serializable
{
    private String word;
    private int count;
    
    public WordCount(String w){
        word = w;
        count = 1;
    }
    
    public String getWord(){
        return word;
    }
    
    public int getCount(){
        return count;
    }
    
    public void increment(){
        count++;
    }
    
    public String toString(){
        return word + " " + count;
    }
    
    public boolean equals(WordCount other){
        return this.word.equals(other.getWord());
    }
    
    public int compareTo(WordCount other){
        return other.getCount()-count;
    }
}
