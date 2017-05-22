/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.event.KeyEvent;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.*;
import java.sql.Statement;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.io.FileNotFoundException;

/**
 *
 * @author heriaditia
 */
public class data extends javax.swing.JFrame {
 private DefaultTableModel model,model1,model2;
 private Connection con = koneksi.getConnection();
 private Statement stt;
 private ResultSet rss;
  private PreparedStatement pst;
    /**
     * Creates new form spare
     */
    public data() {
        initComponents();
    }



   private void InitTable(){
       
    model = new DefaultTableModel();
    model.addColumn("NIS");
    model.addColumn("NAMA");
    model.addColumn("JENIS KELAMIN");
    model.addColumn("ALAMAT");
     
                
   jTable1.setModel(model);
       }
     
 public boolean HapusData(String nis){//fungsi untuk hapus data
        try{
            String sql = "DELETE FROM siswa where nis="+nis+";";//mendeklarasikan variabel sql dengan query untuk menghapus data sesuai kondisi
            stt = con.createStatement();//pembuatan statements
            stt.executeUpdate(sql);//eksekusi query
            return true;//mengembalikan nilai true(benar)
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
            return false;//mengembalikan nilai false(salah)
        }   

 }
 
 private void PencarianData(String by, String cari){//fungsi untuk mencari data yang telah ada 
        try{
            String sql ="SELECT * FROM siswa where "+by+" LIKE'%"+cari+"%';";//mendeklarasikan variabel sql dengan query untuk mencari data berdasarkan variabel by dan yang mengandung setiap huruf dari variabel cari
            stt = con.createStatement();//pembuatan statements
            rss = stt.executeQuery(sql);//eksekusi query
            while(rss.next()){//perulangan untuk menampilkan data
                Object[] data = new Object[4];//membuat objek baru yaitu data dengan jumlah array 4
                data[0] = rss.getString("nis");// objek data pada larik ke-0 yaitu mengambil nilai dari stt berupa id
                data[1] = rss.getString("nama");// objek data pada larik ke-1 yaitu mengambil nilai dari stt berupa judul
                data[2] = rss.getString("jenis_kelamin");// objek data pada larik ke-2 yaitu mengambil nilai dari stt berupa penulis
                data[3] = rss.getString("alamat");// objek data pada larik ke-3 yaitu mengambil nilai dari stt berupa harga
                model.addRow(data);//menambah baris pada model sesuai nilai dari parameternya yaitu data
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
        private void TampilData(){
        try{
            String sql = "SELECT * FROM siswa";
            stt = con. createStatement();
            rss = stt. executeQuery(sql);
            while (rss.next()) {
            Object[] o = new Object[4];
            o[0] = rss.getString("nis");
            o[1] = rss.getString("nama");
            o[2]= rss.getString("jenis_kelamin");
            o[3] = rss.getString("alamat");
            model.addRow(o);
                
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
        
        private boolean validasi(String nis){ //
        try{ //mengeksekusi program yang berada di dalam try
            stt=con.createStatement();
            String sql = "Select *from siswa where nis = '"+nis+"';"; //menampilkan semua data pada tabel buku dimana pencarian berdasarkan judul
            rss=stt.executeQuery(sql);
            if (rss.next())
                return true;
            else
                return false;
        }
            catch (SQLException e){ //catch untuk menentukan jenis exception yang ingin ditangani 
                System.out.println(e.getMessage());
                return false;
            }
    }
        
        private void TambahData(String nis, String nama, String jenis_kelamin, String alamat){ //method tambah data
        try{ //mengeksekusi program yang berada di dalam try
            String sql = "insert into siswa values ('"+nis+"','"+nama+"','"+jenis_kelamin+"','"+alamat+"')"; //menginput data pada judul penulis dan harga
            stt = con.createStatement();
            stt.executeUpdate(sql);
            model.addRow(new Object[]{nis,nama,jenis_kelamin,alamat});
        }catch(SQLException e){ //catch untuk menentukan jenis exception yang ingin ditangani
            System.out.println(e.getMessage());
        }
    }
        
        
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfnis = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfnama1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        laki = new javax.swing.JRadioButton();
        bini = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        Alamat = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btambah = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        combo = new javax.swing.JComboBox();
        Cari = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 51, 51)));

        jLabel1.setFont(new java.awt.Font("Yu Mincho Demibold", 1, 12)); // NOI18N
        jLabel1.setText("NIS");

        jLabel2.setFont(new java.awt.Font("Yu Mincho Demibold", 1, 12)); // NOI18N
        jLabel2.setText("Nama");

        jLabel4.setFont(new java.awt.Font("Yu Mincho Demibold", 1, 12)); // NOI18N
        jLabel4.setText("Jenis kelamin");

        buttonGroup1.add(laki);
        laki.setText("LAKI-LAKI");

        buttonGroup1.add(bini);
        bini.setText("PEREMPUAN");
        bini.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                biniActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Yu Mincho Demibold", 1, 12)); // NOI18N
        jLabel3.setText("Alamat");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        btambah.setIcon(new javax.swing.ImageIcon("C:\\Users\\heriaditia\\Documents\\NetBeansProjects\\ProjekF\\src\\ICON\\Save.png")); // NOI18N
        btambah.setText("SAVE");
        btambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btambahActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon("C:\\Users\\heriaditia\\Documents\\NetBeansProjects\\ProjekF\\src\\ICON\\Erase.png")); // NOI18N
        jButton2.setText("DELETE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon("C:\\Users\\heriaditia\\Documents\\NetBeansProjects\\ProjekF\\src\\ICON\\home.png")); // NOI18N
        jButton4.setText("HOME");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton4MousePressed(evt);
            }
        });
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        combo.setFont(new java.awt.Font("Sylfaen", 0, 11)); // NOI18N
        combo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "nis", "nama", "jenis_kelamin", "alamat" }));
        combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboActionPerformed(evt);
            }
        });

        Cari.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                CariCaretUpdate(evt);
            }
        });
        Cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CariActionPerformed(evt);
            }
        });

        jButton1.setText("INPUT NILAI");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton1MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(46, 46, 46)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Alamat, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfnis, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfnama1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(laki)
                                .addGap(28, 28, 28)
                                .addComponent(bini)))
                        .addGap(51, 51, 51)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(Cari, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btambah)
                        .addGap(186, 186, 186)
                        .addComponent(jButton1)
                        .addGap(24, 24, 24))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfnis, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(tfnama1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(laki)
                            .addComponent(bini)))
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(Alamat, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(90, 151, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cari, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btambah)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(91, 91, 91))
        );

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));

        jLabel8.setFont(new java.awt.Font("SimSun-ExtB", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("FORM");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(353, 353, 353)
                .addComponent(jLabel8)
                .addContainerGap(545, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(856, 459));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        InitTable();
        TampilData();
       
        
   
    }//GEN-LAST:event_formComponentShown

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
                
    }//GEN-LAST:event_formWindowOpened

            
    private void biniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_biniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_biniActionPerformed

    private void btambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btambahActionPerformed
        // TODO add your handling code here:
        if(tfnis.getText().length()!=0 && Alamat.getText().length()!=0){
            String nis = tfnis.getText(); 
            String nama = tfnama1.getText();
            String jenis_kelamin =null;
            if(laki.isSelected()){
            jenis_kelamin= "laki-laki";
            }
            else if (bini.isSelected()){
            jenis_kelamin="perempuan";
            }
            String alamat = Alamat.getText();
            if(validasi(nis)){
                JOptionPane.showMessageDialog(null, "Data Sudah ada"); //menampilkan konfirmasi sesuai statement yang diberikan, jika data yang akan disimpan telah ada di database maka akan muncul statement di samping
            }                                                          //null tidak merujuk ke data manapun
            else{
                TambahData(nis,nama,jenis_kelamin,alamat); //data akan terinput pada method tambah data
                InitTable();TampilData();
                JOptionPane.showMessageDialog(null, "Berhasil Simpan Data"); //menampilkan konfirmasi sesuai statement yang diberikan
            }}
            else{
                JOptionPane.showMessageDialog(null, "data tidak boleh kosong");
            }
    }//GEN-LAST:event_btambahActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try{
            int baris =jTable1.getSelectedRow();//mendeklarasikan variabel baris sesuai dat yang dipilih di table
            String nis = jTable1.getValueAt(baris, 0).toString();//mendeklarasikan variabel id yang bernilai dari baris ke-0 dari tabel yang di konversi ke string
            if(HapusData(nis))//kondisi jika menjalankan fungsi HapusData dengan parameter id
            JOptionPane.showMessageDialog(null, "Data Berhasil DI Hapus");
            else
            JOptionPane.showMessageDialog(null, "Data Berhasil DI Hapus");
            InitTable();//menjalankan fungsi InitTable
            TampilData();//menalankan fungsi TampilData
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this,"table belum dipilih","kesalahan",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MousePressed
        // TODO add your handling code here:
        new menupegawai().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton4MousePressed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboActionPerformed

    private void CariCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_CariCaretUpdate
        // TODO add your handling code here:
        InitTable();
        if(Cari.getText().length()==0){//kondisi jika texfield Cari kosong
            TampilData();//akan langsung menjalankan fungsi TampilData
        }
        else{
            PencarianData(combo.getSelectedItem().toString(),Cari.getText());//menjalan fungsi PencarianData nilai dari combo yang diadikan string dan nilai dari textfield Cari
        }
    }//GEN-LAST:event_CariCaretUpdate

    private void CariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CariActionPerformed

    private void jButton1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MousePressed
        // TODO add your handling code here:
         new nilai().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1MousePressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(data.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(data.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(data.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(data.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new data().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Alamat;
    private javax.swing.JTextField Cari;
    private javax.swing.JRadioButton bini;
    private javax.swing.JButton btambah;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox combo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JRadioButton laki;
    private javax.swing.JTextField tfnama1;
    private javax.swing.JTextField tfnis;
    // End of variables declaration//GEN-END:variables

    private void tambah(int spare2, int nota) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
