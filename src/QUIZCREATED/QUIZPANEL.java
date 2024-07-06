/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QUIZCREATED;

import COMPONENT.REPOSITORYQUIZ;
import HomeRun.MAINPANEL;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import jnafilechooser.api.JnaFileChooser;

/**
 *
 * @author ACER
 */
public class QUIZPANEL extends javax.swing.JPanel {
 
    File f = null ;
    String path = null ;
    MAINPANEL mp ;
    
    int lengthsoal  ;
    
    private String nextRandom;
    
    String getNextRandom(){
        return nextRandom ;
    }
    void setNextRandom(String nextRandom){
        this.nextRandom = nextRandom ;
    }
    
    void doButton(){
          QUIZFILL qf = new QUIZFILL();
          myButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // This code will be executed when the button is clicked
                isiSoal(1, qf);
            }});
          myButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // This code will be executed when the button is clicked
                isiSoal(2, qf);
            }}); 
          
           jButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // This code will be executed when the button is clicked
                FillImage(qf);
            }}); 
           jButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // This code will be executed when the button is clicked
                RemoveImage(qf);
            }}); 
          
      
    }
    
    void doImage(String pathimg){
        ImageIcon img = new ImageIcon(pathimg);
        Image icon = img.getImage();
        
        Image scale = icon.getScaledInstance(196,178, Image.SCALE_SMOOTH);
        ImageIcon baru = new ImageIcon(scale);
        gambar.setIcon(baru);
    }
    
    void RemoveImage(QUIZFILL qf){
        
        qf.isImage[n-1] = false ;
        scaleImage();
        
    }
    
  void isiSoal(int dome  , QUIZFILL qf){
       if(dome == 1){
            if (n <= lengthsoal) {   
                 if (getValid()) {
                        setQuestion(qf, n-1);
                        qf.setIsFill(n-1);
                        // CHANGE INDEX
                        n++;
                        if( n == lengthsoal) { myButton4.setText("SIMPAN"); }
                        if( n == lengthsoal + 1 ){  
                             ShareToDB(qf);
                        }
                        setStatus(n); // GANTI HEADER
                        if(qf.isImage[n-1]){
                            doImage(qf.pathImage[n-1]);
                        } else{
                            scaleImage();
                        }
                        if(qf.getFill(n-1)){
                            FillThePanel(n-1, qf);
                        } else {
                           clearMe();
                        }
                    }
            }
       
        } else if(dome==2){
           
             if (n > 0) {   
                 if (getValid()) {
                        setQuestion(qf, n-1);
                        qf.setIsFill(n-1);
                        
                    } 
                  n-- ;
                  setStatus(n);
                  if(qf.isImage[n-1]){
                            doImage(qf.pathImage[n-1]);
                        } else{
                            scaleImage();
                        }
                  if(qf.getFill(n-1)){
                  FillThePanel(n-1, qf);      
                  }
                 
               
                    
            }
        }
    }
    
    void clearMe(){
         buttonGroup1.clearSelection();
         soal.setText("");
         opsia.setText("");
         opsib.setText("");
         opsic.setText("");
         opsid.setText("");
    }
    
    void FillImage(QUIZFILL qf){
        
        jnafilechooser.api.JnaFileChooser jna = new JnaFileChooser();
        boolean action = jna.showOpenDialog(null);
        if(action){
            path =  String.valueOf(jna.getSelectedFile());
            ImageIcon ii = new ImageIcon(path);
            qf.isImage[n-1] = true ;
            qf.pathImage[n-1] = path ;
            Image img = ii.getImage().getScaledInstance(gambar.getWidth(), gambar.getHeight(), Image.SCALE_SMOOTH);
            gambar.setIcon(new ImageIcon(img));
        }
      
    }
    

    void setHeader(String judul , String guru){
        pembuatsoal.setText(judul);
        pembuatsoal.setText(guru);
    }
    void setStatus(int isi){
        nNow.setText(String.valueOf(isi));
    }
    
    void FillThePanel(int i , QUIZFILL qf){
        soal.setText(qf.getArraySoal(i));
        opsia.setText(qf.getOpsiA(i));
        opsib.setText(qf.getOpsiB(i));
        opsic.setText(qf.getOpsiC(i));
        opsid.setText(qf.getOpsiD(i));
        
        String hasil = qf.getAnswer(i);
        if(hasil.equals("A")){
            jawaba.setSelected(true);
        } else if(hasil.equals("B")){
            jawabb.setSelected(true);
        } else if(hasil.equals("C")){
            jawabc.setSelected(true);
        } else if(hasil.equals("D")){
            jawabd.setSelected(true);
        } 
        
            
    }
    
     void ShareToDB(QUIZFILL qf){
         
         qf.setIDsoal(getNextRandom());
         
         int option = JOptionPane.showConfirmDialog(this, "APAKAH ANDA YAKIN ?");
                   REPOSITORYQUIZ rq = new REPOSITORYQUIZ(mp);
                   if(option==0){
                       qf.config(mp);
                       qf.addDB(lengthsoal);
                       if(qf.getisSave()){
                           
                           mp.initParent(rq);
                           
                       }
                      // JOptionPane.showMessageDialog(this, "BERHASIL");
                   }
    }
    
    public int n = 1 ;
    
    public QUIZPANEL(QUIZFILL qf , MAINPANEL mp) {
        initComponents();
//        qf.setLengthSoal(20);
        this.mp = mp ;
        lengthsoal= qf.getLengthSoal();
        nLength.setText(String.valueOf(lengthsoal));
        nNow.setText(String.valueOf(n));
 
        SetTextarea();
        doButton();
        scaleImage();
    }
    
    void SetTextarea(){
        soal.setColumns (100);
        soal.setLineWrap (true);
        soal.setWrapStyleWord (false);
    }
    
       public void scaleImage()
    {
        ImageIcon img = new ImageIcon("C:\\Users\\ACER\\Downloads\\soal.png");
        Image icon = img.getImage();
        
        Image scale = icon.getScaledInstance(196,178, Image.SCALE_SMOOTH);
        ImageIcon baru = new ImageIcon(scale);
        gambar.setIcon(baru);
        
    }
       
  
    
    String getjawaban(){
        String hasil  = "NONE";
        if(jawaba.isSelected()){
            hasil = "A";
        } else if(jawabb.isSelected()){
            hasil = "B";
        } else if(jawabc.isSelected()){
            hasil = "C";
        } else if(jawabd.isSelected()){
            hasil = "D";
        }
        return hasil ;
    }
    
    boolean getValid(){
        return !soal.getText().equals("") &&
                !opsia.getText().equals("") && 
                 !opsib.getText().equals("") &&
                  !opsic.getText().equals("") &&
                   !opsid.getText().equals("") &&
                     isAnswer() ;
    }
    
    boolean isAnswer(){
          return jawaba.isSelected() ||
                   jawabb.isSelected() ||
                        jawabc.isSelected() ||
                            jawabd.isSelected() ;
    }
    
    void setQuestion(QUIZFILL qf , int index){
        
        String soalindex = soal.getText();
        String opsiA = opsia.getText();
        String opsiB = opsib.getText();
        String opsiC = opsic.getText();
        String opsiD = opsid.getText();
        
        qf.setArray(index, soalindex, opsiA, opsiB, opsiC, opsiD, getjawaban());
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
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        soal = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        opsia = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        opsib = new javax.swing.JTextField();
        opsic = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        opsid = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jawaba = new javax.swing.JRadioButton();
        jawabb = new javax.swing.JRadioButton();
        jawabc = new javax.swing.JRadioButton();
        jawabd = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        gambar = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        pembuatsoal = new javax.swing.JLabel();
        judulsoal1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nNow = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        nLength = new javax.swing.JLabel();
        myButton4 = new button.MyButton();
        myButton3 = new button.MyButton();
        jLabel13 = new javax.swing.JLabel();

        jPanel3.setBackground(new java.awt.Color(51, 255, 51));
        jPanel3.setPreferredSize(new java.awt.Dimension(863, 685));

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        soal.setColumns(20);
        soal.setRows(5);
        jScrollPane1.setViewportView(soal);

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 731, 131));

        jLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jLabel1.setText("SOAL");
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, -1, -1));

        jPanel1.setBackground(new java.awt.Color(255, 153, 153));

        jLabel3.setText("OPSI A");

        jLabel4.setText("OPSI B");

        jLabel5.setText("OPSI C");

        jLabel6.setText("OPSI D");

        jLabel11.setText("JAWABAN");

        buttonGroup1.add(jawaba);
        jawaba.setText("A");
        jawaba.setOpaque(false);

        buttonGroup1.add(jawabb);
        jawabb.setText("B");
        jawabb.setOpaque(false);

        buttonGroup1.add(jawabc);
        jawabc.setText("C");
        jawabc.setOpaque(false);

        buttonGroup1.add(jawabd);
        jawabd.setText("D");
        jawabd.setOpaque(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(opsia))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(opsid))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(opsib))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(opsic))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(jawaba)
                        .addGap(18, 18, 18)
                        .addComponent(jawabb)
                        .addGap(18, 18, 18)
                        .addComponent(jawabc)
                        .addGap(11, 11, 11)
                        .addComponent(jawabd)
                        .addGap(16, 222, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(opsia, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(opsib, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(opsic, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(opsid, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jawaba)
                    .addComponent(jawabd)
                    .addComponent(jawabc)
                    .addComponent(jawabb))
                .addGap(25, 25, 25))
        );

        jPanel4.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 240, -1, -1));

        jPanel2.setBackground(new java.awt.Color(255, 153, 153));

        jButton3.setText("FILE");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("HAPUS");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(255, 153, 153));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(gambar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(gambar, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton3))
                .addContainerGap())
        );

        jPanel4.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 240, 200, 270));

        jLabel7.setText("SOAL BERGAMBAR / OPSIONAL");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 220, -1, -1));

        jLabel10.setText("ISI OPSI");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, -1, -1));

        pembuatsoal.setText("jLabel2");
        jPanel4.add(pembuatsoal, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 30, -1, -1));

        judulsoal1.setText("jLabel2");
        jPanel4.add(judulsoal1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 10, -1, -1));

        jLabel2.setText("Soal No . ");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 60, -1, -1));

        nNow.setText("0");
        jPanel4.add(nNow, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 60, -1, -1));

        jLabel9.setText("/");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 60, -1, -1));

        nLength.setText("0");
        jPanel4.add(nLength, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 60, -1, -1));

        myButton4.setText("LANJUT");
        myButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton4ActionPerformed(evt);
            }
        });
        jPanel4.add(myButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 530, -1, -1));

        myButton3.setText("KEMBALI");
        jPanel4.add(myButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 540, -1, -1));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(320, 320, 320)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 1134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 577, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 1049, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
        

      
    
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
//        scaleImage();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void myButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton3ActionPerformed
        // TODO add your handling code here:
       // isiSoal(2);

    
    }//GEN-LAST:event_myButton3ActionPerformed

    private void myButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton4ActionPerformed
      
        //isiSoal(1);
    
      
        
           
            //nNow.setText(String.valueOf(n));
            

            
        
        
    }//GEN-LAST:event_myButton4ActionPerformed

    private void myButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton5ActionPerformed
        // TODO add your handling code here:
        clearMe();
    }//GEN-LAST:event_myButton5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel gambar;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton jawaba;
    private javax.swing.JRadioButton jawabb;
    private javax.swing.JRadioButton jawabc;
    private javax.swing.JRadioButton jawabd;
    private javax.swing.JLabel judulsoal1;
    private button.MyButton myButton3;
    private button.MyButton myButton4;
    private javax.swing.JLabel nLength;
    private javax.swing.JLabel nNow;
    private javax.swing.JTextField opsia;
    private javax.swing.JTextField opsib;
    private javax.swing.JTextField opsic;
    private javax.swing.JTextField opsid;
    private javax.swing.JLabel pembuatsoal;
    private javax.swing.JTextArea soal;
    // End of variables declaration//GEN-END:variables
}
