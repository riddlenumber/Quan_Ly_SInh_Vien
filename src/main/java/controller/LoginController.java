/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.LoginView;

/**
 *
 * @author Admin
 */
public class LoginController implements ActionListener{
    private LoginView loginView;
    public LoginController(LoginView loginView){
        this.loginView= loginView;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String check= e.getActionCommand();
        if(check.equals("Login")){
            this.loginView.checkuser();
        }
    }
    
}
