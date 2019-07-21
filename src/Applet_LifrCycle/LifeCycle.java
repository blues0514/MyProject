package Applet_LifrCycle;

import java.applet.Applet;
import java.awt.*;

public class LifeCycle extends Applet {

    TextArea mTA;

    public void init() {
        setLayout(null);

        mTA = new TextArea(20,20); //(가로, 세로)
        mTA.setBounds(10,30,380,200); // 텍스트 에어리어를 (10,30) 위치에 가로 380, 세로 200 크기로 지정
        add(mTA);

        mTA.append("초기화 루틴 : init()\n");
    }

    public void start() {
        mTA.append("시작 루틴 : start()\n");
    }

    @Override
    public void stop() {
        mTA.append("정지 루틴 : stop()\n");
    }

    @Override
    public void destroy() {
        mTA.append("소멸 루틴 : destory()\n");
    }

    @Override
    public void paint(Graphics g) {
        mTA.append("페인팅 루틴 : paint()\n");

        g.drawString("애플릿의 라이프 사이클", 10, 20);
    }
}
