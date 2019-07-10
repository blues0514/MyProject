package GugudanGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Gugudan {
    public static void main(String[] args) throws IOException {
        int x,y;
        Random r = new Random();

        if(args.length==1) { // 인수가 있으면 인수로 준 값으로 문제 출제
            x = Integer.valueOf(args[0]).intValue(); // 인수는 String형이므로 int로 형변환
        } else {
            x = Math.abs(r.nextInt() % 9) + 1;
        }
        y = Math.abs(r.nextInt() % 9) + 1;

        int num = x*y;

        System.out.println();
        System.out.println("* 구구단" + x + "단에 대한 문제");
        System.out.println();

        System.out.print(x + " * " + y + " = ");

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String user;
        user = in.readLine(); // 키보드 입력

        int inputNum = new Integer(user).intValue(); // 키보드에서 입력받은 값은 String이므로 int로 형 변환
        if(num==inputNum) {
            System.out.println("정답 !");
        } else {
            System.out.println("오답. 정답은 " + num + "!");
        }
    }
}
