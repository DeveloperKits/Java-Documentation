
/**
 * Write a description of wordLengths here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class wordLengths {
    public void countWordLengths(String word, int c){
        //System.out.println(word + " = " + word.length());
        if(c == 0){
          int temp = 0;
          int max = 0;
        }
        int temp = word.length();
        int max = 0;
        if(temp >  max){
            
        }
    }
    public void main(){
        FileResource resource = new FileResource();
        String full = resource.asString();
        int c = 0;
        int max = 0;
        for(String word : resource.words()){
            int temp = word.length();
            if(temp > max){
                max = temp;
                full = word;
                //System.out.println(word + " = " + word.length());
            }
            countWordLengths(word,c);
            
        }
        System.out.println(full + " = " + full.length());
    }
}
