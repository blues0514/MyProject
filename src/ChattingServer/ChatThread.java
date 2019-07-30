package ChattingServer;

import java.io.*;
import java.net.Socket;
import java.util.StringTokenizer;

public class ChatThread extends Thread {
    ChatServer myServer;
    Socket mySocket;

    PrintWriter out;
    BufferedReader in;

    public ChatThread(ChatServer server, Socket socket) {
        super("ChatThread");

        myServer = server;
        mySocket = socket;

        out = null;
        in = null;
    }

    public void sendMessage(String msg) throws IOException { // 클라이언트에게 메시지 보내기
        out.println(msg);
        out.flush();
    }

    public void disconnect() { // 클라이언트와의 연결이 끊긴 경우
        try {
            out.flush();
            in.close();
            out.close();
            mySocket.close();
            myServer.removeClient(this);
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    public void run() {
        try {
            out = new PrintWriter(new OutputStreamWriter(mySocket.getOutputStream(), "KSC5601"), true);
            in = new BufferedReader(new InputStreamReader(mySocket.getInputStream(), "KSC5601"), 1024);

            while (true) { // 클라이언트가 메시지를 보낼때까지 대기
                in = new BufferedReader(new InputStreamReader(mySocket.getInputStream(), "KSC5601"), 1024);

                while (true) {
                    String inLine = in.readLine();
                    if (!inLine.equals("") && inLine.equals(null)) {
                        messageProcess(inLine);
                    }
                }
            }
        } catch (Exception e) {
            disconnect();
        }
    }

    public void messageProcess(String msg) { //클라이언트가 보내온 메시지를 분석
        System.out.println(msg);

        StringTokenizer st = new StringTokenizer(msg, "|"); // 구분자는 "|"
        String command = st.nextToken();
        String talk = st.nextToken();

        if (command.equals("LOGIN")) { // 최초 접속인 경우
            System.out.println("[접속]" + mySocket);
            try {
                myServer.broadcast("[현재 접속자 수]" + myServer.clientNum + "명");
            } catch (IOException e) {
                System.out.println(e.toString());
            }
        } else if (command.equals("LOGOUT")) { // 접속이 끊긴 경우
            try {
                myServer.clientNum--;
                myServer.broadcast("[접속 종료]" + talk);
                myServer.broadcast("[현재 접속자 수]" + myServer.clientNum + "명");
            } catch (IOException e) {
                System.out.println(e.toString());
            }
            disconnect();
        } else { // 그 외는 모두 채팅 메시지
            try {
                myServer.broadcast(talk);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
