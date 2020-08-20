/**
 * Find the highest (hottest) temperature in a file of CSV weather data.
 * 
 * @author Duke Software Team 
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class CSVMax {
   public CSVRecord hottestHourInFile(CSVParser parser) {
        CSVRecord large = null;
        for(CSVRecord curr_Row : parser){
            large = getLargestOftwo(curr_Row, large);
        }
        return large;
   }

   public void testHottestInDay () {
        FileResource fr = new FileResource("data/2014/weather-2014-01-03.csv");
        CSVRecord largest = hottestHourInFile(fr.getCSVParser());
        System.out.println("hottest temperature was " + largest.get("TemperatureF") +
                   " at " + largest.get("Events"));
   }
    
   public CSVRecord getLargestOftwo(CSVRecord curr_Row , CSVRecord large){
        if (large == null) {
            large = curr_Row;
            //System.out.println("large : " + large);
	}		
	else {
	    double curr_Temp = Double.parseDouble(curr_Row.get("TemperatureF"));
	    double large_Temp = Double.parseDouble(large.get("TemperatureF"));
	    //System.out.println("Current Temperature = " + curr_Temp);
	    //System.out.println("Large Temperature = " + large_Temp);
	    if(curr_Temp < large_Temp){
                    large = curr_Row;
            }
	}
	return large;
   }
   
   public CSVRecord hottestInManyDays(){
        CSVRecord large = null;
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            CSVRecord curr_Row = hottestHourInFile(fr.getCSVParser());
            large = getLargestOftwo(curr_Row, large);
        }
        return large;
   }
   
   public void testHoterTempInManyDays(){
       CSVRecord largest = hottestInManyDays();
       System.out.println("Coll Temperature was :" + largest.get("TemperatureF") + "at "+ largest.get("DateUTC"));
   }
}

