/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author Admin
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import controller.connect;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.khoa;
import model.user;

import controller.connect;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controller.connect;
import java.sql.Connection;

/**
 *
 * @author ADMIN
 */
public class khoa_DAO implements DAO_interface<khoa> {

    public static khoa_DAO getInstance() {
        return new khoa_DAO();
    }

    public boolean primakeyKeyExists(String maKhoa) {
        try {
            connect connector = new connect();
            // Gọi phương thức getConnection() trên đối tượng connect để nhận kết nối đến cơ sở dữ liệu
            Connection con = connector.getConnection();

            Statement st = con.createStatement();

            // Kiểm tra xem có dữ liệu từ bảng nganh tham chiếu đến maKhoa không
            String query = "SELECT COUNT(*) FROM khoa WHERE maKhoa = '" + maKhoa + "'";
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
    public int insert(khoa t) {
        int kq = 0;
        try {
            connect connector = new connect();
            Connection con = connector.getConnection();
            Statement st = con.createStatement();

            String sql = "INSERT INTO khoa VALUES('" + t.getMaKhoa() + "','" + t.getTenKhoa() + "')";

            System.err.println(sql);
            kq = st.executeUpdate(sql);
            con.close();
        } catch (SQLException e) {
            e.printStackTrace(); // In ra thông tin lỗi để xác định nguyên nhân
        }
        return kq;
    }

    @Override
    public int update(khoa t) {
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
            String sql = "UPDATE khoa SET tenKhoa = '" + t.getTenKhoa() + "' "
                    + "WHERE maKhoa = '" + t.getMaKhoa() + "'";

            System.err.println(sql);
            kq = st.executeUpdate(sql);
            con.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return kq; // Trả về giá trị kq để kiểm tra thành công hoặc thất bại
    }

    public boolean isExistsForKhoa(String maKhoa) {
        try {
            connect connector = new connect();
            // Gọi phương thức getConnection() trên đối tượng connect để nhận kết nối đến cơ sở dữ liệu
            Connection con = connector.getConnection();

            Statement st = con.createStatement();

            // Kiểm tra xem có dữ liệu từ bảng nganh tham chiếu đến maKhoa không
            String query = "SELECT COUNT(*) FROM nganh WHERE maKhoa = '" + maKhoa + "'";
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
    public int delete(khoa t) {
        int kq = 0; // Khai báo và khởi tạo biến kq
        try {
            //b1 tạo kết nối csdl
            connect connector = new connect();
            // Gọi phương thức getConnection() trên đối tượng connect để nhận kết nối đến cơ sở dữ liệu
            Connection con = connector.getConnection();

            //b2 tạo ra 1 đối tượng stament
            Statement st = con.createStatement();

            //b3 thực hiện vc thêm 
            String sql = "DELETE FROM khoa WHERE maKhoa = '" + t.getMaKhoa() + "'";

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
    public ArrayList<khoa> selectAll() {
        ArrayList<khoa> khoas = new ArrayList<khoa>();
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
            String sql = "SELECT * FROM khoa";

            System.err.println(sql);
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String maKhoa = rs.getString("maKhoa");
                String tenKhoa = rs.getString("tenKhoa");

                khoa danhmuc = new khoa(maKhoa, tenKhoa);
                khoas.add(danhmuc);
            }
            con.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return khoas;
    }

    @Override
    public khoa selectByid(khoa t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<khoa> selectByCondition(String Condition) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public ArrayList<khoa> Search(String keyword) {
        ArrayList<khoa> khoas = new ArrayList<khoa>();
        // TODO Auto-generated method stub
        try {
            connect connector = new connect();
            Connection con = connector.getConnection();
            Statement st = con.createStatement();

            String sql = "SELECT * FROM khoa";

            // Nếu có từ khóa tìm kiếm, thêm điều kiện WHERE vào câu truy vấn
            if (!keyword.isEmpty()) {
                sql += " WHERE maKhoa LIKE '%" + keyword + "%' OR tenKhoa LIKE '%" + keyword + "%'";
            }

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String maKhoa = rs.getString("maKhoa");
                String tenKhoa = rs.getString("tenKhoa");

                khoa danhmuc = new khoa(maKhoa, tenKhoa);
                khoas.add(danhmuc);
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return khoas;
    }

}
