import java.util.ArrayList;
import java.util.Date;

public class Tester
{
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }

    public void testLogAnalyzer() {
        // complete method
        LogAnalyzer logAnalyzer = new LogAnalyzer();
        logAnalyzer.readFile("short-test_log.txt");
        logAnalyzer.printAll();
    }
    public void testUniqueIp(){
        LogAnalyzer logAnalyzer = new LogAnalyzer();
        logAnalyzer.readFile("short-test_log.txt");
        int uniqueIps = logAnalyzer.countUniqueIp();
        System.out.println("There are " + uniqueIps + " unique IP's");
    }
    public void testHigherThanNum(){
        LogAnalyzer logAnalyzer = new LogAnalyzer();
        logAnalyzer.readFile("short-test_log.txt");
        logAnalyzer.printAllHigherThanNum(400);
    }

    public void testuniqueIPVisitsOnDay(){
        LogAnalyzer logAnalyzer = new LogAnalyzer();
        logAnalyzer.readFile("short-test_log.txt");
        ArrayList<String> uniqueIPVisitsOnDay = logAnalyzer.uniqueIPVisitsOnDay("Mar 17");
        System.out.println("that unique day " + uniqueIPVisitsOnDay.size());

    }

    public void testcountUniqueIPsInRange(){
        LogAnalyzer logAnalyzer = new LogAnalyzer();
        logAnalyzer.readFile("short-test_log.txt");
        int result = logAnalyzer.countUniqueIPsInRange(200,299);
        System.out.println("in the range there are Ips " + result);

    }



    public static void main(String[] args) {
        Tester test = new Tester();
        test.testLogAnalyzer();
        test.testUniqueIp();
        System.out.println("Higher than 300 status code");
        test.testHigherThanNum();
        test.testuniqueIPVisitsOnDay();
        test.testcountUniqueIPsInRange();
    }
}