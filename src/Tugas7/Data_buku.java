/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tugas7;
import Tugas7.Koneksi;
import java.awt.Color;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
   
/**
 *
 * @author heriaditia
 */
public class Data_buku extends javax.swing.JFrame {

    private Connection con = Koneksi.getConnection();
    private Statement stt;
    private ResultSet rss;
    private Object cn;
    /**
     * Creates new form FromDataBaru
     */
    public Data_buku() {
        initComponents();
    }
   private DefaultTableModel model;
    public void InitTable(){//inisiasi tabel atau membuat tabel secara manual
    model = new DefaultTableModel();
    model.addColumn("ID BUKU");//membuat kolom ID di instance class model
    model.addColumn("JUDUL");//membuat kolom JUDUL di instance class model
    model.addColumn("PENULIS");//membuat kolom PENULIS di instance class model
    model.addColumn("HARGA");//membuat kolom HARGA di instance class model
    jTable2.setModel(model);
    }
    private void TampilData(){//fungsi menampilkan data
        try{
            String sql = "SELECT * FROM buku";//mendeklarasikan variabel sql dengan query untuk menampilkan semua data pada tabel buku
            stt = con.createStatement();//pembuatan statement
            rss = stt.executeQuery(sql);//eksekusi query
            while(rss.next()){
                Object[] o = new Object[4];//membuat nama object yaitu o dengan 4 array
                o[0] = rss.getString("id");// objek data pada larik ke-0 yaitu mengambil nilai dari stt berupa id
                o[1] = rss.getString("judul");// objek data pada larik ke-1 yaitu mengambil nilai dari stt berupa judul
                o[2] = rss.getString("penulis");// objek data pada larik ke-2 yaitu mengambil nilai dari stt berupa penulis
                o[3] = rss.getInt("harga");// objek data pada larik ke-3 yaitu mengambil nilai dari stt berupa harga
                model.addRow(o);//menambah baris pada model sesuai nilai dari parameternya yaitu o
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    private void TambahData(String judul, String penulis, String harga ){//fungsi untuk menambah data
     try{
         String sql = "INSERT INTO buku VALUES(null,'"+judul+"','"+penulis+"',"+harga+")";//mendeklarasikan variabel sql dengan query untuk menginsert data judul, penulis, harga
         stt = con.createStatement();//pembuatan statement
         stt.executeUpdate(sql);//eksekusi query
     }   
     catch(SQLException e){
         System.out.println(e.getMessage());
     }
    }
    public boolean UbahData(String id, String judul, String penulis, String harga){//fungsi untuk mengupdate data
        try{
            String sql ="UPDATE buku set judul ='"+judul+"', penulis='"+penulis+"', harga="+harga+" WHERE id="+id+";";//mendeklarasikan variabel sql dengan query untuk mengupdate data judul, penulis, harga berdasarkan id sesuai data tersebut
            stt = con.createStatement();//pembuatan statements
            stt.executeUpdate(sql);//eksekusi query
            return true;//mengembalikan nilai true(benar)      
        }
        
        catch(SQLException e){
            System.out.println(e.getMessage());
            return false;//mengembalikan nilai false(salah)
        }
    }
    public boolean HapusData(String id){//fungsi untuk hapus data
        try{
            String sql = "DELETE FROM buku where id="+id+";";//mendeklarasikan variabel sql dengan query untuk menghapus data sesuai kondisi
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
            String sql ="SELECT * FROM buku where "+by+" LIKE'%"+cari+"%';";//mendeklarasikan variabel sql dengan query untuk mencari data berdasarkan variabel by dan yang mengandung setiap huruf dari variabel cari
            stt = con.createStatement();//pembuatan statements
            rss = stt.executeQuery(sql);//eksekusi query
            while(rss.next()){//perulangan untuk menampilkan data
                Object[] data = new Object[4];//membuat objek baru yaitu data dengan jumlah array 4
                data[0] = rss.getString("id");// objek data pada larik ke-0 yaitu mengambil nilai dari stt berupa id
                data[1] = rss.getString("judul");// objek data pada larik ke-1 yaitu mengambil nilai dari stt berupa judul
                data[2] = rss.getString("penulis");// objek data pada larik ke-2 yaitu mengambil nilai dari stt berupa penulis
                data[3] = rss.getInt("harga");// objek data pada larik ke-3 yaitu mengambil nilai dari stt berupa harga
                model.addRow(data);//menambah baris pada model sesuai nilai dari parameternya yaitu data
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    private boolean ValidasiData(String judul, String penulis){ //method untuk validasi data agar data yang di inputkan tidak boleh sama
        try {
            stt = con.createStatement(); //untuk koneksi ke database
            String sql = "SELECT * FROM buku WHERE judul='"+judul+"' and penulis='"+penulis+"'"; //mendeklarasikan variabel sql dengan query untuk menampilkan data sesuai kondisi judul dan penulis yang ditentukan
            rss = stt.executeQuery(sql); //untuk mengeksekusi query
            //kondisi untuk menampilkan hasil dan nilai pengembaliannya
            if(rss.next()) {
                return true;} //mengembalikan nilai true(Benar)
            else {
                return false;}//mengembalikan nilai false(salah)
        } catch (SQLException e) {
            System.out.print(e.getMessage());
            return false;
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
        jTable1 = new javax.swing.JTable();
        header = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        pilihan = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        Simpan = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        Cari = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        combo = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        header.setBackground(new java.awt.Color(255, 255, 102));
        header.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel2.setBackground(new java.awt.Color(51, 255, 255));

        jLabel7.setFont(new java.awt.Font("Sylfaen", 0, 11)); // NOI18N
        jLabel7.setText("Judul");

        jLabel8.setFont(new java.awt.Font("Sylfaen", 0, 11)); // NOI18N
        jLabel8.setText("Penulis");

        jTextField1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTextField1.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                jTextField1CaretUpdate(evt);
            }
        });

        jTextField3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTextField3.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                jTextField3CaretUpdate(evt);
            }
        });

        pilihan.setBackground(new java.awt.Color(102, 255, 102));
        pilihan.setFont(new java.awt.Font("Sylfaen", 0, 11)); // NOI18N
        pilihan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--PILIHAN--", "Tere Liye", "W.S Rendra", "Felix Slauw", "Asma Nadia", "Dewi Lestari" }));
        pilihan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pilihanActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Sylfaen", 0, 11)); // NOI18N
        jLabel9.setText("Harga");

        Simpan.setFont(new java.awt.Font("Sylfaen", 0, 11)); // NOI18N
        Simpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/Save.png"))); // NOI18N
        Simpan.setText("Simpan");
        Simpan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SimpanMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SimpanMouseExited(evt);
            }
        });
        Simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SimpanActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Sylfaen", 0, 11)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/edit.png"))); // NOI18N
        jButton5.setText("Ubah");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Sylfaen", 0, 11)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/Erase.png"))); // NOI18N
        jButton6.setText("Hapus");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jTable2.setFont(new java.awt.Font("Sylfaen", 0, 11)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "JUDUL", "Penulis", "Harga"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(3).setHeaderValue("Harga");
        }

        jLabel6.setFont(new java.awt.Font("Sylfaen", 0, 11)); // NOI18N
        jLabel6.setText("Search");

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

        jLabel5.setFont(new java.awt.Font("Sylfaen", 0, 11)); // NOI18N
        jLabel5.setText("by");

        combo.setFont(new java.awt.Font("Sylfaen", 0, 11)); // NOI18N
        combo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "id", "judul", "penulis", "harga" }));
        combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 0, 0));
        jButton1.setFont(new java.awt.Font("Sylfaen", 0, 11)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/logout.png"))); // NOI18N
        jButton1.setText("Keluar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(Simpan)
                .addGap(18, 18, 18)
                .addComponent(jButton5)
                .addGap(18, 18, 18)
                .addComponent(jButton6)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel9))
                        .addGap(58, 58, 58)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pilihan, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(47, 47, 47)
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Cari, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 146, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pilihan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Simpan)
                    .addComponent(jButton5)
                    .addComponent(jButton6)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Cari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(51, 255, 255));

        jLabel1.setFont(new java.awt.Font("Sylfaen", 1, 36)); // NOI18N
        jLabel1.setText("DATA BUKU");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(144, 144, 144)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        InitTable();
        TampilData();
    }//GEN-LAST:event_formComponentShown

    private void CariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CariActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        int baris = jTable2.getSelectedRow();
//        IdB.setText(jTable2.getValueAt(baris, 0).toString());
        jTextField1.setText(jTable2.getValueAt(baris, 1).toString());//mengeset nilai di textfield Judul sesuai nilai dari baris ke-1 dari jTable2 yang dijadikan ke tipe data String
        pilihan.setSelectedItem(jTable2.getValueAt(baris, 2).toString());//mengeset nilai di combobox Penulis sesuai nilai dari baris ke-2 dari jTable2 yang dijadikan ke tipe data String
        jTextField3.setText(jTable2.getValueAt(baris, 3).toString());//mengeset nilai di textfield Harga sesuai nilai dari baris ke-3 dari jTable1 yang dijadikan ke tipe data String
    }//GEN-LAST:event_jTable2MouseClicked

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

    private void comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboActionPerformed

    private void jTextField1CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_jTextField1CaretUpdate
        // TODO add your handling code here:
        if(jTextField1.getText().length() !=0 && jTextField3.getText().length() !=0){
            Simpan.setEnabled(true);
        }
        else{
            Simpan.setEnabled(false);
        }
    }//GEN-LAST:event_jTextField1CaretUpdate

    private void jTextField3CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_jTextField3CaretUpdate
        // TODO add your handling code here:
        if(jTextField1.getText().length() !=0 && jTextField3.getText().length() !=0){
            Simpan.setEnabled(true);
        }
        else{
            Simpan.setEnabled(false);
        }
    }//GEN-LAST:event_jTextField3CaretUpdate

    private void pilihanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pilihanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pilihanActionPerformed

    private void SimpanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SimpanMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_SimpanMouseEntered

    private void SimpanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SimpanMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_SimpanMouseExited

    private void SimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SimpanActionPerformed
        // TODO add your handling code here:
//        String id = IdB.getText();
        String judul = jTextField1.getText();//mendeklarasikan judul sesuai dengan texfield Judul
        String penulis = pilihan.getSelectedItem().toString();//mendeklarasikan penulis sesuai dengan combobox combopenulis
        String harga = jTextField3.getText();//mendeklarasikan harga sesuai dengan texfield Harga
         if(ValidasiData(judul,penulis)){ //penyeleksian kondisi yang diambil dari fungsi validasi dengan parameter judul dan penulis
                JOptionPane.showMessageDialog(this, "Data sudah ada");
            }
         else{
        TambahData(judul, penulis, harga);//menjalankan fugsi TambahData
        InitTable();//menampilkan ulang model dari table buku
        TampilData();//untuk menampilkan ulang fungsi TampilData
        JOptionPane.showMessageDialog(this,"data berhasil ditambahkan");
         }
    }//GEN-LAST:event_SimpanActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        try{
            int baris = jTable2.getSelectedRow();//mendekarasikan variabel baris sesuai data yang dipilih di tabel
        
        String id = jTable2.getValueAt(baris, 0).toString();//mendeklarasikan variabel id yang bernilai dari baris ke-0 dari tabel yang dikonversi ke string
        String judul = jTextField1.getText();//mendeklarasikan judul sesuai dengan textfield Judul
        String penulis = pilihan.getSelectedItem().toString();//mendeklarasikan penulis sesuai dengan comobox Penulis
        String harga = jTextField3.getText();//mendeklarasikan harga sesuai dengan textfield Harga
           if(ValidasiData(judul,penulis)){//penyeleksian kondisi yang diambil dari fungsi validasi dengan parameter judul dan penulis
               JOptionPane.showMessageDialog(this, "Data sudah ada");
           }
           else{
                UbahData(id, judul, penulis, harga);//menjalankan fungsi UbahData 
                InitTable();//menjalankan fungsi InitTable
                TampilData();//menjalankan fungsi TampilData
                JOptionPane.showMessageDialog(null, "Data Berhasil DI Ubah");
           }}
        catch(Exception e){
            JOptionPane.showMessageDialog(this,"table belum dipilih","kesalahan",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        try{
        int baris =jTable2.getSelectedRow();//mendeklarasikan variabel baris sesuai dat yang dipilih di table
        String id = jTable2.getValueAt(baris, 0).toString();//mendeklarasikan variabel id yang bernilai dari baris ke-0 dari tabel yang di konversi ke string
        if(HapusData(id))//kondisi jika menjalankan fungsi HapusData dengan parameter id
            JOptionPane.showMessageDialog(null, "Data Berhasil DI Hapus");
        else
            JOptionPane.showMessageDialog(null, "Data Berhasil DI Hapus");
        InitTable();//menjalankan fungsi InitTable
        TampilData();//menalankan fungsi TampilData
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this,"table belum dipilih","kesalahan",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Data_buku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Data_buku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Data_buku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Data_buku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Data_buku().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Cari;
    private javax.swing.JButton Simpan;
    private javax.swing.JComboBox combo;
    private javax.swing.JPanel header;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JComboBox pilihan;
    // End of variables declaration//GEN-END:variables
}
