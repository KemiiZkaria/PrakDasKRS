import java.util.Scanner;

public class TugasKelompokKRS {
    static String[][] dataKRS = new String[100][6]; 
    static int jumlahMahasiswa = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== Sistem KRS ===");
            System.out.println("1. Tambah KRS Mahasiswa");
            System.out.println("2. Tampilkan KRS Berdasarkan NIM");
            System.out.println("3. Analisis Mahasiswa dengan SKS < 20");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu: ");
            int menu = scanner.nextInt();
            scanner.nextLine();

            switch (menu) {
                case 1:
                    tambahKRS(scanner);
                    break;
                case 2:
                    tampilkanKRS(scanner);
                    break;
                case 3:
                    analisisSKS();
                    break;
                case 4:
                    System.out.println("Keluar dari program.");
                    return;
                default:
                    System.out.println("Menu tidak valid.");
            }
        }
    }

    public static void tambahKRS(Scanner scanner) {
        if (jumlahMahasiswa >= dataKRS.length) {
            System.out.println("Data sudah penuh, tidak bisa menambahkan lagi.");
            return;
        }

        System.out.print("Masukkan nama mahasiswa: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan NIM mahasiswa: ");
        String nim = scanner.nextLine();

        int totalSKS = hitungTotalSKS(nim);

        while (true) {
            System.out.print("Masukkan kode mata kuliah: ");
            String kodeMatkul = scanner.nextLine();
            System.out.print("Masukkan nama mata kuliah: ");
            String namaMatkul = scanner.nextLine();
            System.out.print("Masukkan jumlah SKS (1-3): ");
            int sks = scanner.nextInt();
            scanner.nextLine();

            if (sks < 1 || sks > 3) {
                System.out.println("Jumlah SKS tidak valid. Harus antara 1-3.");
                continue;
            }

            if (totalSKS + sks > 24) {
                System.out.println("Total SKS melebihi batas maksimum (24).");
                break;
            }

            dataKRS[jumlahMahasiswa][0] = nim;
            dataKRS[jumlahMahasiswa][1] = nama;
            dataKRS[jumlahMahasiswa][2] = kodeMatkul;
            dataKRS[jumlahMahasiswa][3] = namaMatkul;
            dataKRS[jumlahMahasiswa][4] = Integer.toString(sks);
            totalSKS += sks;
            dataKRS[jumlahMahasiswa][5] = Integer.toString(totalSKS);
            jumlahMahasiswa++;

            System.out.print("Tambah mata kuliah lain? (y/n): ");
            String lanjut = scanner.nextLine();
            if (!lanjut.equalsIgnoreCase("y")) {
                break;
            }
        }

        System.out.println("Data KRS berhasil ditambahkan.");
    }

    public static void tampilkanKRS(Scanner scanner) {
        System.out.print("Masukkan NIM mahasiswa: ");
        String nim = scanner.nextLine();
        boolean ditemukan = false;

        int totalSKS = 0;
        System.out.println("\nData KRS Mahasiswa:");
        for (int i = 0; i < jumlahMahasiswa; i++) {
            if (dataKRS[i][0].equals(nim)) {
                if (!ditemukan) {
                    System.out.println("Nama: " + dataKRS[i][1]);
                    System.out.println("NIM: " + dataKRS[i][0]);
                    System.out.println("Mata Kuliah:");
                    ditemukan = true;
                }

                System.out.println("- " + dataKRS[i][2] + " | " + dataKRS[i][3] + " | SKS: " + dataKRS[i][4]);
                totalSKS += Integer.parseInt(dataKRS[i][4]);
            }
        }

        if (ditemukan) {
            System.out.println("Total SKS: " + totalSKS);
        } else {
            System.out.println("Data KRS dengan NIM " + nim + " tidak ditemukan.");
        }
    }

    public static void analisisSKS() {
        boolean[] diproses = new boolean[jumlahMahasiswa];
        int jumlahMahasiswaKurangDari20 = 0;

        for (int i = 0; i < jumlahMahasiswa; i++) {
            if (diproses[i]) continue;
            String nim = dataKRS[i][0];
            int totalSKS = 0;

            for (int j = 0; j < jumlahMahasiswa; j++) {
                if (dataKRS[j][0].equals(nim)) {
                    totalSKS += Integer.parseInt(dataKRS[j][4]);
                    diproses[j] = true;
                }
            }

            if (totalSKS < 20) {
                jumlahMahasiswaKurangDari20++;
            }
        }

        System.out.println("\n------------ Analisis data KRS -------------");
        System.out.println("Jumlah mahasiswa dengan total SKS < 20: " + jumlahMahasiswaKurangDari20);
    }

    public static int hitungTotalSKS(String nim) {
        int totalSKS = 0;
        for (int i = 0; i < jumlahMahasiswa; i++) {
            if (dataKRS[i][0].equals(nim)) {
                totalSKS += Integer.parseInt(dataKRS[i][4]);
            }
        }
        return totalSKS;
    }
}
