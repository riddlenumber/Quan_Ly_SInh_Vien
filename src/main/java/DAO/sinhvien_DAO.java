/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import controller.connect;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.sinhvien;

/**
 *
 * @author Admin
 */
public class sinhvien_DAO implements DAO_interface<sinhvien> {

    public static sinhvien_DAO getInstance() {
        return new sinhvien_DAO();
    }

    @Override
    public int insert(sinhvien t) {
        int kq = 0;
        try {
            connect connector = new connect();
            Connection con = connector.getConnection();
            Statement st = con.createStatement();

            String sql = "INSERT INTO sinhvien VALUES('" + t.getId() + "','" + t.getMaSV() + "','" + t.getAnh() + "','" + t.getTenSV() + "','" + t.getNgaySinh() + "','" + t.getGioiTinh() + "','" + t.getEmail() + "','" + t.getDiaChi() + "','" + t.getMaLop() + "')";

            System.err.println(sql);
            kq = st.executeUpdate(sql);
            con.close();
        } catch (SQLException e) {
            e.printStackTrace(); // In ra thông tin lỗi để xác định nguyên nhân
        }
        return kq;
    }

    @Override
    public int update(sinhvien t) {
        int kq = 0;
        try {
            //b1 tạo kết nối csdl
            //Connection con = connect.getConnection();

            connect connector = new connect();
            // Gọi phương thức getConnection() trên đối tượng connect để nhận kết nối đến cơ sở dữ liệu
            Connection con = connector.getConnection();

            //b2 tạo ra 1 đối tượng stament
            Statement st = con.createStatement();

            //b3 thực hiện vc thêm 
            String sql = "UPDATE sinhvien SET id = '" + t.getId() + "', tenSV = '" + t.getTenSV() + "' , anh = '" + t.getAnh() + "' , ngaySinh = '" + t.getNgaySinh() + "' , gioiTinh = '" + t.getGioiTinh() + "' , email = '" + t.getEmail() + "' , diaChi = '" + t.getDiaChi() + "' , maLop = '" + t.getMaLop() + "' "
                    + "WHERE maSV = '" + t.getMaSV() + "'";

            System.err.println(sql);
            kq = st.executeUpdate(sql);
            con.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return kq; // Trả về giá trị kq để kiểm tra thành công hoặc thất bại
    }
    
     public boolean isExistsForSV(String maSV) {
        try {
            connect connector = new connect();
            // Gọi phương thức getConnection() trên đối tượng connect để nhận kết nối đến cơ sở dữ liệu
            Connection con = connector.getConnection();

            Statement st = con.createStatement();

            // Kiểm tra xem có dữ liệu từ bảng nganh tham chiếu đến maKhoa không
            String query = "SELECT COUNT(*) FROM hocphan WHERE maSV = '" + maSV + "'";
            ResultSet rs = st.executeQuery(query);

            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }

            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
     
     
      public boolean isExistsForSV1(String maSV) {
        try {
            connect connector = new connect();
            // Gọi phương thức getConnection() trên đối tượng connect để nhận kết nối đến cơ sở dữ liệu
            Connection con = connector.getConnection();

            Statement st = con.createStatement();

            // Kiểm tra xem có dữ liệu từ bảng nganh tham chiếu đến maKhoa không
            String query = "SELECT COUNT(*) FROM diemhp WHERE maSV = '" + maSV + "'";
            ResultSet rs = st.executeQuery(query);

            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }

            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    @Override
    public int delete(sinhvien t) {
        int kq = 0; // Khai báo và khởi tạo biến kq
        try {
            //b1 tạo kết nối csdl
            connect connector = new connect();
            // Gọi phương thức getConnection() trên đối tượng connect để nhận kết nối đến cơ sở dữ liệu
            Connection con = connector.getConnection();

            //b2 tạo ra 1 đối tượng stament
            Statement st = con.createStatement();

            //b3 thực hiện vc thêm 
            String sql = "DELETE FROM sinhvien WHERE maSV = '" + t.getMaSV() + "'";

            System.err.println(sql);
            kq = st.executeUpdate(sql); // Gán giá trị cho biến kq
            con.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return kq;
    }

    @Override
    public ArrayList<sinhvien> selectAll() {
        ArrayList<sinhvien> sinhviens = new ArrayList<sinhvien>();
        // TODO Auto-generated method stub
        try {
            //b1 tạo kết nối csdl
//            Connection con = connect.getConnection();

            connect connector = new connect();
            // Gọi phương thức getConnection() trên đối tượng connect để nhận kết nối đến cơ sở dữ liệu
            Connection con = connector.getConnection();

            //b2 tạo ra 1 đối tượng stament
            Statement st = con.createStatement();

            //b3 thực hiện vc thêm 
            String sql = "SELECT * FROM sinhvien";

            System.err.println(sql);
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String id = rs.getString("id");
                String maSV = rs.getString("maSV");
                String anh = rs.getString("anh");
                String tenSV = rs.getString("tenSV");
                String ngaySinh = rs.getString("ngaySinh");
                String gioiTinh = rs.getString("gioiTinh");
                String email = rs.getString("email");
                String diaChi = rs.getString("diaChi");
                String maLop = rs.getString("maLop");

                sinhvien danhmuc = new sinhvien(id, maSV, anh, tenSV, ngaySinh, gioiTinh, email, diaChi, maLop);
                sinhviens.add(danhmuc);
            }
            con.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return sinhviens;
    }

    @Override
    public sinhvien selectByid(sinhvien t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<sinhvien> selectByCondition(String Condition) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
