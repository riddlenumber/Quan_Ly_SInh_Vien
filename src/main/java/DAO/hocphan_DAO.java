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
import model.hocphan;

/**
 *
 * @author Admin
 */
public class hocphan_DAO implements DAO_interface<hocphan> {

    public static hocphan_DAO getInstance() {
        return new hocphan_DAO();
    }

    public boolean primakeyKeyExists(String maHP) {
        try {
            connect connector = new connect();
            // Gọi phương thức getConnection() trên đối tượng connect để nhận kết nối đến cơ sở dữ liệu
            Connection con = connector.getConnection();

            Statement st = con.createStatement();

            // Kiểm tra xem có dữ liệu từ bảng nganh tham chiếu đến maKhoa không
            String query = "SELECT COUNT(*) FROM hocphan WHERE maHP = '" + maHP + "'";
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
    public int insert(hocphan t) {
        int kq = 0;
        try {
            connect connector = new connect();
            Connection con = connector.getConnection();
            Statement st = con.createStatement();

            String sql = "INSERT INTO hocphan VALUES('" + t.getMaHP() + "','" + t.getTenHP() + "','" + t.getNamHoc() + "','" + t.getSTC() + "','" + t.getMaSV() + "','" + t.getMaNganh() + "')";

            System.err.println(sql);
            kq = st.executeUpdate(sql);
            con.close();
        } catch (SQLException e) {
            e.printStackTrace(); // In ra thông tin lỗi để xác định nguyên nhân
        }
        return kq;
    }

    @Override
    public int update(hocphan t) {
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
            String sql = "UPDATE hocphan SET tenHP = '" + t.getTenHP() + "' , namHoc = '" + t.getNamHoc() + "', STC = '" + t.getSTC() + "', maSV = '" + t.getMaSV() + "', maNganh = '" + t.getMaNganh() + "' "
                    + "WHERE maHP = '" + t.getMaHP() + "'";

            System.err.println(sql);
            kq = st.executeUpdate(sql);
            con.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return kq; // Trả về giá trị kq để kiểm tra thành công hoặc thất bại
    }

    public boolean isExistsForHocPhan(String maHP) {
        try {
            connect connector = new connect();
            // Gọi phương thức getConnection() trên đối tượng connect để nhận kết nối đến cơ sở dữ liệu
            Connection con = connector.getConnection();

            Statement st = con.createStatement();

            // Kiểm tra xem có dữ liệu từ bảng nganh tham chiếu đến maKhoa không
            String query = "SELECT COUNT(*) FROM diemhp WHERE maHP = '" + maHP + "'";
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
    public int delete(hocphan t) {
        int kq = 0; // Khai báo và khởi tạo biến kq
        try {
            //b1 tạo kết nối csdl
            connect connector = new connect();
            // Gọi phương thức getConnection() trên đối tượng connect để nhận kết nối đến cơ sở dữ liệu
            Connection con = connector.getConnection();

            //b2 tạo ra 1 đối tượng stament
            Statement st = con.createStatement();

            //b3 thực hiện vc thêm 
            String sql = "DELETE FROM hocphan WHERE maHP = '" + t.getMaHP() + "'";

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
    public ArrayList<hocphan> selectAll() {
        ArrayList<hocphan> hocphans = new ArrayList<hocphan>();
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
            String sql = "SELECT * FROM hocphan";

            System.err.println(sql);
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String maHP = rs.getString("maHP");
                String tenHP = rs.getString("tenHP");
                int namHoc = rs.getInt("namHoc");
                int STC = rs.getInt("STC");
                String maSV = rs.getString("maSV");
                String maNganh = rs.getString("maNganh");

                hocphan danhmuc = new hocphan(maHP, tenHP, namHoc, STC, maSV, maNganh);
                hocphans.add(danhmuc);
            }
            con.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return hocphans;
    }

    @Override
    public hocphan selectByid(hocphan t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<hocphan> selectByCondition(String Condition) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String selectTenHP(String maHP) {
        String tenHP = null;
        try {
            connect connector = new connect();
            Connection con = connector.getConnection();
            Statement st = con.createStatement();

            String sql = "SELECT tenHP FROM hocphan WHERE maHP = '" + maHP + "'";
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                tenHP = rs.getString("tenHP");
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tenHP;
    }

    public ArrayList<hocphan> Search(String keyword) {
        ArrayList<hocphan> hocphans = new ArrayList<hocphan>();
        // TODO Auto-generated method stub
        try {
            connect connector = new connect();
            Connection con = connector.getConnection();
            Statement st = con.createStatement();

            String sql = "SELECT * FROM hocphan";

            if (!keyword.isEmpty()) {
                sql += " WHERE maHP LIKE '%" + keyword + "%' OR tenHP LIKE '%" + keyword + "%'";
            }

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String maHP = rs.getString("maHP");
                String tenHP = rs.getString("tenHP");
                int namHoc = rs.getInt("namHoc");
                int STC = rs.getInt("STC");
                String maSV = rs.getString("maSV");
                String maNganh = rs.getString("maNganh");

                hocphan danhmuc = new hocphan(maHP, tenHP, namHoc, STC, maSV, maNganh);
                hocphans.add(danhmuc);
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hocphans;
    }
}
