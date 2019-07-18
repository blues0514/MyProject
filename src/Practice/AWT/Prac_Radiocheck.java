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

        myCheckbox1 = new Checkbox("C언어", false, group);
        myCheckbox1.addItemListener(this);
        add(myCheckbox1);

        myCheckbox2 = new Checkbox("C++언어", false, group);
        myCheckbox2.addItemListener(this);
        add(myCheckbox2);

        myCheckbox3 = new Checkbox("자바", true, group);
        myCheckbox3.addItemListener(this);
        add(myCheckbox3);

        myLabel = new Label("체크박스를 선택하세요!");
        myLabel.setAlignment(Label.CENTER);
        myLabel.setBackground(Color.yellow);
        add(myLabel);
    }
    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getSource()==myCheckbox1) {
            myLabel.setText("선택 : C언어");
        }else if(e.getSource()==myCheckbox2) {
            myLabel.setText("선택 : C++언어");
        }else if(e.getSource()==myCheckbox3) {
            myLabel.setText("선택 : 자바");
        }
    }
}
