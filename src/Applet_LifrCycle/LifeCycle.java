package Applet_LifrCycle;

import java.applet.Applet;
import java.awt.*;

public class LifeCycle extends Applet {

    TextArea mTA;

    public void init() {
        setLayout(null);

        mTA = new TextArea(20,20); //(����, ����)
        mTA.setBounds(10,30,380,200); // �ؽ�Ʈ ���� (10,30) ��ġ�� ���� 380, ���� 200 ũ��� ����
        add(mTA);

        mTA.append("�ʱ�ȭ ��ƾ : init()\n");
    }

    public void start() {
        mTA.append("���� ��ƾ : start()\n");
    }

    @Override
    public void stop() {
        mTA.append("���� ��ƾ : stop()\n");
    }

    @Override
    public void destroy() {
        mTA.append("�Ҹ� ��ƾ : destory()\n");
    }

    @Override
    public void paint(Graphics g) {
        mTA.append("������ ��ƾ : paint()\n");

        g.drawString("���ø��� ������ ����Ŭ", 10, 20);
    }
}
