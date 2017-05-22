/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POSTTEST_7;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel; //buat model di table
import POSTTEST_7.koneksi1;
public class FormDataBuku extends javax.swing.JFrame { //class formdatabuku yang diturunkan dari class javax.swing.jframe
    private DefaultTableModel model; 
    private Connection con = koneksi1.getConnection(); //untuk mengambil dari class koneksi
    private Statement stt; //eksekusi query database
    private ResultSet rss; //menampung data dari table yang telah dibua

    /**
     * Creates new form FormDataBuku
     */
    public FormDataBuku() {
        initComponents();
    }
    private void InitTable(){
        model = new DefaultTableModel();
        model.addColumn("ID BUKU"); //menambahkan kolom pada id buku
        model.addColumn("JUDUL"); //menambahkan kolom pada judul
        model.addColumn("PENULIS"); ////menambahkan kolom pada penulis
        model.addColumn("HARGA"); //menambahkan kolom pada harga
        
        jTable1.setModel(model);
    }
    private void TampilData(){
        try{
            String sql = "Select *from buku"; //menampilkan seluruh data dari tabel buku
            stt = con.createStatement(); //menampilakn data dengan mengkoneksikan ke database
            rss = stt.executeQuery(sql); //menampung data dengan mengeksekusi seiap query
            while(rss.next()){
                Object[] o = new Object[4];
                o[0] = rss.getString("id");
                o[1] = rss.getString("judul"); //menampung data pada judul
                o[2] = rss.getString("penulis"); //menampung data pada penulis
                o[3] = rss.getString("harga"); //menampung data pada harga
                model.addRow(o); //menambah baris
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    private boolean validasi(String Judul, String Penulis){ //
        try{ //mengeksekusi program yang berada di dalam try
            stt=con.createStatement();
            String sql = "Select *from buku where judul = '"+Judul+"' and penulis='"+Penulis+"';"; //menampilkan semua data pada tabel buku dimana pencarian berdasarkan judul
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
    
    private boolean ubahdata (String id, String judul, String penulis, String harga){
        try{
            String sql = "Update buku set judul='"+judul+"', penulis='"+penulis+"', harga="+harga+" where id="+id+";"; //data yang bisa diubah judul, penulis, dan harga
            stt=con.createStatement();
            stt.executeUpdate(sql);
            return true;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    private boolean hapusdata (String id){
        try{
            String sql = "delete from buku where id="+id+";";
            stt=con.createStatement();
            stt.executeUpdate(sql);
            return true;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
     
    private void TambahData(String judul, String penulis, String harga){ //method tambah data
        try{ //mengeksekusi program yang berada di dalam try
            String sql = "insert into buku values (NULL,'"+judul+"','"+penulis+"',"+harga+")"; //menginput data pada judul penulis dan harga
            stt = con.createStatement();
            stt.executeUpdate(sql);
            model.addRow(new Object[]{judul,penulis,harga});
        }catch(SQLException e){ //catch untuk menentukan jenis exception yang ingin ditangani
            System.out.println(e.getMessage());
        }
    }
    
    private void PencarianData(String by, String cari){
        try{
            String sql = "Select *from buku where "+by+" like'%"+cari+"%';"; //menampilkan seluruh data dari tabel buku
            stt = con.createStatement(); //menampilakn data dengan mengkoneksikan ke database
            rss = stt.executeQuery(sql); //menampung data dengan mengeksekusi seiap query
            while(rss.next()){
                Object[] o = new Object[4];
                o[0] = rss.getString("id");
                o[1] = rss.getString("judul"); //menampung data pada judul
                o[2] = rss.getString("penulis"); //menampung data pada penulis
                o[3] = rss.getString("harga"); //menampung data pada harga
                model.addRow(o); //menambah baris
            }
        }catch(SQLException e){
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        TFJudul = new javax.swing.JTextField();
        TFHarga = new javax.swing.JTextField();
        JBSimpan = new javax.swing.JButton();
        JBUbah = new javax.swing.JButton();
        JBHapus = new javax.swing.JButton();
        JBKeluar = new javax.swing.JButton();
        CBPen = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        TFCari = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        CBCari = new javax.swing.JComboBox();

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable2);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(jTable3);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));

        jLabel1.setFont(new java.awt.Font("Felix Titling", 1, 24)); // NOI18N
        jLabel1.setText("Form Data Buku");

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 254, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 11, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 248, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(162, 162, 162)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addGap(13, 13, 13)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(102, 102, 255));

        jLabel2.setFont(new java.awt.Font("Bookman Old Style", 0, 16)); // NOI18N
        jLabel2.setText("Judul");

        jLabel3.setFont(new java.awt.Font("Bookman Old Style", 0, 16)); // NOI18N
        jLabel3.setText("Penulis");

        jLabel4.setFont(new java.awt.Font("Bookman Old Style", 0, 16)); // NOI18N
        jLabel4.setText("Harga");

        JBSimpan.setBackground(new java.awt.Color(0, 0, 0));
        JBSimpan.setForeground(new java.awt.Color(255, 255, 255));
        JBSimpan.setText("Simpan");
        JBSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBSimpanActionPerformed(evt);
            }
        });

        JBUbah.setBackground(new java.awt.Color(0, 0, 0));
        JBUbah.setForeground(new java.awt.Color(255, 255, 255));
        JBUbah.setText("Ubah");
        JBUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBUbahActionPerformed(evt);
            }
        });

        JBHapus.setBackground(new java.awt.Color(0, 0, 0));
        JBHapus.setForeground(new java.awt.Color(255, 255, 255));
        JBHapus.setText("Hapus");
        JBHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBHapusActionPerformed(evt);
            }
        });

        JBKeluar.setBackground(new java.awt.Color(0, 0, 0));
        JBKeluar.setForeground(new java.awt.Color(255, 255, 255));
        JBKeluar.setText("Keluar");
        JBKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBKeluarActionPerformed(evt);
            }
        });

        CBPen.setFont(new java.awt.Font("Bookman Old Style", 0, 16)); // NOI18N
        CBPen.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tere Liye", "Khalil Gibran", "Felix Slauw", "Asma Nadia" }));

        jLabel5.setFont(new java.awt.Font("Bookman Old Style", 0, 16)); // NOI18N
        jLabel5.setText("Search");

        TFCari.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                TFCariCaretUpdate(evt);
            }
        });
        TFCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFCariActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Bookman Old Style", 0, 16)); // NOI18N
        jLabel6.setText("By");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Judul", "Penulis", "Harga"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        CBCari.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Judul", "Penulis", "Harga" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TFJudul, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CBPen, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TFHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(TFCari, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(75, 75, 75)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(CBCari, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(57, 57, 57))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(JBSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(JBUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(JBHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JBKeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TFJudul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(CBPen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(TFHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBKeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(TFCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(CBCari, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
       InitTable();
       TampilData();
    // TODO add your handling code here:
    }//GEN-LAST:event_formComponentShown

    private void JBSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBSimpanActionPerformed
        // TODO add your handling code here:
        String judul = TFJudul.getText(); //memberi aturan text sehingga menginput text
        String penulis = CBPen.getSelectedItem().toString(); //memberi aturan selected item sehingga bisa memilih penulis
        String harga = TFHarga.getText();//memberi aturan text sehingga menginput text
        if(validasi(judul,penulis)){
            JOptionPane.showMessageDialog(null, "Data Sudah ada"); //menampilkan konfirmasi sesuai statement yang diberikan, jika data yang akan disimpan telah ada di database maka akan muncul statement di samping
        }                                                          //null tidak merujuk ke data manapun
        else{
        TambahData(judul,penulis,harga); //data akan terinput pada method tambah data
        InitTable();TampilData();
        JOptionPane.showMessageDialog(null, "Berhasil Simpan Data"); //menampilkan konfirmasi sesuai statement yang diberikan
    }//GEN-LAST:event_JBSimpanActionPerformed
    }
    private void JBKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBKeluarActionPerformed
        // TODO add your handling code here:
        System.exit(0); //
    }//GEN-LAST:event_JBKeluarActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here
        int baris = jTable1.getSelectedRow();
        TFJudul.setText(jTable1.getValueAt(baris, 1).toString());
        CBPen.setSelectedItem(jTable1.getValueAt(baris, 2).toString());
        TFHarga.setText(jTable1.getValueAt(baris, 3).toString());
//        String judul = jTable1.getValueAt(baris,0).toString();
//        String penulis = jTable1.getValueAt(baris,1).toString();
//        String harga = jTable1.getValueAt(baris,2).toString();
//        TFJudul.setText(judul);
//        CBPen.setSelectedItem(penulis);
//        TFHarga.setText(harga);
    }//GEN-LAST:event_jTable1MouseClicked

    private void JBHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBHapusActionPerformed
        // TODO add your handling code here:
        int baris = jTable1.getSelectedRow();
        String id = jTable1.getValueAt(baris, 0).toString();
        if(hapusdata(id))
            JOptionPane.showMessageDialog(null, "Berhasil Hapus Data"); //menampilkan konfirmasi sesuai statement yang diberikan
        else
            JOptionPane.showMessageDialog(null, "Gagal Hapus Data"); //jika data yang ingin dihapus belum dipilih maka akan muncul tampilan gagal hapus data
        InitTable();TampilData();
//        try {
//        int pilih = JOptionPane.showConfirmDialog(this, "Yakin Ingin Menghapus?", "Konfirmasi Hapus", JOptionPane.YES_OPTION); //
//        if(pilih==JOptionPane.YES_OPTION){
//        int baris = jTable1.getSelectedRow();
//        model.removeRow(baris);}
//        } 
//        catch (Exception e){
//                JOptionPane.showMessageDialog(this,"Pilih Data yang ingin di hapus"); 
//                }
    }//GEN-LAST:event_JBHapusActionPerformed

    private void JBUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBUbahActionPerformed
        // TODO add your handling code here:
        int baris = jTable1.getSelectedRow();
         String id = jTable1.getValueAt(baris, 0).toString();
         String judul = TFJudul.getText();
         String penulis = CBPen.getSelectedItem().toString();
         String harga = TFHarga.getText();
         if(validasi(judul,penulis)){
              JOptionPane.showMessageDialog(null, "Data Sudah ada");} //mengkonfirmasi sesuai statement yang diberikan
         else{
              ubahdata(id, judul, penulis, harga);
              InitTable();TampilData();
              JOptionPane.showMessageDialog(null, "Berhasil Ubah Data");} //mengkonfirmasi sesuai statement yang diberikan
         
         
//            JOptionPane.showMessageDialog(null, "Gagal Ubah Data");
            
         
//        try{
//            int baris = jTable1.getSelectedRow();
//            jTable1.setValueAt(TFJudul.getText(), baris, 0);
//            jTable1.setValueAt(CBPen.getSelectedItem(), baris, 1);
//            jTable1.setValueAt(TFHarga.getText(), baris, 2);
//        }
//        catch (Exception e) {
//        }
//            
    }//GEN-LAST:event_JBUbahActionPerformed

    private void TFCariCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_TFCariCaretUpdate
        // TODO add your handling code here:
        InitTable();
        if(TFCari.getText().length()==0){ //jika data yang akan dicari ada, maka akan menyeleksi else
            TampilData();
        }else{
            PencarianData(CBCari.getSelectedItem().toString(),TFCari.getText()); //mencari data pada method PencarianData 
        }
//        model.getDataVector().removeAllElements();
//        model.fireTableDataChanged();
//        String search = CBCari.getSelectedItem().toString();
//        if (TFCari.getText().length()>0){
//        try {
//            String sql = "select *from buku where "+search+" like '%"+TFCari.getText()+"%'";
//            stt = con. createStatement();
//            rss = stt.executeQuery(sql);
//            ResultSet rss=stt.executeQuery(sql);
//            while (rss.next()){
//                Object[] o=new Object [3];
//                o[0]=rss.getString("judul");
//                o[1]=rss.getString("penulis");
//                o[2]=rss.getString("harga");
//                model.addRow(o);
//            }
//            stt.close();
//            rss.close();
//        }
//        catch(SQLException e){
//            System.out.println("Ada Kesalahan");
//        }
//    }
// 
    }//GEN-LAST:event_TFCariCaretUpdate

    private void TFCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFCariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TFCariActionPerformed

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
            java.util.logging.Logger.getLogger(FormDataBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormDataBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormDataBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormDataBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormDataBuku().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox CBCari;
    private javax.swing.JComboBox CBPen;
    private javax.swing.JButton JBHapus;
    private javax.swing.JButton JBKeluar;
    private javax.swing.JButton JBSimpan;
    private javax.swing.JButton JBUbah;
    private javax.swing.JTextField TFCari;
    private javax.swing.JTextField TFHarga;
    private javax.swing.JTextField TFJudul;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    // End of variables declaration//GEN-END:variables
}
