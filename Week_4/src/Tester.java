import edu.duke.FileResource;

/**
 * Created by Hamit on 8/4/2016.
 */
public class Tester {

    public void testme() {

        VigenereBreaker vigenereBreaker = new VigenereBreaker();
        FileResource fr = new FileResource("test.txt");
        String encrypted = fr.asString();
        int[] keys = vigenereBreaker.tryKeyLength(encrypted, 5, 'e');
        for (int key : keys) {
            System.out.print(key + ", ");
        }
        System.out.println();
        vigenereBreaker.breakVigenere();

    }

    public static void main(String[] args) {
        Tester tester = new Tester();
        tester.testme();
    }

}
