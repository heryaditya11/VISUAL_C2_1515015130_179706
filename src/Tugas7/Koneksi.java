/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tugas7;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author heriaditia
 */
public class Koneksi {
     private static Connection con;
    
    public static Connection getConnection(){
        try{
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/data_buku","root","");
            JOptionPane.showMessageDialog(null, "koneksi berhasil");
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "koneksi gagal"
                +e.getMessage());
        }
        return con;
    }
        
    
    
}
    

