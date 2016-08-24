import java.util.Date;

/**
 * Created by Hamit on 8/2/2016.
 */
public class LogEntry {

    private String ipAddress;
    private Date accessTime;
    private String request;
    private int statusCode;
    private int bytesReturned;


    //constructor for the class
    public LogEntry(String ip, Date time, String req, int status, int bytes){
        ipAddress = ip;
        accessTime = time;
        request = req;
        statusCode = status;
        bytesReturned = bytes;
    }

    //getters for the members of the class


    public String getIpAddress() {
        return ipAddress;
    }

    public Date getAccessTime() {
        return accessTime;
    }

    public String getRequest() {
        return request;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public int getBytesReturned() {
        return bytesReturned;
    }

    public String toString(){
        return ipAddress + " " + accessTime + " " + request +  " " + statusCode +  " " +bytesReturned ;
    }
}
