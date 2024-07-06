/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CHILDPANEL;

import java.awt.Rectangle;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import scrollbar.ScrollBarCustom;

//import org.apache.http.HttpResponse;
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.impl.client.HttpClients;
//import org.apache.http.util.EntityUtils;

/**
 *
 * @author ACER
 */
public class AICOMPONENT extends javax.swing.JPanel {

    /**
     * Creates new form AICOMPONENT
     */
    private  String pertanyaan ;
    public AICOMPONENT() {
        initComponents();
        ScrollBarCustom sc = new ScrollBarCustom();
      jScrollPane1.setVerticalScrollBar(sc);
    }
    
   static int nY   = 10;
    int nV = 500 ;
    private void addMessage(){

                
        PANELPESAN pp = new PANELPESAN(textField1.getText());
       // System.out.println("menambah pesan");
//        pp.setBounds(20, nY, 364 48);
       pp.setBounds(10, nY, 348, 48);
        jPanel2.add(pp);
        nY+= 58 ;
    }
    

    private static void addRespon(String s){

        PANELAI pa = new PANELAI(s);
        //333 374
        pa.setBounds(5,nY,324 ,345);
        jPanel2.add(pa);
        nY+=366 ;
    }
    
     private static String sendRequest(String url, String question) throws Exception {
        HttpURLConnection connection = null;
        try {
            // Buat koneksi ke URL Node.js server
            URL nodeJsServerUrl = new URL(url);
            connection = (HttpURLConnection) nodeJsServerUrl.openConnection();

            // Setel metode request ke POST
            connection.setRequestMethod("GET");
            connection.setDoOutput(true);

            // Kumpulkan data untuk dikirim
          //  String data = String.format("{\"question\":\"%s\"}", question);

            // Kirim data ke server
            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = url.getBytes("utf-8");
                os.write(input, 0, input.length);
            }    
                           
   
            // Dapatkan kode respons
            int responseCode = connection.getResponseCode();
            System.out.println("Kode respons dari Node.js server: " + responseCode);

            // Baca respons dari server
            try (InputStreamReader reader = new InputStreamReader(connection.getInputStream())) {
                StringBuilder response = new StringBuilder();
                int c;
                while ((c = reader.read()) != -1) {
                    response.append((char) c);
                }
                return response.toString();
            }

        } finally {
            // Tutup koneksi
            if (connection != null) {
                connection.disconnect();
            }
        }
     }
     private static String fetchDataFromApi(String apiUrl) throws IOException {
         
     //    String apiUrl = "http://localhost:8080/api/example";
            
            // Membuat objek URL
            URL url = new URL(apiUrl);
            
            // Membuat koneksi HttpURLConnection
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            
            // Mengatur metode request (GET, POST, dll.)
            connection.setRequestMethod("GET");
            
            
//            //
//             TrustManager[] trustAllCerts = new TrustManager[] {
//                new X509TrustManager() {
//                    public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {}
//                    public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {}
//                    public X509Certificate[] getAcceptedIssuers() { return null; }
//                }
//            };
//
//            // Mengonfigurasi SSLContext untuk menggunakan TrustManager kustom
//            SSLContext sslContext = null;
//        try {
//            sslContext = SSLContext.getInstance("TLS");
//                try {
//                    sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
//                } catch (KeyManagementException ex) {
//                    Logger.getLogger(AICOMPONENT.class.getName()).log(Level.SEVERE, null, ex);
//                }
//        } catch (NoSuchAlgorithmException ex) {
//            Logger.getLogger(AICOMPONENT.class.getName()).log(Level.SEVERE, null, ex);
//        }

            // Mengatur default SSLContext untuk HttpClient
     //       HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.getSocketFactory());

            
            // Mendapatkan response code
            int responseCode = connection.getResponseCode();
            System.out.println("respon " +responseCode);
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Membaca response dari API
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();
                
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                
                in.close();
                
                // Menampilkan response dari API
                System.out.println(response.toString());
                return response.toString();
            } else {
                System.out.println("Gagal mengakses API. Response Code: " + responseCode);
            }
         
         return "nothing";
//        URL url = new URL(apiUrl);
//        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//
//        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
//            StringBuilder response = new StringBuilder();
//            String line;
//
//            while ((line = reader.readLine()) != null) {
//                response.append(line);
//            }
//
//            return response.toString();
//        } finally {
//            connection.disconnect();
//        }
    }

     private void setText(){
         try {
          //   String s =fetchDataFromApi("http://localhost:3001/chatBot/" +textField1.getText());
             String s= fetchDataFromApi("http://localhost:3001/chatBot/hiii" +textField1.getText());
          System.out.println("hasil " +s);
         } catch (IOException e) {
             System.out.println("err occured " +e.getMessage());
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
        jScrollPane1 = new javax.swing.JScrollPane();
        panelChat = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        panelRound1 = new test.PanelRound();
        textField1 = new textfield.TextField();
        jLabel1 = new javax.swing.JLabel();

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        panelChat.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 396, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2756, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelChatLayout = new javax.swing.GroupLayout(panelChat);
        panelChat.setLayout(panelChatLayout);
        panelChatLayout.setHorizontalGroup(
            panelChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelChatLayout.setVerticalGroup(
            panelChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelChatLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(panelChat);

        panelRound1.setBackground(new java.awt.Color(204, 204, 204));
        panelRound1.setRoundBottomLeft(30);
        panelRound1.setRoundBottomRight(30);
        panelRound1.setRoundTopLeft(30);
        panelRound1.setRoundTopRight(30);

        textField1.setBackground(new java.awt.Color(204, 204, 204));
        textField1.setLabelText("");

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\OneDrive\\Pictures\\pesawat-removebg-preview.png")); // NOI18N
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(textField1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(textField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents
 int xY = 2 ;
    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
 //       pertanyaan = textField1.getText();
        addMessage();
//        fetchDataInBackground();          AICONSUME ac = new AICONSUME();
// AICONSUME ac = new AICONSUME();
//          ac.setAnswer("halo bot");
//          String sw = ac.getJawaban();
//        addRespon(sw);   
        
//        AICONSUME ai = new AICONSUME();
//       ai.setAnswer(textField1.getText());
////        System.out.println("hasil " +ai.getJawaban());
//        
//        
//        
//        addRespon(ai.getJawaban());
     Thread thread2 = new Thread(new MyRunnable(textField1.getText()));
        thread2.start();
        jPanel2.revalidate();
        textField1.setText("");
//         Rectangle bounds = jPanel2.getComponent(xY).getBounds();
//        jPanel2.scrollRectToVisible(bounds);
        xY+= 2 ;
        doTurn();
        
        
        
    }//GEN-LAST:event_jLabel1MouseClicked
 void doTurn(){
          AICONSUME ac = new AICONSUME();
          ac.setAnswer("halo bot");
          //String sw = ac.getJawaban(textField1.getText());
      //  addRespon(sw);
     //   addRespon(ac.getJawaban());
        textField1.setText("");
 }
 
  private static class MyRunnable implements Runnable {
        private String name;

        public MyRunnable(String name) {
          this.name = name ;
        }

        @Override
        public void run() {
                     AICONSUME ai = new AICONSUME();
                     ai.setAnswer(name);
                      addRespon(ai.getJawaban());
                      jPanel2.revalidate();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private static javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelChat;
    private test.PanelRound panelRound1;
    private textfield.TextField textField1;
    // End of variables declaration//GEN-END:variables
}
