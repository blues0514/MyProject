package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prac_StringTokenizer {
    public static void main(String[] args) {
        InputStreamReader isR = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(isR);

        int myTokens = 0;
        do {
            System.out.print("문자열 입력 : ");

            try {
                String str = in.readLine();
                StringTokenizer myST = new StringTokenizer(str); // 기본 구분자를 사용

                myTokens = myST.countTokens(); // 토큰수 조사
                System.out.println("토큰수 : " + myTokens);

                while (myST.hasMoreTokens()) { //토큰이 더 있는 경우
                    System.out.println("  " + myST.nextToken());
                }
            } catch (IOException e) {
                System.out.println(e.toString());
            }
            System.out.println();
        } while (myTokens != 0);
    }
}
