/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class user {
    private String id;
    private String tenDN;
    private String matKhau;

    public user() {
    }

    public user(String id, String tenDN, String matKhau) {
        this.id = id;
        this.tenDN = tenDN;
        this.matKhau = matKhau;
    }

    public String getId() {
        return id;
    }

    public String getTenDN() {
        return tenDN;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTenDN(String tenDN) {
        this.tenDN = tenDN;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    
    
    
}
