import java.util.Random;

/**
 * Created by Hamit on 7/24/2016.
 */
public class DiceRolling {

    public void simulate (int rolls){
        Random random = new Random();
        int [] counts = new int[13];
        for (int i=0; i<rolls ; i++ ){
            int d1 = random.nextInt(6) +1;
            int d2 = random.nextInt(6) + 1;
            counts[d1+d2] +=1;
        }
        for (int i =2 ; i<=12 ; i++){
            System.out.println(i + "'s \t"+ counts[i] +"\t" +100.0 * counts[i] / rolls);
        }
    }

    public static void main(String[] args) {
        DiceRolling test = new DiceRolling();
        test.simulate(100000);
    }
}
