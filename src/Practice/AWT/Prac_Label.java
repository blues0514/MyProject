package Practice.AWT;

import java.applet.*;
import java.awt.*;

public class Prac_Label extends Applet {
    Label myLabel1, myLabel2, myLabel3;

    public void init() {
        myLabel1 = new Label();
        myLabel1.setText("C ���");
        myLabel1.setAlignment(Label.LEFT); // ���̺��� ���� ���ķ� ����
        myLabel1.setBackground(Color.cyan);
        add(myLabel1);

        myLabel2=new Label("C++ ���");
        myLabel2.setAlignment(Label.CENTER); // ���̺��� ��� ���ķ� ����
        myLabel2.setBackground(Color.GREEN);
        add(myLabel2);

        myLabel3 = new Label("�ڹ�", Label.RIGHT); // ���̺��� ������ ���ķ� ����
        myLabel3.setBackground(Color.yellow);
        add(myLabel3);
    }
}
