
/**
 * Write a description of GladLibs here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.util.*;
public class GladLibs {
    private ArrayList<String> adjectiveList;
    private ArrayList<String> nounList;
    private ArrayList<String> colorList;
    private ArrayList<String> countryList;
    private ArrayList<String> nameList;
    private ArrayList<String> animalList;
    private ArrayList<String> timeList;
    private ArrayList<String> verbList;
    private Random myRandom;
    
    private String dataSourceURL = " ";
    private String dataSourceDirectory = "data";
    
    public GladLibs(){
        initiallizeFromSource(dataSourceDirectory);
        myRandom = new Random();
    }
    
    public GladLibs(String source){
        initiallizeFromSource(source);
        myRandom = new Random();
    }
    
    private void initiallizeFromSource(String source){
        adjectiveList = readIt(source + "/adjective.txt");
        nounList = readIt(source + "/noun.txt");
        colorList = readIt(source + "/color.txt");
        countryList = readIt(source + "/country.txt");
        nameList = readIt(source + "/name.txt");
        animalList = readIt(source + "/animal.txt");
        timeList = readIt(source + "/time.txt");
        verbList = readIt(source + "/verb.txt");
    }
    
    private String randomFrom(ArrayList<String> source){
        int index = myRandom.nextInt(source.size());
        return source.get(index);
    }
    
    private String getSubstitute(String label){
        if(label.equals("country")){
            return randomFrom(countryList);
        }
        if(label.equals("color")){
            return randomFrom(colorList);
        }
        if(label.equals("noun")){
            return randomFrom(nounList);
        }
        if(label.equals("name")){
            return randomFrom(nameList);
        }
        if(label.equals("adjective")){
            return randomFrom(adjectiveList);
        }
        if(label.equals("animal")){
            return randomFrom(animalList);
        }
        if(label.equals("time")){
            return randomFrom(timeList);
        }
        if(label.equals("verb")){
            return randomFrom(verbList);
        }
        if(label.equals("number")){
            return ""+myRandom.nextInt(50)+5;
        }
        return "*Unknown*";
    }
    
    private String processWord(String w){
        int first = w.indexOf("<");
        int last = w.indexOf(">");
        if(first == -1 || last == -1){
            return w;
        }
        String prefix = w.substring(0,first);
        String suffix = w.substring(last+1);
        String sub = getSubstitute(w.substring(first+1,last));
        return prefix+sub+suffix;
    }
    private void printOut(String s,int lineWidth){
        int charsWritten = 0;
        for(String w : s.split("\\s+")){
            if(charWritten +w.length() > lineWidth)....{
                System.out.println();
                charsWritten = 0;
            }
        }
    }
}
