package POSTTEST_7;





/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.*;
import javax.swing.JOptionPane;
public class koneksi1 {
    private static Connection con;
    public static Connection getConnection(){
        try{
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/praktikum_visual","root","");
            JOptionPane.showMessageDialog(null, "Koneksi Berhasil Coy!!");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Koneksi Gagal Coy!!: "+e.getMessage());
        }
        return con;
    }
    
}
