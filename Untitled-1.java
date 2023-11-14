// Import kelas Scanner untuk input/output
import java.util.Scanner;

// Kelas Game untuk merepresentasikan objek game tebak angka
class Game {
  // Atribut game yang bersifat private
  private int angka; // angka acak yang harus ditebak
  private int kesempatan; // jumlah kesempatan yang tersisa
  private boolean menang; // status apakah pemain menang atau tidak

  // Konstruktor game dengan parameter
  public Game(int kesempatan) {
    this.angka = (int) (Math.random() * 10) + 1; // menghasilkan angka acak dari 1 sampai 10
    this.kesempatan = kesempatan; // menginisialisasi jumlah kesempatan dengan parameter
    this.menang = false; // menginisialisasi status menang dengan false
  }

  // Getter dan setter untuk atribut game
  public int getAngka() {
    return angka;
  }

  public void setAngka(int angka) {
    this.angka = angka;
  }

  public int getKesempatan() {
    return kesempatan;
  }

  public void setKesempatan(int kesempatan) {
    this.kesempatan = kesempatan;
  }

  public boolean isMenang() {
    return menang;
  }

  public void setMenang(boolean menang) {
    this.menang = menang;
  }

  // Metode displayInfo untuk menampilkan informasi game
  public void displayInfo() {
    System.out.println("Game Tebak Angka");
    System.out.println("Tebaklah angka dari 1 sampai 10");
    System.out.println("Anda memiliki " + kesempatan + " kesempatan");
    System.out.println();
  }
}

// Kelas Pemain untuk merepresentasikan objek pemain game tebak angka
class Pemain {
  // Atribut pemain yang bersifat private
  private String nama; // nama pemain
  private int tebakan; // tebakan pemain

  // Konstruktor pemain dengan parameter
  public Pemain(String nama) {
    this.nama = nama; // menginisialisasi nama dengan parameter
    this.tebakan = 0; // menginisialisasi tebakan dengan 0
  }

   // Getter dan setter untuk atribut pemain
   public String getNama() {
     return nama;
   }
 
   public void setNama(String nama) {
     this.nama = nama;
   }
 
   public int getTebakan() {
     return tebakan;
   }
 
   public void setTebakan(int tebakan) {
     this.tebakan = tebakan;
   }
 
   // Metode displayInfo untuk menampilkan informasi pemain
   public void displayInfo() {
     System.out.println("Nama Pemain: " + nama);
     System.out.println("Tebakan Pemain: " + tebakan);
     System.out.println();
   }
}

// Kelas Main untuk menjalankan game tebak angka
public class Main {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in); // membuat objek Scanner untuk input/output

    System.out.print("Masukkan nama Anda: "); // meminta input nama pemain
    String nama = input.nextLine(); // menyimpan input nama pemain

    Pemain p = new Pemain(nama); // membuat objek Pemain dengan parameter nama

    Game g = new Game(3); // membuat objek Game dengan parameter jumlah kesempatan

    g.displayInfo(); // memanggil metode displayInfo dari objek Game

    do { // melakukan perulangan selama jumlah kesempatan lebih dari 0
      System.out.print("Masukkan tebakan Anda: "); // meminta input tebakan pemain
      int tebakan = input.nextInt(); // menyimpan input tebakan pemain

      p.setTebakan(tebakan); // mengubah atribut tebakan dari objek Pemain dengan input tebakan pemain

      p.displayInfo(); // memanggil metode displayInfo dari objek Pemain

      if (p.getTebakan() == g.getAngka()) { // jika tebakan pemain sama dengan angka game
        System.out.println("Selamat, Anda berhasil menebak angka!"); // menampilkan pesan kemenangan
        g.setMenang(true); // mengubah atribut menang dari objek Game menjadi true
        break; // keluar dari perulangan
      } else if (p.getTebakan() < g.getAngka()) { // jika tebakan pemain lebih kecil dari angka game
        System.out.println("Maaf, tebakan Anda terlalu kecil"); // menampilkan pesan kesalahan
      } else if (p.getTebakan() > g.getAngka()) { // jika tebakan pemain lebih besar dari angka game
        System.out.println("Maaf, tebakan Anda terlalu besar"); // menampilkan pesan kesalahan
      }

      g.setKesempatan(g.getKesempatan() - 1); // mengurangi jumlah kesempatan dari objek Game sebanyak 1

      if (g.getKesempatan() > 0) { // jika jumlah kesempatan masih lebih dari 0
        System.out.println("Anda masih memiliki " + g.getKesempatan() + " kesempatan"); // menampilkan sisa kesempatan
      } else { // jika jumlah kesempatan habis
        System.out.println("Anda gagal menebak angka"); // menampilkan pesan kekalahan
        System.out.println("Angka yang dimaksud adalah " + g.getAngka()); // menampilkan angka yang benar
      }

      System.out.println(); // membuat baris baru

    } while (g.getKesempatan() > 0); // mengulangi selama jumlah kesempatan lebih dari 0

    input.close(); // menutup objek Scanner
  }
}
