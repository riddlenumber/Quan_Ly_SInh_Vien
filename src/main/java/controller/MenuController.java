/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.HomeView;

/**
 *
 * @author Admin
 */
public class MenuController implements ActionListener{
    private HomeView homeview;
    public  MenuController(HomeView homeView){
        this.homeview= homeView;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String check= e.getActionCommand();
        if(check.equals("Logout")){
            this.homeview.logout();
        }
        if(check.equals("Close")){
            this.homeview.close();
        }
        if(check.equals("Khoa")){
            this.homeview.khoa();
        }
        if(check.equals("Ngành")){
            this.homeview.nganh();
        }
        if(check.equals("Lớp")){
            this.homeview.lop();
        }
        if(check.equals("Sinh viên")){
            this.homeview.sinhvien();
        }
        if(check.equals("Học phần")){
            this.homeview.hocphan();
        }
        if(check.equals("Điểm học phần")){
            this.homeview.diemhp();
        }
   
        
    }
    
}