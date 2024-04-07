/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;

import javax.swing.UIManager;
import view.LoginView;

/**
 *
 * @author Admin
 */
public class test {

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            LoginView lg = new LoginView();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
