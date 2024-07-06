/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package COMPONENT;

import HomeRun.MAINPANEL;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import jnafilechooser.api.JnaFileChooser;



/**
 *
 * @author ACER
 */
public class EACHSTAFF extends javax.swing.JPanel {

    /**
     * Creates new form EACHSTAFF
     */
    Connection con ;
    PreparedStatement prs ;
    boolean isSet = false ;
    MAINPANEL mp ;
    String path ;
    public EACHSTAFF( MAINPANEL mp ) {
        initComponents();
        this.mp = mp ;
        this.con = mp.con ;
    }
    
    private void doImage(){
          InputStream is = null;
            System.out.println("Image Path" +path);
            File f = new File(path);
        try {
            is = new FileInputStream(f);
            try {
            String sql = "UPDATE barang SET  gambarBarang = ?  WHERE idBarang = ? ";
            PreparedStatement prs;
             prs = con.prepareStatement(sql);
//             prs.setString(1, s);
//             prs.setInt(2, harga1);
//             prs.setInt(3, stok1);
             prs.setBlob(1, is);
             prs.setString(2, path);
             
             int inserted = prs.executeUpdate();
             if(inserted> 0)
             {
                 JOptionPane.showMessageDialog(this, "Gambar Berhasil Diupload");
             }
            } catch (SQLException ex) {
//                Logger.getLogger(TabelPenjualan.class.getName()).log(Level.SEVERE, null, ex);
            }
//            prs.setString(1, s);
            
        } catch (FileNotFoundException ex ) {
//            Logger.getLogger(TabelPenjualan.class.getName()).log(Level.SEVERE, null, ex);
         
        } finally {
            try {
                is.close();
            } catch (IOException ex) {
//                Logger.getLogger(TabelPenjualan.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
         InputStream is = null ;
    private void Inserted(){
         File f = new File(path);
        try {
            is = new FileInputStream(f);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EACHSTAFF.class.getName()).log(Level.SEVERE, null, ex);
        }
        String sTanggal1 = tanggal.getText();
        String tanggal = sTanggal1.substring(0, 2);
        String bulan  = sTanggal1.substring(3, 5);
        String tahun  = sTanggal1.substring(6, 10);
        String tanggalAkhir = tahun +"-" +bulan +"-"+tanggal;
        String s = pria.isSelected() ? "Pria" : "Wanita";
        String sql = "INSERT INTO pegawai(namaPegawai , pendidikanterakhir , jenkel , agama , alamat , tanggallahir , noTelp , email ,kodePegawai,status , tanggalMasuk , foto  , nik) VALUES (?,?,?,?,?,?,?,? ,?,?,curdate() , ?,?)";
        try {
            prs = con.prepareStatement(sql);
            prs.setString(1, namaPegawai.getText());
            prs.setString(2, pendidikanTerakhir.getSelectedItem().toString());
           prs.setString(3, s);
           prs.setString(4, agama.getSelectedItem().toString());
           prs.setString(5, alamat.getText());
           prs.setString(6 , tanggalAkhir);    
           prs.setString(7, notelp.getText());
            prs.setString(8, email.getText());
            prs.setString(9, getRandom(6));
             prs.setString(10, status.getSelectedItem().toString());
//                prs.setBlob(1, path);
         prs.setBlob(11, is);
                prs.setString(12, nik.getText());
           int n =   prs.executeUpdate();
           if(n > 0){
               isSet = true ;
           }
            //System.out.println("Can Not Inserted data ");
        } catch (SQLException e) {
            System.out.println("err => " +e.getMessage());
        }
    }
      public String getRandom(int length){
        // Define the characters that can be used in the random string
        String characters = "abcdefghijklmnopqrstuvwxyz";

        // Set the length of the random string
//        int length = 4;

        // Create a StringBuilder to build the random string
        //StringBuilder randomString = new StringBuilder();
        String wl = "";
        // Create a Random object
        Random random = new Random();

        // Generate the random string
        for (int i = 0; i < length; i++) {
            // Generate a random index to pick a character from the 'characters' string
            int randomIndex = random.nextInt(characters.length());

            // Append the randomly selected character to the random string
           // randomString.append(characters.charAt(randomIndex));
           wl += characters.charAt(randomIndex);
        }
        
       // randomString.append(length);

        // Print the generated random string
//        System.out.println("Random 4-letter string: " + randomString.toString());

return  wl;
    }
    private void isCome()
    {
            STAFF s = new STAFF( mp);
            s.RefreshTable();
            mp.initParent(s);
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
        dateChooser1 = new com.raven.datechooser.DateChooser();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        agama = new combobox.Combobox();
        tanggal = new textfield.TextField();
        textAreaScroll1 = new textarea.TextAreaScroll();
        alamat = new textarea.TextArea();
        wanita = new radio_button.RadioButtonCustom();
        pria = new radio_button.RadioButtonCustom();
        jLabel2 = new javax.swing.JLabel();
        pendidikanTerakhir = new combobox.Combobox();
        gambar = new test.PanelRound();
        gambarku = new javax.swing.JLabel();
        namaPegawai = new textfield.TextField();
        notelp = new textfield.TextField();
        email = new textfield.TextField();
        button1 = new button.Button();
        myButton1 = new button.MyButton();
        myButton2 = new button.MyButton();
        status = new combobox.Combobox();
        myButton3 = new button.MyButton();
        nik = new textfield.TextField();

        dateChooser1.setTextRefernce(tanggal);

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(0, 51, 51));

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("DATA PEGAWAI ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 965, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        agama.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Katolik", "Kristen", "Islam", "Hindu", "Buddha", "Konghucu", " " }));
        agama.setSelectedIndex(-1);
        agama.setLabeText("Agama");
        agama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agamaActionPerformed(evt);
            }
        });

        tanggal.setLabelText("Tanggal Lahir");

        textAreaScroll1.setBackground(new java.awt.Color(255, 255, 255));
        textAreaScroll1.setLabelText("Alamat");

        alamat.setColumns(20);
        alamat.setRows(5);
        textAreaScroll1.setViewportView(alamat);

        buttonGroup1.add(wanita);
        wanita.setText("Wanita");

        buttonGroup1.add(pria);
        pria.setText("Pria");

        jLabel2.setText("Jenis Kelamin");

        pendidikanTerakhir.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SMA / Sederajat", "S1", "S2", "S3" }));
        pendidikanTerakhir.setSelectedIndex(-1);
        pendidikanTerakhir.setLabeText("Pendidikan Terakhir");

        gambar.setBackground(new java.awt.Color(204, 204, 204));
        gambar.setRoundBottomLeft(20);
        gambar.setRoundBottomRight(20);
        gambar.setRoundTopLeft(20);
        gambar.setRoundTopRight(20);

        javax.swing.GroupLayout gambarLayout = new javax.swing.GroupLayout(gambar);
        gambar.setLayout(gambarLayout);
        gambarLayout.setHorizontalGroup(
            gambarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gambarku, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
        );
        gambarLayout.setVerticalGroup(
            gambarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gambarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(gambarku, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                .addContainerGap())
        );

        namaPegawai.setLabelText("Nama Lengkap");

        notelp.setLabelText("No Telp");

        email.setLabelText("Email");
        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });

        myButton1.setText("SIMPAN DATA");
        myButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton1ActionPerformed(evt);
            }
        });

        myButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton2ActionPerformed(evt);
            }
        });

        status.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Guru", "Admin", "Pegawai", "Satpam", "Pembersih", "Koki", "Koperasi", " " }));
        status.setSelectedIndex(-1);
        status.setLabeText("Status");
        status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusActionPerformed(evt);
            }
        });

        myButton3.setText("FILE");
        myButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton3ActionPerformed(evt);
            }
        });

        nik.setLabelText("NIK");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(350, 350, 350)
                        .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(myButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(myButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(gambar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(namaPegawai, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addComponent(tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(pendidikanTerakhir, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(agama, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textAreaScroll1, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(notelp, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(pria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(wanita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(39, 39, 39))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(nik, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(myButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(339, 339, 339)
                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(myButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(namaPegawai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pendidikanTerakhir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(notelp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(agama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(pria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(wanita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(nik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(textAreaScroll1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(166, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(gambar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(myButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(myButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 999, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 65, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailActionPerformed

    private void myButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton1ActionPerformed
        // TODO add your handling code here:
        Inserted();
        isCome();
    }//GEN-LAST:event_myButton1ActionPerformed

    private void agamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_agamaActionPerformed

    private void myButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton2ActionPerformed
        // TODO add your handling code here:
        dateChooser1.showPopup();
    }//GEN-LAST:event_myButton2ActionPerformed

    private void statusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_statusActionPerformed
File f = null ;
    private void myButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton3ActionPerformed
        // TODO add your handling code here:
          jnafilechooser.api.JnaFileChooser jna = new JnaFileChooser();
        boolean action = jna.showOpenDialog(null);
        if(action){
            path =  String.valueOf(jna.getSelectedFile());
            ImageIcon ii = new ImageIcon(path);
//            qf.isImage[n-1] = true ;
//            qf.pathImage[n-1] = path ;
            Image img = ii.getImage().getScaledInstance(193,204, Image.SCALE_SMOOTH);
            gambarku.setIcon(new ImageIcon(img));
        }

// JFileChooser pilih = new JFileChooser();
//      FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG JPEG AND JPG" ,"png" , "jpg" , "jpeg");
//      pilih.addChoosableFileFilter(filter);
//      int Load = pilih.showOpenDialog(null);
//      
//      if(Load==pilih.APPROVE_OPTION)
//      {
//          f = pilih.getSelectedFile();
//          path = f.getAbsolutePath();
////          gam.setText(path);
//          ImageIcon ii = new ImageIcon(path);
//          Image img = ii.getImage().getScaledInstance(193,204, Image.SCALE_SMOOTH);
//          gambarku.setIcon(new ImageIcon(img));
//      }
    }//GEN-LAST:event_myButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private combobox.Combobox agama;
    private textarea.TextArea alamat;
    private button.Button button1;
    private javax.swing.ButtonGroup buttonGroup1;
    private com.raven.datechooser.DateChooser dateChooser1;
    private textfield.TextField email;
    private test.PanelRound gambar;
    private javax.swing.JLabel gambarku;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private button.MyButton myButton1;
    private button.MyButton myButton2;
    private button.MyButton myButton3;
    private textfield.TextField namaPegawai;
    private textfield.TextField nik;
    private textfield.TextField notelp;
    private combobox.Combobox pendidikanTerakhir;
    private radio_button.RadioButtonCustom pria;
    private combobox.Combobox status;
    private textfield.TextField tanggal;
    private textarea.TextAreaScroll textAreaScroll1;
    private radio_button.RadioButtonCustom wanita;
    // End of variables declaration//GEN-END:variables
}
