package Practice.AWT;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

public class Prac_TextArea extends Applet implements TextListener {
    Label myLabel;
    TextArea myTextArea;

    public void init() {
        setLayout(new BorderLayout()); // ���� ���̾ƿ����� ����

        myTextArea = new TextArea(20,10);
        myTextArea.addTextListener(this);
        add("Center", myTextArea); // �߾� ������ myTextArea �߰�

        myLabel = new Label("���� �Է����ּ���!");
        myLabel.setAlignment(Label.CENTER);
        myLabel.setBackground(Color.yellow);
        add("South", myLabel); // ���� ������ myLabel �߰�
    }
    @Override
    public void textValueChanged(TextEvent e) {
        if(e.getSource()==myTextArea) {
            myLabel.setText("�Է� : " + myTextArea.getText());
        }
    }
}
