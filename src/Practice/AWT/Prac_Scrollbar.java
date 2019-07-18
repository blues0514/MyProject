package Practice.AWT;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

public class Prac_Scrollbar extends Applet implements AdjustmentListener {
    Label myLabel;
    Scrollbar myScrollbar;

    public void init() {
        setLayout(new BorderLayout());

        myScrollbar = new Scrollbar(Scrollbar.HORIZONTAL, 50, 0, 1, 100);
        //(������ ����, start�� ������ �ʱⰪ, ���� ũ��, �ּ�, �ִ�)
        myScrollbar.addAdjustmentListener(this);
        add("North", myScrollbar);

        myLabel = new Label("��ũ�ѹ� ����");
        myLabel.setAlignment(Label.CENTER);
        myLabel.setBackground(Color.yellow);
        add("Center", myLabel);
    }

    @Override
    public void adjustmentValueChanged(AdjustmentEvent e) {
        if(e.getSource()==myScrollbar) {
            myLabel.setText("��ġ : " + myScrollbar.getValue());
        }
    }
}
