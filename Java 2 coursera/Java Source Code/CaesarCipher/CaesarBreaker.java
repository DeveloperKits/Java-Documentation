/**
 * Write a description of CaesarBreaker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.lang.*;
import java.io.*;
public class CaesarBreaker {
    public String encrypt(String input, int key) {
        StringBuilder encrypted = new StringBuilder(input);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0,key);      

        for(int i = 0; i < encrypted.length(); i++) {
            char currChar = encrypted.charAt(i);
            int C = 0;
            if(Character.isLowerCase(currChar)){
                currChar = Character.toUpperCase(currChar);
                C++;
            }
            int idx = alphabet.indexOf(currChar);
            if(idx != -1){
                char newChar = shiftedAlphabet.charAt(idx);
                if(C == 1){
                    newChar = Character.toLowerCase(newChar);
                }
                encrypted.setCharAt(i, newChar);
            }

        }
        return encrypted.toString();
    }   
    public int counLetters(String message){
        for(int i=0; i<message.length(); i++){
            
            if (Character.isLetter(message.charAt(message.length()-1)) == false) {
                 wordlength--;
             }
        }
    }    
    /*public int counLetters
    public int getKey(String message){
        CaesarCipher cc = new CaesarCipher();
        int[] freps = counLetters(message);
        int maxDex = maxIndex(freqs);
        int key = maxDex - 4;
        if(maxDex < 4){
            key = 26 - (4 - maxDex);
        }
        return key;
    }*/
    public void testDecrypt() {
        FileResource fr = new FileResource();
        String message = fr.asString();
        int c = 0;
        int max = 0;
        String full = " ";
        for(String word : fr.words()){
            int temp = word.length();
            if(temp > max){
                max = temp;
                full = word;
            }
        }
        int maxDex = getKey(message, full);
        int key = maxDex - 4;
        if(maxDex < 4){
            key = 26 - (4 - maxDex);
        }
        
        String encrypted = encrypt(message, key);
        String decrypted = encrypt(encrypted, 26-key);
        System.out.println(decrypted);
    }
}
