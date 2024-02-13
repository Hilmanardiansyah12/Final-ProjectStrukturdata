package tubesdata;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

record Peserta(String nama, String email, String password) {}

record Tiket(String kategori, int harga, int jumlahTersedia) {
 public Tiket withJumlahTersedia(int newJumlahTersedia) {
        return new Tiket(kategori, harga, newJumlahTersedia);
    }
}

class Transaksi implements Comparable<Transaksi> {
    private final Peserta peserta;
    private final Tiket tiket;
    private final int jumlahPesan;
    private final int totalHarga;

    public Transaksi(Peserta peserta, Tiket tiket, int jumlahPesan) {
        this.peserta = peserta;
        this.tiket = tiket;
        this.jumlahPesan = jumlahPesan;
        this.totalHarga = tiket.harga() * jumlahPesan;
    }

    public Peserta getPeserta() {
        return peserta;
    }

    public Tiket getTiket() {
        return tiket;
    }

    public int getJumlahPesan() {
        return jumlahPesan;
    }

    public int getTotalHarga() {
        return totalHarga;
    }

    @Override
    public int compareTo(Transaksi other) {
        return Integer.compare(other.getTotalHarga(), this.getTotalHarga());
    }
}

class RiwayatTransaksi {
    private final LinkedList<Transaksi> daftarTransaksi;

    public RiwayatTransaksi() {
        this.daftarTransaksi = new LinkedList<>();
    }

    public void tambahTransaksi(Transaksi transaksi) {
        daftarTransaksi.add(transaksi);
    }

    public LinkedList<Transaksi> getDaftarTransaksi() {
        return daftarTransaksi;
    }
}

class Konser {
    private final String nama;
    private final String tanggal;
    private final ArrayList<Tiket> daftarTiket;
    private final Stack<Band> daftarBand;

    public Konser(String nama, String tanggal) {
        this.nama = nama;
        this.tanggal = tanggal;
        this.daftarTiket = new ArrayList<>();
        this.daftarBand = new Stack<>();
    }

    public String getNama() {
        return nama;
    }

    public String getTanggal() {
        return tanggal;
    }

    public ArrayList<Tiket> getDaftarTiket() {
        return daftarTiket;
    }

    public Stack<Band> getDaftarBand() {
        return daftarBand;
    }

    public void tambahTiket(Tiket tiket) {
        daftarTiket.add(tiket);
    }

    public void tambahBand(Band band) {
        daftarBand.push(band);
    }
}

class Band {
    private final String nama;

    public Band(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }
}

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Peserta peserta = login(scanner);
            
            System.out.println("===========================================================");
            Konser konser = new Konser("Konser Musik Spektakuler", "01 Maret 2024");

            Band band1 = new Band("Hindia");
            Band band2 = new Band("Coldplay");
            Band band3 = new Band("BMTH");

            konser.tambahBand(band1);
            konser.tambahBand(band2);
            konser.tambahBand(band3);

            Tiket tiketGold = new Tiket("Gold", 500000, 50);
            Tiket tiketSilver = new Tiket("Silver", 300000, 100);
            Tiket tiketBronze = new Tiket("Bronze", 150000, 200);

            konser.tambahTiket(tiketGold);
            konser.tambahTiket(tiketSilver);
            konser.tambahTiket(tiketBronze);

            RiwayatTransaksi riwayatTransaksi = new RiwayatTransaksi();

            boolean lanjutPemesanan = true;
            while (lanjutPemesanan) {
                System.out.println("Informasi Konser: " + konser.getNama() + ", Tanggal: " + konser.getTanggal());
                System.out.println("Daftar Band:");
                for (Band band : konser.getDaftarBand()) {
                    System.out.println(band.getNama());
                }

                System.out.print("Masukkan nama band yang ingin dipesan tiketnya: ");
                String namaBand = scanner.nextLine();

                Band bandPesan = null;
                for (Band band : konser.getDaftarBand()) {
                    if (band.getNama().equalsIgnoreCase(namaBand)) {
                        bandPesan = band;
                        break;
                    }
                }

                if (bandPesan != null) {
                    System.out.println("Daftar Tiket:");
                    for (Tiket tiket : konser.getDaftarTiket()) {
                        System.out.println(tiket.kategori() + ": Harga " + tiket.harga() + ", Tersedia " + tiket.jumlahTersedia());
                    }

                    System.out.print("Masukkan kategori tiket yang ingin dipesan (Gold/Silver/Bronze): ");
                    String kategori = scanner.nextLine();

                    boolean kategoriValid = false;
                    while (!kategoriValid) {
                        if (kategori.equalsIgnoreCase("Gold") || kategori.equalsIgnoreCase("Silver") || kategori.equalsIgnoreCase("Bronze")) {
                            kategoriValid = true;
                        } else {
                            System.out.println("Kategori tiket tidak valid. Silakan masukkan kembali (Gold/Silver/Bronze): ");
                            kategori = scanner.nextLine();
                        }
                    }

                    System.out.print("Masukkan jumlah tiket yang ingin dipesan: ");
                    int jumlahPesan = scanner.nextInt();
                    scanner.nextLine(); 

                    Tiket tiketPesan = null;
                    for (Tiket tiket : konser.getDaftarTiket()) {
                        if (tiket.kategori().equalsIgnoreCase(kategori)) {
                            tiketPesan = tiket;
                            break;
                        }
                    }

                    if (tiketPesan != null) {
                        Transaksi transaksi = new Transaksi(peserta, tiketPesan, jumlahPesan);
                        if (jumlahPesan <= tiketPesan.jumlahTersedia()) {
                          tiketPesan = tiketPesan.withJumlahTersedia(tiketPesan.jumlahTersedia() - jumlahPesan);
                            riwayatTransaksi.tambahTransaksi(transaksi);
                            System.out.println("Pemesanan berhasil!");
                            System.out.println("Total Harga: " + transaksi.getTotalHarga());
                            System.out.println("Terima kasih, " + peserta.nama() + "!");
                        } else {
                            System.out.println("Maaf, jumlah tiket yang tersedia tidak mencukupi.");
                        }
                    } else {
                        System.out.println("Kategori tiket tidak valid.");
                    }
                } else {
                    System.out.println("Nama band tidak valid.");
                }

                System.out.print("Apakah ingin melanjutkan pemesanan? (y/n): ");
                String jawaban = scanner.nextLine();
                lanjutPemesanan = jawaban.equalsIgnoreCase("y");
            }

            // Menampilkan riwayat transaksi
            System.out.println("Riwayat Transaksi : ");
            PriorityQueue<Transaksi> priorityQueue = new PriorityQueue<>(riwayatTransaksi.getDaftarTransaksi());
            while (!priorityQueue.isEmpty()) {
                Transaksi transaksi = priorityQueue.poll();
                System.out.println("Peserta: " + transaksi.getPeserta().nama());
                System.out.println("Kategori Tiket: " + transaksi.getTiket().kategori());
                System.out.println("Jumlah: " + transaksi.getJumlahPesan());
                System.out.println("Total Harga: " + transaksi.getTotalHarga());
            }
        }
    }

    private static Peserta login(Scanner scanner) {
        System.out.println("=== Login ===");
        while (true) {
            System.out.print("Email: ");
            String email = scanner.nextLine();
            System.out.print("Password: ");
            String password = scanner.nextLine();

            
            if (email.equals("admin@gmail.com") && password.equals("admin123")) {
                System.out.println("Login berhasil!");
                System.out.print("Nama peserta: ");
                String namaPeserta = scanner.nextLine();
                return new Peserta(namaPeserta, email, password);
            } else {
                System.out.println("Email atau password salah. Silakan coba lagi.");
            }
        }
    }
}
