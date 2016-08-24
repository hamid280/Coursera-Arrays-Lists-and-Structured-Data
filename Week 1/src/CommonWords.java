import edu.duke.FileResource;

/**
 * Created by Hamit on 7/24/2016.
 */

public class CommonWords {

    public String[] getCommon(){
        FileResource fileResource = new FileResource("data/common.txt");

        //make an array of strings that has 20 elements
        String[] common = new String[20];
        int index = 0;

        // for each word in the file common.txt
        for (String s : fileResource.words()){

            //place the file to the array elements one by one
            common[index] = s;
            index ++;
        }
        return common;
    }

    public void countShakespeare(){
        String[] plays = {"data/caesar.txt", "data/errors.txt", "data/hamlet.txt",
                "data/likeit.txt", "data/macbeth.txt", "data/romeo.txt"};
        String [] common = getCommon();
        int [] counts = new int[common.length];
        for (int i = 0 ; i < plays.length; i++){
            FileResource resource = new FileResource(plays[i]);
            countWords(resource,common,counts);
            System.out.println("done with" + plays[i]);
        }
        for (int i = 0; i <common.length ; i++) {
            System.out.println(common[i] + "   " +"\t" + counts[i]);
            
        }
            
    }

    private void countWords(FileResource resource, String[] common, int[] counts) {
        for (String word : resource.words()){
            word = word.toLowerCase();
            int index = indexOf(common,word);
            if (index !=-1)
                counts[index] +=1;
        }
    }

    private int indexOf(String[] list, String word) {
        for (int i = 0; i <list.length ; i++) {
            if(list[i].equals(word)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        CommonWords test = new CommonWords();
        test.countShakespeare();
    }
}
