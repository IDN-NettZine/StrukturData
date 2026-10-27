package Pertemuan3;
public class StackAr {
    private int maxSize;
    private char[] stackArray;
    private int top;
    public StackAr(int s){
        maxSize = s;
        stackArray = new char[maxSize];
        top = -1;
    }  
    public void push(char j){
        stackArray[++top] = j;
    }
    public char pop(){
        return stackArray[top--];
    }
    public double peek(){
        return stackArray[top];
    }
    public boolean isEmpty(){
        return (top == -1);
    }
    public boolean isFull(){
        return (top== maxSize-1);
    }
    public int size(){
        return top+1;
    }
    public char peekN(int n){
        return stackArray[n];
    }
    public void displayStack(String s){
        System.out.println(s);
        System.out.println("Stack (Bottom-->top): "  );
        for (int j = 0; j < size(); j++) {
            System.out.print(peekN(j));
            System.out.print("");
        }
        System.out.println("");
    }
    public void tampilStack(){
        while( !isEmpty()){
            char value = pop();
            System.out.print(value);
            System.out.print(" ");
        }
    }
}
// end class stackAr
class stackArApp{
    public static void main(String[] args) {
        StackAr theStack = new StackAr(10);
        theStack.push('p');
        theStack.push('b');
        theStack.push('6');
        theStack.push('0');       
        System.out.println("");
        theStack.tampilStack();
        System.out.println("");
    }
 
}
