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
       setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

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

        // Initialize the panel where alarms will be displayed
        alarmSlot = new JPanel();
        alarmSlot.setLayout(new BoxLayout(alarmSlot, BoxLayout.Y_AXIS));
        alarmSlot.setBackground(Color.BLACK);
        add(alarmSlot);
    }

    //A method to open the set timer frame
    private void openSetAlarmFrame() {
        setAlarmFrame setFrame = new setAlarmFrame(this);
        setFrame.setVisible(true);
    }

    // Method to add alarms to the display panel
    public void addAlarm(String alarmText) {
        JLabel alarmLabel = new JLabel(alarmText);
        alarmLabel.setFont(font_Style.sansSerif.getFont());
        alarmLabel.setForeground(Color.WHITE);
        alarmSlot.add(alarmLabel);
        alarmSlot.revalidate();
        alarmSlot.repaint();
    }
}
