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
import model.nganh;

/**
 *
 * @author Admin
 */
public class nganh_DAO implements DAO_interface<nganh> {

    public static nganh_DAO getInstance() {
        return new nganh_DAO();
    }

    public boolean primakeyKeyExists(String maNganh) {
        try {
            connect connector = new connect();
            // Gọi phương thức getConnection() trên đối tượng connect để nhận kết nối đến cơ sở dữ liệu
            Connection con = connector.getConnection();

            Statement st = con.createStatement();

            // Kiểm tra xem có dữ liệu từ bảng nganh tham chiếu đến maKhoa không
            String query = "SELECT COUNT(*) FROM nganh WHERE maNganh = '" + maNganh + "'";
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
    public int insert(nganh t) {
        int kq = 0;
        try {
            connect connector = new connect();
            Connection con = connector.getConnection();
            Statement st = con.createStatement();

            String sql = "INSERT INTO nganh VALUES('" + t.getMaNganh() + "','" + t.getTenNganh() + "','" + t.getMaKhoa() + "')";

            System.err.println(sql);
            kq = st.executeUpdate(sql);
            con.close();
        } catch (SQLException e) {
            e.printStackTrace(); // In ra thông tin lỗi để xác định nguyên nhân
        }
        return kq;
    }

    @Override
    public int update(nganh t) {
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
            String sql = "UPDATE nganh SET tenNganh = '" + t.getTenNganh() + "' , maKhoa = '" + t.getMaKhoa() + "' "
                    + "WHERE maNganh = '" + t.getMaNganh() + "'";

            System.err.println(sql);
            kq = st.executeUpdate(sql);
            con.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return kq; // Trả về giá trị kq để kiểm tra thành công hoặc thất bại
    }

    public boolean isExistsForNganh(String maNganh) {
        try {
            connect connector = new connect();
            // Gọi phương thức getConnection() trên đối tượng connect để nhận kết nối đến cơ sở dữ liệu
            Connection con = connector.getConnection();

            Statement st = con.createStatement();

            // Kiểm tra xem có dữ liệu từ bảng nganh tham chiếu đến maKhoa không
            String query = "SELECT COUNT(*) FROM lop WHERE maNganh = '" + maNganh + "'";
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

    public boolean isExistsForNganh1(String maNganh) {
        try {
            connect connector = new connect();
            // Gọi phương thức getConnection() trên đối tượng connect để nhận kết nối đến cơ sở dữ liệu
            Connection con = connector.getConnection();

            Statement st = con.createStatement();

            // Kiểm tra xem có dữ liệu từ bảng nganh tham chiếu đến maKhoa không
            String query = "SELECT COUNT(*) FROM hocphan WHERE maNganh = '" + maNganh + "'";
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
    public int delete(nganh t) {
        int kq = 0; // Khai báo và khởi tạo biến kq
        try {
            //b1 tạo kết nối csdl
            connect connector = new connect();
            // Gọi phương thức getConnection() trên đối tượng connect để nhận kết nối đến cơ sở dữ liệu
            Connection con = connector.getConnection();

            //b2 tạo ra 1 đối tượng stament
            Statement st = con.createStatement();

            //b3 thực hiện vc thêm 
            String sql = "DELETE FROM nganh WHERE maNganh = '" + t.getMaNganh() + "'";

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
    public ArrayList<nganh> selectAll() {
        ArrayList<nganh> nganhs = new ArrayList<nganh>();
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
            String sql = "SELECT * FROM nganh";

            System.err.println(sql);
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String maNganh = rs.getString("maNganh");
                String tenNganh = rs.getString("tenNganh");
                String maKhoa = rs.getString("maKhoa");

                nganh danhmuc = new nganh(maNganh, tenNganh, maKhoa);
                nganhs.add(danhmuc);
            }
            con.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return nganhs;
    }

    @Override
    public nganh selectByid(nganh t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<nganh> selectByCondition(String Condition) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public ArrayList<nganh> Search(String keyword) {
        ArrayList<nganh> nganhs = new ArrayList<nganh>();
        // TODO Auto-generated method stub
        try {
            connect connector = new connect();
            Connection con = connector.getConnection();
            Statement st = con.createStatement();

            String sql = "SELECT * FROM nganh";

            // Nếu có từ khóa tìm kiếm, thêm điều kiện WHERE vào câu truy vấn
            if (!keyword.isEmpty()) {
                sql += " WHERE maNganh LIKE '%" + keyword + "%' OR tenNganh LIKE '%" + keyword + "%'";
            }

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String maNganh = rs.getString("maNganh");
                String tenNganh = rs.getString("tenNganh");
                String maKhoa = rs.getString("maKhoa");

                nganh danhmuc = new nganh(maNganh, tenNganh, maKhoa);
                nganhs.add(danhmuc);
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nganhs;
    }

}
