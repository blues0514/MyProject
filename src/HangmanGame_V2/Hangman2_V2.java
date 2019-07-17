package HangmanGame_V2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Hangman2_V2 extends Hangman_V2 {
    String[] words = { "influenza", "fever","cancer", "poison", "victim", "physician", "clinic", "symptom", "medicine", "drug", "hygiene"};
    String[] meaning = {"독감", "열", "암", "독", "환자", "내과의사", "진료소", "징후", "의학", "약", "위생학"};

    public Hangman2_V2() throws IOException{
        Random r = new Random();
        int randonNum = Math.abs(r.nextInt() % words.length);

        hiddenString = words[randonNum];

        System.out.println("\n의미 : " + meaning[randonNum]);
    }

    public char readChar() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String user;

        do {
            System.out.print("1 문자를 입력하세요(힌트를 원하면 '?' 입력) : ");
            user= in.readLine();

            if(user.charAt(0)=='?') {
                boolean givehint = false;
                int i = 0;
                while(!givehint) {
                    if(outputString.charAt(i)=='-'){
                        System.out.println();
                        System.out.println("힌트 : " + hiddenString.charAt(i));
                        System.out.println();
                        failed++;
                        givehint = true;
                    }
                    i++;
                }
            }
        }while(user.charAt(0)=='?');

        return user.charAt(0);
    }
}
