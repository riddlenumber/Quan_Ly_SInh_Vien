/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class sinhvien {
    private String id;
    private String maSV;
    private String anh;
    private String tenSV;
    private String ngaySinh;
    private String gioiTinh;
    private String email;
    private String diaChi;
    private String maLop;

    public sinhvien() {
    }

    public sinhvien(String id, String maSV, String anh, String tenSV, String ngaySinh, String gioiTinh, String email, String diaChi, String maLop) {
        this.id = id;
        this.maSV = maSV;
        this.anh = anh;
        this.tenSV = tenSV;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.email = email;
        this.diaChi = diaChi;
        this.maLop = maLop;
    }

    public String getId() {
        return id;
    }

    public String getMaSV() {
        return maSV;
    }

    public String getAnh() {
        return anh;
    }

    public String getTenSV() {
        return tenSV;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public String getEmail() {
        return email;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public String getMaLop() {
        return maLop;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public void setTenSV(String tenSV) {
        this.tenSV = tenSV;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }
    
    
    
}
