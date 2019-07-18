package Practice.AWT;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Prac_List extends Applet implements ActionListener, ItemListener {
    Label myLabel;
    List mylist;

    public void init() {

        mylist = new List(3,false); // ���߼����� �Ұ����� 3��¥�� ���ϼ��� ����Ʈ ����
        mylist.add("C���");
        mylist.add("C++���");
        mylist.add("�ڹ�");
        mylist.add("�Ľ�Į");
        mylist.addActionListener(this);
        mylist.addItemListener(this);
        add(mylist);

        myLabel = new Label("����Ʈ �׸��� �������ּ��� !");
        myLabel.setAlignment(Label.CENTER);
        myLabel.setBackground(Color.yellow);
        add(myLabel);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==mylist) {
            myLabel.setText("����Ŭ�� : " + mylist.getSelectedItem());
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getSource()==mylist) {
            myLabel.setText("Ŭ�� : " + mylist.getSelectedItem());
        }
    }
}
