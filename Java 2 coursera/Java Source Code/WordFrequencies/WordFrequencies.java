import edu.duke.*;
import java.util.ArrayList;

public class WordFrequencies
{
    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;
    
    public WordFrequencies() {
        myWords = new ArrayList<String>();
        myFreqs = new ArrayList<Integer>();
    }
    
    public void findUnique(){
        FileResource resource = new FileResource();
        
        for(String s : resource.words()){
            s = s.toLowerCase();
            //System.out.println("S = "+s);
            int index = myWords.indexOf(s);
            //System.out.println("Index = "+index);
            if (index == -1){
                myWords.add(s);
                myFreqs.add(1);
                //System.out.println("myWords.add(s) = "+myWords.add(s));
                //System.out.println("myFreqs.add(1) = "+myFreqs.add(1));
            }
            
            else {
                int freq = myFreqs.get(index);
                //System.out.println("Freqs = "+freq);
                myFreqs.set(index,freq+1);
                //System.out.println("++ = "+myFreqs.set(index,freq+1));
            }
        }
    }
    public void All(){
        FileResource resource = new FileResource();
        int c = 0;
        for(String s : resource.words()){
             c++; 
        }
        System.out.println(c);
    }    
    
    public void tester(){
        findUnique();
        System.out.println("# unique words: "+myWords.size());
        System.out.println(myWords);
        int index = findMax();
        System.out.println("max word/freq: "+myWords.get(index)+" "+myFreqs.get(index));
    }
    public int findMax(){
        int max = myFreqs.get(0);
        int maxIndex = 0;
        for(int k=0; k < myFreqs.size(); k++){
            if (myFreqs.get(k) > max){
                max = myFreqs.get(k);
                maxIndex = k;
            }
        }
        return maxIndex;
    }
    public void main(){
        ArrayList<String> words = new ArrayList<String>();
        words.add("hello");
        words.add("world");
        String s = words.get(1);
        System.out.println(s);
        words.set(0,"goodbye");
        System.out.println(words);
    }
}
