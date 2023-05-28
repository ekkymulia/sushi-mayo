package com.sushimayo.models;

import java.util.Date;

public class NotaModel {
    private int idNota;
    private String telpPelanggan;
    private String alamat;
    private String metodePembayaran;
    private String namaPelanggan;
    private Date tanggalPemesanan;

    public int getIdNota() {
        return idNota;
    }

    public void setIdNota(int idNota) {
        this.idNota = idNota;
    }

    public String getTelpPelanggan() {
        return telpPelanggan;
    }

    public void setTelpPelanggan(String telpPelanggan) {
        this.telpPelanggan = telpPelanggan;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getMetodePembayaran() {
        return metodePembayaran;
    }

    public void setMetodePembayaran(String metodePembayaran) {
        this.metodePembayaran = metodePembayaran;
    }

    public String getNamaPelanggan() {
        return namaPelanggan;
    }

    public void setNamaPelanggan(String namaPelanggan) {
        this.namaPelanggan = namaPelanggan;
    }

    public Date getTanggalPemesanan() {
        return tanggalPemesanan;
    }

    public void setTanggalPemesanan(Date tanggalPemesanan) {
        this.tanggalPemesanan = tanggalPemesanan;
    }
}

