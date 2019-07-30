package Practice.Socket;

import java.io.*;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.Socket;

public class Prac_ServerSocket {
    public static void main(String[] args) {
        try {
            ServerSocket myServerSocket = new ServerSocket(8080); // 서버 소켓 생성
            System.out.println("클라이언트 접속 대기");

            Socket mySocket = myServerSocket.accept(); // 클라이언트 접속을 기다림
            System.out.println("클라이언트 접속");

            BufferedReader in = new BufferedReader(new InputStreamReader(mySocket.getInputStream()));
            PrintWriter out = new PrintWriter(new OutputStreamWriter(mySocket.getOutputStream()));

            System.out.println("클라이언트로부터 받은 메시지: " + in.readLine());
            String msg = "###접속 허락";
            out.println(msg);
            out.flush();
            System.out.println("클라이언트에 보낸 메시지 : " + msg);

            mySocket.close();
        } catch (MalformedURLException e) {
            System.out.println(e.toString());
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
}
