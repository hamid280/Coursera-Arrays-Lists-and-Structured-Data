import edu.duke.FileResource;

/**
 * Created by Hamit on 7/27/2016.
 */
public class WordLengths {

    public int[] countWordLengths (FileResource resource, int [] counts){

        int validWordLenght = 0;
        char firstChar = ' ';
        char lastChar = ' ';

        for (String word : resource.words()){

            //lenght of each word
            int initialLength = word.length();

            //first char of word
            firstChar = word.charAt(0);

            //last char of the word
            lastChar = word.charAt(word.length() - 1);

            //if first char is not letter then decrease word lenght by 1
            if (!Character.isLetter(firstChar)){
                initialLength--;
            }

            //if last char not a letter
            if (!Character.isLetter(lastChar)){
                initialLength--;
            }
            validWordLenght = initialLength;

            if (validWordLenght <= counts.length && validWordLenght !=0){
                counts[validWordLenght- 1] +=1;
            }
            else {
                System.out.println("The length of ARRAY counts is not enough!");
            }
        }
        return counts;
    }

    public int indexOfMax (int[] values){
        int max = 0;
        for (int i = 0; i < values.length ; i++) {
            if (values[i] > max){
                max = values[i];
            }
        }
        return max;
    }

    public void testcountWordLengths() {
        FileResource resource = new FileResource("smallHamlet.txt");
        int [] counts = new int[31];
        int [] result = countWordLengths(resource, counts);
        for (int i = 0; i < 31; i++) {

            System.out.println(result[i] + " words of length "+ (i+1));
        }
        int max = indexOfMax(result);
        System.out.println("The most common word length in the file is "+max);

    }

    public static void main(String[] args) {
        WordLengths test = new WordLengths();
        test.testcountWordLengths();
    }




}