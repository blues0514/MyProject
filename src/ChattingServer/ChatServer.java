package ChattingServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.Vector;

public class ChatServer {
    Vector clientVector = new Vector();
    int clientNum = 0;

    public void broadcast(String msg) throws IOException { // ��ϵ� ��� Ŭ���̾�Ʈ���� �޽��� ������
        synchronized (clientVector) {
            for (int i = 0; i < clientVector.size(); i++) {
                ChatThread client = (ChatThread) clientVector.elementAt(i);
                synchronized (client) {
                    client.sendMessage(msg);
                }
            }
        }
    }

    public void removeClient(ChatThread client) { // clientVector���� Ŭ���̾�Ʈ ������ ����
        synchronized (clientVector) {
            clientVector.removeElement(client);
            client = null;
            System.gc();
        }
    }

    public void addClient(ChatThread client) { // clientVector���� Ŭ���̾�Ʈ ������ �߰�
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
        System.out.println("[���� ��� ����]" + myServerSocket);

        try {
            ChatThread client = new ChatThread(myServer, myServerSocket.accept());
            client.start();
            myServer.addClient(client);

            myServer.clientNum++;
            System.out.println("[���� ������ ��]" + myServer.clientNum + "��");
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
}
