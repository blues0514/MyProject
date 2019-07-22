package Event;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class myActionEvent extends Applet implements ActionListener {
    Button bt1, bt2, bt3;
    TextArea ta;
    Panel pa;

    public void init() {
        setLayout(new BorderLayout());

        pa = new Panel();
        pa.setBackground(Color.yellow);

        bt1 = new Button("C언어");
        bt1.addActionListener(this);
        pa.add(bt1);

        bt2 = new Button("C++ 언어");
        bt2.addActionListener(this);
        pa.add(bt2);

        bt3 = new Button("JAVA");
        bt3.addActionListener(this);
        pa.add(bt3);

        add("North", pa);

        ta = new TextArea(50, 20);
        add("Center", ta);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bt1) {
            ta.append("C언어 선택\n");
        } else if (e.getSource() == bt2) {
            ta.append("C++선택 \n");
        } else {
            ta.append("JAVA 선택\n");
        }
    }
}
