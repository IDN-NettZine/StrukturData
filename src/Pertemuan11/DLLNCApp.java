package Pertemuan11;

public class DLLNCApp {
    public static void main(String[] args) {
        dLink link = new dLink();

        link.insertDepan(6);
        link.insertDepan(3);
        link.insertDepan(9);
        link.printDepan();
        System.out.println();
        link.printBelakang();
        
        link.insertBelakang(7);
        System.out.println();
        link.printDepan();
        
        link.hapusDepan();
        System.out.println();
        link.printDepan();
        
        link.hapusBelakang();
        System.out.println();
        link.printDepan();
    }
}