package com.mycompany.cetakdekat;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PrimaryController {

    @FXML
    private ComboBox<String> pilihanTempat;

    @FXML
    private ComboBox<String> pilihanLayanan;

    @FXML
    private TextField jumlahLembar;

    @FXML
    private Label hasilTempat;

    @FXML
    private Label hasilLayanan;

    @FXML
    private Label hasilJumlah;

    @FXML
    private Label hasilTotal;

    @FXML
    private Button tombolHitung;

    private TempatFotocopy tempat1;
    private TempatFotocopy tempat2;

    @FXML
    public void initialize() {

        tempat1 = new TempatFotocopy(
                "Fotocopy A",
                "Sekitar Universitas Lampung",
                "Belum tersedia",
                200, 500, 300
        );

        tempat2 = new TempatFotocopy(
                "Fotocopy B",
                "Sekitar Universitas Lampung",
                "Belum tersedia",
                250, 600, 350
        );

        pilihanTempat.getItems().addAll(
                "Fotocopy A",
                "Fotocopy B"
        );

        pilihanLayanan.getItems().addAll(
                "Fotocopy Hitam Putih",
                "Fotocopy Warna",
                "Cetak Dokumen"
        );
    }

    @FXML
    private void hitungBiaya() {

        if (pilihanTempat.getValue() == null
                || pilihanLayanan.getValue() == null
                || jumlahLembar.getText().trim().isEmpty()) {

            tampilkanAlert(
                    Alert.AlertType.WARNING,
                    "Input Belum Lengkap",
                    "Mohon lengkapi semua data terlebih dahulu."
            );

            return;
        }

        try {

            int jumlah = Integer.parseInt(
                    jumlahLembar.getText().trim()
            );

            if (jumlah <= 0) {

                tampilkanAlert(
                        Alert.AlertType.WARNING,
                        "Jumlah Tidak Valid",
                        "Jumlah lembar harus lebih dari 0."
                );

                return;
            }

            TempatFotocopy tempatDipilih;

            if (pilihanTempat.getValue().equals("Fotocopy A")) {
                tempatDipilih = tempat1;
            } else {
                tempatDipilih = tempat2;
            }

            int harga = 0;
            String layanan = pilihanLayanan.getValue();

            switch (layanan) {

                case "Fotocopy Hitam Putih":
                    harga = tempatDipilih.getHargaHitamPutih();
                    break;

                case "Fotocopy Warna":
                    harga = tempatDipilih.getHargaWarna();
                    break;

                case "Cetak Dokumen":
                    harga = tempatDipilih.getHargaCetak();
                    break;
            }

            long total = (long) harga * jumlah;

            hasilTempat.setText(tempatDipilih.getNama());
            hasilLayanan.setText(layanan);
            hasilJumlah.setText(jumlah + " lembar");

            hasilTotal.setText(
                    "Rp" + String.format("%,d", total)
                            .replace(',', '.')
            );

        } catch (NumberFormatException e) {

            tampilkanAlert(
                    Alert.AlertType.ERROR,
                    "Input Tidak Valid",
                    "Jumlah lembar harus diisi menggunakan angka."
            );
        }
    }

    private void tampilkanAlert(
            Alert.AlertType jenis,
            String judul,
            String pesan) {

        Alert alert = new Alert(jenis);
        alert.setTitle(judul);
        alert.setHeaderText(null);
        alert.setContentText(pesan);
        alert.showAndWait();
    }
}
