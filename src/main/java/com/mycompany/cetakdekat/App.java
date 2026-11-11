
package com.mycompany.cetakdekat;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        TempatFotocopy tempat1 = new TempatFotocopy(
                "Fotocopy A",
                "Sekitar Universitas Lampung",
                "Belum tersedia",
                200, 500, 300
        );

        TempatFotocopy tempat2 = new TempatFotocopy(
                "Fotocopy B",
                "Sekitar Universitas Lampung",
                "Belum tersedia",
                250, 600, 350
        );

        int menu = 0;

        while (menu != 3) {

            System.out.println("==================================");
            System.out.println("          CETAKDEKAT");
            System.out.println(" Katalog Tempat Fotocopy dan Cetak");
            System.out.println("==================================");

            System.out.println("\nMENU UTAMA");
            System.out.println("1. Lihat Daftar Tempat Fotocopy");
            System.out.println("2. Hitung Biaya Fotocopy");
            System.out.println("3. Keluar");

            System.out.print("Pilih menu: ");

            try {
                menu = Integer.parseInt(input.nextLine());

                if (menu == 1) {

                    System.out.println("\nDAFTAR TEMPAT FOTOCOPY");

                    System.out.println("1. " + tempat1.getNama());
                    System.out.println("   Alamat: " + tempat1.getAlamat());
                    System.out.println("   Kontak: " + tempat1.getKontak());
                    System.out.println("   Hitam Putih: Rp" + tempat1.getHargaHitamPutih());
                    System.out.println("   Warna: Rp" + tempat1.getHargaWarna());
                    System.out.println("   Cetak: Rp" + tempat1.getHargaCetak());

                    System.out.println("\n2. " + tempat2.getNama());
                    System.out.println("   Alamat: " + tempat2.getAlamat());
                    System.out.println("   Kontak: " + tempat2.getKontak());
                    System.out.println("   Hitam Putih: Rp" + tempat2.getHargaHitamPutih());
                    System.out.println("   Warna: Rp" + tempat2.getHargaWarna());
                    System.out.println("   Cetak: Rp" + tempat2.getHargaCetak());

                    System.out.println("\nTekan Enter untuk kembali ke menu.");
                    input.nextLine();

                } else if (menu == 2) {

                    System.out.println("\nDAFTAR TEMPAT FOTOCOPY");
                    System.out.println("1. " + tempat1.getNama());
                    System.out.println("2. " + tempat2.getNama());

                    System.out.print("Pilih tempat: ");
                    int pilihanTempat = Integer.parseInt(input.nextLine());

                    TempatFotocopy tempatDipilih = null;

                    if (pilihanTempat == 1) {
                        tempatDipilih = tempat1;
                    } else if (pilihanTempat == 2) {
                        tempatDipilih = tempat2;
                    } else {
                        System.out.println("Pilihan tempat tidak tersedia.");
                        continue;
                    }

                    System.out.println("\nJENIS LAYANAN");
                    System.out.println("1. Fotocopy Hitam Putih");
                    System.out.println("2. Fotocopy Warna");
                    System.out.println("3. Cetak Dokumen");

                    System.out.print("Pilih layanan: ");
                    int pilihanLayanan = Integer.parseInt(input.nextLine());

                    int harga = 0;
                    String namaLayanan = "";

                    switch (pilihanLayanan) {

                        case 1:
                            harga = tempatDipilih.getHargaHitamPutih();
                            namaLayanan = "Fotocopy Hitam Putih";
                            break;

                        case 2:
                            harga = tempatDipilih.getHargaWarna();
                            namaLayanan = "Fotocopy Warna";
                            break;

                        case 3:
                            harga = tempatDipilih.getHargaCetak();
                            namaLayanan = "Cetak Dokumen";
                            break;

                        default:
                            System.out.println("Pilihan layanan tidak tersedia.");
                            continue;
                    }

                    System.out.print("\nMasukkan jumlah lembar: ");
                    int jumlah = Integer.parseInt(input.nextLine());

                    if (jumlah <= 0) {
                        System.out.println("Jumlah lembar harus lebih dari 0.");
                        continue;
                    }

                    long totalBiaya = (long) harga * jumlah;

                    System.out.println("\n==================================");
                    System.out.println("       HASIL PERHITUNGAN");
                    System.out.println("==================================");

                    System.out.println("Nama Tempat : " + tempatDipilih.getNama());
                    System.out.println("Jenis Layanan : " + namaLayanan);
                    System.out.println("Harga per Lembar : Rp" + harga);
                    System.out.println("Jumlah Lembar : " + jumlah);
                    System.out.println("Total Biaya : Rp" + totalBiaya);

                    System.out.println("\nPerhitungan berhasil.");

                    System.out.println("\nTekan Enter untuk kembali ke menu.");
                    input.nextLine();

                } else if (menu == 3) {

                    System.out.println("\nTerima kasih telah menggunakan CetakDekat.");
                    System.out.println("Program selesai.");

                } else {

                    System.out.println("\nPilihan menu tidak tersedia.");
                    System.out.println("Silakan pilih menu 1 sampai 3.");

                    System.out.println("\nTekan Enter untuk kembali.");
                    input.nextLine();
                }

            } catch (NumberFormatException e) {

                System.out.println("\nInput harus berupa angka.");
                System.out.println("Tekan Enter untuk kembali ke menu.");
                input.nextLine();
            }
        }

        input.close();
    }
}
