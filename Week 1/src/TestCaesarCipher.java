import edu.duke.FileResource;

/**
 * Created by Hamit on 7/28/2016.
 */
public class TestCaesarCipher {

    private int[] countLetters(String message){
        String alph = "abcdefghijklmnopqrstuvwxyz";
        int[] counts = new int[26];
        for (int k = 0; k<message.length(); k++) {
            char ch = Character.toLowerCase(message.charAt(k));
            int dex = alph.indexOf(ch);
            if (dex != -1) {
                counts[dex] += 1;
            }
        }
        return counts;
    }

    private int maxIndex(int[] values){
        int max = 0;
        for (int i = 0; i < values.length ; i++) {
            if (values[i] > max){
                max = values[i];
            }
        }
        return max;
    }

    public void breakCaesarCipher(String input){
        int[] letterFreqs = countLetters(input);
        int maxindex = maxIndex(letterFreqs);
        int dkey = maxindex - 4;
        if (maxindex < 4) {
            dkey = 26 - (4-maxindex);
        }
        OOCeaserCipher c = new OOCeaserCipher(dkey);
        System.out.println("Encrypted message:\n" + input);
        System.out.println("\nkey:" + dkey);
        System.out.println("\nDecrypted message:\n" + c.decrypt(input));
    }

    public void simpleTests(){
        FileResource fr = new FileResource();
        String message = fr.asString();
        OOCeaserCipher cc = new OOCeaserCipher(18);
        String encrypted = cc.encrypt(message);
        System.out.println(encrypted);
        System.out.println(cc.decrypt(encrypted));
        breakCaesarCipher("XJWW USCW AF LZW UGFXWJWFUW JGGE!");

    }

    public static void main(String[] args) {
        TestCaesarCipher test = new TestCaesarCipher();
        test.simpleTests();
    }
}
