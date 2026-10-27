package Pertemuan9;

import javax.swing.JOptionPane;

public class IteratifFibonacci {

    public static void main(String[] args) {
        int bil;
        bil = Integer.parseInt(JOptionPane.showInputDialog("Masukan Jumlah Deret : "));
        int f1 = 1, f2 = 1, fibo;
        for (int i = 0; i < bil; i++) {
            if (i == 0 || i == 1) {
                fibo = f1;
            } else {
                fibo = f1 + f2;
                f2 = f1;
                f1 = fibo;
            }
            System.out.print(" " + fibo);
        }
    }
}
