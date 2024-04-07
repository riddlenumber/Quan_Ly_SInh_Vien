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
import model.diemhp;

/**
 *
 * @author Admin
 */
public class diemhp_DAO implements DAO_interface<diemhp> {

    public static diemhp_DAO getInstance() {
        return new diemhp_DAO();
    }

    @Override
    public int insert(diemhp t) {
        int kq = 0;
        try {
            connect connector = new connect();
            Connection con = connector.getConnection();
            Statement st = con.createStatement();

            String sql = "INSERT INTO diemhp VALUES('" + t.getMaSV() + "','" + t.getMaHP() + "','" + t.getTenHP() + "','" + t.getDiemHP() + "')";

            System.err.println(sql);
            kq = st.executeUpdate(sql);
            con.close();
        } catch (SQLException e) {
            e.printStackTrace(); // In ra thông tin lỗi để xác định nguyên nhân
        }
        return kq;
    }

    @Override
    public int update(diemhp t) {
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
            String sql = "UPDATE diemhp SET diemHP = '" + t.getDiemHP() + "' "
                    + "WHERE maSV = '" + t.getMaSV() + "' and maHP =   '" + t.getMaHP() + "'";

            System.err.println(sql);
            kq = st.executeUpdate(sql);
            con.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return kq; // Trả về giá trị kq để kiểm tra thành công hoặc thất bại
    }

//    public boolean isExistsForLop(String maLop) {
//        try {
//            connect connector = new connect();
//            // Gọi phương thức getConnection() trên đối tượng connect để nhận kết nối đến cơ sở dữ liệu
//            Connection con = connector.getConnection();
//
//            Statement st = con.createStatement();
//
//            // Kiểm tra xem có dữ liệu từ bảng nganh tham chiếu đến maKhoa không
//            String query = "SELECT COUNT(*) FROM lop WHERE maLop = '" + maLop + "'";
//            ResultSet rs = st.executeQuery(query);
//
//            if (rs.next()) {
//                int count = rs.getInt(1);
//                return count > 0;
//            }
//
//            con.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return false;
//    }

    @Override
    public int delete(diemhp t) {
        int kq = 0; // Khai báo và khởi tạo biến kq
        try {
            //b1 tạo kết nối csdl
            connect connector = new connect();
            // Gọi phương thức getConnection() trên đối tượng connect để nhận kết nối đến cơ sở dữ liệu
            Connection con = connector.getConnection();

            //b2 tạo ra 1 đối tượng stament
            Statement st = con.createStatement();

            //b3 thực hiện vc thêm 
            String sql = "DELETE FROM diemhp WHERE maSV = '" + t.getMaSV()+ "' and maHP = '" + t.getMaHP()+ "'";

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
    public ArrayList<diemhp> selectAll() {
        ArrayList<diemhp> diemhps = new ArrayList<diemhp>();
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
            String sql = "SELECT * FROM diemhp";

            System.err.println(sql);
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String maSV = rs.getString("maSV");
                String maHP = rs.getString("maHP");
                String tenHP = rs.getString("tenHP");
                float diemHP = rs.getFloat("diemHP");

                diemhp danhmuc = new diemhp(maSV, maHP, tenHP, diemHP);
                diemhps.add(danhmuc);
            }
            con.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return diemhps;
    }

    @Override
    public diemhp selectByid(diemhp t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<diemhp> selectByCondition(String Condition) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
