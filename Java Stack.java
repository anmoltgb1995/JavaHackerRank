import java.util.*;
import java.lang.Character;

class Node{
    public Character data;
    public Node next;
}


class Stack{
    private Node top;
    
    Stack(){
        top = null;
    }
    
    public void push(Character data){
        Node newNode = new Node();
        newNode.data=data;
        newNode.next = top;
        top = newNode;
    }
    
    public Character pop(){
        if(isStackEmpty()){
            return null;
        }
        Character data = top.data;
        top = top.next;
        return data;
    }
    
    public boolean isStackEmpty(){
        return top==null;
    }
    
    public void popStack(){
        while(!isStackEmpty()){
            Character data = pop();
            System.out.println(data.charValue());
        }
    }
    
}

class Solution{
   
   public static void main(String []argh)
   {
      Scanner sc = new Scanner(System.in);
      
      while (sc.hasNext()) {
         String input=sc.next();
            //Complete the code
          Stack stack = new Stack();
          boolean validString= true;
          char c;
          for(int i=0;i<input.length();i++){
          c = input.charAt(i);
          if(c=='(' || c=='{' || c=='[')
              stack.push(new Character(c));
          else{
             Character xChar = stack.pop();
              if(xChar==null){
                  System.out.println("false");
                      validString = false;
                      break;
              }
              char x=xChar.charValue();
              if(c==')'&&x=='('){}
              else if(c=='}'&&x=='{'){}
              else if(c==']'&&x=='['){}
                  else{
                      System.out.println("false");
                      validString = false;
                      break;
                  }
          }
          }
          if(validString) 
              System.out.println(stack.isStackEmpty() ? "true" : "false");
      }
      
   }
}
