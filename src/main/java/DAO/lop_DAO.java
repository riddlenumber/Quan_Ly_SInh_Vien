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
import model.lop;

/**
 *
 * @author Admin
 */
public class lop_DAO implements DAO_interface<lop> {

    public static lop_DAO getInstance() {
        return new lop_DAO();
    }

    public boolean primakeyKeyExists(String maLop) {
        try {
            connect connector = new connect();
            // Gọi phương thức getConnection() trên đối tượng connect để nhận kết nối đến cơ sở dữ liệu
            Connection con = connector.getConnection();

            Statement st = con.createStatement();

            // Kiểm tra xem có dữ liệu từ bảng nganh tham chiếu đến maKhoa không
            String query = "SELECT COUNT(*) FROM lop WHERE maLop = '" + maLop + "'";
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
    public int insert(lop t) {
        int kq = 0;
        try {
            connect connector = new connect();
            Connection con = connector.getConnection();
            Statement st = con.createStatement();

            String sql = "INSERT INTO lop VALUES('" + t.getMaLop() + "','" + t.getTenLop() + "','" + t.getMaNganh() + "')";

            System.err.println(sql);
            kq = st.executeUpdate(sql);
            con.close();
        } catch (SQLException e) {
            e.printStackTrace(); // In ra thông tin lỗi để xác định nguyên nhân
        }
        return kq;
    }

    @Override
    public int update(lop t) {
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
            String sql = "UPDATE lop SET tenLop = '" + t.getTenLop() + "' , maNganh = '" + t.getMaNganh() + "' "
                    + "WHERE maLop = '" + t.getMaLop() + "'";

            System.err.println(sql);
            kq = st.executeUpdate(sql);
            con.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return kq; // Trả về giá trị kq để kiểm tra thành công hoặc thất bại
    }

    public boolean isExistsForLop(String maLop) {
        try {
            connect connector = new connect();
            // Gọi phương thức getConnection() trên đối tượng connect để nhận kết nối đến cơ sở dữ liệu
            Connection con = connector.getConnection();

            Statement st = con.createStatement();

            // Kiểm tra xem có dữ liệu từ bảng nganh tham chiếu đến maKhoa không
            String query = "SELECT COUNT(*) FROM lop WHERE maLop = '" + maLop + "'";
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
    public int delete(lop t) {
        int kq = 0; // Khai báo và khởi tạo biến kq
        try {
            //b1 tạo kết nối csdl
            connect connector = new connect();
            // Gọi phương thức getConnection() trên đối tượng connect để nhận kết nối đến cơ sở dữ liệu
            Connection con = connector.getConnection();

            //b2 tạo ra 1 đối tượng stament
            Statement st = con.createStatement();

            //b3 thực hiện vc thêm 
            String sql = "DELETE FROM lop WHERE maLop = '" + t.getMaLop() + "'";

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
    public ArrayList<lop> selectAll() {
        ArrayList<lop> lops = new ArrayList<lop>();
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
            String sql = "SELECT * FROM lop";

            System.err.println(sql);
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String maLop = rs.getString("maLop");
                String tenLop = rs.getString("tenLop");
                String maNganh = rs.getString("maNganh");

                lop danhmuc = new lop(maLop, tenLop, maNganh);
                lops.add(danhmuc);
            }
            con.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return lops;
    }

    @Override
    public lop selectByid(lop t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<lop> selectByCondition(String Condition) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public ArrayList<lop> Search(String keyword) {
        ArrayList<lop> lops = new ArrayList<lop>();
        // TODO Auto-generated method stub
        try {
            connect connector = new connect();
            Connection con = connector.getConnection();
            Statement st = con.createStatement();

            String sql = "SELECT * FROM lop";

            // Nếu có từ khóa tìm kiếm, thêm điều kiện WHERE vào câu truy vấn
            if (!keyword.isEmpty()) {
                sql += " WHERE maLop LIKE '%" + keyword + "%' OR tenLop LIKE '%" + keyword + "%'";
            }

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String maLop = rs.getString("maLop");
                String tenLop = rs.getString("tenLop");
                String maNganh = rs.getString("maNganh");

                lop danhmuc = new lop(maLop, tenLop, maNganh);
                lops.add(danhmuc);
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lops;
    }

}
