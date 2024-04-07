/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.KhoaView;

/**
 *
 * @author Admin
 */
public class KhoaController implements ActionListener{
    private KhoaView khoaview;
    public KhoaController(KhoaView khoaview){
        this.khoaview= khoaview;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
         String check= e.getActionCommand();
        if(check.equals("Add")){
            this.khoaview.insert();
        }
        if(check.equals("Edit")){
            this.khoaview.update();
        }
        if(check.equals("Delete")){
            this.khoaview.delete();
        }
        if(check.equals("Clear")){
            this.khoaview.reset();
        }
         if(check.equals("Search")){
            this.khoaview.btnsearch();
        }
    }
    
}
