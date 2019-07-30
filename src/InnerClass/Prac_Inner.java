package InnerClass;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Prac_Inner extends Applet {
    Label myLabel;
    int[] x, y;
    int num;

    public void init() {
        setLayout(new BorderLayout());
        myLabel = new Label("마우스로 클릭하면 원을 그립니다");
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

    class MyMouseHandler implements MouseListener {
        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }

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
