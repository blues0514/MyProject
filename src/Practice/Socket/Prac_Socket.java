package Practice.Socket;

import java.io.*;
import java.net.MalformedURLException;
import java.net.Socket;

public class Prac_Socket {
    public static void main(String[] args) {
        try {
            Socket mySocket = new Socket("127.0.0.1",8080);
            System.out.println("������ ����");

            BufferedReader in = new BufferedReader(new InputStreamReader(mySocket.getInputStream()));
            PrintWriter out = new PrintWriter(new OutputStreamWriter(mySocket.getOutputStream()));

            String msg = "%%%���� �����û";
            System.out.println("������ ���� �޽��� : " + msg);
            out.println(msg);
            out.flush();
            System.out.println("�����κ��� ���� �޽��� : " + in.readLine());

            mySocket.close();
        } catch (MalformedURLException e){
            System.out.println(e.toString());
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
}
