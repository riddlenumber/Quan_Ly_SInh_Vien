/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.NganhView;

/**
 *
 * @author Admin
 */
public class NganhController implements ActionListener{
    private NganhView nganhview;
    public NganhController(NganhView nganhview){
        this.nganhview= nganhview;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
         String check= e.getActionCommand();
        if(check.equals("Add")){
            this.nganhview.insert();
        }
        if(check.equals("Edit")){
            this.nganhview.update();
        }
        if(check.equals("Delete")){
            this.nganhview.delete();
        }
        if(check.equals("Clear")){
            this.nganhview.reset();
        }
        if(check.equals("Search")){
            this.nganhview.btnsearch();
        }
        
    }
    
}