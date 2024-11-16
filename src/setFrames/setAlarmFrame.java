package src.setFrames;

import styles.*;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class setAlarmFrame extends JFrame {

    public setAlarmFrame() {
        setTitle("Set Alarm");
        getContentPane().setBackground(new Color(106, 106, 106));
        setSize(400, 400);
        setLayout(new FlowLayout());
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        setTime();
    }

    private void setTime()
    {
        //Create a panel to set time
        JPanel setTimePanel = new JPanel();
        setTimePanel.setBackground(new Color(138, 137, 137));
        setTimePanel.setLayout(new FlowLayout());
//        setTimePanel.setBounds(0, 0, 400, 400);
        setTimePanel.setPreferredSize(new Dimension(300, 140));

        setTimePanel.add(upIcon());
        setTimePanel.add(timeField());
        setTimePanel.add(downIcon());


        File file = new File("Clock_Gui/src/Sounds/upIcon.png");

        System.out.println("File exists: " + file.exists());
        System.out.println("Absolute path: " + file.getAbsolutePath());

        add(setTimePanel, BorderLayout.CENTER);

    }

    public JLabel upIcon() {
//        JPanel upIconPanel = new JPanel();
        ImageIcon upIcon = new ImageIcon("Clock_Gui/src/Sounds/upIcon.png");
        Image scaledImage = upIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        JLabel upIconLabel = new JLabel(scaledIcon);

        return upIconLabel;
    }

    public JLabel downIcon() {
        ImageIcon upIcon = new ImageIcon("Clock_Gui/src/Sounds/downIcon.png");
        Image scaledImage = upIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        JLabel downIconLabel = new JLabel(scaledIcon);

        return downIconLabel;
    }

    public JTextField timeField()
    {
        JTextField timeField = new JTextField(3);
        return timeField;
    }

}
