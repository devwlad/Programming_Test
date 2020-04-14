import java.util.Scanner;

public class CharReplacer {
    public void shiftRight2(char[] text, int pos, int text_length){
        for (int i = text_length - 1; i > pos; i--){
            text[i + 2] = text[i];
        }
    }
    public int SpaceReplacer(char[] text, int text_length){
        int spaces = 0;
        for (int i = 0; i < text_length; i++){
            if (text[i] == ' '){
                spaces++;
                shiftRight2(text, i, text_length);
                text_length += 2;
                text[i] = '&';
                text[i+1] = '3';
                text[i+2] = '2';
            }
        }
        return spaces;
    }

    public static void main(String[] args){
        CharReplacer cf = new CharReplacer();
        Scanner input = new Scanner(System.in);
        String stext = input.nextLine();
        char[] text = new char[100];
        for (int i = 0; i < stext.length(); i++){
            text[i] = stext.charAt(i);
        }
        int spaces = cf.SpaceReplacer(text, stext.length());
        for(int i = 0; i < stext.length() + (2 * spaces); i++){
            System.out.print(text[i]);
        }
    }
}