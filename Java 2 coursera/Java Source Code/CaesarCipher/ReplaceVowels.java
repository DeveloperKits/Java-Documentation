
/**
 * Write a description of ReplaceVowels here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.io.*;
import java.lang.*;
public class ReplaceVowels {
    public int isVowel(char ch){
        ch = Character.toLowerCase(ch);
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
            return 1;
        }
        return -1;
    }
    public String replaceVowels(String message){
        StringBuilder replace = new StringBuilder(message);
        char newChar;
        for(int i=0; i<message.length(); i++){
            char ch = replace.charAt(i);
            int vowel = isVowel(ch);
            if(vowel == 1){
                if(i%2 == 0){
                    newChar = '*';
                }else{
                    newChar = '+';
                }
                replace.setCharAt(i, newChar);
            }
        }
        return replace.toString(); 
    }
    /*public String emphasize(String message, char ch){
        return message;
    }*/
    public void main(){
        FileResource fr = new FileResource();
        String message = fr.asString();
        message = replaceVowels(message);
        System.out.println(message);
    }
    /*public void test(){
        String message = emphasize(“dna ctgaaactga”, ‘a’);
    }*/
}
