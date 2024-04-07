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
import model.user;

/**
 *
 * @author Admin
 */
public class user_DAO implements DAO_interface<user> {

    public static user_DAO getInstance() {
        return new user_DAO();
    }

    @Override
    public int insert(user t) {
        return 0;
    }

    @Override
    public int update(user t) {
        return 0;
    }

    @Override
    public int delete(user t) {
        return 0;
    }

   @Override
    public ArrayList<user> selectAll() {
        ArrayList<user> users = new ArrayList<user>();
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
            String sql = "SELECT * FROM taikhoan";

            System.err.println(sql);
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String id = rs.getString("id");
                String tenDN = rs.getString("tenDN");
                 String matKhau = rs.getString("matKhau");

                user danhmuc = new user(id, tenDN, matKhau);
                users.add(danhmuc);
            }
            con.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public user selectByid(user t) {
        return null;
    }

    @Override
    public ArrayList<user> selectByCondition(String Condition) {
        return null;
    }

    public boolean checkuser(user t) {
        // TODO Auto-generated method stub
        try {
            //b1 tạo kết nối csdl

            //Connection con = connect.getConnection();
            connect connector = new connect();
            // Gọi phương thức getConnection() trên đối tượng connect để nhận kết nối đến cơ sở dữ liệu
            Connection con = connector.getConnection();

            //b2 tạo ra 1 đối tượng stament
            Statement st = con.createStatement();

            //b3 thực hiện vc thêm 
            String sql = "SELECT * FROM taikhoan WHERE tenDN = '" + t.getTenDN() + "' AND matKhau = '" + t.getMatKhau() + "'";

            //System.err.println(sql);
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                return true;
            }
            con.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }

}
