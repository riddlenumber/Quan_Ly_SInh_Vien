/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import DAO.hocphan_DAO;
import DAO.lop_DAO;
import DAO.nganh_DAO;
import DAO.sinhvien_DAO;
import controller.HocPhanController;
import controller.LopController;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
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
import model.hocphan;
import model.lop;
import model.nganh;
import model.sinhvien;

/**
 *
 * @author Admin
 */
public class HocPhanView extends JFrame {

    private DefaultTableModel model;
    private JScrollPane jScrollPane1;
    private JTable table;
    private String maHP;
    private JTextField text_maHP;
    private JTextField text_tenHP;
    private JTextField text_namHoc;
    private JTextField text_STC;
    private JComboBox<String> cb_maSV;
    private JComboBox<String> cb_maNganh;
    private JTextField text_search;

    public HocPhanView() {
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
        ActionListener ac = new HocPhanController(this);
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

        ImageIcon searchIcon = new ImageIcon("D:\\JavaEasy\\QuanLySinhVien\\src\\main\\java\\img\\search.jpg");
        JButton btnsearch = new JButton("Search", searchIcon);
        btnsearch.setFont(font);
        btnsearch.addActionListener(ac);

        text_search = new JTextField();
        text_search.setFont(font);
        text_search.setColumns(20);

        text_maHP = new JTextField();
        text_maHP.setFont(font);
        text_maHP.setColumns(15);
        JLabel jLabel_id = new JLabel("Mã học phần");
        jLabel_id.setFont(font);

        text_tenHP = new JTextField();
        text_tenHP.setFont(font);
        text_tenHP.setColumns(15);
        JLabel jLabel_name = new JLabel("Tên học phần");
        jLabel_name.setFont(font);

        text_namHoc = new JTextField();
        text_namHoc.setFont(font);
        text_namHoc.setColumns(15);
        JLabel jLabel_name1 = new JLabel("Năm học");
        jLabel_name1.setFont(font);

        text_STC = new JTextField();
        text_STC.setFont(font);
        text_STC.setColumns(15);
        JLabel jLabel_name2 = new JLabel("Số tín chỉ");
        jLabel_name2.setFont(font);

        cb_maSV = new JComboBox<>();
        cb_maSV.setFont(font);
        cb_maSV.setPreferredSize(new Dimension(150, 30)); // Đặt kích thước cho JComboBox
        JLabel jLabel_id1 = new JLabel("Mã sinh viên");
        jLabel_id1.setFont(font);

        ArrayList<sinhvien> listSinhVien = sinhvien_DAO.getInstance().selectAll();
        for (sinhvien sinhvien : listSinhVien) {
            cb_maSV.addItem(sinhvien.getMaSV());
        }

        cb_maNganh = new JComboBox<>();
        cb_maNganh.setFont(font);
        cb_maNganh.setPreferredSize(new Dimension(150, 30)); // Đặt kích thước cho JComboBox
        JLabel jLabel_id2 = new JLabel("Mã ngành");
        jLabel_id2.setFont(font);

        ArrayList<nganh> listNganh = nganh_DAO.getInstance().selectAll();
        for (nganh nganh : listNganh) {
            cb_maNganh.addItem(nganh.getMaNganh());
        }

        JPanel jp_North = new JPanel(new BorderLayout());
        EmptyBorder border1 = new EmptyBorder(20, 20, 20, 20);

        jp_North.setBorder(border1);
        JPanel jpCenter = new JPanel();

        jpCenter.setBorder(
                new EmptyBorder(10, 20, 20, 20));

        JPanel jp_title = new JPanel(new FlowLayout());

        jp_title.setBorder(border1);
        JLabel title = new JLabel("Quản lý danh mục học phần");

        title.setFont(
                new Font("Arial", Font.BOLD, 20));
        jp_title.add(title);

        GridLayout layout2 = new GridLayout(2, 2);

        layout2.setHgap(
                20);
        layout2.setVgap(
                20);
        GridLayout layout3 = new GridLayout(1, 4);

        layout2.setHgap(
                20);
        layout2.setVgap(
                20);

        GridLayout layout4 = new GridLayout(1, 2);

        layout2.setHgap(
                20);
        layout2.setVgap(
                20);

        JPanel jp_North_content = new JPanel(new BorderLayout());

        jp_North_content.setBorder(border1);
        JPanel jp_North_content_North = new JPanel(layout2);
        JPanel jp_North_content_Center = new JPanel(layout3);
        JPanel jp_search = new JPanel(new FlowLayout());

        JPanel jp_North_content_Bottom = new JPanel(layout4);

        jp_North_content_Center.setBorder(
                new EmptyBorder(30, 0, 0, 0));

        jp_North_content_North.add(jLabel_id);

        jp_North_content_North.add(text_maHP);

        jp_North_content_North.add(jLabel_name);

        jp_North_content_North.add(text_tenHP);

        jp_North_content_North.add(jLabel_name1);

        jp_North_content_North.add(text_namHoc);

        jp_North_content_North.add(jLabel_name2);

        jp_North_content_North.add(text_STC);

        jp_North_content_North.add(jLabel_id1);

        jp_North_content_North.add(cb_maSV);

        jp_North_content_North.add(jLabel_id2);

        jp_North_content_North.add(cb_maNganh);

        jp_North_content_Center.add(add);

        jp_North_content_Center.add(edit);

        jp_North_content_Center.add(delete);

        jp_North_content_Center.add(clear);

        jp_North_content_Bottom.setBorder(
                new EmptyBorder(30, 0, 0, 0));

        jp_North_content_Bottom.add(text_search);
        jp_North_content_Bottom.add(btnsearch);

        jp_North_content.add(jp_North_content_North, BorderLayout.NORTH);

        jp_North_content.add(jp_North_content_Center, BorderLayout.CENTER);

        jp_North_content.add(jp_North_content_Bottom, BorderLayout.SOUTH);

        jp_North.add(jp_title, BorderLayout.NORTH);

        jp_North.add(jp_North_content, BorderLayout.CENTER);

        jp_North.add(jp_search, BorderLayout.SOUTH);

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

                String maHP = model.getValueAt(table.getSelectedRow(), 1) + "";
                String tenHP = model.getValueAt(table.getSelectedRow(), 2) + "";
                int namHoc = Integer.parseInt(model.getValueAt(table.getSelectedRow(), 3).toString());
                int STC = Integer.parseInt(model.getValueAt(table.getSelectedRow(), 4).toString());
                String maSV = model.getValueAt(table.getSelectedRow(), 5) + "";
                String maNganh = model.getValueAt(table.getSelectedRow(), 6) + "";

                text_maHP.setText(maHP);
                text_tenHP.setText(tenHP);
                text_namHoc.setText(String.valueOf(namHoc));
                text_STC.setText(String.valueOf(STC));
                cb_maSV.setSelectedItem(maSV);
                cb_maNganh.setSelectedItem(maNganh);

                HocPhanView.this.maHP = maHP;
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

    }

    public void render() {
        model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{
            "STT", "Mã học phần", "Tên học phần", "Năm học", "Số tín chỉ", "Mã sinh viên", "Mã ngành"
        });
        hocphan_DAO dao = new hocphan_DAO();
        ArrayList<hocphan> categorys = dao.selectAll();

        int stt = 0;
        if (categorys.size() > 0) {
            for (hocphan ct : categorys) {
                stt++;
                Object[] rowdata = {
                    stt,
                    ct.getMaHP(),
                    ct.getTenHP(),
                    ct.getNamHoc(),
                    ct.getSTC(),
                    ct.getMaSV(),
                    ct.getMaNganh(),};

                model.addRow(rowdata);
            }
        }
        table.setModel(model);
    }

    public void reset() {
        // TODO Auto-generated method stub
        text_maHP.setText("");
        text_tenHP.setText("");
        text_namHoc.setText(String.valueOf(""));
        text_STC.setText(String.valueOf(""));
        cb_maSV.setSelectedIndex(0);
        cb_maNganh.setSelectedIndex(0);

    }

    public void insert() {
        String maHP = text_maHP.getText();
        String tenHP = text_tenHP.getText();
        String namHocText = text_namHoc.getText();
        String STCText = text_STC.getText();
        String maSV = cb_maSV.getSelectedItem().toString();
        String maNganh = cb_maNganh.getSelectedItem().toString();

        try {
            int namHoc = Integer.parseInt(namHocText);
            int STC = Integer.parseInt(STCText);

            if (tenHP.isEmpty() || namHocText.isEmpty() || STCText.isEmpty() || maSV.isEmpty() || maNganh.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng không để trống nội dung");
            } else {

                boolean primakeyKeyExists = hocphan_DAO.getInstance().primakeyKeyExists(maHP);

                if (primakeyKeyExists) {
                    JOptionPane.showMessageDialog(this, "Không trùng mã học phần");
                } else {
                    hocphan ct = new hocphan(maHP, tenHP, namHoc, STC, maSV, maNganh);
                    int result = hocphan_DAO.getInstance().insert(ct);

                    if (result > 0) {
                        JOptionPane.showMessageDialog(this, "Thêm thành công");
                        this.render();
                        this.reset();
                    } else {
                        JOptionPane.showMessageDialog(this, "Thêm thất bại");
                    }
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập một số nguyên hợp lệ cho năm học và số tín chỉ.");
        }
    }

    public void update() {
        // Kiểm tra xem maHP có giá trị không
        if (maHP != null && !maHP.isEmpty()) {
            String tenHP = text_tenHP.getText();

            // Kiểm tra xem giá trị nhập vào từ trường văn bản có phải là một số nguyên hợp lệ không
            try {
                int namHoc = Integer.parseInt(text_namHoc.getText());
                int STC = Integer.parseInt(text_STC.getText());

                String maSV = cb_maSV.getSelectedItem().toString();
                String maNganh = cb_maNganh.getSelectedItem().toString();

                hocphan ct = new hocphan(maHP, tenHP, namHoc, STC, maSV, maNganh);
                int result = hocphan_DAO.getInstance().update(ct);

                if (result > 0) {
                    JOptionPane.showMessageDialog(this, "Sửa thành công");
                    this.render(); // Hiển thị lại dữ liệu sau khi sửa
                } else {
                    JOptionPane.showMessageDialog(this, "Sửa thất bại");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập một số nguyên hợp lệ cho năm học và số tín chỉ.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn học phần cần sửa");
        }
    }

    public void delete() {
        // Kiểm tra xem maKhoa có giá trị không
        if (maHP != null && !maHP.isEmpty()) {
            String tenHP = text_tenHP.getText();
            int namHoc = Integer.parseInt(text_namHoc.getText());
            int STC = Integer.parseInt(text_STC.getText());
            String maSV = cb_maSV.getSelectedItem().toString();
            String maNganh = cb_maNganh.getSelectedItem().toString();

            boolean hpExists = hocphan_DAO.getInstance().isExistsForHocPhan(maHP);

            if (hpExists) {
                JOptionPane.showMessageDialog(this, "Không thể xóa, dữ liệu còn tồn tại!!.");
            } else {
                int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa không?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    hocphan ct = new hocphan(maHP, tenHP, namHoc, STC, maSV, maNganh);
                    int result = hocphan_DAO.getInstance().delete(ct);
                    if (result > 0) {
                        JOptionPane.showMessageDialog(this, "Xóa thành công");
                        this.reset();
                        this.render();
                    } else {
                        JOptionPane.showMessageDialog(this, "Xóa thất bại");
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn tài khoản cần xóa");
        }
    }

    public void btnsearch() {
        String keyword = text_search.getText();
        ArrayList<hocphan> searchResult = hocphan_DAO.getInstance().Search(keyword);

        if (searchResult.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy kết quả nào!");
        } else {
            model.setRowCount(0);
            int stt = 0;
            for (hocphan ct : searchResult) {
                stt++;
                Object[] rowdata = {stt, ct.getMaHP(), ct.getTenHP(), ct.getNamHoc(), ct.getSTC(), ct.getMaSV(), ct.getMaNganh()};
                model.addRow(rowdata);
            }
        }
    }
}
