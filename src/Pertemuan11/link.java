package Pertemuan11;
public class link {
    public int data;
    public link next;
    public link previous;

    public link(int d) {
        data = d;
        next = null;
        previous = null;
    }

    public void displaynode() {
        System.out.print(data + " ");
    }
}