package Practice.AWT;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

public class Prac_TextArea extends Applet implements TextListener {
    Label myLabel;
    TextArea myTextArea;

    public void init() {
        setLayout(new BorderLayout()); // 보더 레이아웃으로 구성

        myTextArea = new TextArea(20,10);
        myTextArea.addTextListener(this);
        add("Center", myTextArea); // 중앙 구역에 myTextArea 추가

        myLabel = new Label("글을 입력해주세요!");
        myLabel.setAlignment(Label.CENTER);
        myLabel.setBackground(Color.yellow);
        add("South", myLabel); // 남쪽 구역에 myLabel 추가
    }
    @Override
    public void textValueChanged(TextEvent e) {
        if(e.getSource()==myTextArea) {
            myLabel.setText("입력 : " + myTextArea.getText());
        }
    }
}
