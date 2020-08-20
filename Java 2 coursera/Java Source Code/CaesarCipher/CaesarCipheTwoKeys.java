
/**
 * Write a description of CaesarCipheTwoKeys here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class CaesarCipheTwoKeys {
    public String encrypt(String input, int key1, int key2) {
        StringBuilder encrypted = new StringBuilder(input);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedAlphabet1 = alphabet.substring(key1) + alphabet.substring(0, key1);
        String shiftedAlphabet2 = alphabet.substring(key2) + alphabet.substring(0, key2);
        //System.out.println(shiftedAlphabet);

        for(int i = 0; i < encrypted.length(); i=i+2) {
            char currChar = encrypted.charAt(i);
            int C = 0;
            if(Character.isLowerCase(currChar)){
                currChar = Character.toUpperCase(currChar);
                C++;
            }
            int idx = alphabet.indexOf(currChar);
            if(idx != -1){
                char newChar = shiftedAlphabet1.charAt(idx);
                if(C == 1){
                    newChar = Character.toLowerCase(newChar);
                }
                encrypted.setCharAt(i, newChar);
            }

        }
                
        for(int i = 1; i < encrypted.length(); i=i+2) {
            char currChar = encrypted.charAt(i);
            int C = 0;
            if(Character.isLowerCase(currChar)){
                currChar = Character.toUpperCase(currChar);
                C++;
            }
            int idx = alphabet.indexOf(currChar);
            if(idx != -1){
                char newChar = shiftedAlphabet2.charAt(idx);
                if(C == 1){
                    newChar = Character.toLowerCase(newChar);
                }
                encrypted.setCharAt(i, newChar);
            }

        }
        return encrypted.toString();
    }
    public void testCaesar() {
        int key1 = 14;
        int key2 = 24;
        FileResource fr = new FileResource();
        String message = fr.asString();
        String encrypted = encrypt(message, key1, key2);
        System.out.println(encrypted);
        String decrypted = encrypt(encrypted, 26-key1, 26-key2);
        System.out.println(decrypted);
    }
}
