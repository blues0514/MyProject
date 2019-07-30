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
            System.out.print("���ڿ� �Է� : ");

            try {
                String str = in.readLine();
                StringTokenizer myST = new StringTokenizer(str); // �⺻ �����ڸ� ���

                myTokens = myST.countTokens(); // ��ū�� ����
                System.out.println("��ū�� : " + myTokens);

                while (myST.hasMoreTokens()) { //��ū�� �� �ִ� ���
                    System.out.println("  " + myST.nextToken());
                }
            } catch (IOException e) {
                System.out.println(e.toString());
            }
            System.out.println();
        } while (myTokens != 0);
    }
}
