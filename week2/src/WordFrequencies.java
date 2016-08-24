import edu.duke.FileResource;

import java.util.ArrayList;

/**
 * Created by Hamit on 7/30/2016.
 */
public class WordFrequencies {
    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;

    public WordFrequencies() {
        myWords = new ArrayList<>();
        myFreqs = new ArrayList<>();
    }

    public void findUnique(){
        myWords.clear();
        myFreqs.clear();

        FileResource resource = new FileResource("romeo.txt");

        for(String s : resource.words()){
            s = s.toLowerCase();
            int index = myWords.indexOf(s);
            if(index == -1){
                myWords.add(s);
                myFreqs.add(1);
            }
            else {
                int value = myFreqs.get(index);
                myFreqs.set(index,value+1);
            }
        }
    }

    private int findIndexOfMax(){
        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i <myFreqs.size() ; i++) {

            //get value for every myFreqs because its array list we cant access integer value directly
            int value = myFreqs.get(i);
            if ( value > max){
                max = value;
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public void tester(){
        findUnique();
        System.out.println(" # unique words " + myWords.size());
        int maxIndex = findIndexOfMax();

        for (int i = 0; i <myWords.size() ; i++) {
            System.out.println(myFreqs.get(i) +"\t"+myWords.get(i));
        }
        System.out.println("The word that occurs most often and its count are: " +myWords.get(maxIndex)+ "\t" + myFreqs.get(maxIndex));
    }



    public static void main(String[] args) {
        WordFrequencies test = new WordFrequencies();
        test.tester();

    }







}
