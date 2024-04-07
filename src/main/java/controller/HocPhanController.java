/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.HocPhanView;
import view.KhoaView;

/**
 *
 * @author Admin
 */
public class HocPhanController implements ActionListener{
    private HocPhanView hocphanview;
    public HocPhanController(HocPhanView hocphanview){
        this.hocphanview= hocphanview;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
         String check= e.getActionCommand();
        if(check.equals("Add")){
            this.hocphanview.insert();
        }
        if(check.equals("Edit")){
            this.hocphanview.update();
        }
        if(check.equals("Delete")){
            this.hocphanview.delete();
        }
        if(check.equals("Clear")){
            this.hocphanview.reset();
        }
        if(check.equals("Search")){
            this.hocphanview.btnsearch();
        }
    }
    
}
