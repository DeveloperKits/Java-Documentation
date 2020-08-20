
/**
 * Write a description of countTester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class countTester {
    public void testCounts(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("short-test_log");
        HashMap<String,Integer> counts = la.countVisitsperIP();
        System.out.println(counts);
    }
}
