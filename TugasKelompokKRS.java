import java.util.Scanner;
public class TugasKelompokKRS {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pilihan;
        do {
            System.out.println("\n=== Sistem Pemantauan KRS Mahasiswa ---");
            System.out.println("1. Tambahh Data KRS");
            System.out.println("2. Tampilkan Daftar KRS Mahasiswa");
            System.out.println("3. Analisis Data KRS");
            System.out.println("4. Keluar");
            System.out.print("Masukkan pilihan: ");
            pilihan = scanner.nextInt();
            switch (pilihan) {
                case 1:
                    
                    break;
                case 2:
                    
                    break;
                case 3:
                    analisisKRS();
                    break;
                case 4:
                    System.out.println("Keluar dari program.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Coba lagi.");
            }
        } while (pilihan != 4);
    }
    
    static void analisisKRS(dataKRS[]) {
        // for (int i = 0; i < array.length; i++) {
        //     int data = 0;
        //     for (int j = 0; j < array[i].length; j++) {
        //         data += array[i][j] ;
        //     }
        //     if (data < 20) {
        //         int kurang20 = 0;
        //         kurang20++;
        //     }
        // }


        int kurang20 = 0;
        for (int i = 0; i < dataKRS.length; i++){
            int a = (int) dataKRS [i][5];
            if (a < 20){
                kurang20++;
            };
        }

        System.out.println("------------ Analisis data KRS -------------");
        System.out.println("Jumlah mahasiswa yang mengambil sks dibawah 20: " + kurang20);
    }
}

