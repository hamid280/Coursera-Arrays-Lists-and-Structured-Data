import edu.duke.FileResource;

import java.util.ArrayList;
import java.util.HashMap;

public class LogAnalyzer
{
    private ArrayList<LogEntry> records;

    public LogAnalyzer() {
        // complete constructor
        records = new ArrayList<>();
    }

    public void readFile(String filename) {
        // complete method
        FileResource resource = new FileResource(filename);
        for (String line : resource.lines()){
            LogEntry logEntry = WebLogParser.parseEntry(line);
            records.add(logEntry);
        }
    }

    public int countUniqueIp(){
        ArrayList<String> uniqueIps = new ArrayList<>();
        for (LogEntry le : records){
            String ipAddr = le.getIpAddress();
            if (!uniqueIps.contains(ipAddr)){
                uniqueIps.add(ipAddr);
            }
        }
        return uniqueIps.size();
    }

    public void printAllHigherThanNum(int num){

        for(LogEntry le : records){
            if(le.getStatusCode() > num){
                System.out.println(le);
            }
        }
    }

    public ArrayList<String> uniqueIPVisitsOnDay(String someDay) {

        ArrayList<String> wanted = new ArrayList<>();
        for (LogEntry logEntry : records){
            String ip = logEntry.getIpAddress();
            String date = logEntry.getAccessTime().toString();
            if(!wanted.contains(ip)){
                if (date.contains(someDay))
                    wanted.add(ip);
            }
        }
        return wanted;
    }

    public int countUniqueIPsInRange(int low, int high){
        ArrayList<String> uniqueIps = new ArrayList<>();
        for (LogEntry logEntry : records){
            String uniqueIp = logEntry.getIpAddress();
            if(!uniqueIps.contains(uniqueIp)){
                if(logEntry.getStatusCode() >= low && logEntry.getStatusCode() <= high)
                    uniqueIps.add(uniqueIp);
            }
        }
        return uniqueIps.size();
    }

    public HashMap<String,Integer> countVisitsPerIP(){
        HashMap<String,Integer> counts = new HashMap<>();
        for (LogEntry logEntry : records){
            String ip = logEntry.getIpAddress();
            if(counts.containsKey(ip)){
                counts.put(ip, counts.get(ip) + 1);
            }
            else {
                counts.put(ip, 1);
            }
        }
        return counts;
    }

    public int mostNumberVisitsByIP (HashMap<String, Integer> hashMap ){
        hashMap = countVisitsPerIP();
        int max = 0;
        for (int value : hashMap.values()){
            if ( value > max)
                max = value;
        }
        return max;
    }

    public ArrayList<String> iPsMostVisits(HashMap<String,Integer> hashMap){
        ArrayList<String > mostVisitedIps = new ArrayList<>();
        hashMap =countVisitsPerIP();
        int max = mostNumberVisitsByIP(hashMap);
        for (String element : hashMap.keySet()){
            if (max == hashMap.get(element)){
                mostVisitedIps.add(element);
            }
        }
        return mostVisitedIps;
    }

    public HashMap<String, ArrayList<String >> iPsForDays(){
        HashMap<String, ArrayList<String>> hashMap = new HashMap<>();

        for (LogEntry logEntry : records){
            ArrayList<String> IPs = new ArrayList<>();
            String ipAddress = logEntry.getIpAddress();
            String date = logEntry.getAccessTime().toString().substring(4, 10);

            if (!hashMap.containsKey(date)){
                IPs.add(ipAddress);
                hashMap.put(date,IPs);
            }
            else {
                ArrayList<String> currentIp = hashMap.get(date);
                currentIp.add(ipAddress);
                hashMap.put(date,currentIp);
            }
        }
        return hashMap;
    }

    public String dayWithMostIPVisits(HashMap<String,ArrayList<String>> hashMap){
        hashMap = iPsForDays();
        int max = 0;
        String thatDay = " ";

        for (String element : hashMap.keySet()){
            ArrayList<String> Ips = hashMap.get(element);
            if (Ips.size() > max) {
                max = Ips.size();
                thatDay = element;
            }

        }
        return thatDay;
    }

    // return the IP list with most visits on particular day.
    public ArrayList<String> iPsWithMostVisitsOnDay(HashMap<String, ArrayList<String>> eachday, String day) {
        ArrayList<String> ip = new ArrayList<String>();
        HashMap<String, Integer> eachip = new HashMap<String, Integer>();
        ArrayList<String> mostthatday = new ArrayList<String>();
        int mostnumber = 0;
        int currentnumber;
        for (String time: eachday.keySet()) {
            if (time.equals(day)) {
                ip = eachday.get(time);
            }
        }
        for (int k = 0; k < ip.size(); k++) {
            if (!eachip.containsKey(ip.get(k))) {
                eachip.put(ip.get(k), 1);
            }
            else eachip.put(ip.get(k), eachip.get(ip.get(k))+1);
        }
        mostthatday = iPsMostVisits(eachip);
        return mostthatday;
    }


    public void printAll() {
        for (LogEntry le : records) {
            System.out.println(le);
        }
    }

}