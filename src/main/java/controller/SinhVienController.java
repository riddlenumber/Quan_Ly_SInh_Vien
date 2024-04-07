/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.SinhVienView;

/**
 *
 * @author Admin
 */
public class SinhVienController implements ActionListener{
    private SinhVienView sinhvienView;
    public SinhVienController(SinhVienView sinhvienView){
        this.sinhvienView= sinhvienView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
         String check= e.getActionCommand();
        if(check.equals("Add")){
            this.sinhvienView.insert();
        }
        if(check.equals("Edit")){
            this.sinhvienView.update();
        }
        if(check.equals("Delete")){
            this.sinhvienView.delete();
        }
        if(check.equals("Clear")){
            this.sinhvienView.reset();
        }
        if(check.equals("Chọn ảnh")){
            this.sinhvienView.choosefile();
        }
        
    }
    
}
