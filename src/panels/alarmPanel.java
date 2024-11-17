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

       //Add image icon
       ImageIcon addIcon = new ImageIcon("Clock_Gui/src/Import/add.png");
        Image scaledImage = addIcon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        //button to set alarm
       setAlarmButton = new JButton();
       setAlarmButton.setIcon(scaledIcon);



       //Edit set button
        button_Style.attributeStyle(setAlarmButton);
        setAlarmButton.setOpaque(false);


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
