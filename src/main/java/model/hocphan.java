/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class hocphan {
    private String maHP;
    private String tenHP;
    private int namHoc;
    private int STC;
    private String maSV;
    private String maNganh;

    public hocphan() {
    }

    public hocphan(String maHP, String tenHP, int namHoc, int STC, String maSV, String maNganh) {
        this.maHP = maHP;
        this.tenHP = tenHP;
        this.namHoc = namHoc;
        this.STC = STC;
        this.maSV = maSV;
        this.maNganh = maNganh;
    }

    public String getMaHP() {
        return maHP;
    }

    public String getTenHP() {
        return tenHP;
    }

    public int getNamHoc() {
        return namHoc;
    }

    public int getSTC() {
        return STC;
    }

    public String getMaSV() {
        return maSV;
    }

    public String getMaNganh() {
        return maNganh;
    }

    public void setMaHP(String maHP) {
        this.maHP = maHP;
    }

    public void setTenHP(String tenHP) {
        this.tenHP = tenHP;
    }

    public void setNamHoc(int namHoc) {
        this.namHoc = namHoc;
    }

    public void setSTC(int STC) {
        this.STC = STC;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public void setMaNganh(String maNganh) {
        this.maNganh = maNganh;
    }
    
    
}
