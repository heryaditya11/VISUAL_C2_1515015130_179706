
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author heriaditia
 */
public class koneksi {
     static Connection con;
    public static Connection getConnection(){
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/revisilagi","root","");
//           JOptionPane.showMessageDialog(null,"Koneksi Berhasil");
        }catch(SQLException e){
            
           
            JOptionPane.showMessageDialog(null,"Koneksi Gagal: "+e.getMessage());
        }
        return con;
    }    

    static Connection getConnestion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
