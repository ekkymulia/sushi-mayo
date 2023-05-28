package com.sushimayo.models;

import java.math.BigDecimal;

public class DetailNotaModel {
    private int idDetailNota;
    private int idNota;
    private int idMenu;
    private int qty;
    private double harga;
    private double totalHarga;

    public int getIdDetailNota() {
        return idDetailNota;
    }

    public void setIdDetailNota(int idDetailNota) {
        this.idDetailNota = idDetailNota;
    }

    public int getIdNota() {
        return idNota;
    }

    public void setIdNota(int idNota) {
        this.idNota = idNota;
    }

    public int getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(int idMenu) {
        this.idMenu = idMenu;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public double getTotalHarga() {
        return totalHarga;
    }

    public void setTotalHarga(double totalHarga) {
        this.totalHarga = totalHarga;
    }
}
