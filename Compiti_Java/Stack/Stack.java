package Compiti_Java.Stack;
import java.util.ArrayList;

public class Stack {
    public ArrayList<Object> stack;

    public Stack(){
         this.stack = new ArrayList<>();
    }

    public void push(Object elemento){
        stack.add(elemento);
    }

    public Object pop(){
        if (stack.size() == 0)
            return null;

        return stack.remove(stack.size()-1);
    }

    public int getCount(){
        return stack.size();
    }

    public static void main(String[] args){
        Stack stack = new Stack();

        stack.push("Diego");
        stack.push("Cipriettti");

        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }

}
