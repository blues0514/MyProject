package ChattingServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.Vector;

public class ChatServer {
    Vector clientVector = new Vector();
    int clientNum = 0;

    public void broadcast(String msg) throws IOException { // 등록된 모든 클라이언트에게 메시지 보내기
        synchronized (clientVector) {
            for (int i = 0; i < clientVector.size(); i++) {
                ChatThread client = (ChatThread) clientVector.elementAt(i);
                synchronized (client) {
                    client.sendMessage(msg);
                }
            }
        }
    }

    public void removeClient(ChatThread client) { // clientVector에서 클라이언트 스레드 제거
        synchronized (clientVector) {
            clientVector.removeElement(client);
            client = null;
            System.gc();
        }
    }

    public void addClient(ChatThread client) { // clientVector에서 클라이언트 스레드 추가
        synchronized (clientVector) {
            clientVector.addElement(client);
        }
    }

    public static void main(String[] args) {
        ServerSocket myServerSocket = null;

        ChatServer myServer = new ChatServer();

        try {
            myServerSocket = new ServerSocket(8080);
        } catch (IOException e) {
            System.out.println(e.toString());
            System.exit(-1);
        }
        System.out.println("[서버 대기 상태]" + myServerSocket);

        try {
            ChatThread client = new ChatThread(myServer, myServerSocket.accept());
            client.start();
            myServer.addClient(client);

            myServer.clientNum++;
            System.out.println("[현재 접속자 수]" + myServer.clientNum + "명");
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
}
