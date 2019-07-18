package Practice.AWT;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Prac_Radiocheck extends Applet implements ItemListener {
    Label myLabel;
    Checkbox myCheckbox1, myCheckbox2, myCheckbox3;
    CheckboxGroup group;

    public void init() {
        group = new CheckboxGroup();

        myCheckbox1 = new Checkbox("C���", false, group);
        myCheckbox1.addItemListener(this);
        add(myCheckbox1);

        myCheckbox2 = new Checkbox("C++���", false, group);
        myCheckbox2.addItemListener(this);
        add(myCheckbox2);

        myCheckbox3 = new Checkbox("�ڹ�", true, group);
        myCheckbox3.addItemListener(this);
        add(myCheckbox3);

        myLabel = new Label("üũ�ڽ��� �����ϼ���!");
        myLabel.setAlignment(Label.CENTER);
        myLabel.setBackground(Color.yellow);
        add(myLabel);
    }
    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getSource()==myCheckbox1) {
            myLabel.setText("���� : C���");
        }else if(e.getSource()==myCheckbox2) {
            myLabel.setText("���� : C++���");
        }else if(e.getSource()==myCheckbox3) {
            myLabel.setText("���� : �ڹ�");
        }
    }
}
