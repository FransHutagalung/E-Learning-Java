/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package COMPONENT;

import HomeRun.MAINPANEL;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author ACER
 */
public class RINDICANSTAFF extends javax.swing.JPanel {

    /**
     * Creates new form RINDICANSTAFF
     */
    Connection con ;
      private ImageIcon imgicon = null ;
    PreparedStatement prs ;
      PreparedStatement prs1 ;
    ResultSet rs ;
       ResultSet rs1 ;
    MAINPANEL MP ;
    public RINDICANSTAFF(MAINPANEL mp , String s) {
        this.MP = mp ;
        initComponents();
        con = mp.con ;
//        nama.setEditable(false);
//         agama.setEditable(false);
//          kodepegawai.setEditable(false);
//           jenkel.setEditable(false);
//            alamat.setEditable(false);
//            notelp.setEditable(false);
//             nik.setEditable(false);
//              status.setEditable(false);
//               tanggalgabung.setEditable(false);
//                tanggallahir.setEditable(false);
//                 nik.setEditable(false);
        initGambar(s);
        initMe(s);
                nama.setEditable(false);
         agama.setEditable(false);
          kodepegawai.setEditable(false);
           jenkel.setEditable(false);
            alamat.setEditable(false);
            notelp.setEditable(false);
             nik.setEditable(false);
              status.setEditable(false);
               tanggalgabung.setEditable(false);
                tanggallahir.setEditable(false);
                 nik.setEditable(false);
                 
//        initComponents();
    }
//    private byte [] imageData;
    private void initGambar (String s){
        try {
             prs1 = con.prepareStatement("SELECT foto FROM pegawai WHERE kodepegawai = ?");
                 prs1.setString(1, s);
                 rs1 = prs1.executeQuery();
                 while(rs1.next()){
                     System.out.println("Data ada");
                     
                 byte []  imageData = rs1.getBytes(1);
                     System.out.println("Foto " +rs1.getBytes(1));
               //   Image image = Toolkit.getDefaultToolkit().createImage(imageData);
                 imgicon = new ImageIcon(imageData);
                Image mm = imgicon.getImage();
                Image mm2 = mm.getScaledInstance(215, 258, Image.SCALE_SMOOTH);
                
               avatar.setIcon(new ImageIcon(mm2));
                 }
        } catch (SQLException e) {
        }
    }
    
    private void printRecord(JPanel panel){
        PrinterJob printerJob = PrinterJob.getPrinterJob();
        printerJob.setJobName("printer");
        printerJob.setPrintable(new Printable() {
            @Override
            public int print(Graphics grphcs, PageFormat pf, int i) throws PrinterException {
                if(i>0){
                    return Printable.NO_SUCH_PAGE;
                }
                //make 2D graphics to map content
                Graphics2D graphics2D = (Graphics2D)grphcs;
                //set graphics translation
                graphics2D.translate(pf.getImageableX()*2, pf.getImageableY()*2);
                //this is a page scale.default should be 0.3
                graphics2D.scale(0.5, 0.5);
                //now paint panel as graphics2D
                panel.paint(graphics2D);
                //return if page exists
                return Printable.PAGE_EXISTS;
            }
        });
        //store printer dialog  as boolean
         boolean returningResult = printerJob.printDialog();
         //check if dialog showing
         if(returningResult){
             //use try catch exeption for failure
             try{
                 //now call print method inside printerjob to print
                 printerJob.print();
             }catch(PrinterException printerException){
                 JOptionPane.showMessageDialog(this,"print error" + printerException.getMessage());
             }
         }
    }


    
    private void initMe(String s){
        String sql = "SELECT * FROM pegawai WHERE kodePegawai = ?";
//        byte [] imageData ;
//        ImageIcon imgicon ;
//        byte [] imageData;
        try {
            //266 //296
             prs = con.prepareStatement(sql);
             prs.setString(1, s);
             rs = prs.executeQuery();
             while(rs.next()){
                   Nama = rs.getString(3);
                   nama.setText(Nama);
                   System.out.println("nama"+Nama);
                   Agama =rs.getString(7);
                   agama.setText(rs.getString(7));
                   System.out.println("agama"+Agama);
                 Kodepegawai = rs.getString(2);System.out.println("kode pegawai" +Kodepegawai);
                 kodepegawai.setText(Kodepegawai);
                 Jenkel = rs.getString(8);
                 jenkel.setText(Jenkel);
                 Alamat = rs.getString(9);
                 alamat.setText(Alamat);
                 Notelp =rs.getString(12);
                 notelp.setText(Notelp);
                 Nik = rs.getString(14);
                 if(Nik.equals("")){
                     nik.setText("xxx-xxx");
                 } else{
                     
                 nik.setText(rs.getString(14));
                 }
                 
                 Status =rs.getString(4);
                 status.setText(Status);
                 Tanggalgabung =rs.getString(5);
                 tanggalgabung.setText(Tanggalgabung);
                 Tanggallahir = rs.getString(6);
                 tanggallahir.setText(Tanggallahir);
//                 prs1 = con.prepareStatement("SELECT foto FROM pegawai WHERE kodepegawai = ?");
//                 prs1.setString(1, s);
//                 rs1 = prs1.executeQuery();
//                 while(rs1.next()){
//                     System.out.println("Data ada");
//                 byte []  imageData = rs.getBytes("foto");
//               //   Image image = Toolkit.getDefaultToolkit().createImage(imageData);
//                 imgicon = new ImageIcon(imageData);
//                Image mm = imgicon.getImage();
//                Image mm2 = mm.getScaledInstance(215, 258, Image.SCALE_SMOOTH);
//                
//               avatar.setIcon(new ImageIcon(mm2));
//                 }
    
                        // Set the Image to the JLabel
//                 imgicon = new ImageIcon(image);
//                  //imgicon = new ImageIcon(imageData);
//                Image mm = imgicon.getImage();
//                Image mm2 = mm.getScaledInstance(215, 265, Image.SCALE_SMOOTH);
//                 
//                 avatar.setIcon(new ImageIcon(mm2));
//                        imageLabel.setIcon(imageIcon);
//                if(imageData==null)
//                {
//                     avatar.setBackground(Color.yellow);
//                } else {
//                 System.out.println("gambar " + imageData);
//                }      if (rs.getBytes("foto")== null) {
//           avatar.setBackground(Color.yellow); // set it to empty string as you desire.
//           } 
//                
//                if(imageData==null)
//                {
//                     avatar.setBackground(Color.yellow);
//                } else {
//                 System.out.println("gambar " + imageData);
//                }   
             }
//                 imgicon = new ImageIcon(imageData);
//                Image mm = imgicon.getImage();
//                Image mm2 = mm.getScaledInstance(215, 265, Image.SCALE_SMOOTH);
//                 
//                 avatar.setIcon(new ImageIcon(mm2));
             
        } catch (SQLException e) {
            System.out.println("err => " +e.getMessage());
        }
//         nama.setEditable(false);
//         
//         agama.setEditable(false);
//          kodepegawai.setEditable(false);
//           jenkel.setEditable(false);
//            alamat.setEditable(false);
//            notelp.setEditable(false);
//             nik.setEditable(false);
//              status.setEditable(false);
//               tanggalgabung.setEditable(false);
//                tanggallahir.setEditable(false);
//      //           nik.setEditable(false);
        //         initComponents();
    }
    private void iniComponent(){
        nama.setText(Nama);
        nik.setText(Nik);
        agama.setText(Agama);
        jenkel.setText(Jenkel);
        alamat.setText(Alamat);
        notelp.setText(Notelp);
        kodepegawai.setText(Kodepegawai);
        status.setText(Status);
        tanggallahir.setText(Tanggallahir);
        tanggalgabung.setText(Tanggalgabung);
//                          imgicon = new ImageIcon(imageData);
//                Image mm = imgicon.getImage();
//                Image mm2 = mm.getScaledInstance(266, 296, Image.SCALE_SMOOTH);
//                
//               gambar.setIcon(new ImageIcon(mm2));
    }
String Nama,Agama,Kodepegawai,Jenkel,Alamat,Notelp,Nik,Status,Tanggalgabung,Tanggallahir;
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
        panelRound1 = new test.PanelRound();
        panelRound2 = new test.PanelRound();
        panelRound3 = new test.PanelRound();
        nama = new textfield.TextField();
        kodepegawai = new textfield.TextField();
        nik = new textfield.TextField();
        agama = new textfield.TextField();
        tanggallahir = new textfield.TextField();
        jenkel = new textfield.TextField();
        textAreaScroll1 = new textarea.TextAreaScroll();
        alamat = new textarea.TextArea();
        notelp = new textfield.TextField();
        status = new textfield.TextField();
        tanggalgabung = new textfield.TextField();
        avatar = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        myButton1 = new button.MyButton();
        myButton2 = new button.MyButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(0, 51, 51));

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("RINCIAN STAFF");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        panelRound1.setBackground(new java.awt.Color(255, 255, 255));
        panelRound1.setRoundBottomLeft(20);
        panelRound1.setRoundBottomRight(20);
        panelRound1.setRoundTopLeft(20);
        panelRound1.setRoundTopRight(20);

        panelRound2.setRoundBottomLeft(20);
        panelRound2.setRoundBottomRight(20);
        panelRound2.setRoundTopLeft(20);
        panelRound2.setRoundTopRight(20);

        javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
        panelRound2.setLayout(panelRound2Layout);
        panelRound2Layout.setHorizontalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelRound2Layout.setVerticalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 41, Short.MAX_VALUE)
        );

        panelRound3.setRoundBottomLeft(20);
        panelRound3.setRoundBottomRight(20);
        panelRound3.setRoundTopLeft(20);
        panelRound3.setRoundTopRight(20);

        javax.swing.GroupLayout panelRound3Layout = new javax.swing.GroupLayout(panelRound3);
        panelRound3.setLayout(panelRound3Layout);
        panelRound3Layout.setHorizontalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelRound3Layout.setVerticalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        nama.setLabelText("Nama Lengkap");

        kodepegawai.setLabelText("Kode Pegawai");

        nik.setLabelText("NIK");

        agama.setLabelText("Agama");

        tanggallahir.setLabelText("Tanggal Lahir");

        jenkel.setLabelText("Jenis Kelamin");

        textAreaScroll1.setBackground(new java.awt.Color(255, 255, 255));
        textAreaScroll1.setLabelText("Alamat");

        alamat.setColumns(20);
        alamat.setRows(5);
        textAreaScroll1.setViewportView(alamat);

        notelp.setLabelText("No . Telp");
        notelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                notelpActionPerformed(evt);
            }
        });

        status.setLabelText("Status");

        tanggalgabung.setLabelText("Tanggal Bergabung");
        tanggalgabung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tanggalgabungActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 21, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelRound1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(panelRound2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(avatar, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(61, 61, 61)))
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nama, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nik, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(agama, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tanggallahir, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tanggalgabung, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textAreaScroll1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelRound1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(panelRound3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18))
                            .addGroup(panelRound1Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(kodepegawai, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)))
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jenkel, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(notelp, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(avatar, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelRound1Layout.createSequentialGroup()
                                .addComponent(tanggalgabung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(textAreaScroll1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelRound1Layout.createSequentialGroup()
                                .addComponent(nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(nik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(agama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tanggallahir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))))
                .addGap(8, 8, 8)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelRound1Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jenkel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelRound1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(panelRound3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(kodepegawai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(notelp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        myButton1.setText("CETAK DATA");
        myButton1.setBorderColor(new java.awt.Color(204, 204, 204));
        myButton1.setColorClick(new java.awt.Color(153, 153, 153));
        myButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton1ActionPerformed(evt);
            }
        });

        myButton2.setText("KEMBALI");
        myButton2.setBorderColor(new java.awt.Color(204, 204, 204));
        myButton2.setColorClick(new java.awt.Color(153, 153, 153));
        myButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(panelRound1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(25, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(myButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(myButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(myButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(myButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(82, 82, 82))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void notelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_notelpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_notelpActionPerformed

    private void myButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton2ActionPerformed
        // TODO add your handling code here:
        MP.initParent(new STAFF(MP));
    }//GEN-LAST:event_myButton2ActionPerformed

    private void tanggalgabungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tanggalgabungActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tanggalgabungActionPerformed

    private void myButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton1ActionPerformed
        // TODO add your handling code here:
        printRecord(panelRound1);
    }//GEN-LAST:event_myButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private textfield.TextField agama;
    private textarea.TextArea alamat;
    private javax.swing.JLabel avatar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private textfield.TextField jenkel;
    private textfield.TextField kodepegawai;
    private button.MyButton myButton1;
    private button.MyButton myButton2;
    private textfield.TextField nama;
    private textfield.TextField nik;
    private textfield.TextField notelp;
    private test.PanelRound panelRound1;
    private test.PanelRound panelRound2;
    private test.PanelRound panelRound3;
    private textfield.TextField status;
    private textfield.TextField tanggalgabung;
    private textfield.TextField tanggallahir;
    private textarea.TextAreaScroll textAreaScroll1;
    // End of variables declaration//GEN-END:variables
}
