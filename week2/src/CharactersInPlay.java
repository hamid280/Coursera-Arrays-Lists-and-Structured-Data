import edu.duke.FileResource;

import java.util.ArrayList;

/**
 * Created by Hamit on 7/30/2016.
 */
public class CharactersInPlay {
    private ArrayList<String> characterNames;
    private ArrayList<Integer> characterFreqs;

    public CharactersInPlay() {
        characterNames = new ArrayList<>();
        characterFreqs = new ArrayList<>();
    }

    public void update(String person){
        person = person.trim();
        int index = characterNames.indexOf(person);
        if(index == -1){
            characterNames.add(person);
            characterFreqs.add(1);
        }
        else {
            int value = characterFreqs.get(index);
            characterFreqs.set(index, value+1);
        }
    }

    public void findAllCharacters(){
        characterFreqs.clear();
        characterNames.clear();

        FileResource resource = new FileResource("romeo.txt");

        for(String line : resource.lines()){
            int periodInLine = line.indexOf('.');

            if(periodInLine != -1) {
                String possibleName = line.substring(0, periodInLine);
                update(possibleName);
            }
        }
    }

    public void charactersWithNumParts(int num1 , int num2){
        for (int i = 0; i < characterFreqs.size() ; i++) {
            if (characterFreqs.get(i) >= num1 && characterFreqs.get(i) <= num2 ){
                System.out.println(characterNames.get(i) + "\t" + characterFreqs.get(i));
        }
        }
    }

    public void tester(){
        findAllCharacters();
        for (int i = 0; i < characterNames.size(); i++) {
            if(characterFreqs.get(i) > 5)
            System.out.println(characterNames.get(i) + "\t" + characterFreqs.get(i));
        }
        System.out.println("characters with two  num parts");
        charactersWithNumParts(10, 15);
    }

    public static void main(String[] args) {
        CharactersInPlay charactersInPlay = new CharactersInPlay();
        charactersInPlay.tester();

    }
}
