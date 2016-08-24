import edu.duke.FileResource;

/**
 * Created by Hamit on 7/23/2016.
 */
public class CaesarCipher {

    public String encrypt(String input, int key){
        //make a string builder with message (encrypted)
        StringBuilder encrypted = new StringBuilder(input);

        //write down the alphabet
        String upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";

        //compute the shifted alphabet
        String upperShiftedAlphabet = upperAlphabet.substring(key)+upperAlphabet.substring(0, key);
        String lowerShiftedAlphabet = lowerAlphabet.substring(key)+lowerAlphabet.substring(0, key);

        //count from 0 to length of encrypt call it i
        for (int i=0;i<encrypted.length();i++){
            char currChar = encrypted.charAt(i);
            if(Character.isUpperCase(currChar)) {

                int idx = upperAlphabet.indexOf(currChar);
                if (idx != -1) {
                    char newChar = upperShiftedAlphabet.charAt(idx);
                    encrypted.setCharAt(i, newChar);
                }
            }

            if(Character.isLowerCase(currChar)) {

                int idx = lowerAlphabet.indexOf(currChar);
                if (idx != -1) {
                    char newChar = lowerShiftedAlphabet.charAt(idx);
                    encrypted.setCharAt(i, newChar);
                }
            }
            //otherwise do nothing

        }
        return encrypted.toString();
    }

    public String encryptTwoKeys(String input, int key1, int key2){
        StringBuilder encrypted = new StringBuilder(input);

        for (int i = 0; i<encrypted.length() ; i++){

            //for characters when i=0,2,4 use key1 to encrypt
            if (i % 2 == 0) {
                char currChart = encrypted.charAt(i);
                String currString = Character.toString(currChart);
                String encryptedString = encrypt(currString, key1);

                char encryptedChar = encryptedString.charAt(0);
                encrypted.setCharAt(i, encryptedChar);
            }

            //for characters when i=1,3,5 use key2 to encrypt
            if (i % 2 != 0) {
                char currChart = encrypted.charAt(i);
                String currString = Character.toString(currChart);
                String encryptedSofar = encrypt(currString, key2);

                char encryptedChar = encryptedSofar.charAt(0);
                encrypted.setCharAt(i, encryptedChar);
            }

        }
        return encrypted.toString();
    }

    public void eyeBallDecrypt(String encrypted){
        CaesarCipher cipher = new CaesarCipher();
        for (int i=0 ; i<26 ; i++){
            String s = cipher.encrypt(encrypted,i);
            System.out.println(i+"\t"+s);
        }
    }



    public void testCaesar(){
        int key = 17;
        FileResource fr = new FileResource();
        String message = fr.asString();
        System.out.println("the message was : " + message);
        message = encrypt(message,key);
        System.out.println("its encryption with the given key is : "+message);
        message = encrypt(message,26-key);
        System.out.println("its decryption is : " + message);
    }

    public static void main(String[] args) {
        CaesarCipher test = new CaesarCipher();
        test.eyeBallDecrypt("Lujyfwapvu huk zljbypaf hyl mbukhtluahs whyaz vm avkhf'z Pualyula.");
    }
}
