package LifeGame;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class LifeGame extends Applet implements ActionListener, MouseListener, Runnable {
    static final int maxX = 40; //월드의 가로 크기
    static final int maxY = 20; //월드의 세로 크기
    boolean map[][]; // 월드
    int mapState[][]; // 주위에 있는 생명의 수
    int gen; // 세대
    boolean nextGen; //다음 세대로 진행할지 여부

    Panel controlPanel;
    Label genLabel;
    Button startButton, stopButton;

    Thread clock; // 쓰레드

    public void init() {
        map = new boolean[maxX][maxY];
        mapState = new int[maxX][maxY];
        gen = 1;
        nextGen = false;

        //디폴트 상태
        for (int x = 15; x < 25; x++) {
            for (int y = 10; y < 11; y++) {
                map[x][y] = true;
            }
        }

        //GUI
        setLayout(new BorderLayout());
        controlPanel = new Panel();
        controlPanel.setBackground(Color.BLUE);
        genLabel = new Label(gen + "세대");
        genLabel.setAlignment(Label.CENTER);
        genLabel.setBackground(Color.yellow);
        controlPanel.add(genLabel);
        startButton = new Button("START");
        startButton.addActionListener(this);
        controlPanel.add(startButton);
        stopButton = new Button("STOP");
        stopButton.setEnabled(false);
        stopButton.addActionListener(this);
        controlPanel.add(stopButton);
        add("South", controlPanel);

        addMouseListener(this);
    }

    public void start() {
        if (clock == null) {
            clock = new Thread(this);
            clock.start(); //쓰레드 시작
        }
    }

    public void paint(Graphics g) {
        for (int x = 0; x < maxX; x++) {
            for (int y = 0; y < maxY; y++) {
                if (map[x][y]) {
                    g.fillRect(x * 10, y * 10, 10, 10); // 생명이 있는 경우
                } else {
                    g.drawRect(x * 10, y * 10, 10, 10); // 생명이 없는 경우
                }
            }
        }
    }

    public void stop() {
        if ((clock != null) && (clock.isAlive())) {
            clock = null; // 시계 정지(없앰)
        }
    }

    public void destroy() {
    }

    //쓰레드 처리 루틴
    public void run() {
        while (true) {
            try {
                clock.sleep(1000); //1초에 한 번씩 쓰레드 작동
            } catch (InterruptedException e) {
            }

            if (nextGen) {
                makeNextGen(); // 다음 세대의 월드를 구함
                gen++; // 세대 증가
                genLabel.setText(gen + "세대");
                repaint(); // paint 호출
            }
        }
    }

    public void makeNextGen() {
        //set mapState
        for (int x = 0; x < maxX; x++) {
            for (int y = 0; y < maxY; y++) {
                if (map[x][y]) {
                    mapState[x][y] = 100; //생명이 있는 경우
                } else {
                    mapState[x][y] = 0; // 생명이 없는 경우
                }
            }
        }

        //countLife
        for (int x = 0; x < maxX; x++) {
            for (int y = 0; y < maxY; y++) {
                countLife(x, y); //(x,y) 위치의 생명 주위에 있는 생명의 수를 구함
            }
        }

        //next Generation
        for (int x = 0; x < maxX; x++) {
            for (int y = 0; y < maxY; y++) {
                switch (mapState[x][y]) {
                    case 3:
                    case 102:
                    case 103:
                        map[x][y] = true; // 생명이 계속 존재하거나 새로 태어나는 경우
                        break;
                    default:
                        map[x][y] = false; // 생명이 소멸하는 경우
                        break;
                }
            }
        }
    }

    public void countLife(int x, int y) {
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if ((i != 0) || (j != 0)) {
                    if ((x + i) >= 0 && (x + i < maxX) && (y + j >= 0) && (y + j < maxY)) {
                        if (map[x + i][y + j]) {
                            mapState[x][y]++;
                        }
                    }
                }
            }
        }
    }

    // 버튼 처리
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            nextGen = true;
            startButton.setEnabled(false); //START버튼을 누를 수 없도록 변경
            stopButton.setEnabled(true);
        } else if (e.getSource() == stopButton) {
            nextGen = false;
            startButton.setEnabled(true);
            stopButton.setEnabled(false);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int mouseX = e.getX();
        int mouseY = e.getY();
        map[mouseX / 10][mouseY / 10] = !map[mouseX / 10][mouseY / 10];
        repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
