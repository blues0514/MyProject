package Practice.AWT.Canvas;

import java.applet.Applet;
import java.awt.*;

/*
Canvas(캔버스)는 아무런 형태도 정해지지 않은 컴포넌트
그냥 사용하는 경우는 거의 없고, 상속받아서 원하는 형태의 컴포넌트를 만드는 데 주로 쓰임
자바의 AWT가 제공하지 않는 컴포넌트를 만들고 싶을 때 유용
예를들어, 마우스가 다가가면 움직이는 그림 컴포넌트나 동그란 모양에 토클되는 버튼 컴포넌트 등을 만들고 싶을 때
캔버스 컴포넌트를 사옥받은 후, paint() 메소드를 오버라이딩해서 사용
 */
public class Prac_Canvas extends Canvas {

    public Prac_Canvas() {
        setBackground(Color.green);
        setSize(100,100);
    }

    public void paint(Graphics g) {
        g.drawString("내 캔버스", 10, 20); // 화면에 문자열 출력
        g.drawOval(40,40,50,50); // 화면에 타원을 출력
        g.drawLine(30,30,60,90); //화면에 선 출력
        g.drawRect(0,0,99,99); // 화면에 사각형 출력
    }
}
