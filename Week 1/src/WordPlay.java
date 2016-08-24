/**
 * Created by Hamit on 7/23/2016.
 */
public class WordPlay {


    public Boolean isVowel(char ch) {
        if (ch == 'a' || ch == 'A' || ch == 'e' || ch == 'E' || ch == 'i' || ch == 'I' || ch == 'o' ||
                ch == 'O' || ch == 'u' || ch == 'U')
            return true;
        else {
            return false;
        }
    }

    public String replaceVowels(String phrase, char ch){

        //change the string phrace to string builder
        StringBuilder withOutVowel = new StringBuilder(phrase);

        //for every char in the given string
        for (int i = 0; i<withOutVowel.length(); i++){
            char currChar = phrase.charAt(i);

            //check if current char is vowel
            if(isVowel(currChar)){

                //if vowel chang that char to ch
               withOutVowel.setCharAt(i , ch);
            }
        }

        //return string without vowel
        return withOutVowel.toString();
    }

    public String emphasize (String phrase, char ch){
        StringBuilder stringBuilder = new StringBuilder(phrase);

        for (int i = 0 ; i < stringBuilder.length() ; i++){

            char currChar = stringBuilder.charAt(i);
            if ((Character.toUpperCase(currChar)) == (Character.toUpperCase(ch))){
                if( i % 2 == 0) {
                    stringBuilder.setCharAt(i, '*');
                }
                if ( i % 2 != 0) {
                    stringBuilder.setCharAt(i, '+');
                }
            }
        }

        return stringBuilder.toString();
    }


    public static void main(String[] args) {
        WordPlay test = new WordPlay();
        Boolean check = test.isVowel('a');
        System.out.println(check);
        String test1 = test.replaceVowels("Hello World", '*');
        System.out.println(test1);
        String test2 = test.emphasize("Mary Bella Abracadabra", 'a');
        System.out.println(test2);

    }
}

