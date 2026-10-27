package Pertemuan3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class StackTriangleApp2 {
    static int theNumber;
    static int theAnswer;
    static StackX2 theStack;
    public static void main(String[] args) throws IOException {
        System.out.println("Masukan bilangan : ");
        System.out.flush();
        theNumber = getInt();
        StackTriangle();
        System.out.println("Bilangan segitiga phytagoras = " + theAnswer);
    }
    public static int getInt() throws IOException {
        String s = getString();
        return Integer.parseInt(s);
    }
    public static void StackTriangle() {
        theStack = new StackX2(10000);
        theAnswer = 0;
        while (theNumber > 0) {
            theStack.push(theNumber);
            --theNumber;
        }
        while (!theStack.isEmpty()) {
            int newN = theStack.pop();
            theAnswer += newN;
        }
    }
    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }  
}
