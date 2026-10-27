package Pertemuan3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
public class Tumpukan {
    private static Stack<Integer> stack;
    private static int ukuran; 
    public static void main(String[] args) {
        System.out.println("Berapa ukuran STACK yang diinginkan ? ");
        ukuran = inputData();
        buatStack(ukuran);
        bacaData();
        tulisData();
    }
    private static void buatStack(int ukuran) {
        stack = new Stack<Integer>();
    }
    private static void bacaData() {
        int data;
        System.out.println("Masukan nilai nilai stack : ");
        for (int i = 0; i < ukuran; i++) {
            System.out.println("Data ke-" + (i + 1) + " : ");
            data = inputData();
            stack.push(data);
        }
    }
    private static void tulisData(){
        System.out.println("Isi Stack adalah (menggunakan prosedur POP) : ");
        int dataStack;
        for (int i = 0; i < ukuran; i++) {
            dataStack = stack.pop();
            System.out.println("Nilainya = " + dataStack);
        }
    }
    private static Integer inputData(){
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        String angkaInput = null;
        try {
            angkaInput = bfr.readLine();
        }catch (IOException e){
            e.printStackTrace();
        }
        int Data = Integer.valueOf(angkaInput).intValue();
        return Data;
    }
}
