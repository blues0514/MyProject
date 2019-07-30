package Practice.Socket;

import java.io.*;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.Socket;

public class Prac_ServerSocket {
    public static void main(String[] args) {
        try {
            ServerSocket myServerSocket = new ServerSocket(8080); // ���� ���� ����
            System.out.println("Ŭ���̾�Ʈ ���� ���");

            Socket mySocket = myServerSocket.accept(); // Ŭ���̾�Ʈ ������ ��ٸ�
            System.out.println("Ŭ���̾�Ʈ ����");

            BufferedReader in = new BufferedReader(new InputStreamReader(mySocket.getInputStream()));
            PrintWriter out = new PrintWriter(new OutputStreamWriter(mySocket.getOutputStream()));

            System.out.println("Ŭ���̾�Ʈ�κ��� ���� �޽���: " + in.readLine());
            String msg = "###���� ���";
            out.println(msg);
            out.flush();
            System.out.println("Ŭ���̾�Ʈ�� ���� �޽��� : " + msg);

            mySocket.close();
        } catch (MalformedURLException e) {
            System.out.println(e.toString());
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
}
