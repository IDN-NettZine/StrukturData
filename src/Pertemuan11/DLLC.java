package Pertemuan11;

public class DLLC {
    link head;
    link bantu;

    public boolean isEmpty() {
        return head == null;
    }

    public void insertDepan(int databaru) {
        link baru = new link(databaru);
        if (isEmpty()) {
            head = baru;
            head.next = head;
            head.previous = head;
        } else {
            bantu = head.previous;
            head.previous = baru;
            baru.next = head;
            head = baru;
            bantu.next = head;
            head.previous = bantu;
        }
    }

    public void insertBelakang(int databaru) {
        link baru = new link(databaru);
        if (isEmpty()) {
            head = baru;
            head.next = head;
            head.previous = head;
        } else {
            bantu = head.previous;
            bantu.next = baru;
            baru.previous = bantu;
            baru.next = head;
            head.previous = baru;
        }
    }

    public void hapusDepan() {
        if (!isEmpty()) {
            if (head.next != head) {
                bantu = head.previous;
                head = head.next;
                bantu.next = head;
                head.previous = bantu;
            } else {
                head = null;
            }
        }
    }

    public void hapusBelakang() {
        if (!isEmpty()) {
            if (head.next == head) {
                head = null;
            } else {
                bantu = head.previous;
                link hapus = bantu;
                link sebelumHapus = bantu.previous;
                
                sebelumHapus.next = head;
                head.previous = sebelumHapus;
                hapus = null;
            }
        }
    }

    public void printDepan() {
        if (!isEmpty()) {
            bantu = head;
            do {
                bantu.displaynode();
                bantu = bantu.next;
            } while (bantu != head);
        }
    }

    public void printBelakang() {
        if (!isEmpty()) {
            bantu = head.previous;
            link bantu2 = bantu;
            do {
                bantu2.displaynode();
                bantu2 = bantu2.previous;
            } while (bantu2 != bantu);
        }
    }

    public static void main(String args[]) {
        DLLC linkedlist = new DLLC();
        linkedlist.insertDepan(5);
        linkedlist.insertDepan(2);
        linkedlist.insertDepan(7);
        
        linkedlist.insertBelakang(9);
        linkedlist.printDepan();
        System.out.println();
        
        linkedlist.insertDepan(6);
        linkedlist.printBelakang();
        System.out.println();
        
        linkedlist.hapusDepan();
        linkedlist.printDepan();
        System.out.println();
        
        linkedlist.hapusBelakang();
        linkedlist.printDepan();
    }
}