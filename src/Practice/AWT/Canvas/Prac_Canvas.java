package Practice.AWT.Canvas;

import java.applet.Applet;
import java.awt.*;

/*
Canvas(ĵ����)�� �ƹ��� ���µ� �������� ���� ������Ʈ
�׳� ����ϴ� ���� ���� ����, ��ӹ޾Ƽ� ���ϴ� ������ ������Ʈ�� ����� �� �ַ� ����
�ڹ��� AWT�� �������� �ʴ� ������Ʈ�� ����� ���� �� ����
�������, ���콺�� �ٰ����� �����̴� �׸� ������Ʈ�� ���׶� ��翡 ��Ŭ�Ǵ� ��ư ������Ʈ ���� ����� ���� ��
ĵ���� ������Ʈ�� ������� ��, paint() �޼ҵ带 �������̵��ؼ� ���
 */
public class Prac_Canvas extends Canvas {

    public Prac_Canvas() {
        setBackground(Color.green);
        setSize(100,100);
    }

    public void paint(Graphics g) {
        g.drawString("�� ĵ����", 10, 20); // ȭ�鿡 ���ڿ� ���
        g.drawOval(40,40,50,50); // ȭ�鿡 Ÿ���� ���
        g.drawLine(30,30,60,90); //ȭ�鿡 �� ���
        g.drawRect(0,0,99,99); // ȭ�鿡 �簢�� ���
    }
}
