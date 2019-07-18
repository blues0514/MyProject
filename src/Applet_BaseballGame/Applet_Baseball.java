package Applet_BaseballGame;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Applet_Baseball extends Applet implements ActionListener {
    int count;
    int key;
    int strike, ball;

    int[] user = new int[3]; // ����ڰ� �Է��� ���� 3��
    int[] com = new int[3]; // ��ǻ�Ͱ� ���� ���� 3��

    boolean gameover = false;

    Label display;
    TextArea history;

    Panel numPanel;
    Button[] buttons = new Button[12];

    public void init() {
        Random r = new Random();
        com[0] = Math.abs(r.nextInt() % 9) + 1;

        do {
            com[1] = Math.abs(r.nextInt() % 9) + 1;
        } while (com[1] == com[0]); // com[0] ���� com[1] ���� ���� �ʵ���(�ٸ� ������) �ݺ�

        do {
            com[2] = Math.abs(r.nextInt() % 9) + 1;
        } while (com[2] == com[0] || com[2] == com[1]); // com[0], com[1], com[2] ���� ���� �ʵ��� (�ٸ� ������) �ݺ�

        count = 0;
        key = 0;
        user[0] = user[1] = user[2] = 0;

        //GUI
        setLayout(new BorderLayout()); // ���� ���̾ƿ����� ����

        display = new Label();
        display.setAlignment(Label.RIGHT);
        add("North", display);

        numPanel = new Panel();
        numPanel.setLayout(new GridLayout(4, 3));

        for (int i = 7; i > 0; i -= 3) {
            for (int j = 0; j < 3; j++) {
                buttons[i + j] = new Button(String.valueOf(i + j));
                numPanel.add(buttons[i + j]);
            }
        }

        buttons[0] = new Button("��");
        numPanel.add(buttons[0]);

        buttons[10] = new Button("�ٽ� �Է�");
        numPanel.add(buttons[10]);

        buttons[11] = new Button("�Է� �Ϸ�");
        numPanel.add(buttons[11]);
        add("Center", numPanel);

        history = new TextArea(10, 20);
        add("South", history);

        for (int i = 0; i < 12; i++) {
            buttons[i].addActionListener(this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (gameover) return;

        if (e.getSource() == buttons[0]) { // <- ��ư
            if (key > 0) {
                key--;
                display.setText("");
                for (int i = 0; i < key; i++) {
                    display.setText(display.getText() + user[i]);
                }
            }
        } else if (e.getSource() == buttons[10]) { //�ٽ� �Է� ��ư
            key = 0;
            user[0] = user[1] = user[2] = 0;
            display.setText("");
        } else if (e.getSource() == buttons[11]) { //�Է� �Ϸ� ��ư
            if (key == 3) {
                strike = ball = 0;

                if (user[0] == com[0]) strike++;
                if (user[1] == com[1]) strike++;
                if (user[2] == com[2]) strike++;

                if (user[0] == com[1]) ball++;
                if (user[0] == com[2]) ball++;
                if (user[1] == com[0]) ball++;
                if (user[1] == com[2]) ball++;
                if (user[2] == com[0]) ball++;
                if (user[2] == com[1]) ball++;

                history.append(user[0] + "," + user[1] + "," + user[2] +
                        " -> Strike : " + strike + " Ball : " + ball + "\n");

                count++;
                key = 0;
                user[0] = user[1] = user[2] = 0;
                display.setText("");

                if ((strike == 3) || (count == 11)) {
                    if (count <= 2) {
                        history.append("\n �� : A");
                    } else if (count <= 5) {
                        history.append("\n �� : B");
                    } else if (count <= 9) {
                        history.append("\n �� : C");
                    } else {
                        history.append("\n �� : D");
                    }

                    gameover = true;
                    display.setText(" Game Over !");
                    history.append("\n\n <<<���� ��>>>");
                }
            } else {
                //���� 3�� �̸� ���� ���
            }
        } else {
            if (key < 3) {
                char butVal = ((Button) e.getSource()).getLabel().charAt(0);
                user[key] = Integer.valueOf(String.valueOf(butVal)).intValue();

                boolean same = false;
                switch (key) {
                    case 2:
                        if (user[key] == user[1]) same = true;
                    case 1:
                        if (user[key] == user[0]) same = true;
                }

                if (same) {
                    //���� ���ڸ� ���� ���
                } else {
                    display.setText(display.getText() + butVal);
                    key++;
                }
            } else {
                //���ڸ� 3�� �̻� ���� ���
            }
        }
    }
}

