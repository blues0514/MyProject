package Practice.AWT;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Prac_Choice extends Applet implements ItemListener {
    Label myLabel;
    Choice myChoice;

    public void init() {
        myChoice = new Choice();
        myChoice.addItem("--����--");
        myChoice.addItem("C���");
        myChoice.addItem("C++���");
        myChoice.addItem("�ڹ�");
        myChoice.addItemListener(this);
        add(myChoice);

        myLabel = new Label("���̽� �׸��� �����ϼ���!");
        myLabel.setAlignment(Label.CENTER);
        myLabel.setBackground(Color.yellow);
        add(myLabel);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getSource()==myChoice) {
            myLabel.setText("���� : " + myChoice.getSelectedItem());
        }
    }
}
