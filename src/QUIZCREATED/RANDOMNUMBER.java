/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QUIZCREATED;

import java.util.Random;

/**
 *
 * @author ACER
 */
public class RANDOMNUMBER {
    public String getRandom(){
        // Define the characters that can be used in the random string
        String characters = "abcdefghijklmnopqrstuvwxyz";

        // Set the length of the random string
        int length = 4;

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
}
