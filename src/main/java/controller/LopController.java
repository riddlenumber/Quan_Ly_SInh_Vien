/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.LopView;

/**
 *
 * @author Admin
 */
public class LopController implements ActionListener{
    private LopView lopview;
    public LopController(LopView lopview){
        this.lopview= lopview;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
         String check= e.getActionCommand();
        if(check.equals("Add")){
            this.lopview.insert();
        }
        if(check.equals("Edit")){
            this.lopview.update();
        }
        if(check.equals("Delete")){
            this.lopview.delete();
        }
        if(check.equals("Clear")){
            this.lopview.reset();
        }
        if(check.equals("Search")){
            this.lopview.btnsearch();
        }
    }
    
}
