/**
 * Print out the names for which 100 or fewer babies were born in a chosen CSV file of baby name data.
 * 
 * @author Duke Software Team 
 */
import edu.duke.*;
import org.apache.commons.csv.*;

public class BabyBirths {
    public void printNames () {
	System.out.println("Name   |  "   + " Gender   |  "  + " Num Born ");
	FileResource fr = new FileResource();
	for (CSVRecord rec : fr.getCSVParser(false)) {
	    int numBorn = Integer.parseInt(rec.get(2));
	    if (numBorn <= 100) {
		System.out.println(rec.get(0) +"   |   " + rec.get(1) +"   |   " + rec.get(2));		  
            }
	}  
    }
}
