package com.mycompany.cetakdekat;

public class TempatFotocopy extends TempatUsaha {

    private int hargaHitamPutih;
    private int hargaWarna;
    private int hargaCetak;

    public TempatFotocopy(String nama, String alamat, String kontak,
                          int hargaHitamPutih, int hargaWarna,
                          int hargaCetak) {

        super(nama, alamat, kontak);

        this.hargaHitamPutih = hargaHitamPutih;
        this.hargaWarna = hargaWarna;
        this.hargaCetak = hargaCetak;
    }

    public int getHargaHitamPutih() {
        return hargaHitamPutih;
    }

    public void setHargaHitamPutih(int hargaHitamPutih) {
        this.hargaHitamPutih = hargaHitamPutih;
    }

    public int getHargaWarna() {
        return hargaWarna;
    }

    public void setHargaWarna(int hargaWarna) {
        this.hargaWarna = hargaWarna;
    }

    public int getHargaCetak() {
        return hargaCetak;
    }

    public void setHargaCetak(int hargaCetak) {
        this.hargaCetak = hargaCetak;
    }
}
