package Practice.AWT;

import java.applet.Applet;
import java.awt.*;

public class Prac_Container extends Applet {
    Button myButton1, myButton2;
    Label myLabel;
    Panel p1, p2;

    public void init() {
        p1 = new Panel(); // �г� ����
        p1.setBackground(Color.cyan);
        myButton1 = new Button("��ư#1");
        p1.add(myButton1); // p1�� ��ư �߰�
        myButton2 = new Button("��ư#2");
        p1.add(myButton2); // p1�� ��ư �߰�
        add(p1); // ���ø��� p1 �߰�

        p2 = new Panel();
        p2.setBackground(Color.red);
        myLabel = new Label("���̺�", Label.CENTER);
        myLabel.setBackground(Color.yellow);
        p2.add(myLabel);
        add(p2);
    }
}
