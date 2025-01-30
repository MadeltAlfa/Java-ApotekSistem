/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package koneksi_db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class Koneksi {
    
    private static Connection conn;
    
    public static Connection getConnect(){
        if (conn == null) {
            try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kampus", "root", "");
                String url = "jdbc:mysql://localhost:3306/apotek_system";
//                String url = "jdbc:mysql://localhost:3306/kampus";
                String user = "root";
                String pass = "";
                DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                conn = (Connection) DriverManager.getConnection(url, user, pass);
            } catch (Exception e) {
                Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return conn;
    }
}
