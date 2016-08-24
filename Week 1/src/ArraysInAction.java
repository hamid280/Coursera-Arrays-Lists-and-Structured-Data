/**
 * Created by Hamit on 7/24/2016.
 */
public class ArraysInAction {
    public void CountCharOccurrence(String s){

        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int[] counters = new int[26];

        for (int i=0; i<s.length();i++){
            char ch = s.charAt(i);
            int index = alphabet.indexOf(Character.toLowerCase(ch));

            if(index != -1)
                counters[index] +=1;
        }
        for(int i = 0 ; i<counters.length; i++){
            System.out.println(alphabet.charAt(i)+ "\t " + counters[i]) ;
        }
    }



    public static void main(String[] args) {
        ArraysInAction test = new ArraysInAction();
        String s = "azdfkdfzz";
        test.CountCharOccurrence(s);
    }
}
