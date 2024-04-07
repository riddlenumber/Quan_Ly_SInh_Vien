/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class diemhp {
    private String maSV;
    private String maHP;
    private String tenHP;
    private float diemHP;

    public diemhp() {
    }

    public diemhp(String maSV, String maHP, String tenHP, float diemHP) {
        this.maSV = maSV;
        this.maHP = maHP;
        this.tenHP = tenHP;
        this.diemHP = diemHP;
    }

    public String getMaSV() {
        return maSV;
    }

    public String getMaHP() {
        return maHP;
    }

    public String getTenHP() {
        return tenHP;
    }

    public float getDiemHP() {
        return diemHP;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public void setMaHP(String maHP) {
        this.maHP = maHP;
    }

    public void setTenHP(String tenHP) {
        this.tenHP = tenHP;
    }

    public void setDiemHP(float diemHP) {
        this.diemHP = diemHP;
    }

    
    
    
   
}
