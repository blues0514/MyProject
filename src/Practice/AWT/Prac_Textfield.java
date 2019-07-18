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
        //myTextField.setEchoChar('*');  // 입력한 문자 대신 *을 입력함 -> 비밀번호 입력할 때 주로 사용
        myTextField.addActionListener(this);
        myTextField.addTextListener(this);
        add(myTextField);

        myLabel = new Label("글을 입력해주세요!");
        myLabel.setAlignment(Label.CENTER);
        myLabel.setBackground(Color.yellow);
        add(myLabel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==myTextField) {
            myLabel.setText("입력완료!");
        }
    }

    @Override
    public void textValueChanged(TextEvent e) {
        if(e.getSource()==myTextField) {
            myLabel.setText("입력 : " + myTextField.getText());
        }
    }
}
