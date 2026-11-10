package Pertemuan11;
public class dLink {
    public int data;
    public dLink next;
    public dLink previous;
    dLink head;
    dLink bantu;

    public dLink() {
    }

    public dLink(int d) {
        data = d;
        next = null;
        previous = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void insertDepan(int databaru) {
        dLink baru = new dLink(databaru);
        if (isEmpty()) {
            head = baru;
        } else {
            head.previous = baru;
            baru.next = head;
            head = baru;
        }
    }

    public void insertBelakang(int databaru) {
        dLink baru = new dLink(databaru);
        if (isEmpty()) {
            head = baru;
        } else {
            bantu = head;
            while (bantu.next != null) {
                bantu = bantu.next;
            }
            bantu.next = baru;
            baru.previous = bantu;
        }
    }

    public void hapusDepan() {
        if (!isEmpty()) {
            if (head.next != null) {
                head = head.next;
                head.previous = null;
            } else {
                head = null;
            }
        }
    }

    public void hapusBelakang() {
        if (!isEmpty()) {
            if (head.next == null) {
                head = null;
            } else {
                bantu = head;
                while (bantu.next != null) {
                    bantu = bantu.next;
                }
                bantu.previous.next = null;
                bantu.previous = null;
            }
        }
    }

    public void printDepan() {
        if (!isEmpty()) {
            bantu = head;
            while (bantu != null) {
                bantu.displaynode();
                bantu = bantu.next;
            }
        }
    }

    public void printBelakang() {
        if (!isEmpty()) {
            bantu = head;
            while (bantu.next != null) {
                bantu = bantu.next;
            }
            dLink bantu2 = bantu;
            while (bantu2 != null) {
                bantu2.displaynode();
                bantu2 = bantu2.previous;
            }
        }
    }

    public void displaynode() {
        System.out.print(data + " ");
    }
}