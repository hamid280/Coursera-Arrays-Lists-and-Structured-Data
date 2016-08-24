import edu.duke.FileResource;

import java.util.HashMap;

/**
 * Created by Hamit on 7/31/2016.
 */
public class WordFrequenciesMap {

    public void countWordsMap(String fileName){

        FileResource fileResource = new FileResource(fileName);
        HashMap<String , Integer> map = new HashMap<>();

        for(String s : fileResource.words()){
            s = s.toLowerCase();
            if (map.keySet().contains(s)){
                map.put(s, map.get(s) + 1 );
            }
            else {
                map.put(s, 1);
            }
        }

        int total = 0;
        for (String element : map.keySet()){
            int occurrences = map.get(element);
            if (occurrences > 20){
                System.out.println(occurrences + "\t" + element);
            }
            total ++;
        }
        System.out.println("total count: "+total+" different = "+map.keySet().size());
    }

}
