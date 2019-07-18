package Practice.AWT;

import java.applet.Applet;
import java.awt.*;

public class Prac_Container extends Applet {
    Button myButton1, myButton2;
    Label myLabel;
    Panel p1, p2;

    public void init() {
        p1 = new Panel(); // 패널 생성
        p1.setBackground(Color.cyan);
        myButton1 = new Button("버튼#1");
        p1.add(myButton1); // p1에 버튼 추가
        myButton2 = new Button("버튼#2");
        p1.add(myButton2); // p1에 버튼 추가
        add(p1); // 애플릿에 p1 추가

        p2 = new Panel();
        p2.setBackground(Color.red);
        myLabel = new Label("레이블", Label.CENTER);
        myLabel.setBackground(Color.yellow);
        p2.add(myLabel);
        add(p2);
    }
}
