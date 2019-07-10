package RSPGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class GameJava {
    public static void main(String[] args) throws IOException {
        // 컴퓨터의 0 = 가위, 1 = 바위, 2 = 보
        // 주석 추가한 내용 확인
        Random r = new Random();
        int com = Math.abs(r.nextInt() % 3);

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String user;
        System.out.print("가위, 바위, 보 중 하나를 선택하세요. (가위 = a, 바위 = b, 보 = c) : ");
        user = in.readLine(); // 키보드로부터 한 줄을 입력 받음

        if(user.equals("a")) { // 유저가 가위 선택
            if(com==0) System.out.println("무승부 (컴퓨터 : 가위 , 유저 : 가위");
            if(com==1) System.out.println("컴퓨터 승 ! (컴퓨터 : 바위 , 유저 : 가위");
            if(com==2) System.out.println("유저 승 ! (컴퓨터 : 보 , 유저 : 가위");
        } else if(user.equals("b")) { // 유저가 바위 선택
            if(com==0) System.out.println("유저 승 ! (컴퓨터 : 가위 , 유저 : 바위");
            if(com==1) System.out.println("무승부 (컴퓨터 : 바위 , 유저 : 바위");
            if(com==2) System.out.println("컴퓨터 승 ! (컴퓨터 : 보 , 유저 : 바위");
        } else if(user.equals("c")) { // 유저가 보 선택
            if(com==0) System.out.println("컴퓨터 승 ! (컴퓨터 : 가위 , 유저 : 보");
            if(com==1) System.out.println("유저 승 ! (컴퓨터 : 바위 , 유저 : 보");
            if(com==2) System.out.println("무승부 (컴퓨터 : 보 , 유저 : 보");
        }
    }
}