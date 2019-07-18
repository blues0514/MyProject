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
        //(지정한 방향, start로 지정한 초기값, 버블 크기, 최소, 최대)
        myScrollbar.addAdjustmentListener(this);
        add("North", myScrollbar);

        myLabel = new Label("스크롤바 조정");
        myLabel.setAlignment(Label.CENTER);
        myLabel.setBackground(Color.yellow);
        add("Center", myLabel);
    }

    @Override
    public void adjustmentValueChanged(AdjustmentEvent e) {
        if(e.getSource()==myScrollbar) {
            myLabel.setText("위치 : " + myScrollbar.getValue());
        }
    }
}
