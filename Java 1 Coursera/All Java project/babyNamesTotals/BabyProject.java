
/**
 * Write a description of BabyProject here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.io.*;
import org.apache.commons.csv.*;
public class BabyProject {
    public void totalBirths(FileResource fr){
        int totalBirths = 0;
        int totalgirls = 0;
        int totalboys = 0;
        for(CSVRecord R : fr.getCSVParser(false)){
            int C = Integer.parseInt(R.get(2));
            //totalBirths++; 
            if(R.get(0).equals("Drew")){
                //System.out.println("Name = "+ R.get(0) + R.get(2));
                break;
            }
            
            totalboys++;
        }
            //totalgirls += C;
            //totalboys += C;
        
        System.out.println("Totalboys = "+ totalboys);
        //System.out.println("Totalgirls = "+ totalgirls + " / " + totalBirths);
        //System.out.println("Total = "+ totalboys + " / " + totalBirths);
    }
    public void ReturnNumber(FileResource fr){
        int girls = 0;
        int boys = 0;
        for(CSVRecord R : fr.getCSVParser(false)){
            girls++;
            System.out.println("Name = " + R.get(0));
            if(girls == 1){
                break;
            }
        }
        //System.out.println("Number of girls = " + girls);
        //System.out.println("Number of Boys = " + boys);
    }
    public void ReturnRank(FileResource fr){
        int girl = 0;
        int boy = 0;
        for(CSVRecord R : fr.getCSVParser(false)){
            
            /*if(R.get(1).equals("F")){
                girl++;
            }*/
            if(R.get(1).equals("M")){
                boy++;
            }
            if(R.get(0).equals("Franco")){
                System.out.println(R.get(0) + R.get(2));
                break;
            }
            
            if(girl == 350){
                //System.out.println("Name of girl = " + R.get(0));
            }
            if(boy == 450){
                //System.out.println("Name of boy = " + R.get(0));
            }
            
        }
        //System.out.println("Number of Emily = " + girl);
        System.out.println("Number of Frank = " + boy);
    }
    public void mainMethod(){
        FileResource fr = new FileResource();
        totalBirths(fr);
        //ReturnNumber(fr);
        //ReturnRank(fr);
    }
}
