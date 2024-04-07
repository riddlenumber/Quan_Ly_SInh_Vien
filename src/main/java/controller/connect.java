/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author Admin
 */
public class connect {
    private String hostName;
    private String user;
    private String pass;
    private String dbName;
    private String url;

    Connection conn;
    Statement stm;

    public connect() {
        hostName = "localhost";
        user = "root";
        pass = "";
        dbName = "javabtl_qlsv";
        url = "jdbc:mysql://" + hostName + "/" + dbName + "?user=" + user + "&password=" + pass;

        conn = null;
        stm = null;
    }

    public Connection getConnection() {
        
        try {
            if (conn == null) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection(url);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
