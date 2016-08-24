import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Hamit on 8/2/2016.
 */
public class CountTester {

    public void testCounts(){
        LogAnalyzer logAnalyzer = new LogAnalyzer();
        logAnalyzer.readFile("short-test_log.txt");

        HashMap<String,Integer> hashMap = logAnalyzer.countVisitsPerIP();
        for(String element : hashMap.keySet()){
            System.out.println(element +" = " + hashMap.get(element));
        }
        int result =logAnalyzer.mostNumberVisitsByIP(hashMap);
        System.out.println("Most visied number by IP is " + result);

        ArrayList<String> mostVisiedIPs = logAnalyzer.iPsMostVisits(hashMap);
        System.out.println("most visited IPs are " + mostVisiedIPs);

        HashMap<String, ArrayList<String>> map = logAnalyzer.iPsForDays();
        for (String element : map.keySet()){
            ArrayList<String> Ips = map.get(element);
            System.out.println(element +" maps to " + Ips.size() );
        }
        String thatDay = logAnalyzer.dayWithMostIPVisits(map);
        System.out.println("the day with most ip visits is " + thatDay);
        ArrayList<String> Ips = logAnalyzer.iPsWithMostVisitsOnDay(map, "Mar 17");
        System.out.println("On that day ips were" + Ips) ;
    }

    public static void main(String[] args) {
        CountTester test = new CountTester();
        test.testCounts();
    }
}
