package Pertemuan10;

public class linkSLLNC {
    public int data;
    public linkSLLNC next;

    public linkSLLNC() {
    }

    public linkSLLNC(int d) {
        data = d;
        next = null;
    }

    linkSLLNC head;
    linkSLLNC bantu;

    public boolean isEmpty() {
        return head == null;
    }

    public void insertDepan(int databaru) {
        linkSLLNC baru = new linkSLLNC(databaru);
        if (isEmpty()) {
            head = baru;
        } else {
            baru.next = head;
            head = baru;
        }
    }

    public void insertBelakang(int databaru) {
        linkSLLNC baru = new linkSLLNC(databaru);
        if (isEmpty()) {
            head = baru;
        } else {
            bantu = head;
            while (bantu.next != null) {
                bantu = bantu.next;
            }
            bantu.next = baru;
        }
    }

    public void hapusDepan() {
        if (!isEmpty()) {
            if (head.next == null) {
                head = null;
            } else {
                head = head.next;
            }
        }
    }

    public void hapusBelakang() {
        if (!isEmpty()) {
            if (head.next == null) {
                head = null;
            } else {
                linkSLLNC hapus = head;
                while (hapus.next.next != null) {
                    hapus = hapus.next;
                }
                hapus.next = null;
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

    public void displaynode() {
        System.out.print(data + " ");
    }
}