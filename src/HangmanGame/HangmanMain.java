package HangmanGame;

import java.io.IOException;

public class HangmanMain {
    public static void main(String[] args) throws IOException {
        Hangman hangman = new Hangman();

        int result = hangman.playGame(); // 게임 실행

        System.out.println();
        if(result<=2) { // 실패 횟수에 따라 메시지 출력
            System.out.println("A등급");
        } else if(result<=3) {
            System.out.println("B등급");
        } else if(result<=4) {
            System.out.println("C등급");
        } else {
            System.out.println("F등급");
        }
    }
}
