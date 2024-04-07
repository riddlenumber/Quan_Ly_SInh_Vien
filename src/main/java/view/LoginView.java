/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import DAO.user_DAO;
import controller.LoginController;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import model.user;

/**
 *
 * @author Admin
 */
public class LoginView extends JFrame {

    private JTextField text_name;
    private JPasswordField text_pass;

    public LoginView() {
        this.setTitle("QLSV");
        this.setSize(800, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.init();
        this.setVisible(true);
    }

    public void init() {
        ActionListener ac = new LoginController(this);
        Font font = new Font("Arial", Font.ROMAN_BASELINE, 15);

        JLabel lb_name = new JLabel("Tên đăng nhập");
        lb_name.setBounds(350, 100, 200, 30);
        lb_name.setFont(font);

        text_name = new JTextField();
        text_name.setBounds(350, 150, 350, 30);
        text_name.setFont(font);

        JLabel lb_pass = new JLabel("Mật khẩu");
        lb_pass.setBounds(350, 200, 200, 30);
        lb_pass.setFont(font);

//        text_pass = new JTextField();
//        text_pass.setBounds(350, 250, 350, 30);
//        text_pass.setFont(font);
        text_pass = new JPasswordField();
        text_pass.setBounds(350, 250, 350, 30);
        text_pass.setFont(font);

        JButton bt_login = new JButton("Login");
        bt_login.setBounds(480, 320, 100, 30);
        bt_login.setFont(font);
        bt_login.setBackground(new Color(0, 153, 153));
        bt_login.addActionListener(ac);

        JPanel panel_left = new JPanel();
        JPanel panel_right = new JPanel();
        panel_left.setBounds(0, 0, 300, 500);
        // panel_left.setBackground(Color.);
        panel_right.setBounds(300, 0, 500, 500);
        panel_right.setBackground(Color.WHITE);

        //poster
        JLabel lb_img = new JLabel();
        ImageIcon icon = new ImageIcon("D:\\JavaEasy\\QuanLySinhVien\\src\\main\\java\\img\\university.png");
        Image image = icon.getImage();
        Image scaledImage = image.getScaledInstance(panel_left.getWidth(), panel_left.getHeight(), Image.SCALE_SMOOTH);
        icon = new ImageIcon(scaledImage);
        lb_img.setIcon(icon);

        panel_left.add(lb_img);

        JLabel lb_title = new JLabel("Welcom to School!");
        lb_title.setBounds(450, 20, 250, 50);
        lb_title.setFont(new Font("Arial", Font.ITALIC, 22));

        lb_title.setForeground(new Color(0, 153, 153));

        this.add(bt_login);
        this.add(text_pass);
        this.add(lb_pass);
        this.add(text_name);
        this.add(lb_name);
        this.add(lb_title);
        this.add(panel_left);
        this.add(panel_right);

    }

    public void checkuser() {
        // Lấy dữ liệu từ các trường nhập liệu
        String username = text_name.getText();
        String pass = text_pass.getText();

        // Tạo một đối tượng user từ dữ liệu nhập liệu
        user nguoidung = new user();
        nguoidung.setTenDN(username);
        nguoidung.setMatKhau(pass);

        // Kiểm tra tài khoản
        if (user_DAO.getInstance().checkuser(nguoidung)) {
            // Nếu tài khoản hợp lệ, chuyển sang trang HomeView
            HomeView trangchu_view = new HomeView();
            trangchu_view.setVisible(true);
            this.dispose(); // Đóng cửa sổ hiện tại
        } else {
            // Nếu tài khoản không hợp lệ, hiển thị thông báo lỗi
            JOptionPane.showMessageDialog(this, "Tài khoản hoặc mật khẩu không đúng. Vui lòng đăng nhập lại hoặc đăng ký tài khoản mới.");
        }
    }

}
