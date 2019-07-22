package LifeGame;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class LifeGame extends Applet implements ActionListener, MouseListener, Runnable {
    static final int maxX = 40; //������ ���� ũ��
    static final int maxY = 20; //������ ���� ũ��
    boolean map[][]; // ����
    int mapState[][]; // ������ �ִ� ������ ��
    int gen; // ����
    boolean nextGen; //���� ����� �������� ����

    Panel controlPanel;
    Label genLabel;
    Button startButton, stopButton;

    Thread clock; // ������

    public void init() {
        map = new boolean[maxX][maxY];
        mapState = new int[maxX][maxY];
        gen = 1;
        nextGen = false;

        //����Ʈ ����
        for (int x = 15; x < 25; x++) {
            for (int y = 10; y < 11; y++) {
                map[x][y] = true;
            }
        }

        //GUI
        setLayout(new BorderLayout());
        controlPanel = new Panel();
        controlPanel.setBackground(Color.BLUE);
        genLabel = new Label(gen + "����");
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
            clock.start(); //������ ����
        }
    }

    public void paint(Graphics g) {
        for (int x = 0; x < maxX; x++) {
            for (int y = 0; y < maxY; y++) {
                if (map[x][y]) {
                    g.fillRect(x * 10, y * 10, 10, 10); // ������ �ִ� ���
                } else {
                    g.drawRect(x * 10, y * 10, 10, 10); // ������ ���� ���
                }
            }
        }
    }

    public void stop() {
        if ((clock != null) && (clock.isAlive())) {
            clock = null; // �ð� ����(����)
        }
    }

    public void destroy() {
    }

    //������ ó�� ��ƾ
    public void run() {
        while (true) {
            try {
                clock.sleep(1000); //1�ʿ� �� ���� ������ �۵�
            } catch (InterruptedException e) {
            }

            if (nextGen) {
                makeNextGen(); // ���� ������ ���带 ����
                gen++; // ���� ����
                genLabel.setText(gen + "����");
                repaint(); // paint ȣ��
            }
        }
    }

    public void makeNextGen() {
        //set mapState
        for (int x = 0; x < maxX; x++) {
            for (int y = 0; y < maxY; y++) {
                if (map[x][y]) {
                    mapState[x][y] = 100; //������ �ִ� ���
                } else {
                    mapState[x][y] = 0; // ������ ���� ���
                }
            }
        }

        //countLife
        for (int x = 0; x < maxX; x++) {
            for (int y = 0; y < maxY; y++) {
                countLife(x, y); //(x,y) ��ġ�� ���� ������ �ִ� ������ ���� ����
            }
        }

        //next Generation
        for (int x = 0; x < maxX; x++) {
            for (int y = 0; y < maxY; y++) {
                switch (mapState[x][y]) {
                    case 3:
                    case 102:
                    case 103:
                        map[x][y] = true; // ������ ��� �����ϰų� ���� �¾�� ���
                        break;
                    default:
                        map[x][y] = false; // ������ �Ҹ��ϴ� ���
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

    // ��ư ó��
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            nextGen = true;
            startButton.setEnabled(false); //START��ư�� ���� �� ������ ����
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
