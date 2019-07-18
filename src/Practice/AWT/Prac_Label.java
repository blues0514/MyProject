package Practice.AWT;

import java.applet.*;
import java.awt.*;

public class Prac_Label extends Applet {
    Label myLabel1, myLabel2, myLabel3;

    public void init() {
        myLabel1 = new Label();
        myLabel1.setText("C 언어");
        myLabel1.setAlignment(Label.LEFT); // 레이블을 왼쪽 정렬로 저장
        myLabel1.setBackground(Color.cyan);
        add(myLabel1);

        myLabel2=new Label("C++ 언어");
        myLabel2.setAlignment(Label.CENTER); // 레이블을 가운데 정렬로 저장
        myLabel2.setBackground(Color.GREEN);
        add(myLabel2);

        myLabel3 = new Label("자바", Label.RIGHT); // 레이블을 오른쪽 정렬로 저장
        myLabel3.setBackground(Color.yellow);
        add(myLabel3);
    }
}
