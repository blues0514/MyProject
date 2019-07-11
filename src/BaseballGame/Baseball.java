package BaseballGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Baseball {
     public static int playGame() throws IOException {
        int x,y,z;
        Random r = new Random();
        x= Math.abs(r.nextInt() % 9) + 1;

        do {
            y = Math.abs(r.nextInt() % 9) + 1;
        } while(y==x); // x값과 y값이 같지 않도록(다를 때까지) 반복

        do {
            z = Math.abs(r.nextInt() % 9) + 1;
        } while(z==x || z==y); // x,y,z값이 같지 않도록(다를 때까지) 반복

         return playGame(x,y,z);
    }

    public static int playGame(int x, int y, int z) throws IOException{
         int count;
         int strike, ball;

         int[] user = new int[3]; // 사용자가 입력한 숫자 3개
         int[] com = {x,y,z}; // 컴퓨터가 숨긴 숫자 3개

        System.out.println("숫자 야구 게임");

        count = 0;

        do {
            count ++; // 문제를 푼 횟수

            do {
                System.out.println("\n카운트 : " + count);
                BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
                String users;

                System.out.print("1번째 숫자 : ");
                users = in.readLine(); // 키보드로 부터 입력
                user[0] = new Integer(users).intValue(); // 입력받은 문자를 int로 형변환

                System.out.print("2번째 숫자 : ");
                users = in.readLine(); // 키보드로 부터 입력
                user[1] = new Integer(users).intValue(); // 입력받은 문자를 int로 형변환

                System.out.print("3번째 숫자 : ");
                users = in.readLine(); // 키보드로 부터 입력
                user[2] = new Integer(users).intValue(); // 입력받은 문자를 int로 형변환

                if( (user[0]==0) || (user[1]==0) || (user[2]==0) ){
                    System.out.println("0은 입력 불가능. 재입력");
                } else if ( (user[0]>9) || (user[1]>9) || (user[2]>9) ) {
                    System.out.println("1부터 9사이의 숫자만 입력. 재입력");
                } else if ( (user[0]==user[1]) || (user[1]==user[2]) || (user[2]==user[0]) ) {
                    System.out.println("모두 다른 숫자로 구성. 재입력");
                }
            } while( (user[0]==0) || (user[1] == 0) || user[2] == 0 ||
                    (user[0]>9) || (user[1]>9) || (user[2]>9) ||
                    (user[0]==user[1]) || (user[1]==user[2]) || (user[2]==user[0]) ); //입력받은 답에 이상이 없을 때 ( 0 ~ 9, 모두 다른 숫자 ) 까지 반복

            strike = ball = 0; // 볼 카운트

            //strike 계산
            if(user[0]==com[0]) strike++;
            if(user[1]==com[1]) strike++;
            if(user[2]==com[2]) strike++;
            //ball 계산
            if(user[0]==com[1]) ball++;
            if(user[0]==com[2]) ball++;
            if(user[1]==com[0]) ball++;
            if(user[1]==com[2]) ball++;
            if(user[2]==com[0]) ball++;
            if(user[2]==com[1]) ball++;

            System.out.println("Strike : " + strike + " Ball : " + ball); // strike, ball 카운트 출력
        } while ( (strike<3) && (count < 11) ); // 답을 맞췄거나 10번 이상 시도해서 못 맞출 때까지 반복

        return count; // 문제를 맞추려고 시도한 횟수를 반환
    }

    public static void main(String[] args) throws IOException{
         int result;

         if(args.length==3) {
             int x = Integer.valueOf(args[0]).intValue(); //인수는 String형으로 int로 형변환
             int y = Integer.valueOf(args[1]).intValue();
             int z = Integer.valueOf(args[2]).intValue();

             result = playGame(x,y,z); // 인수를 playGame() 메소드에 전달
         } else {
             result=playGame(); // 인수가 없는 경우에는 인수없는 playGame()메소드 호출
         }

        System.out.println();

         if(result<=2) { // 문제를 푼 횟수에 따라 메세지 출력
             System.out.println("A등급");
         } else if (result<=5) {
             System.out.println("B등급");
         } else if (result<=9) {
             System.out.println("C등급");
         } else {
             System.out.println("D등급");
         }
    }
}
