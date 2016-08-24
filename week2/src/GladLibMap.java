import edu.duke.FileResource;
import edu.duke.URLResource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by Hamit on 7/31/2016.
 */
public class GladLibMap {

    private HashMap<String, ArrayList<String>> myMap;
    private ArrayList<String> usedBeforeList;

    private Random myRandom;

    private static String dataSourceURL = "http://dukelearntoprogram.com/course3/data";
    private static String dataSourceDirectory = "data";

    public GladLibMap(){
        initializeFromSource(dataSourceDirectory);
        myRandom = new Random();
        myMap = new HashMap<>();
        usedBeforeList = new ArrayList<>();
    }

    public GladLibMap(String source){
        initializeFromSource(source);
        myRandom = new Random();
    }

    private void initializeFromSource(String source) {
        String [] labels = {"country", "noun" , "animal", "adjective" ,  "name" , "color" ,"timeframe"};
        for (String s : labels){
            ArrayList<String> list = readIt(source + "/" + s+ ".txt");
            myMap.put(s,list);
        }
    }

    private String randomFrom(ArrayList<String> source){
        int index = myRandom.nextInt(source.size());
        return source.get(index);
    }

    private String getSubstitute(String label) {
        if (label.equals("number")){
            return ""+myRandom.nextInt(50)+5;
        }
        else {
            return randomFrom(myMap.get(label));
        }
    }

    private String processWord(String w){
        int first = w.indexOf("<");
        int last = w.indexOf(">",first);
        if (first == -1 || last == -1){
            return w;
        }
        String prefix = w.substring(0,first);
        String suffix = w.substring(last+1);
        String sub = getSubstitute(w.substring(first+1,last));
        while (usedBeforeList.contains(sub)){
            sub = getSubstitute(w.substring(first+1,last));
        }
        usedBeforeList.add(sub);
        return prefix+sub+suffix;
    }

    private void printOut(String s, int lineWidth){
        int charsWritten = 0;
        for(String w : s.split("\\s+")){
            if (charsWritten + w.length() > lineWidth){
                System.out.println();
                charsWritten = 0;
            }
            System.out.print(w+" ");
            charsWritten += w.length() + 1;
        }
    }

    private String fromTemplate(String source){
        String story = "";
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for(String word : resource.words()){
                story = story + processWord(word) + " ";
            }
        }
        else {
            FileResource resource = new FileResource(source);
            for(String word : resource.words()){
                story = story + processWord(word) + " ";
            }
        }
        return story;
    }

    private ArrayList<String> readIt(String source){
        ArrayList<String> list = new ArrayList<String>();
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for(String line : resource.lines()){
                list.add(line);
            }
        }
        else {
            FileResource resource = new FileResource(source);
            for(String line : resource.lines()){
                list.add(line);
            }
        }
        return list;
    }

    public void makeStory(){
        usedBeforeList.clear();
        System.out.println("\n");
        String story = fromTemplate("data/madtemplate2.txt");
        printOut(story, 60);
        System.out.println("\n # Replaced words : " + usedBeforeList.size());
    }

    public static void main(String[] args) {
        GladLib gladLib = new GladLib();
        gladLib.makeStory();
    }
}
