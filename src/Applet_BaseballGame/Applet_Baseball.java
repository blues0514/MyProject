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

    int[] user = new int[3]; // 사용자가 입력한 숫자 3개
    int[] com = new int[3]; // 컴퓨터가 숨진 숫자 3개

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
        } while (com[1] == com[0]); // com[0] 값과 com[1] 값이 같지 않도록(다를 때까지) 반복

        do {
            com[2] = Math.abs(r.nextInt() % 9) + 1;
        } while (com[2] == com[0] || com[2] == com[1]); // com[0], com[1], com[2] 값이 같지 않도록 (다를 때까지) 반복

        count = 0;
        key = 0;
        user[0] = user[1] = user[2] = 0;

        //GUI
        setLayout(new BorderLayout()); // 보더 레이아웃으로 저장

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

        buttons[0] = new Button("←");
        numPanel.add(buttons[0]);

        buttons[10] = new Button("다시 입력");
        numPanel.add(buttons[10]);

        buttons[11] = new Button("입력 완료");
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

        if (e.getSource() == buttons[0]) { // <- 버튼
            if (key > 0) {
                key--;
                display.setText("");
                for (int i = 0; i < key; i++) {
                    display.setText(display.getText() + user[i]);
                }
            }
        } else if (e.getSource() == buttons[10]) { //다시 입력 버튼
            key = 0;
            user[0] = user[1] = user[2] = 0;
            display.setText("");
        } else if (e.getSource() == buttons[11]) { //입력 완료 버튼
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
                        history.append("\n 평가 : A");
                    } else if (count <= 5) {
                        history.append("\n 평가 : B");
                    } else if (count <= 9) {
                        history.append("\n 평가 : C");
                    } else {
                        history.append("\n 평가 : D");
                    }

                    gameover = true;
                    display.setText(" Game Over !");
                    history.append("\n\n <<<게임 끝>>>");
                }
            } else {
                //숫자 3개 미만 누른 경우
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
                    //같은 숫자를 누른 경우
                } else {
                    display.setText(display.getText() + butVal);
                    key++;
                }
            } else {
                //숫자를 3개 이상 누른 경우
            }
        }
    }
}

