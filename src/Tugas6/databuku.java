/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tugas6;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author heriaditia
 */
public class databuku extends javax.swing.JFrame {

    /**
     * Creates new form databuku
     */
    public databuku() {
        initComponents();
    }
     private DefaultTableModel model;
        private final Connection con = koneksi.getConnection();
        private Statement stt; 
        private ResultSet rss;
        private PreparedStatement pst;
        
     private void InitTable(){ //inisiasi tabel atau membuat tabel secara manual
        model = new DefaultTableModel(); //instansiasi class model dari class DefaultTableModel
        model.addColumn("JUDUL"); //membuat kolom JUDUL di instance class model
        model.addColumn("PENULIS");//membuat kolom PENULIS di instance class model
        model.addColumn("HARGA");//membuat kolom HARGA di instance class model
        jTable1.setModel(model); //mengeset instance of class model ke jTable1
    }
    private boolean masukan(String judul){ //method untuk validasi data agar tidak boleh sama
        try {
            stt = con.createStatement(); //untuk konek ke database
            String sql = "SELECT * FROM buku WHERE judul='"+judul+"'"; //mendeklarasikan variabel sql dengan query untuk menampilkan data sesuai kondisi judul yang ditentukan
            rss = stt.executeQuery(sql); //untuk mengeksekusi query
            //kondisi untuk menampilkan hasil dan nilai pengembaliannya
            if(rss.next()) 
                return true; 
            else 
                return false;
        } catch (SQLException e) {
            System.out.print(e.getMessage());
            return false;
        }
    }

    
    private void TampilData(){ //fungsi untuk menampilkan data
        try{
            String sql = "SELECT * FROM buku"; //mendeklarasikan variabel sql dengan query untuk menampilkan semua data pada tabel buku
            stt = con.createStatement();//pembuatan statement
            rss = stt.executeQuery(sql);//eksekusi query
            while(rss.next()){//perulangan untuk menampilkan data
                Object[] o = new Object[3]; //membuat object o dengan jumlah array 3
                //menampilkan data sesuai array : 
                o[0] = rss.getString("judul");
                o[1] = rss.getString("penulis");
                o[2] = rss.getInt("harga");
                model.addRow(o);
            }
        rss.close();//menutup rss
        stt.close();//menutup stt
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    
   private void HapusData(String judul){
        try {
            String sql="delete from buku where judul='"+judul+"'";//mendeklarasikan variabel sql dengan query untuk menghapus data sesuai kondisi
            stt = con.createStatement();//pembuatan statement
            stt.executeUpdate(sql);//eksekusi query
            //mengosongkan atau menset isi dari tesxfield dan combobox di frame
            jTextField1.setText("");
            pilihancmb.setSelectedItem(0);
            jTextField3.setText("");
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    // method untuk menambahkan data dengan parameter judul,penulis,harga
    public void TambahData(String judul, String penulis, String harga){
        try{
            
            String sql = "INSERT INTO buku VALUES (NULL,'"+judul+"','"+penulis+"',"+harga+")"; //mendeklarasikan variabel sql dengan query untuk menginsert data judul, penulis, harga
            stt = con.createStatement();//pembuatan statement
            stt.executeUpdate(sql);//eksekusi query
            
            //mengosongkan atau menset isi dari tesxfield dan combobox di frame
            jTextField1.setText("");
            pilihancmb.setSelectedItem(0);
            jTextField3.setText("");
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    // method untuk mngupdate data
    public void UpdateData(String judul, String penulis, String harga){
       try {
            int baris = jTable1.getSelectedRow();
            String sql = "update buku set judul='"+judul+"',penulis='"+penulis+"',harga="+harga+" where judul='"+jTable1.getValueAt(baris, 0).toString()+"'";//mendeklarasikan variabel sql dengan query untuk mengupdate data judul, penulis, harga dari kondisi yang ditentukan
            stt = con.createStatement();//pembuatan statement
            stt.executeUpdate(sql);//eksekusi query
            
            //mengosongkan atau menset isi dari tesxfield dan combobox di frame
            jTextField1.setText("");
            pilihancmb.setSelectedItem(0);
            jTextField3.setText("");
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        pilihancmb = new javax.swing.JComboBox<String>();
        jLabel5 = new javax.swing.JLabel();
        cari = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        pilihancari = new javax.swing.JComboBox<String>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        simpan = new javax.swing.JButton();
        edit = new javax.swing.JButton();
        hapus = new javax.swing.JButton();
        ulang = new javax.swing.JButton();
        keluar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(153, 255, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(255, 255, 102)));

        jPanel2.setBackground(new java.awt.Color(0, 204, 204));

        jLabel1.setFont(new java.awt.Font("Sylfaen", 1, 36)); // NOI18N
        jLabel1.setText("DATA BUKU");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(144, 144, 144))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(0, 204, 255));

        jLabel2.setFont(new java.awt.Font("Sylfaen", 0, 14)); // NOI18N
        jLabel2.setText("Judul");

        jLabel3.setFont(new java.awt.Font("Sylfaen", 0, 11)); // NOI18N
        jLabel3.setText("Penulis");

        jLabel4.setFont(new java.awt.Font("Sylfaen", 0, 11)); // NOI18N
        jLabel4.setText("Harga");

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        pilihancmb.setFont(new java.awt.Font("Sylfaen", 0, 12)); // NOI18N
        pilihancmb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--PILIHAN--", "W.S Rendra", "Tere Liye", "Asma Nadia", "Dewi Lestari", "Felix Siauw", " " }));

        jLabel5.setFont(new java.awt.Font("Sylfaen", 0, 11)); // NOI18N
        jLabel5.setText("Search :");

        cari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cariKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Sylfaen", 0, 11)); // NOI18N
        jLabel6.setText("By :");

        pilihancari.setFont(new java.awt.Font("Sylfaen", 0, 11)); // NOI18N
        pilihancari.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "judul", "penulis", "harga" }));

        jTable1.setBorder(new javax.swing.border.MatteBorder(null));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "judul", "penulis", "harga"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        simpan.setBackground(new java.awt.Color(255, 255, 51));
        simpan.setFont(new java.awt.Font("Sylfaen", 0, 11)); // NOI18N
        simpan.setText("Simpan");
        simpan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                simpanMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                simpanMouseExited(evt);
            }
        });
        simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanActionPerformed(evt);
            }
        });

        edit.setBackground(new java.awt.Color(255, 255, 51));
        edit.setFont(new java.awt.Font("Sylfaen", 0, 11)); // NOI18N
        edit.setText("Update");
        edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                editMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                editMouseExited(evt);
            }
        });
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });

        hapus.setBackground(new java.awt.Color(255, 255, 51));
        hapus.setFont(new java.awt.Font("Sylfaen", 0, 11)); // NOI18N
        hapus.setText("Hapus");
        hapus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                hapusMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                hapusMouseExited(evt);
            }
        });
        hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusActionPerformed(evt);
            }
        });

        ulang.setBackground(new java.awt.Color(255, 255, 51));
        ulang.setFont(new java.awt.Font("Sylfaen", 0, 11)); // NOI18N
        ulang.setText("Ulangi");
        ulang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ulangMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ulangMouseExited(evt);
            }
        });
        ulang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ulangActionPerformed(evt);
            }
        });

        keluar.setBackground(new java.awt.Color(255, 102, 0));
        keluar.setFont(new java.awt.Font("Sylfaen", 0, 11)); // NOI18N
        keluar.setText("Keluar");
        keluar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                keluarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                keluarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                keluarMouseExited(evt);
            }
        });
        keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keluarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(simpan)
                                .addGap(18, 18, 18)
                                .addComponent(edit)
                                .addGap(18, 18, 18)
                                .addComponent(hapus)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ulang)
                                .addGap(18, 18, 18)
                                .addComponent(keluar))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(45, 45, 45)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField1)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                                    .addComponent(pilihancmb, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(pilihancari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(cari, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(pilihancmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(pilihancari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(simpan)
                    .addComponent(edit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(hapus)
                    .addComponent(ulang)
                    .addComponent(keluar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void cariKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cariKeyTyped
        model.getDataVector().removeAllElements();//mendeklarasikan model yang mmengambil data 
        model.fireTableDataChanged();//mendeklarasikan model yang di fireTableDataChanged
        String caridengan = pilihancari.getSelectedItem().toString();//mendeklarasikan variabel cari
        try {

            String sql="select * from buku where "+caridengan+" like '%"+cari.getText()+"%'";////mendeklarasikan variabel sql dengan query untuk mencari data
            stt = con. createStatement();//pembuatan statement
            rss = stt. executeQuery(sql);//eksekusi query
            ResultSet rss=stt.executeQuery(sql);
            while (rss.next()) { // perulangan result set dari variable rss
                //menampilkan data sesuai array 
                Object[] o=new Object[3];
                o[0]=rss.getString("judul");
                o[1]=rss.getString("penulis");
                o[2]=rss.getString("harga");
                model.addRow(o);
            }
            stt.close();//untuk menutup stt
            rss.close();
        }catch(SQLException e) {
            System.out.println("Terjadi kesalahan");
        }
    }//GEN-LAST:event_cariKeyTyped

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int baris = jTable1.getSelectedRow(); //deklarasi variabel baris dengan nilai yang di klik pada jTable1

        String judul_edit = jTable1.getValueAt(baris, 0).toString(); //deklarasi variabel judul_edit dengan nilai dari baris ke-0 dari jTable1 
        String penulis_edit = jTable1.getValueAt(baris, 1).toString(); //deklarasi variabel penulis_edit dengan nilai dari baris ke-1 dari jTable1 
        String harga_edit = jTable1.getValueAt(baris, 2).toString();//deklarasi variabel harga_edit dengan nilai dari baris ke-2 dari jTable1 

        jTextField3.setText(judul_edit); //mengeset nilai di judul sesuai dari nilai judul_edit
        pilihancmb.setSelectedItem(penulis_edit); //mengeset nilai di combobox sesuai dari nilai penulis_edit
        jTextField3.setText(harga_edit);//mengeset nilai di textfield harga sesuai dari nilai harga_edit
    }//GEN-LAST:event_jTable1MouseClicked

    private void simpanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_simpanMouseEntered

        //        
    }//GEN-LAST:event_simpanMouseEntered

    private void simpanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_simpanMouseExited

    }//GEN-LAST:event_simpanMouseExited

    private void simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanActionPerformed
        if (jTextField1.getText().length()!=0 && jTextField3.getText().length()!=0) { //penyeleksian kondisi apabila Jtextfield kosng
            String judul = jTextField1.getText(); //mendeklarasikan judul sesuai dengan judul
            String penulis = pilihancmb.getSelectedItem().toString();//mendeklarasikan penulis sesuai dengan combobox
            String harga = jTextField3.getText(); //mendeklarasikan harga sesuai dengan harga

            if(masukan(judul)){ //penyeleksian kondisi
                JOptionPane.showMessageDialog(this, "Judul Sudah ada");
            }
            else{
                TambahData(judul,penulis,harga); //menjalankan fungsi TambahData
                InitTable();//menampilkan ulang model dari table buku
                TampilData();//untuk menampilkan ulang fungsi TampilData
                JOptionPane.showMessageDialog(this, "Berhasil Simpan Data");
            }
        }
        else {
            JOptionPane.showMessageDialog(this, "harap data disi");

        }
    }//GEN-LAST:event_simpanActionPerformed

    private void editMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editMouseEntered
        //           
       
    }//GEN-LAST:event_editMouseEntered

    private void editMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editMouseExited
       
    }//GEN-LAST:event_editMouseExited

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
       
    }//GEN-LAST:event_editActionPerformed

    private void hapusMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hapusMouseEntered
       
    }//GEN-LAST:event_hapusMouseEntered

    private void hapusMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hapusMouseExited
      
    }//GEN-LAST:event_hapusMouseExited

    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed
      int baris = jTable1.getSelectedRow();
        model.removeRow(baris);
        JOptionPane.showMessageDialog(null, "Data Berhasil Terhapus");
    }//GEN-LAST:event_hapusActionPerformed

    private void ulangMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ulangMouseEntered
        //        
       
    }//GEN-LAST:event_ulangMouseEntered

    private void ulangMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ulangMouseExited
       
    }//GEN-LAST:event_ulangMouseExited

    private void ulangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ulangActionPerformed
        jTextField1.setText("");
        jTextField3.setText("");
        pilihancmb.setSelectedItem("");
        jTextField3.requestFocus();
    }//GEN-LAST:event_ulangActionPerformed

    private void keluarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_keluarMouseClicked
        System.exit(0);//untuk keluar dari program
    }//GEN-LAST:event_keluarMouseClicked

    private void keluarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_keluarMouseEntered
        
    }//GEN-LAST:event_keluarMouseEntered

    private void keluarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_keluarMouseExited
       
    }//GEN-LAST:event_keluarMouseExited

    private void keluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keluarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_keluarActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
         InitTable();//menjalankan fungsi InitTable
        TampilData();//menjalankan fungsi TampilData
    }//GEN-LAST:event_formComponentShown

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
            java.util.logging.Logger.getLogger(databuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(databuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(databuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(databuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new databuku().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cari;
    private javax.swing.JButton edit;
    private javax.swing.JButton hapus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JButton keluar;
    private javax.swing.JComboBox<String> pilihancari;
    private javax.swing.JComboBox<String> pilihancmb;
    private javax.swing.JButton simpan;
    private javax.swing.JButton ulang;
    // End of variables declaration//GEN-END:variables
}
