package Practice.Socket;

import java.io.*;
import java.net.MalformedURLException;
import java.net.Socket;

public class Prac_Socket {
    public static void main(String[] args) {
        try {
            Socket mySocket = new Socket("127.0.0.1",8080);
            System.out.println("서버에 접속");

            BufferedReader in = new BufferedReader(new InputStreamReader(mySocket.getInputStream()));
            PrintWriter out = new PrintWriter(new OutputStreamWriter(mySocket.getOutputStream()));

            String msg = "%%%접속 허락요청";
            System.out.println("서버에 보낸 메시지 : " + msg);
            out.println(msg);
            out.flush();
            System.out.println("서버로부터 받은 메시지 : " + in.readLine());

            mySocket.close();
        } catch (MalformedURLException e){
            System.out.println(e.toString());
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
}
