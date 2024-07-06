
package QUIZCREATED;

//import CONNECTION.GLOBALCONNECTION;
//import static QUIZCREATED.QUIZ.con;
//import static QUIZCREATED.QUIZ.stm;
import HomeRun.MAINPANEL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class QUIZFILL  implements  QUIZFILLDB{

    
    
    String [] ArraySoal = new String[60];
    String [] ArrayJawaban = new String[60] ;
    String [] Opsia = new String[60] ;
    String [] OpsiB = new String[60] ;
    String [] Opsic = new String[60] ;
    String [] OpsiD = new String[60] ;
    
    
    boolean [] wasFill = new boolean[60];
    private int SoalLength = 0 ;
    private String idSoal ;
    
    
    String [] pathImage = new String[60];
    boolean [] isImage = new boolean[60];
    
    
    //
    public static PreparedStatement prs ;
    public static Connection con ;
    public static Statement stm ;
    public static boolean isSucces = false;
  
    
    void setIsFill(int n ){
        wasFill[n] = true ;
    }
    boolean getFill(int n){
        return wasFill[n];
    }
    
    void setArray(int i , String soal , String a , String b , String c , String d , 
            String jawaban){
        
        ArraySoal[i] = soal ;
        Opsia[i] = a ;
        OpsiB[i] = b ;
        Opsic[i] = c;
        OpsiD[i] = d ;
        ArrayJawaban[i] = jawaban;
    }
    
    
    
    
    
    
    String getIdSoal(){
        return idSoal ;
    }
    
    void setLengthSoal(int n ){
        SoalLength = n ;
    }
    
     int getLengthSoal(){
         return  SoalLength;
    }
    
    void setIDsoal(String idsoal){
        this.idSoal = idsoal ;
    }
    
 
    
    
     public static void config(MAINPANEL mp){
//        GLOBALCONNECTION connectiondo = new GLOBALCONNECTION();
//        connectiondo.Config();
        con = mp.con;
//        stm = mp.stm;
    }
     
     public static void main(String[] args) {
//        config();
        QUIZFILL qf = new QUIZFILL();
        qf.setLengthSoal(10);
         System.out.println(qf.ArraySoal.length);
    }
    
  
     
//     void setIndex(int i , String a , String b , String c , String d , String soal
//                   ,String jawaban){
//         
//         
//     }
    
    
    String getArraySoal(int i){
        return ArraySoal[i];
    }
    
    String getOpsiA(int i){
        return Opsia[i];
    }
    
    String getOpsiB(int i){
        return OpsiB[i];
    }  
    
    String getOpsiC(int i){
        return Opsic[i];
    }
    String getOpsiD(int i){
        return OpsiD[i];
    }
    
    String getAnswer(int i){
        return ArrayJawaban[i];
    }
   
    @Override
    public void addDB(int batas) {
        int  w = 0 ;
        try {
            String sql = "INSERT INTO soal ( no ,soal , opsia , opsib , opsic , opsid , jawaban"
                    + " , idSoal ) values (?,?,?,?,?,?,? , ?)";
            
            prs = con.prepareStatement(sql);
            for (int i = 0; i < batas; i++) {
                prs.setInt(1, (i+1));
                prs.setString(2, ArraySoal[i]);
                prs.setString(3, Opsia[i]);
                prs.setString(4, OpsiB[i]);
                prs.setString(5, Opsic[i]);
                prs.setString(6, OpsiD[i]);
                prs.setString(7, ArrayJawaban[i]);
                prs.setString(8, getIdSoal());
                
              w =  prs.executeUpdate();
            //    JOptionPane.showMessageDialog(null, "Berhasil ke " +i);
                
            }
            
            if (w > 0 ){
                isSave = true ;
            }
            
            
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal " +e.getMessage());
        }
    }
    boolean isSave;
    public boolean getisSave(){
        return isSave ;
    }

    @Override
    public void setLength() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getInfoQuestion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setPicture() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getPicture() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
