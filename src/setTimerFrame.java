package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class setTimerFrame extends JFrame {

    private JButton startButton;
    private JPanel buttonPanel;
    private JPanel valuePanel;

    private JPanel hourPanel;
    private JPanel minutePanel;
    private JPanel secondPanel;

   private JButton upButton;
   private JButton downButton;

    public setTimerFrame() {
        //an ui for users to set timer
        setTitle("Set Timer");
        setSize(400,200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setBackground(Color.BLACK);

        //create a
        valuePanel = new JPanel();

        //hour panel
        hourPanel = new JPanel();
        hourPanel.setBackground(Color.BLACK);

        //minute Panel
        minutePanel = new JPanel();
        minutePanel.setBackground(Color.BLACK);

        // second panel
        secondPanel = new JPanel();
        secondPanel.setBackground(Color.BLACK);


        //add panel
        valuePanel.add(hourPanel);
        valuePanel.add(minutePanel);
        valuePanel.add(secondPanel);

        add(valuePanel);

    }

}
