package src;

import styles.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class stopWatchPanel extends JPanel{

    private JButton startButton;
    private JButton stopButton;
    private JButton resetButton;
    private JLabel stopWatchLabel;
    private JPanel buttonPanel;

    private Timer timer;
    private int elapsedTime; // in milliseconds



    public stopWatchPanel()
    {
        setLayout(new BorderLayout());

        //Initialize all component
        stopWatchLabel = new JLabel("00:00.00");
        stopWatchLabel.setFont(font_Style.ROMAN.getFont());

        

        buttonPanel = new JPanel();
        startButton = new JButton("Start");
        stopButton = new JButton("Stop");
        resetButton = new JButton("Reset");


        //add the buttons to the button panel
        buttonPanel.add(startButton);
        buttonPanel.add(stopButton);
        buttonPanel.add(resetButton);
        


        //Give the buttons functions
         // Timer to update the elapsed time
         timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                elapsedTime += 100; // Increment elapsed time by 100 ms
                updateTimeLabel();
            }
        });

         // Action listeners for the buttons
         startButton.addActionListener(e -> start());
         stopButton.addActionListener(e -> stop());
         resetButton.addActionListener(e -> reset());

         
         add(stopWatchLabel, BorderLayout.CENTER);
          add(buttonPanel, BorderLayout.SOUTH);
    }

    private void start()
    {
        timer.start();
    }

    private void stop()
    {
        timer.stop();
    }

    private void reset()
    {
        timer.stop();
        elapsedTime =0;
        updateTimeLabel();
    }

    private void updateTimeLabel() {
        int hours = (elapsedTime / 3600000) % 24;
        int minutes = (elapsedTime / 60000) % 60;
        int seconds = (elapsedTime / 1000) % 60;

        String timeString = String.format("%02d:%02d:%02d", hours, minutes, seconds);
        stopWatchLabel.setText(timeString);
    }

}
