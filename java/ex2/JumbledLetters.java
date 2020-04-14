import java.util.Arrays;
import java.util.Scanner;

public class JumbledLetters {

    public static String sortString(String inputString){

        char sortArray[] = inputString.toCharArray();
        Arrays.sort(sortArray);
        return new String(sortArray);
    }

    public Boolean checkPartialJumble(String s1, String s2){
        int upto23 = (s1.length() * 2) / 3;
        int chPlace = 0;
        if ((s1.equals(s2)) ||
                (s1.charAt(0) != s2.charAt(0)) ||
                (s1.length() != s2.length()) ||
                (sortString(s1) != sortString(s2))){
            return false;
        } else {
            if (s1.length() > 3) {
                for (int i = 0; i < s1.length(); i++) {
                    if (s1.charAt(i) != s2.charAt(i)) {
                        chPlace++;
                    }
                }
                if (chPlace >= upto23) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args){
        JumbledLetters jl = new JumbledLetters();
        Scanner input = new Scanner(System.in);
        String s1 = input.nextLine();
        String s2 = input.nextLine();
        System.out.println(jl.checkPartialJumble(s1, s2));
    }
}
