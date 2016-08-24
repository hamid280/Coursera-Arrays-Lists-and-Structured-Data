import edu.duke.DirectoryResource;
import edu.duke.FileResource;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Hamit on 8/1/2016.
 */
public class WordsInFiles {
    private HashMap<String, ArrayList<String>> wordMap;

    public WordsInFiles(){
        wordMap = new HashMap<>();
    }

    private void addWordsFromFile(File file){

        FileResource resource = new FileResource(file.toString());

        for (String word : resource.words()){
            if(!wordMap.containsKey(word)){
                wordMap.put(word, new ArrayList<>());
                wordMap.get(word).add(word);
            }
            else {
                if(!wordMap.get(word).contains(file.getName())) {
                    wordMap.get(word).add(file.getName());
                }
            }
        }
    }

    public void buildWordFileMap(){
        wordMap.clear();
        DirectoryResource dr = new DirectoryResource();
        for (File file : dr.selectedFiles()){
            addWordsFromFile(file);
        }
    }


    private int maxNumber() {
        int current;
        int largest = 0;

        for (String word: wordMap.keySet()) {
            current = wordMap.get(word).size();
            if (current > largest) {
                largest = current;
            }
        }
        return largest;
    }

    private ArrayList<String> wordsInNumFiles(int number) {
        int current = 0;
        ArrayList<String> list = new ArrayList<String>();
        for (String word: wordMap.keySet()) {
            current = wordMap.get(word).size();
            if (current==number) list.add(word);
        }
        return list;
    }

    private void printFilesIn(String word) {
        System.out.println("The files contain "+word+" are(is): \t");
        ArrayList<String> list = new ArrayList<String>();
        for (String current: wordMap.keySet()) {
            if (current==word) list = wordMap.get(current);
        }
        for (int k = 0; k < list.size(); k++) {
            System.out.println(list.get(k)+"\t");
        }
    }

    public void test() {
        buildWordFileMap();
        int max = maxNumber();
        ArrayList<String> list = wordsInNumFiles(max);
        System.out.println("The greatest number of files a word appears in is "+max+", and there are "+list.size()+ " such words: ");
        for (int k = 0; k < list.size(); k++) {
            System.out.println(list.get(k)+" ");
        }
        System.out.println("\t");
        for (int k = 0; k < list.size(); k++) {
            printFilesIn(list.get(k));
        }


    }

    public static void main(String[] args) {
        WordsInFiles test = new WordsInFiles();
        test.test();
    }


}

