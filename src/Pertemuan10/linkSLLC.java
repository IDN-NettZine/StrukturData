package Pertemuan10;

public class linkSLLC {
    public int data;
    public linkSLLC next;

    public linkSLLC() {
    }

    public linkSLLC(int d) {
        data = d;
        next = null;
    }

    linkSLLC head;
    linkSLLC bantu;

    public boolean isEmpty() {
        return head == null;
    }

    public void insertDepan(int databaru) {
        linkSLLC baru = new linkSLLC(databaru);

        if (isEmpty()) {
            head = baru;
            head.next = head;
        } else {
            if (head.next == head) {
                baru.next = head;
                head.next = baru;
                head = baru;
            } else {
                bantu = head;
                while (bantu.next != head) {
                    bantu = bantu.next;
                }
                bantu.next = baru;
                baru.next = head;
                head = baru;
            }
        }
    }

    public void insertBelakang(int databaru) {
        linkSLLC baru = new linkSLLC(databaru);
        if (isEmpty()) {
            head = baru;
            head.next = head;
        } else {
            bantu = head;
            while (bantu.next != head) {
                bantu = bantu.next;
            }
            bantu.next = baru;
            baru.next = head;
        }
    }

    public void hapusDepan() {
        if (!isEmpty()) {
            if (head.next == head) {
                head = null;
            } else {
                bantu = head;
                while (bantu.next != head) {
                    bantu = bantu.next;
                }
                head = head.next;
                bantu.next = head;
            }
        }
    }

    public void hapusBelakang() {
        if (!isEmpty()) {
            if (head.next == head) {
                head = null;
            } else {
                bantu = head;
                while (bantu.next.next != head) {
                    bantu = bantu.next;
                }
                bantu.next = head;
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

    public void displaynode() {
        System.out.print(data + " ");
    }
}