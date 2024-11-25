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

       //Button panel
        JPanel setButtonPanel = new JPanel(null);
        setButtonPanel.setPreferredSize(new Dimension(1500, 80));
        setButtonPanel.setOpaque(false);
        setButtonPanel.add(setAlarmButton);
        setAlarmButton.setBounds(290,10,50,50);
       //Edit set button
        button_Style.attributeStyle(setAlarmButton);
        setAlarmButton.setOpaque(false);

        //Add action listener to buttons
        setAlarmButton.addActionListener(e -> openSetAlarmFrame() );


        // Initialize the panel where alarms will be displayed
        alarmSlot = new JPanel();
        alarmSlot.setLayout(new BoxLayout(alarmSlot, BoxLayout.Y_AXIS));
        alarmSlot.setBackground(Color.BLACK);

        //add to main panel
        setButtonPanel.setMaximumSize(setButtonPanel.getPreferredSize());
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(setButtonPanel);
//        add(setAlarmButton);
        add(alarmSlot);
    }

    //Method to open the set timer frame
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
