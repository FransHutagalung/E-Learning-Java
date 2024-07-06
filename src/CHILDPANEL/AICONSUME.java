/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CHILDPANEL;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AICONSUME {
    
    
    private static   String jawaban  ;
    
    public void setAnswer(String jawaban){
        this.jawaban = jawaban ;
    }
    
    public static void main(String[] args) {
        AICONSUME ai = new AICONSUME();
       ai.setAnswer("query mysql rename fieldt");
        System.out.println("hasil " +ai.getJawaban());
    }
    
    public   String getJawaban(){
          try {
                            // Specify the URL of your Node.js server
                    //        String nodeJsUrl = "http://localhost:3001/chatBot/ " +jawaban;

                            // Send HTTP GET request to the Node.js server
                            
                            String response = sendGetRequest(jawaban);

                            Gson gson = new Gson();
                            myanswer yourObject = gson.fromJson(response, myanswer.class);

                            return convertEscapeSequence(yourObject.getNama());

                } catch (Exception e) {
                    e.printStackTrace();
                }
                            return   "Tidak bisa";
    }
    
//    public static void main(String[] args) {
//        try {
//            // Specify the URL of your Node.js server
//            String nodeJsUrl = "http://localhost:3001/chatBot/ pemandangan yang indah di swiss ? ";
//
//            // Send HTTP GET request to the Node.js server
//            String response = sendGetRequest(nodeJsUrl);
//            
//                Gson gson = new Gson();
//        myanswer yourObject = gson.fromJson(response, myanswer.class);
//        String jsonString = gson.toJson(yourObject.getNama());
//        
//        // Konversi objek ke dalam bentuk string
////     convertEscapeSequence
//      String haha = convertEscapeSequence(yourObject.getNama());
//
//       System.out.println("json " +haha);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
    private static String convertEscapeSequence(String text) {
        // Gantilah karakter \n dengan newline
        return text.replace("\\n", "\n");
        
    }
    private  static  String sendGetRequest(String url) throws Exception {

        String encodedMessage = URLEncoder.encode(url, StandardCharsets.UTF_8);
        String nodeJsUrl = "http://localhost:3001/chatBot/" + encodedMessage;
        HttpURLConnection connection = null;
        try {
            // Create a connection to the Node.js server URL
            URL nodeJsServerUrl = new URL(nodeJsUrl);
            connection = (HttpURLConnection) nodeJsServerUrl.openConnection();

            // Set the request method to GET
            connection.setRequestMethod("GET");
//               try (OutputStream os = connection.getOutputStream()) {
//                byte[] input = url.getBytes("utf-8");
//                os.write(input, 0, input.length);
//            }
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            // Get the response code
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code from Node.js server: " + responseCode);

            // Read the response from the server
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                return response.toString();
            }

        } finally {
            // Close the connection
            if (connection != null) {
                connection.disconnect();
            }
        }
    }
    
       private static List<getJawaban> deserializeJson(String json) {
    Gson gson = new Gson();
     getJawaban[] postsArray = gson.fromJson(json, getJawaban[].class);
     return Arrays.asList(postsArray);
}
       
       static class getJawaban{
        private String hasil ;
//        private String id ;
        
        @SerializedName("body")
        public String getName(){
            return hasil ;
        }
//        
//        public String getId(){
//            return id ;
//        }
    }
       static class myanswer{
           private  String hasil ;
           
           private String getNama(){
               return hasil;
           }
           public void setText(String text) {
        this.hasil = text;
    }
       }
}
