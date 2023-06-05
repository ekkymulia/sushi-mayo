package com.sushimayo.models;

import java.text.DecimalFormat;

public class MenuModel {
    private int idMenu;
    private String namaMenu;
    private double hargaMenu;
    private int idJenisMenu;
    private String gambarMenu;
    private String deskripsiMenu;

    private boolean isDeleted = false;

    public String getGambarMenu() {
        return gambarMenu;
    }

    public void setGambarMenu(String gambarMenu) {
        this.gambarMenu = gambarMenu;
    }

    public String getDeskripsiMenu() {
        return deskripsiMenu;
    }

    public void setDeskripsiMenu(String deskripsiMenu) {
        this.deskripsiMenu = deskripsiMenu;
    }


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
