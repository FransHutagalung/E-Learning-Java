/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HomeRun;

import COMPONENT.ABOUTAPP;
import COMPONENT.CREATESTUDYEACH;
import COMPONENT.EACHMATERYPANEL;
import COMPONENT.EACHSTUDYPANEL;
import COMPONENT.GETALLSTUDENT;
import COMPONENT.PANELPERTAMA;
import COMPONENT.REPOSITORYQUIZ;
import COMPONENT.ROSTERPANEL;
import COMPONENT.STAFF;
import COMPONENT.STUDYPANEL;
import Connection.Koneksi;
import Event.EventMenu;
import INITCOMPONENT.SIDEBARPANEL;
import QUIZCREATED.CREATEQUESTION;
import java.awt.Component;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;

import javax.swing.JFrame;


public class MAINPANEL extends javax.swing.JFrame {

    public Connection con ;
    MAINPANEL mp ;
    private String whoami ;
    public String WhoAmI ;
    static String guru ;
    String guru1 ;
          private ImageIcon imgicon = null ;
    ResultSet rs ;
    PreparedStatement prs ;
    public void setWhoMeString(String s){
        WhoAmI  = s;
    }
    
    public String getWhoAmI(){
        return WhoAmI ;
    }
    
   //  private final JFXPanel fxPanel = new JFXPanel();
    
    public MAINPANEL(String who , String status , String kode ) {
        mp = this ;
        setUndecorated(true);
        guru1 = who ;
        setWhoMeString(who);
        Koneksi k = new Koneksi();
        k.Config();
        con = k.con;
        
        
        initComponents();
        initParent(new PANELPERTAMA());
        //
        setLocationRelativeTo(null);
        initAvatar(kode);
        namaPengguna.setText(who);
//        setLocationRelativeTo(null);
      //  initParent( );
    //    body.setSize(1016, 645);
      //  init("C:\\Users\\ACER\\Downloads\\akame.mp4");
        //initVideo("C:\\Users\\ACER\\Downloads\\akame.mp4");
        setMenu(status);
    }
    
//         private void initVideo(String fileVideo){
//             jPanel7.removeAll();
//             init(fileVideo);
//             jPanel7.add(fxPanel);
//             jPanel7.repaint();
//             jPanel7.revalidate();
//         }
     
        private void init(String videoFilePath) {
//        setTitle("Video Player");
//        setSize(1110, 700);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        // Create JavaFX scene and set it in the JFXPanel
//        Platform.runLater(() -> {
//            initFX(fxPanel, videoFilePath);
//        });
//        initParent(fxPanel);
//        setLocationRelativeTo(null);
//    }
    
//    class MediaControl extends javafx.scene.media.MediaView {
//
//    private final MediaPlayer mediaPlayer;
//
//    public MediaControl(MediaPlayer mediaPlayer) {
//        super(mediaPlayer);
//        this.mediaPlayer = mediaPlayer;
//        setFitHeight(600);
//        setFitWidth(1200);
//    }
//}    private void initFX(JFXPanel fxPanel, String videoFilePath) {
//        StackPane root = new StackPane();
//
//        Media media = new Media("file:///" + videoFilePath.replace("\\", "/"));
//        MediaPlayer mediaPlayer = new MediaPlayer(media);
//        mediaPlayer.setAutoPlay(true);
//
//        MediaControl mediaControl = new MediaControl(mediaPlayer);
//        root.getChildren().add(mediaControl);
//            
//        Scene scene = new Scene(root);
//      //  scene.setFill(Color.black);
//        fxPanel.setScene(scene);
//        //body.setSize(1084, 600);
//    }
        }
    
    private void initAvatar(String kodePegawai){
        
        try {
           prs    = con.prepareStatement("select foto from pegawai where kodePegawai = ?");
           prs.setString(1, kodePegawai);
           rs = prs.executeQuery();
           while(rs.next()){
               
                  byte []  imageData = rs.getBytes(1);
                  if(imageData!=null){
                   System.out.println("Foto " +rs.getBytes(1));
               //   Image image = Toolkit.getDefaultToolkit().createImage(imageData);
                 imgicon = new ImageIcon(imageData);
                Image mm = imgicon.getImage();
                Image mm2 = mm.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
//                
//               imageAvatar1.setIcon(new ImageIcon(mm2));
                 imageAvatar1.setImage(new ImageIcon(mm2));
                  }
           }
           
        } catch (SQLException e) {
            
            System.out.println("err occured " +e.getMessage());
            
        }
        
    }
    public void setMenu(String s ){
        if(s.equals("Guru") || s.equals("guru")){
        
        SIDEBARPANEL sb = new SIDEBARPANEL();
         EventMenu evt1 = new EventMenu() {
            @Override
            public void selected(int index) {
                if (index == 0) {
                   initParent(new STUDYPANEL(mp ,mp.getWhoAmI()));
                } else if (index == 1) {
                 initParent(new REPOSITORYQUIZ(mp));
            
                }  else if(index==2){
//                    initParent(new STAFF(mp));
                mp.dispose();
                LOGINRUN lg = new LOGINRUN();
                lg.setVisible(true);
            }
              
//                 else if(index == 6){
//                initParent(new CREATESTUDYEACH(mp));
//                 
//            }  else if(index == 7){
//                initParent(new CREATEQUESTION(mp , guru));
//                 
//            } 
            }
        };
         sb.initMenu2(evt1);
         jPanel3.removeAll();
         jPanel3.add(sb);
         jPanel3.repaint();
         jPanel3.revalidate();
        } else if(s.equals("Admin") || s.equals("admin")){
             SIDEBARPANEL sb = new SIDEBARPANEL();
         EventMenu evt1 = new EventMenu() {
            @Override
            public void selected(int index) {
                if (index == 0) {
                     initParent(new ROSTERPANEL(mp));
                } else if (index == 1) {
                     initParent(new GETALLSTUDENT(mp));
                }  else if(index==2){
                     initParent(new STAFF(mp));
                }  else if(index == 3){;
                    initParent(new CREATESTUDYEACH(mp));
                }  else if(index == 4){;
                   initParent(new ABOUTAPP());
                }  else if(index == 5){;
//                initParent(new GETALLSTUDENT(mp));
               //   mp.dispose();
                  mp.dispose();
                  LOGINRUN lg = new LOGINRUN();
                  lg.setVisible(true);
                 
            }  
            }
        };
         sb.initMenu(evt1);
         jPanel3.removeAll();
         jPanel3.add(sb);
         jPanel3.repaint();
         jPanel3.revalidate();
        }
    }
    public void initParent(Component cmp)
    { 
      //  body.setSize(1270 , 600);
        body.removeAll();
        body.add(cmp);
        body.repaint();
        body.revalidate();
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
        jPanel5 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        body = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        panelKiri = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        namaPengguna = new javax.swing.JLabel();
        myButton1 = new button.MyButton();
        jLabel1 = new javax.swing.JLabel();
        imageAvatar1 = new HomeRun.ImageAvatar();
        jPanel4 = new javax.swing.JPanel();

        jPanel5.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 24, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 633, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        body.setBackground(new java.awt.Color(153, 153, 153));
        body.setLayout(new java.awt.CardLayout());

        jPanel7.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        body.add(jPanel6, "card2");

        jPanel3.setBackground(new java.awt.Color(0, 153, 153));
        jPanel3.setLayout(new java.awt.CardLayout());

        namaPengguna.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        namaPengguna.setText("Nama Pengguna");

        myButton1.setText("PROFIL ");
        myButton1.setBorderColor(new java.awt.Color(0, 153, 153));
        myButton1.setColorClick(new java.awt.Color(0, 153, 153));

        javax.swing.GroupLayout panelKiriLayout = new javax.swing.GroupLayout(panelKiri);
        panelKiri.setLayout(panelKiriLayout);
        panelKiriLayout.setHorizontalGroup(
            panelKiriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelKiriLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(myButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelKiriLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelKiriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelKiriLayout.createSequentialGroup()
                        .addComponent(namaPengguna, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(panelKiriLayout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        panelKiriLayout.setVerticalGroup(
            panelKiriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelKiriLayout.createSequentialGroup()
                .addGroup(panelKiriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelKiriLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelKiriLayout.createSequentialGroup()
                        .addGap(0, 19, Short.MAX_VALUE)
                        .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(namaPengguna)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(myButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel4.setBackground(new java.awt.Color(0, 153, 153));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 21, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(panelKiri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(body, javax.swing.GroupLayout.PREFERRED_SIZE, 1016, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(panelKiri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(body, javax.swing.GroupLayout.PREFERRED_SIZE, 645, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)))
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(MAINPANEL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MAINPANEL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MAINPANEL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MAINPANEL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MAINPANEL(guru , "" ,"").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel body;
    private javax.swing.ButtonGroup buttonGroup1;
    private HomeRun.ImageAvatar imageAvatar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private button.MyButton myButton1;
    private javax.swing.JLabel namaPengguna;
    private javax.swing.JPanel panelKiri;
    // End of variables declaration//GEN-END:variables
}
