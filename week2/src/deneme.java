/**
 * Created by Hamit on 7/31/2016.
 */
public class deneme {

    public static void main(String[] args) {
        String s = "CGTTCAAGTTCAA";
        int start = 2;
        for (int i = 0; i <(s.length()- start)/3 ; i++) {
            String result = s.substring(start+i*3, start+i*3+3);
            System.out.println(result);

        }
    }
}
