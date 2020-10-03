import java.io.*;
/**
 * WordCountList.java  
 *
 * @author:
 * Assignment #:
 * 
 * Brief Program Description:
 * 
 *
 */
public class WordCountList implements Serializable
{
    private int size;
    private WordCount[] list;
    
    public String toString(){
        String str = "";
        for(int i = 0; i < size; i++){
            str+= list[i]+"\n";
        }
        return str;
    }
    
    public WordCountList(){
        size = 0;
        list = new WordCount[4];
    }
    
    public int size(){
        return size;
    }
    
    public boolean isFull(){
        return size==list.length;
    }
    
    public void add(String word){
        if(isFull()){
            WordCount[] temp = new WordCount[list.length];
            for(int i = 0; i < size; i++){
                temp[i] = list[i];
            }
            list = new WordCount[size*2];
            for(int i = 0; i < size; i++){
                list[i] = temp[i];
            }
        }
        WordCount temp = new WordCount(word);
        boolean yes = true;
        for(int i = 0; i < size; i++){
            if(list[i].equals(temp)){
                list[i].increment();
                yes = false;
            }
        }
        if(yes) {
            list[size] = temp;
            size++;
        }
    }
    
    public WordCount get(int index){
        return list[index];
    }
    
    public void rank(){
        for (int i = 1; i < size; ++i) { 
            WordCount temp = list[i]; 
            int j = i - 1; 
            while (j >= 0 && list[j].compareTo(temp)>0) { 
                list[j + 1] = list[j]; 
                j = j - 1; 
            } 
            list[j + 1] = temp;
        } 
    }
}
