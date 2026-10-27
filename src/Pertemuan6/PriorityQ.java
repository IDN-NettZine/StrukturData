package Pertemuan6;
import java.io.*;

public class PriorityQ {
    private int maxSize;
    private double[] queArray;
    private int nItems;

    public PriorityQ(int s) { // constructor
        maxSize = s;
        queArray = new double[maxSize];
        nItems = 0;
    }

    public void insert(double item) {
        int j;
        if (nItems == 0) {
            queArray[nItems++] = item;
        } else {
            for (j = nItems - 1; j >= 0; j--) {
                if (item > queArray[j]) {
                    queArray[j + 1] = queArray[j];
                } else {
                    break;
                }
            }
            queArray[j + 1] = item;
            nItems++;
        }
    }

    public double remove() {
        return queArray[--nItems];
    }

    public double peekMin() {
        return queArray[nItems - 1];
    }

    public boolean isEmpty() {
        return (nItems == 0);
    }

    public boolean isFull() {
        return (nItems == maxSize);
    }
}