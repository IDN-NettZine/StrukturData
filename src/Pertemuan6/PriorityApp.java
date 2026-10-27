package Pertemuan6;

import java.io.*;

public class PriorityApp {
    public static void main(String[] args) throws IOException {
        PriorityQ thePQ = new PriorityQ(5);
        thePQ.insert(30);
        thePQ.insert(50);
        thePQ.insert(10);
        thePQ.insert(40);
        thePQ.insert(20);

        while (!thePQ.isEmpty()) {
            double item = thePQ.remove();
            System.out.print(item + " ");
        }
        System.out.println("");
    }
}