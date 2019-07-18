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
        myChoice.addItem("--선택--");
        myChoice.addItem("C언어");
        myChoice.addItem("C++언어");
        myChoice.addItem("자바");
        myChoice.addItemListener(this);
        add(myChoice);

        myLabel = new Label("초이스 항목을 선택하세요!");
        myLabel.setAlignment(Label.CENTER);
        myLabel.setBackground(Color.yellow);
        add(myLabel);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getSource()==myChoice) {
            myLabel.setText("선택 : " + myChoice.getSelectedItem());
        }
    }
}
