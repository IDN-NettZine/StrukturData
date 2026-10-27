package Pertemuan6;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
public class Antrian {
    private static int ukuran;
    private static Queue<Integer>queue;
    public static void main(String[] args) {
        System.out.println("Berapa ukuran QUEUE diinginkan : ");
        ukuran = inputData();
        buatQueue();
        bacaData();
        tulisData();
    }
    private static void bacaData(){
        Integer data;
        for (int i = 0; i < ukuran; i++) {
            System.out.println("Data ke-" + (i+1) + " : ");
            data = inputData();
            queue.add(data);
        }
        data = queue.size();
        System.out.println("Ukuran QUEUE sekarang adalah " + data);
    }
    
    private static void buatQueue(){
        queue = new LinkedList<>();
    }
    
    private static int inputData(){
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        String angkaInput = null;
        try {
            angkaInput=bfr.readLine();
        }catch(IOException e){
            e.printStackTrace();
        }
        int Data = Integer.valueOf(angkaInput).intValue();
        return Data;
    }
    private static void tulisData(){
        Integer data;
        System.out.println("\n Urutan keluar elemen dari QUEUE : ");
        for (int i = 0; i < ukuran; i++) {
            data = queue.remove();
            System.out.println("Data ke- "+ (i+1) + " : " + data); 
        }
        data = queue.size();
        System.out.println("Ukuran QUEUE sekarang adalah " + data);
    }
}
