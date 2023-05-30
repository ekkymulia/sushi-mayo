package com.sushimayo.models;

import java.text.DecimalFormat;

public class MenuModel {
    private int idMenu;
    private String namaMenu;
    private double hargaMenu;
    private int idJenisMenu;

    public String getGambarMenu() {
        return gambarMenu;
    }

    private String gambarMenu;

    public int getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(int idMenu) {
        this.idMenu = idMenu;
    }

    public String getNamaMenu() {
        return namaMenu;
    }

    public void setNamaMenu(String namaMenu) {
        this.namaMenu = namaMenu;
    }

    public String getHargaMenu() {
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        return decimalFormat.format(hargaMenu);
    }

    public void setHargaMenu(double hargaMenu) {
        this.hargaMenu = hargaMenu;
    }

    public int getIdJenisMenu() {
        return idJenisMenu;
    }

    public void setIdJenisMenu(int idJenisMenu) {
        this.idJenisMenu = idJenisMenu;
    }
}
