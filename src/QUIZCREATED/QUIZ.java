
package QUIZCREATED;

import Connection.Koneksi;
import HomeRun.MAINPANEL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QUIZ {
MAINPANEL mp ;
Connection con ;
PreparedStatement prs ;
    ResultSet rs ;
        
    public QUIZ(MAINPANEL mp ){
        this.con = mp.con ;
    }
    private int jumlahsoal , waktu  , kelas;
    private String judul , guru , metode , akses , sandi , keterangan , mapel ;
    String random ;
    
    
    void set(String random,int jumlahsoal , int waktu , int kelas , String judul , String guru , 
           String metode , String akses, String mapel , String keterangan){
           this.akses = akses ;
           this.jumlahsoal = jumlahsoal ;
           this.waktu = waktu ;
           this.kelas = kelas;  
           this.judul = judul ;
           this.guru = guru ;
           this.metode = metode ;
           this.keterangan = keterangan ;
           this.random = random ;
           this.mapel = mapel ;
    }
    
//    public static PreparedStatement prs ;
//    public static Connection con ;
//    public static Statement stm ;
    public static boolean isSucces = false;
    
//    public static void main(String[] args) {
//        Koneksi gb = new Koneksi();
//        gb.Config();
//        con = gb.con;
//        stm = gb.stm ;
//        QUIZ qz = new QUIZ();
////             String sql = "insert into quiz (Guru , Akses , sistem , idSoal , kelas , jumlahsoal ,"
////                    + "judul , waktu , keterangan , tanggalbuat) values (?,?,?,?,?,?,?,?,?,curdate())";
////        qz.set(30, 30, 6, "Anatomi Tumbuhan", "Samuel", "Normal", "Public", "Quiz Baru");
////        qz.createDB(sql);
//    }


    



    public void create(String password) {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public void createDB() {
        RANDOMNUMBER rd = new RANDOMNUMBER();
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        try {
            String sql = "insert into quiz (Guru , Akses , sistem , idSoal , kelas , jumlahsoal ,"
                    + "judul , waktu , keterangan , mapel , tanggalbuat) values (?,?,?,?,?,?,?,?,?,?,curdate())";
        prs = con.prepareStatement(sql);
        prs.setString(1, guru);
        prs.setString(2, akses);
        prs.setString(3, metode);
        prs.setString(4, random);
        prs.setInt(5, kelas);
        prs.setInt(6, jumlahsoal);
        prs.setString(7, judul);
        prs.setInt(8, waktu);
        prs.setString(9, keterangan);
        prs.setString(10, mapel);
        
        int n = prs.executeUpdate();
        isSucces = true ;
//            System.out.println("berhgasil");
     
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    
    }
    
//        public static void config(){
//        Koneksi connectiondo = new Koneksi();
//        connectiondo.Config();
//        con = connectiondo.con;
//        stm = connectiondo.stm;
//    }
}
