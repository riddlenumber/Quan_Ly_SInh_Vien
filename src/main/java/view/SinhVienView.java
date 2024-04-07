/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import DAO.lop_DAO;
import DAO.nganh_DAO;
import DAO.sinhvien_DAO;
import DAO.user_DAO;
import controller.LopController;
import controller.SinhVienController;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.lop;
import model.nganh;
import model.sinhvien;
import model.user;
import org.jdesktop.swingx.JXDatePicker;

/**
 *
 * @author Admin
 */
public class SinhVienView extends JFrame {

    private JComboBox box_dm;
    private int selectedRow;
    private DefaultTableModel model;
    private JScrollPane jScrollPane1;
    private JTable table;
    private String maSV;
    private JTextField text_maSV;
    private JTextField text_tenSV;
    private JTextField text_ngaySinh;
    private JTextField text_gioiTinh;
    private JTextField text_email;
    private JTextField text_diaChi;
    private JComboBox<String> cb_id;
    private JComboBox<String> cb_maLop;
    private JLabel lb_img;
    private JPanel jp_avatar;
    private Image image, scaledImage;
    private ImageIcon icon;
    private String path, Paths;
    private ArrayList<String> avtaray = new ArrayList<>();

    private JLabel lblAvatar;
    private JButton btnChooseImage;
    private String imagePath;
    private String newImagePath;

    private JXDatePicker datePicker;

    public SinhVienView() {
        this.setTitle("Sinh viên");
        this.setSize(1800, 750);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.init();
        this.setVisible(true);
        this.render();
    }

    public void init() {
        ActionListener ac = new SinhVienController(this);
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

        JPanel jpanel_Content_Center_Right = new JPanel();
        jpanel_Content_Center_Right.setBorder(new EmptyBorder(0, 30, 0, 0));
        jpanel_Content_Center_Right.setLayout(new BoxLayout(jpanel_Content_Center_Right, BoxLayout.Y_AXIS));
        //JPanel jp_avatar= new JPanel();
        JButton bt_choose = new JButton("Choose");
        bt_choose.setFont(font);
        bt_choose.setPreferredSize(new Dimension(100, 30));
        bt_choose.addActionListener(ac);

        cb_id = new JComboBox<>();
        cb_id.setFont(font);
        cb_id.setPreferredSize(new Dimension(150, 30)); // Đặt kích thước cho JComboBox
        JLabel jLabel_id2 = new JLabel("Mã danh mục id");
        jLabel_id2.setFont(font);

        ArrayList<user> listUser = user_DAO.getInstance().selectAll();
        for (user user : listUser) {
            cb_id.addItem(user.getId());
        }

        text_maSV = new JTextField();
        text_maSV.setFont(font);
        text_maSV.setColumns(15);
        JLabel jLabel_id = new JLabel("Mã danh mục sinh viên");
        jLabel_id.setFont(font);

        lb_img = new JLabel();
        jp_avatar = new JPanel();

        jp_avatar.setPreferredSize(new Dimension(170, 150));
        //jp_avatar.setBackground(Color.BLUE);

        jp_avatar.add(lb_img);
        jpanel_Content_Center_Right.add(jp_avatar);
        jpanel_Content_Center_Right.add(bt_choose);

        lblAvatar = new JLabel();
        lblAvatar.setPreferredSize(new Dimension(10, 10)); // Đặt kích thước cho khung ảnh
        lblAvatar.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        btnChooseImage = new JButton("Chọn ảnh");
        btnChooseImage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                choosefile();
            }
        });

        text_tenSV = new JTextField();
        text_tenSV.setFont(font);
        text_tenSV.setColumns(15);
        JLabel jLabel_name = new JLabel("Tên sinh viên");
        jLabel_name.setFont(font);

        datePicker = new JXDatePicker(); // Thêm dòng này
        datePicker.setFont(font);
        datePicker.setPreferredSize(new Dimension(40, 15));
        JLabel jLabel_name1 = new JLabel("Ngày sinh");
        jLabel_name1.setFont(font);

        text_ngaySinh = new JTextField(); // Thêm dòng này
        text_ngaySinh.setFont(font); // Thêm dòng này
        text_ngaySinh.setColumns(15); // Thêm dòng này

        text_gioiTinh = new JTextField();
        text_gioiTinh.setFont(font);
        text_gioiTinh.setColumns(15);
        JLabel jLabel_name2 = new JLabel("Giới tính");
        jLabel_name2.setFont(font);

        text_email = new JTextField();
        text_email.setFont(font);
        text_email.setColumns(15);
        JLabel jLabel_name3 = new JLabel("Email");
        jLabel_name3.setFont(font);

        text_diaChi = new JTextField();
        text_diaChi.setFont(font);
        text_diaChi.setColumns(15);
        JLabel jLabel_name4 = new JLabel("Địa chỉ");
        jLabel_name4.setFont(font);

        cb_maLop = new JComboBox<>();
        cb_maLop.setFont(font);
        cb_maLop.setPreferredSize(new Dimension(150, 30)); // Đặt kích thước cho JComboBox
        JLabel jLabel_id1 = new JLabel("Mã lớp");
        jLabel_id1.setFont(font);

        ArrayList<lop> listLop = lop_DAO.getInstance().selectAll();
        for (lop lop : listLop) {
            cb_maLop.addItem(lop.getMaLop());
        }

        JPanel jp_North = new JPanel(new BorderLayout());
        EmptyBorder border1 = new EmptyBorder(20, 20, 20, 20);

        jp_North.setBorder(border1);
        JPanel jpCenter = new JPanel();

        jpCenter.setBorder(
                new EmptyBorder(10, 20, 20, 20));

        JPanel jp_title = new JPanel(new FlowLayout());

        jp_title.setBorder(border1);
        JLabel title = new JLabel("Quản lý danh mục sinh viên");

        title.setFont(
                new Font("Arial", Font.BOLD, 20));
        jp_title.add(title);

        GridLayout layout2 = new GridLayout(3, 2);

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

        jp_North_content_North.add(jLabel_id2);

        jp_North_content_North.add(cb_id);

        jp_North_content_North.add(jLabel_id);

        jp_North_content_North.add(text_maSV);

        jp_North_content_North.add(lblAvatar);
        jp_North_content_North.add(btnChooseImage);

        jp_North_content_North.add(jLabel_name);

        jp_North_content_North.add(text_tenSV);

        jp_North_content_North.add(jLabel_name1);

        jp_North_content_North.add(datePicker);

        jp_North_content_North.add(jLabel_name2);

        jp_North_content_North.add(text_gioiTinh);

        jp_North_content_North.add(jLabel_name3);

        jp_North_content_North.add(text_email);

        jp_North_content_North.add(jLabel_name4);

        jp_North_content_North.add(text_diaChi);

        jp_North_content_North.add(jLabel_id1);

        jp_North_content_North.add(cb_maLop);

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
                new Dimension(900, 190));
        //jScrollPane1= new JScrollPane(table,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0 && selectedRow < model.getRowCount()) {
                    String id = model.getValueAt(selectedRow, 1).toString();
                    String maSV = model.getValueAt(selectedRow, 2).toString();
                    String tenSV = model.getValueAt(selectedRow, 3).toString();
                    String ngaySinh = model.getValueAt(selectedRow, 4).toString();
                    String gioiTinh = model.getValueAt(selectedRow, 5).toString();
                    String email = model.getValueAt(selectedRow, 6).toString();
                    String diaChi = model.getValueAt(selectedRow, 7).toString();
                    String maLop = model.getValueAt(selectedRow, 8).toString();
                    String path = model.getValueAt(selectedRow, 9).toString();

                    // Display data in corresponding fields
                    cb_id.setSelectedItem(id);
                    text_maSV.setText(maSV);
                    text_tenSV.setText(tenSV);

                    // Update value for JXDatePicker
                    try {
                        Date selectedDate = new SimpleDateFormat("yyyy-MM-dd").parse(ngaySinh);
                        datePicker.setDate(selectedDate);
                    } catch (ParseException ex) {
                        ex.printStackTrace();
                    }

                    text_gioiTinh.setText(gioiTinh);
                    text_email.setText(email);
                    text_diaChi.setText(diaChi);
                    cb_maLop.setSelectedItem(maLop);

                    // Load and display image on JLabel
                    if (path != null && !path.isEmpty()) {
                        ImageIcon imageIcon = new ImageIcon(path);
                        Image image = imageIcon.getImage().getScaledInstance(lblAvatar.getWidth(), lblAvatar.getHeight(), Image.SCALE_SMOOTH);
                        lblAvatar.setIcon(new ImageIcon(image));
                    }

                    // Save student ID
                    SinhVienView.this.maSV = maSV;
                }
            }
        });

        jScrollPane1 = new JScrollPane();
        //jScrollPane1.setSize(20, 10);

        jScrollPane1.setViewportView(table);

        jpCenter.add(jScrollPane1);

        this.setLayout(
                new BorderLayout());

        this.add(jp_North, BorderLayout.NORTH);

        this.add(jpCenter, BorderLayout.CENTER);

    }

    public void choosefile() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "jpg", "jpeg", "png", "gif");
        fileChooser.setFileFilter(filter);

        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            imagePath = selectedFile.getAbsolutePath();
            // Hiển thị ảnh trên JLabel
            ImageIcon imageIcon = new ImageIcon(imagePath);
            Image image = imageIcon.getImage().getScaledInstance(lblAvatar.getWidth(), lblAvatar.getHeight(), Image.SCALE_SMOOTH);
            lblAvatar.setIcon(new ImageIcon(image));
            // Lưu đường dẫn ảnh
            path = imagePath;
        }
    }

    public void reset() {
        // TODO Auto-generated method stub
        text_maSV.setText("");
        text_tenSV.setText("");
        text_ngaySinh.setText("");
        text_gioiTinh.setText("");
        text_email.setText("");
        text_diaChi.setText("");
//        path = null;
//        lb_img.setIcon(null);
        cb_maLop.setSelectedIndex(0);
        cb_id.setSelectedIndex(0);

        lblAvatar.setIcon(null);

        // Gán giá trị null cho đường dẫn ảnh
        imagePath = null;

    }

    public void render() {
        model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{
            "STT", "ID", "Mã sinh viên", "Tên sinh viên", "Ngày sinh", "Giới tính", "Email", "Địa chỉ", "Mã lớp", "Ảnh"
        });
        sinhvien_DAO dao = new sinhvien_DAO();
        ArrayList<sinhvien> students = dao.selectAll();

        int stt = 0;
        if (students.size() > 0) {
            for (sinhvien student : students) {
                stt++;
                Object[] rowData = {
                    stt,
                    student.getId(),
                    student.getMaSV(),
                    student.getTenSV(),
                    student.getNgaySinh(), // Cập nhật hiển thị ngày sinh
                    student.getGioiTinh(),
                    student.getEmail(),
                    student.getDiaChi(),
                    student.getMaLop(),
                    student.getAnh()
                };
                model.addRow(rowData);
            }
        }
        table.setModel(model);

        // Hiển thị ảnh
        table.getColumnModel().getColumn(9).setCellRenderer(new ImageRenderer());
    }

// Thêm lớp ImageRenderer để hiển thị ảnh
    class ImageRenderer extends DefaultTableCellRenderer {

        JLabel lbl = new JLabel();

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            if (value != null) {
                ImageIcon icon = new ImageIcon(value.toString());
                Image image = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                lbl.setIcon(new ImageIcon(image));
            } else {
                lbl.setIcon(null);
            }
            return lbl;
        }
    }

    public void insert() {
        String maSV = text_maSV.getText();
        String tenSV = text_tenSV.getText();
//        String ngaySinh = text_ngaySinh.getText();

        Date selectedDate = datePicker.getDate();
        String ngaySinh = new SimpleDateFormat("yyyy-MM-dd").format(selectedDate);
        String gioiTinh = text_gioiTinh.getText();
        String email = text_email.getText();
        String diaChi = text_diaChi.getText();
        String maLop = cb_maLop.getSelectedItem().toString();
        String id = cb_id.getSelectedItem().toString();

        // Kiểm tra xem đã chọn ảnh hay chưa
        if (imagePath != null && !imagePath.isEmpty()) {
            String anh = imagePath.replace("\\", "\\\\"); // Thay thế các ký tự backslash bằng hai backslash
            avtaray.add(anh.replace("\\\\", "\\"));

            // Gán giá trị cho biến path
            path = anh;

            sinhvien ct = new sinhvien(id, maSV, anh, tenSV, ngaySinh, gioiTinh, email, diaChi, maLop);
            int result = sinhvien_DAO.getInstance().insert(ct);

            if (result > 0) {
                JOptionPane.showMessageDialog(this, "Thêm thành công");
                this.render();
                this.reset();
            } else {
                System.out.println("Thêm thất bại");
                JOptionPane.showMessageDialog(this, "Thêm thất bại");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn ảnh");
        }
    }

    public void update() {
        // Kiểm tra xem maSV có giá trị không
        if (maSV != null && !maSV.isEmpty()) {
            String maSV = text_maSV.getText();
            String tenSV = text_tenSV.getText();
            Date selectedDate = datePicker.getDate();
            String ngaySinh = new SimpleDateFormat("yyyy-MM-dd").format(selectedDate);
            String gioiTinh = text_gioiTinh.getText();
            String email = text_email.getText();
            String diaChi = text_diaChi.getText();
            String maLop = cb_maLop.getSelectedItem().toString();
            String id = cb_id.getSelectedItem().toString();

            // Kiểm tra xem có đường dẫn ảnh mới được chọn không
            if (imagePath != null && !imagePath.isEmpty()) {
                // Cập nhật đường dẫn ảnh mới
                path = imagePath.replace("\\", "\\\\");
            }

            // Kiểm tra xem đường dẫn ảnh có tồn tại không
            if (path != null && !path.isEmpty()) {
                // Tạo đối tượng sinh viên với đường dẫn ảnh mới (nếu có)
                sinhvien ct = new sinhvien(id, maSV, path, tenSV, ngaySinh, gioiTinh, email, diaChi, maLop);
                int result = sinhvien_DAO.getInstance().update(ct);

                if (result > 0) {
                    JOptionPane.showMessageDialog(this, "Sửa thành công");
                    this.render();
                } else {
                    JOptionPane.showMessageDialog(this, "Sửa thất bại");
                }
            } else {
                // Nếu không có đường dẫn ảnh mới, sử dụng đường dẫn ảnh cũ
                path = lblAvatar.getIcon().toString(); // Lấy đường dẫn ảnh hiện tại
                sinhvien ct = new sinhvien(id, maSV, path, tenSV, ngaySinh, gioiTinh, email, diaChi, maLop);
                int result = sinhvien_DAO.getInstance().update(ct);

                if (result > 0) {
                    JOptionPane.showMessageDialog(this, "Sửa thành công");
                    this.render();
                } else {
                    JOptionPane.showMessageDialog(this, "Sửa thất bại");
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn tài khoản cần sửa");
        }
    }

    public void delete() {
        // Kiểm tra xem đã chọn sinh viên nào chưa
        if (maSV != null && !maSV.isEmpty()) {
            
            boolean svExists = sinhvien_DAO.getInstance().isExistsForSV(maSV);
             boolean svExists1 = sinhvien_DAO.getInstance().isExistsForSV1(maSV);
            
             if (svExists || svExists1) {
                JOptionPane.showMessageDialog(this, "Không thể xóa, dữ liệu còn tồn tại!!.");
            } else {
            
            
            int choice = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa sinh viên này không?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);

            // Nếu người dùng chọn Yes
            if (choice == JOptionPane.YES_OPTION) {
                String maSV = text_maSV.getText();
                String tenSV = text_tenSV.getText();
                Date selectedDate = datePicker.getDate();
                String ngaySinh = new SimpleDateFormat("yyyy-MM-dd").format(selectedDate);
                String gioiTinh = text_gioiTinh.getText();
                String email = text_email.getText();
                String diaChi = text_diaChi.getText();
                String maLop = cb_maLop.getSelectedItem().toString();
                String id = cb_id.getSelectedItem().toString();

                // Tạo đối tượng sinh viên chỉ với thông tin liên quan đến sinh viên
                sinhvien ct = new sinhvien(id, maSV, null, tenSV, ngaySinh, gioiTinh, email, diaChi, maLop);
                int result = sinhvien_DAO.getInstance().delete(ct); // Sử dụng phương thức delete() thích hợp

                if (result > 0) {
                    JOptionPane.showMessageDialog(this, "Xóa thành công");
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

}
