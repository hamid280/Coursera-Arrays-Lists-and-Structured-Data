import edu.duke.FileResource;

import java.util.HashMap;

/**
 * Created by Hamit on 8/1/2016.
 */
public class CodonCountMap {
    private HashMap<String , Integer> DNAmap;

    public CodonCountMap() {
        DNAmap = new HashMap<>();
    }

    public void buildCodonMap (int start , String dna) {
        //clear the map before using
        DNAmap.clear();
        String current;

        //take all 3characters char from start till dividable to 3
        for (int i = 0; i <(dna.length()- start)/3 ; i++){
            current = dna.substring(start+i *3, start+i*3+3);

            //if the chars are in them map already
            if (!DNAmap.containsKey(current)) {

                //increment that value
                DNAmap.put(current, 1);

            }
            //if not in the map already put it and make its value 1
            else {
                DNAmap.put(current, DNAmap.get(current) + 1);
            }
        }
    }

        //This method returns a String, the codon in a reading frame that has the largest count.
        // If there are several such codons, return any one of them.

    public String getMostCommonCodon(){
            int max = 0;
            String maxCodon = " ";

            //every element in the map
            for(String element : DNAmap.keySet()){
                if(DNAmap.get(element) > max){
                    max = DNAmap.get(element);
                     maxCodon = element;
                }
            }
            return maxCodon;
    }

        //Write a void method named printCodonCounts that has two int parameters, start and end.
        // This method prints all the codons in the HashMap along with their counts
        // if their count is between start and end, inclusive.

    public void printCodonCounts(int start, int end){
            for (String element : DNAmap.keySet()){
                if (DNAmap.get(element) >= start && DNAmap.get(element) <= end){
                    System.out.println(element + "\t" + DNAmap.get(element));
                }

            }
    }
    public void tester(){

        FileResource resource = new FileResource();
        String dna = resource.asString();
        dna = dna.toUpperCase().trim();
        int start = 1;
        int end = 5;

        buildCodonMap(0, dna);
        System.out.println("Reading frame starting with 0 results in " + DNAmap.size() + " unique codons");
        String largest = getMostCommonCodon();
        System.out.println("and most common codon is " + largest + " with counts " + DNAmap.get(largest));

        System.out.println("Counts of codons between "+start+" and "+end+" inclusive are:"+"\t");
        printCodonCounts(start, end);

        buildCodonMap(1, dna);
        System.out.println("Reading frame starting with 1 results in "+DNAmap.size()+" unique codons"+"\t");
        largest = getMostCommonCodon();
        System.out.println("Most common codon is "+largest+" with count "+DNAmap.get(largest)+"\t");
        System.out.println("Counts of codons between "+start+" and "+end+" inclusive are:"+"\t");
        printCodonCounts(start, end);

        buildCodonMap(2, dna);
        System.out.println("Reading frame starting with 2 results in "+DNAmap.size()+" unique codons"+"\t");
        largest = getMostCommonCodon();
        System.out.println("Most common codon is "+largest+" with count "+DNAmap.get(largest)+"\t");
        System.out.println("Counts of codons between "+start+" and "+end+" inclusive are:"+"\t");
        printCodonCounts(start, end);
    }

    public static void main(String[] args) {
        CodonCountMap test = new CodonCountMap();
        test.tester();
    }

}
