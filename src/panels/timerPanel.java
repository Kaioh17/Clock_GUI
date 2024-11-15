package src.panels;

import java.awt.*;
import javax.sound.sampled.*;
import java.io.*;
import javax.swing.*;

import styles.*;


public class timerPanel extends JPanel implements setTimerFrame.TimerCallback {
    
   private JLabel timerLabel;
   private Timer timer;
   private JButton setButton;
   private JButton pauseButton;
   private JButton startorResetButton;
   private JPanel buttonPanel;
   private JButton resetButton;

   private int hours= 0;
    private int minutes= 0;
    private int seconds= 0;
    private boolean isPaused= false;
    private boolean isRunning= false;

    
    public timerPanel()
    {
        //edit panel
        setLayout(new BorderLayout());
        setBackground(Color.black);

         //timer label   (00:00:00)
         timerLabel = new JLabel(formatTime(hours, minutes, seconds));
         timerLabel.setFont(font_Style.ROMAN.getFont());
         timerLabel.setHorizontalAlignment(SwingConstants.CENTER);
         timerLabel.setForeground(Color.WHITE);


         //initialize components
         buttonPanel = new JPanel();
         setButton = new JButton("Set");//set will prompt a new frame to set timer
         pauseButton = new JButton("Paused");
         startorResetButton = new JButton("Start");
       


         //edit button panel
         buttonPanel.setBackground(Color.BLACK);
         buttonPanel.setLayout(new FlowLayout());

        //set button functions
        setButton.addActionListener(e -> openSetTimerFrame());
        startorResetButton.addActionListener(e -> startResetTimer());
        pauseButton.addActionListener(e -> pauseTimer());
//        resetButton.addActionListener(e -> resetTimer());

         //edit button
        button_Style.attributeStyle(setButton,startorResetButton);
        button_Style.stopStyle(pauseButton);

        //add buttons to the panel
         buttonPanel.add(setButton);
         buttonPanel.add(pauseButton);
         buttonPanel.add(startorResetButton);

         add(timerLabel, BorderLayout.CENTER);
         add(buttonPanel, BorderLayout.SOUTH);
    }


    private void startResetTimer()
    {
        if(isRunning){
            resetTimer();
            startorResetButton.setText("start");
        }
        else {
            startTimer();
            startorResetButton.setText("Reset");
        }
        isRunning= !isRunning;

    }

    // Timer functions
    private void startTimer() {


            if (timer != null && timer.isRunning()) return;


            timer = new Timer(1000, e -> {
                if (!isPaused) {
                    if (seconds > 0) seconds--;
                    else if (minutes > 0) {
                        minutes--;
                        seconds = 59;
                    } else if (hours > 0) {
                        hours--;
                        minutes = 59;
                        seconds = 59;
                    } else {
                        timer.stop();
                        notifyTimerFinished();
                        startorResetButton.setText("Start");
                        isRunning= false;

                    }
                    updateTimerLabel();
                }
            });

            timer.start();
    }

    private void notifyTimerFinished() {
        playSound();
        JOptionPane.showMessageDialog(null, "Time's up!", "Timer", JOptionPane.INFORMATION_MESSAGE);
        System.out.println("Time's up!");
    }

    // Method to play a beep sound
    private void playSound() {
        try {
            // Use a short beep sound
            Clip clip = AudioSystem.getClip();
            InputStream audioSrc = getClass().getResourceAsStream("/Sounds/bark.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(new BufferedInputStream(audioSrc));
            clip.open(audioStream);
            clip.start();
            System.out.println("Sound played");
        } catch (Exception ex) {
            System.err.println("Error playing sound: " + ex.getMessage());
        }
    }


    //pause Timer
    private void pauseTimer() {
        isPaused= !isPaused;

        if(isPaused) {
            pauseButton.setText("Resume");
            button_Style.resumeStyle(pauseButton);
        }

        else {
            pauseButton.setText("Paused");
            button_Style.stopStyle(pauseButton);
        }
    }

    //reset timer
    private void resetTimer() {
        if(timer !=null) timer.stop();
        hours= 0;
        minutes= 0;
        seconds= 0;
        isPaused= false;
        pauseButton.setText("Paused");
        updateTimerLabel();
    }

    //Create a format for the display
    private String formatTime(int hours, int minutes, int seconds) {
        return String.format("%02d:%02d.%02d", hours, minutes, seconds);
    }

    //create a new frame to set timer
    private void openSetTimerFrame() {
        setTimerFrame setFrame = new setTimerFrame(this);
        setFrame.setVisible(true);
    }

    //implementing the call back method
    @Override
    public void onTimeSet(int hour,int minute,int second) {
        this.hours = hour;
        this.minutes = minute;
        this.seconds = second;

        updateTimerLabel();
    }

    // Update the timer label
    private void updateTimerLabel() {
        timerLabel.setText(formatTime(hours, minutes, seconds));
    }
    

}

