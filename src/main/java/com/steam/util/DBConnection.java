
package com.steam.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String HOST = "mysql-2f641a82-boqn2005-2431.c.aivencloud.com";
    private static final int PORT = 20695;
    private static final String DATABASE = "defaultdb";
    private static final String USER = "avnadmin";
    private static final String PASSWORD = "AVNS_BsSF8jT6DmSt9lT6RD0";

    private static final String URL = String.format(
            "jdbc:mysql://%s:%d/%s?ssl-mode=REQUIRED&allowPublicKeyRetrieval=true",
            HOST, PORT, DATABASE
    );
    private static Connection con = null;
    
    public  static Connection getConnection(){
            try {
//                Class.forName("com.mysql.cj.jdbc.Driver");
                if (con == null || con.isClosed()) {
                    con = DriverManager.getConnection(URL, USER, PASSWORD);
                    System.out.println("👉 Tạo kết nối DB mới");
                }
            }
            catch (SQLException ex){
                System.err.println(" LỖI KẾT NỐI DB: Kiểm tra User/Pass và Firewall.");
                System.err.println("Chi tiết: " + ex.getMessage());
                con = null;
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }

//            }
//            return null;

            return con;
    }
}
