package Rangga2555301165;

import java.util.Scanner;

// Class Node
class Pasien {

    String nama;
    String keluhan;
    int prioritas; // 1 = Kritis, 2 = Mendesak, 3 = Reguler
    Pasien next;

    public Pasien(String nama, String keluhan, int prioritas) {
        this.nama = nama;
        this.keluhan = keluhan;
        this.prioritas = prioritas;
        this.next = null;
    }
}

// Class Single Linked List Non-Circular
public class Klinik2555301165 {

    Pasien pasienPertama;
    String kodeKlinik;

    public Klinik2555301165(String nim) {
        this.kodeKlinik = nim.length() >= 3 ? nim.substring(nim.length() - 3) : nim;
    }

    public boolean isEmpty() {
        return pasienPertama == null;
    }

    // Method pasien Kritis (Prioritas 1 di paling depan) (JANGAN DIUBAH)
    public void tambahDepan(String nama, String keluhan) {
        Pasien baru = new Pasien(nama, keluhan, 1);
        baru.next = pasienPertama;
        pasienPertama = baru;

        System.out.println("Berhasil: Pasien bernama " + nama
                + ", masuk di antrean terdepan (Prioritas 1).");
    }

    // Method pasien Reguler (Prioritas 3 di paling belakang) (JANGAN DIUBAH)
    public void tambahBelakang(String nama, String keluhan) {
        Pasien baru = new Pasien(nama, keluhan, 3);

        if (pasienPertama == null) {
            pasienPertama = baru;
        } else {
            Pasien bantu = pasienPertama;

            while (bantu.next != null) {
                bantu = bantu.next;
            }

            bantu.next = baru;
        }

        System.out.println("Berhasil: Pasien " + nama
                + " masuk di antrean belakang (Prioritas 3).");
        System.out.println();
    }

    public void hapusDepan() {

        // Kondisi 1 antrean kosong
        if (pasienPertama == null) {
            System.out.println(
                    "GAGAL: Antrean kosong, tidak ada pasien untuk dipanggil.");
            return;
        }
// kondisi 2 Simpan referensi pasien terdepan, lalu geser pasienPertama ke node berikutnya
        Pasien dipanggil = pasienPertama;
        pasienPertama = pasienPertama.next;
        dipanggil.next = null; // Putuskan tautan node lama agar bersih dari rantai list

        System.out.println("PANGGILAN MASUK: Pasien " + dipanggil.nama
                + " (Prioritas " + dipanggil.prioritas
                + " | Keluhan: " + dipanggil.keluhan
                + ") silakan menuju ruang periksa.");
    }

    // Method menampilkan seluruh antrean (JANGAN DIUBAH)
    public void cetakAntrean() {

        System.out.println("\n--- DAFTAR ANTREAN KLINIK ("
                + kodeKlinik + ") ---");

        if (pasienPertama == null) {
            System.out.println("Antrean Kosong (NULL)");
            return;
        }

        Pasien bantu = pasienPertama;
        int nomerUrut = 1;

        while (bantu != null) {

            System.out.print("[" + kodeKlinik + "-" + nomerUrut
                    + " | Level" + bantu.prioritas + " | "
                    + bantu.nama + " (" + bantu.keluhan + ")] -> ");

            bantu = bantu.next;
            nomerUrut++;
        }

        System.out.println("NULL");
    }

    // Method menyisipkan pasien setelah nama yang dicari
    public void insertTengah(Scanner input) {

        while (true) {

            if (isEmpty()) {
                System.out.println("GAGAL: Linked list kosong!");
                return;
            }

            System.out.print("Sisipkan setelah nama pasien: ");
            String cariNama = input.nextLine();

            System.out.print("Masukkan nama pasien baru: ");
            String namaBaru = input.nextLine();

            System.out.print("Masukkan keluhan: ");
            String keluhanBaru = input.nextLine();

            System.out.print("Masukkan prioritas (1/2/3): ");
            
            int prioritasBaru = input.nextInt();
            input.nextLine();

            Pasien bantu = pasienPertama;

            while (bantu != null) {

                if (bantu.nama.equalsIgnoreCase(cariNama)) {

                    // Memeriksa prioritas setelah pasien yang dicari
                    if (prioritasBaru < bantu.prioritas) {

                        System.out.println("GAGAL: Prioritas pasien baru tidak sesuai!");
                        System.out.println("Silakan masukkan data kembali.\n");
                        break;
                    }

                    // Memeriksa prioritas sebelum pasien berikutnya
                    if (bantu.next != null
                            && prioritasBaru > bantu.next.prioritas) {

                        System.out.println("GAGAL: Prioritas pasien baru tidak sesuai!");
                        System.out.println("Silakan masukkan data kembali.\n");
                        break;
                    }

                    // Menyisipkan pasien baru
                    Pasien baru = new Pasien(
                            namaBaru, keluhanBaru, prioritasBaru);

                    baru.next = bantu.next;
                    bantu.next = baru;

                    System.out.println("Pasien " + namaBaru
                            + " berhasil disisipkan setelah "
                            + cariNama + ".");

                    return;
                }

                bantu = bantu.next;
            }

            // Jika nama tidak ditemukan
            if (bantu == null) {
                System.out.println("Pasien " + cariNama + " tidak ditemukan!");
                System.out.println("Silakan masukkan data kembali.\n");
            }
        }
    }

//    public void insertTengah(Scanner input) {
//
//        if (isEmpty()) {
//            System.out.println("GAGAL: Linked list kosong!");
//            return;
//        }
//
//        System.out.print("Sisipkan setelah nama pasien: ");
//        String cariNama = input.nextLine();
//
//        System.out.print("Masukkan nama pasien baru: ");
//        String namaBaru = input.nextLine();
//
//        System.out.print("Masukkan keluhan: ");
//        String keluhanBaru = input.nextLine();
//
//        System.out.print("Masukkan prioritas (1/2/3): ");
//        int prioritasBaru = input.nextInt();
//        input.nextLine();
//
//        Pasien bantu = pasienPertama;
//
//        while (bantu != null) {
//
//            if (bantu.nama.equalsIgnoreCase(cariNama)) {
//
//                Pasien baru = new Pasien(namaBaru, keluhanBaru, prioritasBaru);
//
//                baru.next = bantu.next;
//                bantu.next = baru;
//
//                System.out.println("Pasien " + namaBaru + " berhasil disisipkan setelah " + cariNama + ".");
//
//                return;
//            }
//
//            bantu = bantu.next;
//        }
//
//        System.out.println("Pasien " + cariNama + " tidak ditemukan!");
//    }
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan Nomor ID Pegawai Klinik: ");
        String nim = input.nextLine().trim();

        Klinik2555301165 klinik
                = new Klinik2555301165(nim);

        int pilihan;
        System.out.println();
        do {

            System.out.println("Menu Operasi: ");
            System.out.println("1. Tambah pasien kritis - Depan (Prioritas 1)");
            System.out.println("2. Tambah pasien reguler - Belakang (Prioritas 3)");
            System.out.println("3. Sisip pasien di tengah (Berdasarkan Prioritas 1-3)");
            System.out.println("4. Panggil pasien masuk (Hapus Depan)");
            System.out.println("5. Lihat antrean");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = input.nextInt();
            input.nextLine();
            if (pilihan == 1) {
                System.out.print("Masukan nama pasien: ");
                String namaKritis = input.nextLine();
                System.out.print("Masukan keluhan: ");
                String keluhanKritis = input.nextLine();
                klinik.tambahDepan(namaKritis, keluhanKritis);
            } else if (pilihan == 2) {
                System.out.print("Masukkan nama pasien: ");
                
                String namaReguler = input.nextLine();

                System.out.print("Masukkan keluhan: ");
                String keluhanReguler = input.nextLine();

                klinik.tambahBelakang(namaReguler, keluhanReguler);
            } else if (pilihan == 3) {
                klinik.insertTengah(input);
            } else if (pilihan == 4) {
                klinik.hapusDepan();
            } else if (pilihan == 5) {
                klinik.cetakAntrean();
            } else if (pilihan == 0) {
                System.out.println("Terima kasih, program selesai.");
            } else {
                System.out.println("Pilihan tidak tersedia Bos!");
            }
        } while (pilihan != 0);

    }
}
