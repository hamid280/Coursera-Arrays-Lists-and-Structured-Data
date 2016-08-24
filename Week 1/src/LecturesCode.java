public class LecturesCode {

    public String reverse (String s){
        String reverse = "";
        for (int i=0; i < s.length(); i++){
            reverse =s.charAt(i) + reverse ;
        }
        return reverse;
    }

    public void digitTest(String s){
        for (int i = 0; i < s.length(); i ++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                System.out.println(ch + " is a digit");
            }
            if(Character.isAlphabetic(ch)){
                System.out.println(ch + " is a alphabetic");
            }
        }
    }

    public static void main(String[] args) {
        LecturesCode test = new LecturesCode();
        String result =test.reverse("Ahamat1234435");
        System.out.println(result);
        test.digitTest("ali34df35643===0-0-++++///sdfa");
        System.out.println("checking" );
        System.out.println("checking");
    }
}
