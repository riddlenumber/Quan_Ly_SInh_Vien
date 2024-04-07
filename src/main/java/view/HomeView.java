/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.BorderLayout;
import controller.MenuController;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Admin
 */
public class HomeView extends JFrame {

    public HomeView() {
        this.setTitle("Trang chủ");
        this.setSize(1000, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.init();
        this.setVisible(true);
    }

    public void init() {
        ActionListener ac = new MenuController(this);
        JMenuBar menu = new JMenuBar();
        JMenu menu_hethong = new JMenu("Hệ thống");
        JMenu menu_danhmuc = new JMenu("Danh mục");

        menu.add(menu_hethong);
        menu.add(menu_danhmuc);

        ImageIcon addIcon = new ImageIcon("D:\\JavaEasy\\QuanLySinhVien\\src\\main\\java\\img\\logout.jpg");
        JMenuItem item_logout = new JMenuItem("Logout", addIcon);
        item_logout.addActionListener(ac);

        
        ImageIcon addIcon1 = new ImageIcon("D:\\JavaEasy\\QuanLySinhVien\\src\\main\\java\\img\\close.jpg");
        JMenuItem item_close = new JMenuItem("Close", addIcon1);
        item_close.addActionListener(ac);
        menu_hethong.add(item_logout);
        menu_hethong.add(item_close);

        ImageIcon addIcon2 = new ImageIcon("D:\\JavaEasy\\QuanLySinhVien\\src\\main\\java\\img\\department.jpg");
        JMenuItem item_khoa = new JMenuItem("Khoa", addIcon2);
        item_khoa.addActionListener(ac);
        menu_danhmuc.add(item_khoa);

        ImageIcon addIcon3 = new ImageIcon("D:\\JavaEasy\\QuanLySinhVien\\src\\main\\java\\img\\nganh.jpg");
        JMenuItem item_nganh = new JMenuItem("Ngành", addIcon3);
        item_nganh.addActionListener(ac);
        menu_danhmuc.add(item_nganh);

        ImageIcon addIcon4 = new ImageIcon("D:\\JavaEasy\\QuanLySinhVien\\src\\main\\java\\img\\lop.jpg");
        JMenuItem item_lop = new JMenuItem("Lớp", addIcon4);
        item_lop.addActionListener(ac);
        menu_danhmuc.add(item_lop);

        ImageIcon addIcon5 = new ImageIcon("D:\\JavaEasy\\QuanLySinhVien\\src\\main\\java\\img\\sinhvien.jpg");
        JMenuItem item_sv = new JMenuItem("Sinh viên", addIcon5);
        item_sv.addActionListener(ac);
        menu_danhmuc.add(item_sv);

        ImageIcon addIcon6 = new ImageIcon("D:\\JavaEasy\\QuanLySinhVien\\src\\main\\java\\img\\hocphan.jpg");
        JMenuItem item_hp = new JMenuItem("Học phần", addIcon6);
        item_hp.addActionListener(ac);
        menu_danhmuc.add(item_hp);

        ImageIcon addIcon7 = new ImageIcon("D:\\JavaEasy\\QuanLySinhVien\\src\\main\\java\\img\\diem.jpg");
        JMenuItem item_dhp = new JMenuItem("Điểm học phần", addIcon7);
        item_dhp.addActionListener(ac);
        menu_danhmuc.add(item_dhp);

        this.setJMenuBar(menu);
    }

    public void logout() {
        LoginView loginView = new LoginView();
        this.setVisible(true);
        dispose();
    }

    public void close() {
        dispose();
    }

    public void khoa() {
        KhoaView khoaView = new KhoaView();
        khoaView.setVisible(true);

    }

    public void nganh() {
        NganhView nganhView = new NganhView();
        nganhView.setVisible(true);
    }

    public void lop() {
        LopView lopView = new LopView();
        lopView.setVisible(true);
    }

    public void sinhvien() {
        SinhVienView sinhvienView = new SinhVienView();
        sinhvienView.setVisible(true);
    }

    public void hocphan() {
        HocPhanView hocphanView = new HocPhanView();
        hocphanView.setVisible(true);
    }

    public void diemhp() {
        DiemHPView diemhpView = new DiemHPView();
        diemhpView.setVisible(true);
    }
}
