/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import DAO.diemhp_DAO;
import DAO.hocphan_DAO;
import DAO.lop_DAO;
import DAO.nganh_DAO;
import DAO.sinhvien_DAO;
import controller.DiemHPController;
import controller.LopController;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import model.diemhp;
import model.hocphan;
import model.lop;
import model.nganh;
import model.sinhvien;

/**
 *
 * @author Admin
 */
public class DiemHPView extends JFrame {

    private DefaultTableModel model;
    private JScrollPane jScrollPane1;
    private JTable table;
    private String maHP, maSV;
    private JComboBox<String> cb_maSV;
    private JComboBox<String> cb_maHP;
    private JTextField text_tenHP;
    private JTextField text_diemHP;

    public DiemHPView() {
        this.setTitle("Danh mục");
        this.setSize(1000, 550);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.init();
        this.setVisible(true);
        this.render();
    }

    public void init() {
        ActionListener ac = new DiemHPController(this);
        Font font = new Font("Arial", Font.ROMAN_BASELINE, 15);

        ImageIcon addIcon = new ImageIcon("D:\\JavaEasy\\QuanLySinhVien\\src\\main\\java\\img\\them.jpg");
        JButton add = new JButton("Add", addIcon);
        add.setFont(font);
        add.addActionListener(ac);

        ImageIcon addIcon1 = new ImageIcon("D:\\JavaEasy\\QuanLySinhVien\\src\\main\\java\\img\\sua.jpg");
        JButton edit = new JButton("Edit", addIcon1);
        edit.setFont(font);
        edit.addActionListener(ac);
        
        ImageIcon addIcon2 = new ImageIcon("D:\\JavaEasy\\QuanLySinhVien\\src\\main\\java\\img\\xoa.jpg");
        JButton delete = new JButton("Delete", addIcon2);
        delete.setFont(font);
        delete.addActionListener(ac);
        
        ImageIcon addIcon3 = new ImageIcon("D:\\JavaEasy\\QuanLySinhVien\\src\\main\\java\\img\\reset.jpg");
        JButton clear = new JButton("Clear", addIcon3);
        clear.setFont(font);
        clear.addActionListener(ac);

        cb_maSV = new JComboBox<>();
        cb_maSV.setFont(font);
        cb_maSV.setPreferredSize(new Dimension(150, 30)); // Đặt kích thước cho JComboBox
        JLabel jLabel_id1 = new JLabel("Mã sinh viên");
        jLabel_id1.setFont(font);

        ArrayList<sinhvien> listSinhVien = sinhvien_DAO.getInstance().selectAll();
        for (sinhvien sinhvien : listSinhVien) {
            cb_maSV.addItem(sinhvien.getMaSV());
        }

        cb_maHP = new JComboBox<>();
        cb_maHP.setFont(font);
        cb_maHP.setPreferredSize(new Dimension(150, 30)); // Đặt kích thước cho JComboBox
        JLabel jLabel_id2 = new JLabel("Mã học phần");
        jLabel_id2.setFont(font);

        ArrayList<hocphan> listHocPhan = hocphan_DAO.getInstance().selectAll();
        for (hocphan hocphan : listHocPhan) {
            cb_maHP.addItem(hocphan.getMaHP());
        }

        text_tenHP = new JTextField();
        text_tenHP.setFont(font);
        text_tenHP.setColumns(15);
        JLabel jLabel_name = new JLabel("Tên học phần");
        jLabel_name.setFont(font);

        text_diemHP = new JTextField();
        text_diemHP.setFont(font);
        text_diemHP.setColumns(15);
        JLabel jLabel_name1 = new JLabel("Điểm học phần");
        jLabel_name1.setFont(font);

        JPanel jp_North = new JPanel(new BorderLayout());
        EmptyBorder border1 = new EmptyBorder(20, 20, 20, 20);

        jp_North.setBorder(border1);
        JPanel jpCenter = new JPanel();

        jpCenter.setBorder(
                new EmptyBorder(10, 20, 20, 20));

        JPanel jp_title = new JPanel(new FlowLayout());

        jp_title.setBorder(border1);
        JLabel title = new JLabel("Quản lý danh mục điểm học phần");

        title.setFont(
                new Font("Arial", Font.BOLD, 20));
        jp_title.add(title);

        GridLayout layout2 = new GridLayout(1, 2);

        layout2.setHgap(
                20);
        layout2.setVgap(
                20);
        GridLayout layout3 = new GridLayout(1, 4);

        layout2.setHgap(
                20);
        layout2.setVgap(
                20);

        JPanel jp_North_content = new JPanel(new BorderLayout());

        jp_North_content.setBorder(border1);
        JPanel jp_North_content_North = new JPanel(layout2);
        JPanel jp_North_content_Center = new JPanel(layout3);

        jp_North_content_Center.setBorder(
                new EmptyBorder(30, 0, 0, 0));

        jp_North_content_North.add(jLabel_id1);

        jp_North_content_North.add(cb_maSV);

        jp_North_content_North.add(jLabel_id2);

        jp_North_content_North.add(cb_maHP);

        jp_North_content_North.add(jLabel_name);

        jp_North_content_North.add(text_tenHP);

        jp_North_content_North.add(jLabel_name1);

        jp_North_content_North.add(text_diemHP);

        jp_North_content_Center.add(add);

        jp_North_content_Center.add(edit);

        jp_North_content_Center.add(delete);

        jp_North_content_Center.add(clear);

        jp_North_content.add(jp_North_content_North, BorderLayout.NORTH);

        jp_North_content.add(jp_North_content_Center, BorderLayout.CENTER);

        jp_North.add(jp_title, BorderLayout.NORTH);

        jp_North.add(jp_North_content, BorderLayout.CENTER);

        //bảng
        table = new JTable(model);

//          this.render();
        table.setFont(font);

        table.setPreferredScrollableViewportSize(
                new Dimension(800, 190));
        //jScrollPane1= new JScrollPane(table,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        table.addMouseListener(
                new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e
            ) {

                String maSV = model.getValueAt(table.getSelectedRow(), 1) + "";
                String maHP = model.getValueAt(table.getSelectedRow(), 2) + "";
                String tenHP = model.getValueAt(table.getSelectedRow(), 3) + "";
                float diemHP = Float.parseFloat(model.getValueAt(table.getSelectedRow(), 4).toString());

                cb_maSV.setSelectedItem(maSV);
                cb_maHP.setSelectedItem(maHP);;
                text_tenHP.setText(tenHP);
                text_diemHP.setText(String.valueOf(diemHP));

                DiemHPView.this.maSV = maSV;
                DiemHPView.this.maHP = maHP;
            }
        }
        );

        jScrollPane1 = new JScrollPane();
        //jScrollPane1.setSize(20, 10);

        jScrollPane1.setViewportView(table);

        jpCenter.add(jScrollPane1);

        this.setLayout(
                new BorderLayout());

        this.add(jp_North, BorderLayout.NORTH);

        this.add(jpCenter, BorderLayout.CENTER);

        cb_maHP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lấy mã học phần được chọn từ JComboBox
                String selectedMaHP = cb_maHP.getSelectedItem().toString();

                // Truy vấn tên học phần từ CSDL dựa trên mã học phần được chọn
                String tenHP = hocphan_DAO.getInstance().selectTenHP(selectedMaHP);

                // Đặt giá trị của JTextField text_tenHP bằng tên học phần đã truy vấn được
                text_tenHP.setText(tenHP);
            }
        });

    }

    public void render() {
        model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{
            "STT", "Mã sinh viên", "Mã học phần", "Tên học phần", "Điểm học phần"
        });
        diemhp_DAO dao = new diemhp_DAO();
        ArrayList<diemhp> categorys = dao.selectAll();

        int stt = 0;
        if (categorys.size() > 0) {
            for (diemhp ct : categorys) {
                stt++;
                Object[] rowdata = {
                    stt,
                    ct.getMaSV(),
                    ct.getMaHP(),
                    ct.getTenHP(),
                    ct.getDiemHP(),};

                model.addRow(rowdata);
            }
        }
        table.setModel(model);
    }

    public void reset() {
        // TODO Auto-generated method stub
        cb_maSV.setSelectedIndex(0);
        cb_maHP.setSelectedIndex(0);
        text_tenHP.setText("");
        text_diemHP.setText("");
    }

    public void insert() {
        String maSV = cb_maSV.getSelectedItem().toString();
        String maHP = cb_maHP.getSelectedItem().toString();
        String tenHP = text_tenHP.getText();
        float diemHP = Float.parseFloat(text_diemHP.getText());

        if (maHP.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng không để trống nội dung");
        } else {

            diemhp ct = new diemhp(maSV, maHP, tenHP, diemHP);
            int result = diemhp_DAO.getInstance().insert(ct);

            if (result > 0) {
                JOptionPane.showMessageDialog(this, "Thêm thành công");
                this.render();
                this.reset();
            } else {
                System.out.println("Thêm thất bại");
                JOptionPane.showMessageDialog(this, "Thêm thất bại");
            }
        }
    }

    public void update() {
        // Kiểm tra xem maKhoa có giá trị không
        if (maSV != null && !maSV.isEmpty() || maHP != null && !maHP.isEmpty()) {
            String tenHP = text_tenHP.getText();
            float diemHP = Float.parseFloat(text_diemHP.getText());

            diemhp ct = new diemhp(maSV, maHP, tenHP, diemHP);
            int result = diemhp_DAO.getInstance().update(ct);

            if (result > 0) {
                JOptionPane.showMessageDialog(this, "Sửa thành công");
                this.render(); // Hiển thị lại dữ liệu sau khi sửa
            } else {
                JOptionPane.showMessageDialog(this, "Sửa thất bại");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn tài khoản cần sửa");
        }
    }

    public void delete() {
        // Kiểm tra xem maKhoa có giá trị không
        if (maSV != null && !maSV.isEmpty() || maHP != null && !maHP.isEmpty()) {
            String tenHP = text_tenHP.getText();
            float diemHP = Float.parseFloat(text_diemHP.getText());

//            boolean lopExists = lop_DAO.getInstance().isExistsForLop(maLop);
//
//            if (lopExists) {
//                JOptionPane.showMessageDialog(this, "Không thể xóa, dữ liệu còn tồn tại!!.");
//            } else {
            int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa không?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                diemhp ct = new diemhp(maSV, maHP, tenHP, diemHP);
                int result = diemhp_DAO.getInstance().delete(ct);
                if (result > 0) {
                    JOptionPane.showMessageDialog(this, "Xóa thành công");
                    this.reset();
                    this.render();
                } else {
                    JOptionPane.showMessageDialog(this, "Xóa thất bại");
                }
            }
//            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn tài khoản cần xóa");
        }
    }

}
