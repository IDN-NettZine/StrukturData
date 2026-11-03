package Pertemuan10;
public class SLLNC {

    public static void main(String args[]) {
        linkSLLNC linkedlist = new linkSLLNC();
        linkedlist.insertDepan(5);
        linkedlist.insertDepan(2);
        linkedlist.insertDepan(7);
        linkedlist.insertBelakang(9);
        linkedlist.printDepan();
        System.out.println();
        linkedlist.insertDepan(6);
        System.out.println();
        linkedlist.printDepan();
        linkedlist.hapusDepan();
        System.out.println();
        linkedlist.printDepan();
        linkedlist.hapusBelakang();
        System.out.println();
        linkedlist.printDepan();
        linkedlist.insertBelakang(4);
        System.out.println();
        linkedlist.printDepan();
    }
}