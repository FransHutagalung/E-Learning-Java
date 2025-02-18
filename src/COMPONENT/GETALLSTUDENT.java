/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package COMPONENT;

import HomeRun.MAINPANEL;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.html.parser.DTDConstants;

/**
 *
 * @author ACER
 */
public class GETALLSTUDENT extends javax.swing.JPanel {

    /**
     * Creates new form GETALLSTUDENT
     */
    MAINPANEL mp ;
    Connection con ;
    PreparedStatement prs ;
    ResultSet rs ;
    DefaultTableModel df ;
    
    public GETALLSTUDENT(MAINPANEL mp ) {
        this.mp = mp ;
        con = mp.con ;
        initComponents();
        datalogin.setVisible(false);
        RefreshTable();
    }
    public void RefreshTable(){
        datalogin.setVisible(false);
        int n = 0 ;
        df = new DefaultTableModel();
        df.addColumn("No");
        df.addColumn("NISN");
        df.addColumn("Nama");
        df.addColumn("Kode Login");
        df.addColumn("Kelas");
        df.addColumn("Ruang Kelas");
        df.addColumn("Agama");
        df.addColumn("No Telp");
        String sql = "SELECT * FROM siswa";
        try {
            prs = con.prepareStatement(sql);
            rs = prs.executeQuery();
            while(rs.next()){
                df.addRow(new Object[]{
                    ++n,
                    rs.getString(3),
                    rs.getString(2),
                    rs.getString("kodeLogin"),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(8),
                    rs.getString(9)
                });
            }
            jTable1.setModel(df);
        } catch(SQLException e){
            
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

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        myButton1 = new button.MyButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        myButton2 = new button.MyButton();
        myButton3 = new button.MyButton();
        myButton4 = new button.MyButton();
        myButton5 = new button.MyButton();
        datalogin = new button.MyButton();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(0, 51, 51));

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("DATA SISWA");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1021, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        myButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton1ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kelas ", "NISN", "Nama", " " }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        myButton2.setText("TAMBAH DATA");
        myButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton2ActionPerformed(evt);
            }
        });

        myButton3.setText("LAPORAN");
        myButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton3ActionPerformed(evt);
            }
        });

        myButton4.setText("HAPUS");
        myButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton4ActionPerformed(evt);
            }
        });

        myButton5.setText("EDIT");
        myButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton5ActionPerformed(evt);
            }
        });

        datalogin.setText("INIT");
        datalogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dataloginActionPerformed(evt);
            }
        });

        jButton1.setText("REFRESH");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(myButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(myButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(datalogin, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 501, Short.MAX_VALUE)
                                .addComponent(myButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(myButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(myButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(28, 28, 28))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(myButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1)))
                .addGap(16, 16, 16)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(myButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(myButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(myButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(myButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(datalogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void myButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton2ActionPerformed
        // TODO add your handling code here:
        CREATESTRUDENT cs = new CREATESTRUDENT(mp);
        mp.initParent(cs);
    }//GEN-LAST:event_myButton2ActionPerformed

    private void myButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton5ActionPerformed
        // TODO add your handling code here:
        String s = String.valueOf(df.getValueAt(jTable1.getSelectedRow(), 1));
        CREATESTRUDENT1 qw = new CREATESTRUDENT1(mp, s);
        mp.initParent(qw);
        System.out.println("s => " +s);
    }//GEN-LAST:event_myButton5ActionPerformed

    private void addAccount(){
        String sql ="INSERT INTO studentlogin(Username,passowrd , nisn , classRoom) VALUES (?,?,?,?)";
        String usn = df.getValueAt(jTable1.getSelectedRow(), 1).toString();
        try{
            prs = con.prepareStatement(sql);
            prs.setString(1, usn);
            prs.setString(2,usn);
            prs.setString(3, usn);
            prs.setString(4, df.getValueAt(jTable1.getSelectedRow(), 5).toString() );
            int n = prs.executeUpdate();
            if(n > 0){
                System.out.println("Data Berhasil di Input");
            }
        } catch(SQLException e){
            System.out.println("err "+e.getMessage());
        }
    }
    
    private void UpdateAccount(){
        String sql = "UPDATE siswa SET kodeLogin = ? WHERE nisn = ?";
        try {
             prs = con.prepareStatement(sql);
             prs.setString(1, df.getValueAt(jTable1.getSelectedRow(), 1).toString());
             prs.setString(2, df.getValueAt(jTable1.getSelectedRow(), 1).toString());
             int n = prs.executeUpdate();
             if(n > 0){
                 System.out.println("Inserted Data");
                 RefreshTable();
             } else{
                 System.out.println(" Can Not Inserted Data");
             }
        } catch (SQLException e) {
            System.out.println("err => " +e.getMessage());
        }
    }
    
    private void dataloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dataloginActionPerformed
        // TODO add your handling code here:
        
        addAccount();
        UpdateAccount();
        
    }//GEN-LAST:event_dataloginActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        if(df.getValueAt(jTable1.getSelectedRow(), 3).toString().equals("null")){
            datalogin.setVisible(true);
        } else{
            datalogin.setVisible(false);
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        RefreshTable();
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void myButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton3ActionPerformed
        // TODO add your handling code here:
        print();
    }//GEN-LAST:event_myButton3ActionPerformed

     public void CariData(String nama){
        df = new DefaultTableModel();
        datalogin.setVisible(false);
        int n = 0 ;
        df = new DefaultTableModel();
        df.addColumn("No");
        df.addColumn("NISN");
        df.addColumn("Nama");
        df.addColumn("Kode Login");
        df.addColumn("Kelas");
        df.addColumn("Ruang Kelas");
        df.addColumn("Agama");
        df.addColumn("No Telp");
        String sql = "SELECT * FROM siswa where namaSiswa = ?";
        try {
            prs = con.prepareStatement(sql);
            prs.setString(1, nama);
            rs = prs.executeQuery();
            while(rs.next()){
                df.addRow(new Object[]{
                    ++n,
                    rs.getString(3),
                    rs.getString(2),
                    rs.getString("kodeLogin"),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(8),
                    rs.getString(9)
                });
            }
            jTable1.setModel(df);
        } catch(SQLException e){
            
        }
    }
    
     private void deleteData(String nisn){
         try {
             prs = con.prepareStatement("delete from siswa where nisn = ?");
             prs.setString(1, nisn);
             int n = prs.executeUpdate();
             if( n > 0){
                 System.out.println("berhasil hapus data");
//                 RefreshTable();
             }
         } catch (SQLException e) {
                    System.out.println("err occured " +e.getMessage());
         }
     }
     
     private void urutData(String s){
           df = new DefaultTableModel();
         int n = 0 ;
         try {
             prs = con.prepareStatement("select * from siswa order by ?");
             prs.setString(1, s);
                     rs = prs.executeQuery();
            while(rs.next()){
                df.addRow(new Object[]{
                    ++n,
                    rs.getString(3),
                    rs.getString(2),
                    rs.getString("kodeLogin"),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(8),
                    rs.getString(9)
                });
            }
            jTable1.setModel(df);
         } catch (SQLException e) {
             System.out.println("err occured " +e.getMessage());
         }
     }
     
    private void myButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton1ActionPerformed
        // TODO add your handling code here:
        CariData(jTextField1.getText());
    }//GEN-LAST:event_myButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        if(jComboBox1.getSelectedIndex()==0){
             urutData("RuangKelas");
        } else if(jComboBox1.getSelectedIndex()==1){
            urutData("nisn");
        } else if(jComboBox1.getSelectedIndex()==2){
            urutData("namaSiswa");
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void myButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton4ActionPerformed
        // TODO add your handling code here:
        deleteData(df.getValueAt(jTable1.getSelectedRow(), 1).toString());
        RefreshTable();
    }//GEN-LAST:event_myButton4ActionPerformed

    public void print() {
        try {
            jTable1.print(JTable.PrintMode.FIT_WIDTH, new MessageFormat("Data Siswa"), null);
        } catch (PrinterException ex) {
            Logger.getLogger(GETALLSTUDENT.class.getName()).log(Level.SEVERE, null, ex);
}
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private button.MyButton datalogin;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private button.MyButton myButton1;
    private button.MyButton myButton2;
    private button.MyButton myButton3;
    private button.MyButton myButton4;
    private button.MyButton myButton5;
    // End of variables declaration//GEN-END:variables
}
