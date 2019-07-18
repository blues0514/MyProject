package Practice.AWT;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

public class Prac_Textfield extends Applet implements ActionListener, TextListener {
    Label myLabel;
    TextField myTextField;

    public void init() {
        myTextField = new TextField(20);
        //myTextField.setEchoChar('*');  // �Է��� ���� ��� *�� �Է��� -> ��й�ȣ �Է��� �� �ַ� ���
        myTextField.addActionListener(this);
        myTextField.addTextListener(this);
        add(myTextField);

        myLabel = new Label("���� �Է����ּ���!");
        myLabel.setAlignment(Label.CENTER);
        myLabel.setBackground(Color.yellow);
        add(myLabel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==myTextField) {
            myLabel.setText("�Է¿Ϸ�!");
        }
    }

    @Override
    public void textValueChanged(TextEvent e) {
        if(e.getSource()==myTextField) {
            myLabel.setText("�Է� : " + myTextField.getText());
        }
    }
}
