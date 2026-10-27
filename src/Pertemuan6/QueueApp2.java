package Pertemuan6;

import java.util.Scanner;

public class QueueApp2 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // 1. Meminta input jumlah elemen yang akan dimasukkan ke queue
        System.out.print("Masukkan jumlah elemen queue: ");
        int n = input.nextInt();

        // 2. Inisialisasi object Queue dengan kapasitas sesuai input user
        Queue theQueue = new Queue(n);

        // 3. Loop untuk meminta inputan elemen dari user dan meng-insert ke queue
        System.out.println("\n--- Input Elemen Queue ---");
        for (int i = 0; i < n; i++) {
            System.out.print("Masukkan elemen ke-" + (i + 1) + ": ");
            int value = input.nextInt();
            theQueue.insert(value);
        }

        // 4. Menampilkan dan mengeluarkan elemen dari queue (FIFO)
        System.out.println("\n--- Elemen yang Dikeluarkan dari Queue ---");
        while (!theQueue.isEmpty()) {
            int element = theQueue.remove();
            System.out.print(element + " ");
        }
        System.out.println();

        input.close();
    }
}