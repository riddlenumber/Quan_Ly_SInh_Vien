/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.DiemHPView;
import view.KhoaView;

/**
 *
 * @author Admin
 */
public class DiemHPController implements ActionListener{
    private DiemHPView diemhpview;
    public DiemHPController(DiemHPView diemhpview){
        this.diemhpview= diemhpview;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
         String check= e.getActionCommand();
        if(check.equals("Add")){
            this.diemhpview.insert();
        }
        if(check.equals("Edit")){
            this.diemhpview.update();
        }
        if(check.equals("Delete")){
            this.diemhpview.delete();
        }
        if(check.equals("Clear")){
            this.diemhpview.reset();
        }
        
    }
    
}
