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

        mylist = new List(3,false); // 다중선택이 불가능한 3줄짜리 단일선택 리스트 생성
        mylist.add("C언어");
        mylist.add("C++언어");
        mylist.add("자바");
        mylist.add("파스칼");
        mylist.addActionListener(this);
        mylist.addItemListener(this);
        add(mylist);

        myLabel = new Label("리스트 항목을 선택해주세요 !");
        myLabel.setAlignment(Label.CENTER);
        myLabel.setBackground(Color.yellow);
        add(myLabel);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==mylist) {
            myLabel.setText("더블클릭 : " + mylist.getSelectedItem());
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getSource()==mylist) {
            myLabel.setText("클릭 : " + mylist.getSelectedItem());
        }
    }
}
