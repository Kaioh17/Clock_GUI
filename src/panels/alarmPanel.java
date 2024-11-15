package src.panels;

import src.setFrames.setAlarmFrame;
import styles.*;

import javax.swing.*;
import java.awt.*;

public class alarmPanel  extends JPanel{

    private JPanel alarmSlot;
    private JButton setAlarmButton;

    public alarmPanel()
    {
       setBackground(Color.BLACK);

        //button to set alarm
       setAlarmButton = new JButton("+");
        button_Style.attributeStyle(setAlarmButton);//set button style
        setAlarmButton.setPreferredSize(new Dimension(55, 45));//override attribute style method to set new height
        setAlarmButton.setOpaque(true);

        //Add action listener to buttons
        setAlarmButton.addActionListener(e -> openSetAlarmFrame() );
       //add to main panel
        add(setAlarmButton);
    }

    //A method to open the set timer frame
    private void openSetAlarmFrame() {
        setAlarmFrame setFrame = new setAlarmFrame();
        setFrame.setVisible(true);
    }


}
