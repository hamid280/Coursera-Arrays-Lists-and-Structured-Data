import edu.duke.FileResource;

/**
 * Created by Hamit on 7/27/2016.
 */
public class DecryptMessage {

    public int [] countLetters(String message){
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int [] counts = new int[26];

        //for each character in encrypted message
        for (int i = 0; i<message.length() ; i++) {

            //get lower case of character
            char ch = message.charAt(i);
            ch = Character.toLowerCase(ch);

            //check the index of the char in the alphabet
            int index = alphabet.indexOf(ch);

            if (index !=-1){
                counts[index] += 1;
            }

        }
        return counts;
    }

    public String decrypt(String encrypted){
        CaesarCipher cc = new CaesarCipher();
        int distanceKey = getKey(encrypted);
        return cc.encrypt(encrypted,26-distanceKey);

    }

    private int getKey(String s1) {
        int[] freqs = countLetters(s1);
        int maxIndex = maxIndex(freqs);
        int distanceKey = maxIndex - 4;
        if(maxIndex < 4){
            distanceKey = 26 - (4-maxIndex);
        }
        return distanceKey;
    }

    private String halfOfString(String encrypted, int start) {
        String halfString = " ";
        for (int j = start; j <encrypted.length() ; j +=2) {
            halfString = halfString + encrypted.charAt(j);
        }
        return halfString;
    }

    public int maxIndex(int[] freqs) {
        int maxSoFar = 0;
        for (int i = 0; i <freqs.length ; i++) {
            if(freqs[i] > freqs[maxSoFar]){
                maxSoFar = i;
            }
        }
        return maxSoFar;
    }

    //decyrpt with two keys (assignment)
    public String decryptWithTwoKeys(String encrypted){

        //split string into two parts s1 and s1 with every other character
        String s1 = halfOfString(encrypted, 0);
        String s2 = halfOfString(encrypted, 1);
        System.out.println(s1);
        System.out.println(s2);
        int key1 = getKey(s1);
        int key2 = getKey(s2);
        System.out.println("Two keys found: key1= " + key1 + ", key2= " + key2);
        CaesarCipher cc = new CaesarCipher();
        String result = cc.encryptTwoKeys(encrypted, 26-key1, 26-key2);
        return result;
    }


    public void testEncryptThenDecrypt(){
        FileResource resouce = new FileResource("mysteryTwoKeysPractice.txt");
        String message = resouce.asString();
        CaesarCipher cc = new CaesarCipher();
       // String encrypted = cc.encrypt(message,23);
        //System.out.println("encrypted message is " +"\t"+ encrypted);

        System.out.println("decyropted message of example is " +"\t" +  decryptWithTwoKeys(message));
    }

    public static void main(String[] args) {
        DecryptMessage test = new DecryptMessage();
        test.testEncryptThenDecrypt();
    }
}
