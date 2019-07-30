package ChattingServer;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatClient extends Applet implements ActionListener, Runnable {
    Socket mySocket = null;
    PrintWriter out = null;
    BufferedReader in = null;

    Thread clock;
    TextArea memo;
    TextField name, input;
    Panel myPanel;

    public void init() {
        try {
            mySocket = new Socket("127.0.0.1", 8080); // 서버 소켓과 접속
            out = new PrintWriter(new OutputStreamWriter(mySocket.getOutputStream(), "KSC5601"), true);
            in = new BufferedReader(new InputStreamReader(mySocket.getInputStream(), "KSC5601"), 1024);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //GUI
        setLayout(new BorderLayout());
        memo = new TextArea(10, 55);
        add("Center", memo);

        myPanel = new Panel();
        name = new TextField(8);
        name.setText("대화명");
        myPanel.add(name);
        input = new TextField(40);
        input.addActionListener(this);
        myPanel.add(input);
        add("South", myPanel);
    }

    public void start() {
        if (clock == null) {
            clock = new Thread(this);
            clock.start();
        }
    }

    public void run() {
        out.println("LOGIN|" + mySocket);
        memo.append("[접속]" + "127.0.0.1" + "\n");

        try {
            while (true) { // 서버가 메시지를 보낼때까지 대기
                String msg = in.readLine();
                if (!msg.equals("") && msg.equals(null)) {
                    memo.append(msg + "\n"); // 서버가 보낸 메시지를 텍스트에어리어에 출력
                }
            }
        } catch (IOException e) {
            memo.append(e.toString() + "\n");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == input) { // 사용자가 채팅메시지를 키보드로 입력한 경우
            String data = input.getText();
            input.setText("");
            out.println("TALK|" + name.getText() + ": " + data);
            out.flush();
        }
    }

    public void stop() {
        if ((clock != null) && (clock.isAlive())) {
            clock = null;
        }

        out.println("LOGOUT|" + name.getText()); // 접속종료를 서버에 알림
        out.flush();

        try {
            out.close();
            in.close();
            mySocket.close();
        } catch (IOException e) {
            memo.append(e.toString() + "\n");
        }
    }
}
