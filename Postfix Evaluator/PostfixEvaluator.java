import java.util.Stack;
import java.util.EmptyStackException;
/**
 * Write a description of class PostfixEvaluator here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PostfixEvaluator
{
   public static int evaluate(String expression) throws PostfixException{
      Stack<Integer> stack = new Stack<Integer>();
      String temp = "";
      for (int i = 0; i < expression.length(); i++)
      {
          if (expression.substring(i, i+1).equals(" "))
          {
              if (!temp.equals("+") && !temp.equals("/") && !temp.equals("*") && !temp.equals("-"))
              {
                  stack.push(Integer.parseInt(temp));
                }
              else if (temp.equals("+"))
              {
                  add(stack);
                }
              else if (temp.equals("-"))
              {
                  subtract(stack);
                  
                }
              else if (temp.equals("/"))
              {
                  divide(stack);
                }
              else if (temp.equals("*"))
              {
                  multiply(stack);
                }
              temp = "";
          }
          else
          {
             temp += expression.substring(i, i+1); 
            }
      }
      if (!temp.equals("+") && !temp.equals("/") && !temp.equals("*") && !temp.equals("-"))
      {
          stack.push(Integer.parseInt(temp));
      }
      else if (temp.equals("+"))
      {
          add(stack);
      }
      else if (temp.equals("-"))
      {
          subtract(stack);
      }
      else if (temp.equals("/"))
              {
          divide(stack);
      }
      else if (temp.equals("*"))
      {
          multiply(stack);
      }  
      
      if (stack.isEmpty())
      {
          throw new PostfixException("Nothing to Pop");
      }
      if(stack.size() > 1)
      {
          throw new PostfixException("To many elements remaining");
      }
      return stack.pop();
   }
   
   public static void add(Stack<Integer> stack) throws PostfixException{
       try{
           int b = stack.pop();
           int a = stack.pop();
           stack.push(a + b);
       }catch(EmptyStackException e){
           throw new PostfixException("Not enough operands");
        }
   }
   
   public static void subtract(Stack<Integer> stack) throws PostfixException{
       try{
           int b = stack.pop();
           int a = stack.pop();
           stack.push(a - b);
       }catch(EmptyStackException e){
           throw new PostfixException("Not enough operands");
        }
   }
   
   public static void multiply(Stack<Integer> stack) throws PostfixException{
       try{
           int b = stack.pop();
           int a = stack.pop();
           stack.push(a*b);
       }catch(EmptyStackException e){
           throw new PostfixException("Not enough operands");
        }
   }
   
   public static void divide(Stack<Integer> stack) throws PostfixException{
       try{
           int b = stack.pop();
           int a = stack.pop();
           stack.push(a/b);
       }catch(EmptyStackException e){
           throw new PostfixException("Not enough operands");
        }
   }    
}
