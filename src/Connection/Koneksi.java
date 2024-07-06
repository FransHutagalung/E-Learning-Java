/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ACER
 */
public class Koneksi {
     public static Statement stm ; 
    public static java.sql.Connection con ;
     public static void Config (){
        String dbURL = "jdbc:mysql://localhost:3306/sekolahdasar";
        String username = "root";
        String password = "adhi123";
//         KoneksiAdmin kon = new KoneksiAdmin();
        try {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection(dbURL, username, password);
        stm = con.createStatement();
            System.out.println("Koneksi Berhasil ");
            
//String s = "select * from tb_mahasiswa";
//ResultSet oke =stm.executeQuery(s);
//ResultSetMetaData dataku =
//oke.getMetaData();

        
        } catch (Exception ex){
            System.out.println("Koneksi gagal " +ex.getMessage());
            
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
    }
     private static java.sql.Connection mysqlconfig;

        public static java.sql.Connection configDB()throws SQLException{
      try{
          String url="jdbc:mysql://localhost:3306/restaurant";
          String user = "root";
          String pass = "adhihutagalung";
       //   DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
          mysqlconfig = DriverManager.getConnection(url,user,pass);
          System.out.println("Koneski Berhasil");
      }  catch(Exception e){
          System.err.println("Koneksi Gagal  :"+e.getMessage());
          
      }
    return mysqlconfig;
        }


    public static void main(String[] args) throws SQLException {
//      
Config();
    }
}
