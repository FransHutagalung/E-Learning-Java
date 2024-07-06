/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package COMPONENT;

import HomeRun.MAINPANEL;
import checkbox.JCheckBoxCustom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ACER
 */
public class CREATESTUDYEACH extends javax.swing.JPanel {

    /**
     * Creates new form CREATESTUDYEACH
     */
    ArrayList<String> kodeGuru = new ArrayList<>() ;
    Connection con ;
    ResultSet rs ;
    PreparedStatement prs ;
    DefaultTableModel df ;
    DefaultTableModel df2 ;
    ComboBoxModel<String> comboBoxModel ;
    private boolean is1 ,is2 ,is3 ,is4 ,is5 ,is6 ;
    JCheckBoxCustom [] cb = new JCheckBoxCustom[24];
    int nBidStud = 0 ;
    public CREATESTUDYEACH(MAINPANEL mp) {
        this.con = mp.con ;
        initComponents();
        
        cb[0] = a1;
        cb[1] = b1;
        cb[2] = c1;
        cb[3] = d1;
        cb[4] = a2;
        cb[5] = b2;
        cb[6] = c2;
        cb[7] = d2;
        cb[8] = a3;
        cb[9] = b3;
        cb[10] = c3;
        cb[11] = d3;
        cb[12] = a4;
        cb[13] = b4;
        cb[14] = c4;
        cb[15] = d4;
        cb[16] = a5;
        cb[17] = b5;
        cb[18] = c5;
        cb[19] = d5;
        cb[20] = a6;
        cb[21] = b6;
        cb[22] = c6;
        cb[23] = d6;
      
        
        
        jPanel5.setVisible(false);
        refreshComboBox();
        RefreshTable();
        jPanel7.setVisible(false);
        jPanel12.setVisible(false);
        jPanel13.setVisible(false);
        jPanel14.setVisible(false);
        jPanel15.setVisible(false);
        jPanel16.setVisible(false);
        
    }
    
    
    String [] kodeBidangStudi = new String[200];
    
    private void InsertedTable(){
        String Kelas1 =kelas1.isSelected() ? "YA" : "";
        String Kelas2 =kelas2.isSelected() ? "YA" : "";
        String Kelas3 =kelas3.isSelected() ? "YA" : "";
        String Kelas4 =kelas4.isSelected() ? "YA" : "";
        String Kelas5 =kelas5.isSelected() ? "YA" : "";
        String Kelas6 =kelas6.isSelected() ? "YA" : "";
        
        for (int i = 0; i < cb.length; i++) {
           if(cb[i].isSelected()){
                String sql = "INSERT INTO bidangstudi (namaBidangStudi , namaGuru ,id , kelas1 ,kelas2,kelas3,kelas4,kelas5 ,kelas6 ,ruangKelas , role) values (?,?,?,?,?,?,?,?,?,?,?)";
        try{
        prs = con.prepareStatement(sql);
        prs.setString(1, namaMapel.getText());
        prs.setString(2, namaGuru.getSelectedItem().toString());
        prs.setString(3, getRandom(4));
        prs.setString(4, Kelas1 );
        prs.setString(5, Kelas2 );
        prs.setString(6, Kelas3 );
        prs.setString(7, Kelas4 );
        prs.setString(8, Kelas5 );
        prs.setString(9, Kelas6 );
         prs.setString(10, cb[i].getText() );
         prs.setString(11, combobox2.getSelectedItem().toString());
        prs.executeUpdate();
        System.out.println("");
        } catch(SQLException e){
            System.out.println("err " + e.getMessage());
        }
           }
        }
//        String sql = "INSERT INTO bidangstudi (namaBidangStudi , namaGuru ,id , kelas1 ,kelas2,kelas3,kelas4,kelas5 ,kelas6) values (?,?,?,?,?,?,?,?,?)";
//        try{
//        prs = con.prepareStatement(sql);
//        prs.setString(1, namaMapel.getText());
//        prs.setString(2, namaGuru.getSelectedItem().toString());
//        prs.setString(3, getRandom(4));
//        prs.setString(4, Kelas1 );
//        prs.setString(5, Kelas2 );
//        prs.setString(6, Kelas3 );
//        prs.setString(7, Kelas4 );
//        prs.setString(8, Kelas5 );
//        prs.setString(9, Kelas6 );
//        prs.executeUpdate();
//        System.out.println("");
//        } catch(SQLException e){
//            System.out.println("err " + e.getMessage());
//        }
        
    }
    
    private void RefreshTable(){
        df = new DefaultTableModel();
        df2 = new DefaultTableModel();
        df.addColumn("Nama Guru");
        df.addColumn("Nama Pelajaran");
        df.addColumn("Kode Pelajaran");
        df.addColumn("Ruang Kelas");
        
        df2.addColumn("Kelas 1");
        df2.addColumn("Kelas 2");
        df2.addColumn("Kelas 3");
        df2.addColumn("Kelas 4");
        df2.addColumn("Kelas 5");
        df2.addColumn("Kelas 6");
//        df.addColumn("");
        String sql = "SELECT * FROM bidangstudi ";
        try {
            prs = con.prepareStatement(sql);
            rs = prs.executeQuery();
            while(rs.next()){
                df.addRow(new Object[]{
                    rs.getString(6),
                    rs.getString(2),
                    rs.getString(1),
                     rs.getString(4)
                   
                });
                System.out.println("hasil " +rs.getString(1));
                kodeBidangStudi[nBidStud] = rs.getString(1);
                nBidStud ++ ;
                df2.addRow(new Object[]{
                    rs.getString(8),
                    rs.getString(9),
                    rs.getString(10),
                    rs.getString(11),
                    rs.getString(12),
                    rs.getString(13)
                });
            }
            jTable1.setModel(df);
            jTable2.setModel(df2);
        } catch (SQLException e) {
            System.out.println("err occured " +e.getMessage());
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
    
    public void refreshComboBox( ){
     
        String sql = "select namaPegawai, kodePegawai from pegawai where status = 'Guru'";
        try {
        prs = con.prepareStatement(sql);
        rs = prs.executeQuery();
        Vector<String> data = new Vector<>();
        while(rs.next()){
             data.add(rs.getString(1));
             kodeGuru.add(rs.getString(2));
        }
        namaGuru.setModel(new DefaultComboBoxModel<>(data));
        } catch (SQLException e ){
            System.out.println("error => " +e.getMessage());
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
        panelRound1 = new test.PanelRound();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        pencarian = new javax.swing.JTextField();
        myButton1 = new button.MyButton();
        combobox1 = new combobox.Combobox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        myButton5 = new button.MyButton();
        myButton4 = new button.MyButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        kelas3 = new checkbox.JCheckBoxCustom();
        kelas1 = new checkbox.JCheckBoxCustom();
        kelas4 = new checkbox.JCheckBoxCustom();
        kelas6 = new checkbox.JCheckBoxCustom();
        kelas2 = new checkbox.JCheckBoxCustom();
        kelas5 = new checkbox.JCheckBoxCustom();
        jLabel4 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        b1 = new checkbox.JCheckBoxCustom();
        c1 = new checkbox.JCheckBoxCustom();
        a1 = new checkbox.JCheckBoxCustom();
        d1 = new checkbox.JCheckBoxCustom();
        jPanel12 = new javax.swing.JPanel();
        b2 = new checkbox.JCheckBoxCustom();
        c2 = new checkbox.JCheckBoxCustom();
        a2 = new checkbox.JCheckBoxCustom();
        d2 = new checkbox.JCheckBoxCustom();
        jPanel13 = new javax.swing.JPanel();
        b3 = new checkbox.JCheckBoxCustom();
        c3 = new checkbox.JCheckBoxCustom();
        a3 = new checkbox.JCheckBoxCustom();
        d3 = new checkbox.JCheckBoxCustom();
        jPanel14 = new javax.swing.JPanel();
        b4 = new checkbox.JCheckBoxCustom();
        c4 = new checkbox.JCheckBoxCustom();
        a4 = new checkbox.JCheckBoxCustom();
        d4 = new checkbox.JCheckBoxCustom();
        jPanel15 = new javax.swing.JPanel();
        b5 = new checkbox.JCheckBoxCustom();
        c5 = new checkbox.JCheckBoxCustom();
        a5 = new checkbox.JCheckBoxCustom();
        d5 = new checkbox.JCheckBoxCustom();
        jPanel16 = new javax.swing.JPanel();
        b6 = new checkbox.JCheckBoxCustom();
        c6 = new checkbox.JCheckBoxCustom();
        a6 = new checkbox.JCheckBoxCustom();
        d6 = new checkbox.JCheckBoxCustom();
        myButton2 = new button.MyButton();
        namaMapel = new textfield.TextField();
        namaGuru = new combo_suggestion.ComboBoxSuggestion();
        jLabel3 = new javax.swing.JLabel();
        combobox2 = new combobox.Combobox();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(0, 51, 51));

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("DATA PELAJARAN");

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

        panelRound1.setBackground(new java.awt.Color(255, 255, 255));
        panelRound1.setRoundBottomLeft(30);
        panelRound1.setRoundBottomRight(30);
        panelRound1.setRoundTopLeft(30);
        panelRound1.setRoundTopRight(30);

        jPanel3.setBackground(new java.awt.Color(0, 153, 153));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setText("Cari Data :");

        myButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton1ActionPerformed(evt);
            }
        });

        combobox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nama Guru", "Nama Pelajaran", "Nama Kelas", " " }));
        combobox1.setSelectedIndex(-1);
        combobox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combobox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(combobox1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pencarian, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(myButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(myButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(pencarian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(37, 37, 37))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(combobox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

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
        jScrollPane2.setViewportView(jTable2);

        myButton5.setText("SEGARKAN");
        myButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton5ActionPerformed(evt);
            }
        });

        myButton4.setText("HAPUS");
        myButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(myButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(myButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(myButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(myButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 160, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        kelas3.setText("3");
        kelas3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kelas3ActionPerformed(evt);
            }
        });

        kelas1.setText("1");
        kelas1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kelas1MouseClicked(evt);
            }
        });
        kelas1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kelas1ActionPerformed(evt);
            }
        });

        kelas4.setText("4");
        kelas4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kelas4ActionPerformed(evt);
            }
        });

        kelas6.setText("6");
        kelas6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kelas6ActionPerformed(evt);
            }
        });

        kelas2.setText("2");
        kelas2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kelas2ActionPerformed(evt);
            }
        });

        kelas5.setText("5");
        kelas5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kelas5ActionPerformed(evt);
            }
        });

        jLabel4.setText("Kelas");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(kelas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(kelas2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(kelas3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(kelas4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(kelas5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(kelas6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kelas3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kelas6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kelas2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kelas4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kelas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kelas5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel17.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        b1.setText("1-B");

        c1.setText("1-C");

        a1.setText("1-A");

        d1.setText("1-D");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(105, Short.MAX_VALUE)
                .addComponent(b1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(c1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(d1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addGap(26, 26, 26)
                    .addComponent(a1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(260, Short.MAX_VALUE)))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(b1, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                .addComponent(d1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(c1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(a1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jPanel6.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        b2.setText("2-B");

        c2.setText("2-C");

        a2.setText("2-A");

        d2.setText("2-D");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(b2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(c2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(d2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel12Layout.createSequentialGroup()
                    .addGap(26, 26, 26)
                    .addComponent(a2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(260, Short.MAX_VALUE)))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(b2, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                .addComponent(d2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(c2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel12Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(a2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jPanel6.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 43, -1, -1));

        b3.setText("3-B");

        c3.setText("3-C");

        a3.setText("3-A");

        d3.setText("3-D");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(b3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(c3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(d3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
            .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel13Layout.createSequentialGroup()
                    .addGap(26, 26, 26)
                    .addComponent(a3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(260, Short.MAX_VALUE)))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(b3, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                .addComponent(d3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(c3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel13Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(a3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jPanel6.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 86, -1, -1));

        b4.setText("4-B");

        c4.setText("4-C");

        a4.setText("4-A");

        d4.setText("4-D");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(b4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(c4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(d4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel14Layout.createSequentialGroup()
                    .addGap(26, 26, 26)
                    .addComponent(a4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(260, Short.MAX_VALUE)))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(b4, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                .addComponent(d4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(c4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel14Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(a4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jPanel6.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 129, -1, -1));

        b5.setText("5-B");

        c5.setText("5-C");

        a5.setText("5-A");

        d5.setText("5-D");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(b5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(c5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(d5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel15Layout.createSequentialGroup()
                    .addGap(26, 26, 26)
                    .addComponent(a5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(260, Short.MAX_VALUE)))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(b5, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                .addComponent(d5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(c5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel15Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(a5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jPanel6.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 172, -1, -1));

        b6.setText("6-B");

        c6.setText("6-C");

        a6.setText("6-A");

        d6.setText("6-D");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(b6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(c6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(d6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
            .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel16Layout.createSequentialGroup()
                    .addGap(26, 26, 26)
                    .addComponent(a6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(260, Short.MAX_VALUE)))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(b6, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                .addComponent(d6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(c6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel16Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(a6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jPanel6.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 215, -1, -1));

        jPanel17.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, -1, -1));

        myButton2.setText("SIMPAN");
        myButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton2ActionPerformed(evt);
            }
        });
        jPanel17.add(myButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 510, -1, -1));

        namaMapel.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        namaMapel.setLabelText("Nama Mata Pelajaran");
        jPanel17.add(namaMapel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 290, -1));
        jPanel17.add(namaGuru, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 11, 290, 37));

        jLabel3.setText("Guru");
        jPanel17.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 22, -1, -1));

        combobox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sains", "Hukum", "Sosial ", "Budaya", "Teknologi", "Matematika", "Geografis", "Olahraga", "Keagamaan", "Sastra" }));
        combobox2.setSelectedIndex(-1);
        combobox2.setLabeText("Role");
        jPanel17.add(combobox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 290, -1));

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(661, 661, 661)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(121, 121, 121)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(409, 409, 409)
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(122, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, 1030, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void myButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton1ActionPerformed
        // TODO add your handling code here:
         df = new DefaultTableModel();
        df2 = new DefaultTableModel();
        df.addColumn("Nama Guru");
        df.addColumn("Nama Pelajaran");
        df.addColumn("Kode Pelajaran");
        df.addColumn("Ruang Kelas");
        
        df2.addColumn("Kelas 1");
        df2.addColumn("Kelas 2");
        df2.addColumn("Kelas 3");
        df2.addColumn("Kelas 4");
        df2.addColumn("Kelas 5");
        df2.addColumn("Kelas 6");
//        df.addColumn("");
        String sql = "SELECT * FROM bidangstudi where namaBidangStudi = ?";
        try {
            prs = con.prepareStatement(sql);
            prs.setString(1, pencarian.getText());
            rs = prs.executeQuery();
            while(rs.next()){
                df.addRow(new Object[]{
                    rs.getString(6),
                    rs.getString(2),
                    rs.getString(1),
                     rs.getString(4)
                   
                });
//                kodeBidangStudi[nBidStud] = rs.getString(1);
//                nBidStud ++ ;
                df2.addRow(new Object[]{
                    rs.getString(8),
                    rs.getString(9),
                    rs.getString(10),
                    rs.getString(11),
                    rs.getString(12),
                    rs.getString(13)
                });
            }
            jTable1.setModel(df);
            jTable2.setModel(df2);
        } catch (SQLException e) {
        }
        
    }//GEN-LAST:event_myButton1ActionPerformed

    private void myButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton2ActionPerformed
        // TODO add your handling code here:
        InsertedTable();
        RefreshTable();
    }//GEN-LAST:event_myButton2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        jPanel5.setVisible(true);
    }//GEN-LAST:event_jTable1MouseClicked

    private void myButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton5ActionPerformed
        // TODO add your handling code here:
        RefreshTable();
    }//GEN-LAST:event_myButton5ActionPerformed

    private void getOrder(String order){
         df = new DefaultTableModel();
        df2 = new DefaultTableModel();
        df.addColumn("Nama Guru");
        df.addColumn("Nama Pelajaran");
        df.addColumn("Kode Pelajaran");
        df.addColumn("Ruang Kelas");
        
        df2.addColumn("Kelas 1");
        df2.addColumn("Kelas 2");
        df2.addColumn("Kelas 3");
        df2.addColumn("Kelas 4");
        df2.addColumn("Kelas 5");
        df2.addColumn("Kelas 6");
//        df.addColumn("");
        String sql = "SELECT * FROM bidangstudi  order by " +order;
        try {
            prs = con.prepareStatement(sql);
//            prs.setString(1, order);
            rs = prs.executeQuery();
            while(rs.next()){
                df.addRow(new Object[]{
                    rs.getString(6),
                    rs.getString(2),
                    rs.getString(1),
                     rs.getString(4)
                   
                });
//                kodeBidangStudi[nBidStud] = rs.getString(1);
//                nBidStud ++ ;
                df2.addRow(new Object[]{
                    rs.getString(8),
                    rs.getString(9),
                    rs.getString(10),
                    rs.getString(11),
                    rs.getString(12),
                    rs.getString(13)
                });
            }
            jTable1.setModel(df);
            jTable2.setModel(df2);
        } catch (SQLException e) {
        }
    }
    
    private void kelas1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kelas1MouseClicked
        // TODO add your handling code here:
        if(is1){
            jPanel7.setVisible(false);
            is1 = false ;
        } else if(!is1){
            jPanel7.setVisible(true);
            is1= true ;
    }
    }//GEN-LAST:event_kelas1MouseClicked

    private void kelas2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kelas2ActionPerformed
        // TODO add your handling code here:
                if(is2){
            jPanel12.setVisible(false);
            is2 = false ;
        } else if(!is2){
            jPanel12.setVisible(true);
            is2= true ;
    }
    }//GEN-LAST:event_kelas2ActionPerformed

    private void kelas3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kelas3ActionPerformed
        // TODO add your handling code here:
                if(is3){
            jPanel13.setVisible(false);
            is3 = false ;
        } else if(!is3){
            jPanel13.setVisible(true);
            is3=true ;
    }
    }//GEN-LAST:event_kelas3ActionPerformed

    private void kelas4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kelas4ActionPerformed
        // TODO add your handling code here:
                if(is4){
            jPanel14.setVisible(false);
            is4 = false ;
        } else if(!is4){
            jPanel14.setVisible(true);
            is4= true ;
    }
    }//GEN-LAST:event_kelas4ActionPerformed

    private  void deleteStudy(){
        int n = jTable1.getSelectedRow();
        String k = kodeBidangStudi[n];
        try {
             prs = con.prepareStatement("delete from bidangstudi where id = ?");
             prs.setString(1, k);
             int  w= prs.executeUpdate();
             if( w > 0){
                 System.out.println("Berhasil Hapus Data");
                 RefreshTable();
             }
        } catch (SQLException e) {
            System.out.println("err " +e.getMessage());
        }
    }
    
    private void kelas5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kelas5ActionPerformed
        // TODO add your handling code here:
                if(is5){
            jPanel15.setVisible(false);
            is5 = false ;
        } else if(!is5){
            jPanel15.setVisible(true);
            is5= true ;
    }
    }//GEN-LAST:event_kelas5ActionPerformed

    private void kelas6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kelas6ActionPerformed
        // TODO add your handling code here:
                if(is6){
            jPanel16.setVisible(false);
            is6 = false ;
        } else if(!is6){
            jPanel16.setVisible(true);
            is6= true ;
    }
    }//GEN-LAST:event_kelas6ActionPerformed

    private void kelas1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kelas1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kelas1ActionPerformed

    private void myButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton4ActionPerformed
        // TODO add your handling code here:
        deleteStudy();
    }//GEN-LAST:event_myButton4ActionPerformed

    private void combobox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combobox1ActionPerformed
        // TODO add your handling code here:
       if(combobox1.getSelectedIndex()==0){
           getOrder("namaGuru");
       } else   if(combobox1.getSelectedIndex()==1){
           getOrder("namaBidangStudi");
       } else   if(combobox1.getSelectedIndex()==0){
           getOrder("ruangKelas");
       }
    }//GEN-LAST:event_combobox1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private checkbox.JCheckBoxCustom a1;
    private checkbox.JCheckBoxCustom a2;
    private checkbox.JCheckBoxCustom a3;
    private checkbox.JCheckBoxCustom a4;
    private checkbox.JCheckBoxCustom a5;
    private checkbox.JCheckBoxCustom a6;
    private checkbox.JCheckBoxCustom b1;
    private checkbox.JCheckBoxCustom b2;
    private checkbox.JCheckBoxCustom b3;
    private checkbox.JCheckBoxCustom b4;
    private checkbox.JCheckBoxCustom b5;
    private checkbox.JCheckBoxCustom b6;
    private checkbox.JCheckBoxCustom c1;
    private checkbox.JCheckBoxCustom c2;
    private checkbox.JCheckBoxCustom c3;
    private checkbox.JCheckBoxCustom c4;
    private checkbox.JCheckBoxCustom c5;
    private checkbox.JCheckBoxCustom c6;
    private combobox.Combobox combobox1;
    private combobox.Combobox combobox2;
    private checkbox.JCheckBoxCustom d1;
    private checkbox.JCheckBoxCustom d2;
    private checkbox.JCheckBoxCustom d3;
    private checkbox.JCheckBoxCustom d4;
    private checkbox.JCheckBoxCustom d5;
    private checkbox.JCheckBoxCustom d6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private checkbox.JCheckBoxCustom kelas1;
    private checkbox.JCheckBoxCustom kelas2;
    private checkbox.JCheckBoxCustom kelas3;
    private checkbox.JCheckBoxCustom kelas4;
    private checkbox.JCheckBoxCustom kelas5;
    private checkbox.JCheckBoxCustom kelas6;
    private button.MyButton myButton1;
    private button.MyButton myButton2;
    private button.MyButton myButton4;
    private button.MyButton myButton5;
    private combo_suggestion.ComboBoxSuggestion namaGuru;
    private textfield.TextField namaMapel;
    private test.PanelRound panelRound1;
    private javax.swing.JTextField pencarian;
    // End of variables declaration//GEN-END:variables
}
