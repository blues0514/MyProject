package Practice.Adapter;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Prac_Adapter extends Applet {
    Label myLabel;
    int[] x, y;
    int num;

    public void init() {
        setLayout(new BorderLayout());
        myLabel = new Label("���콺�� Ŭ���ϸ� ���� �׸��ϴ�");
        myLabel.setAlignment(Label.CENTER);
        add("North", myLabel);

        x = new int[100];
        y = new int[100];
        num = 0;

        addMouseListener(new MyMouseHandler());
    }

    public void paint(Graphics g) {
        g.setColor(Color.red);

        for (int i = 0; i < num; i++) {
            g.fillOval(x[i] - 20, y[i] - 20, 40, 40);
        }
    }

    class MyMouseHandler extends MouseAdapter { // ����͸� ��ӹ��� ���� Ŭ������ ����
        @Override
        public void mouseClicked(MouseEvent e) {
            if (num < 100) {
                x[num] = e.getX();
                y[num] = e.getY();
                num++;
            }
            repaint();
        }
    }
}
