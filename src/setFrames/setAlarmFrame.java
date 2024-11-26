package src.setFrames;

import styles.*;
//import src.alarmMemory;

import javax.print.attribute.standard.Media;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import src.panels.alarmPanel;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ArrayList;

public class setAlarmFrame extends JFrame {

    private JPanel setTimePanel;
    private JFrame setDaysFrame;
    private JTextField hourField;
    private JTextField minuteField;
    private JTextField AmPmField;
    private JLabel selectedDaysLabel = new JLabel(" ");
    private JCheckBox[] dayCheckboxes = new JCheckBox[7]; // Array to hold checkboxes for days
    private List<alarmMemory> alarms = new ArrayList<>();
    private alarmPanel parentPanel;


    class alarmMemory {
        private String time;
        private String days;
        private boolean triggeredToday;
        // Default to false

        private alarmMemory(String time, String days) {
            this.time = time;
            this.days = days;
            this.triggeredToday = false;
        }

        public String getTime() {
            return time;
        }
        public String getDays() {
            return days;
        }
        public boolean isTriggeredToday() {
            return triggeredToday;
        }

        public void setTriggeredToday(boolean triggered) {
            this.triggeredToday = triggered;
        }
    }


    public setAlarmFrame(alarmPanel parentPanel) {
        this.parentPanel = parentPanel;
        setTitle("Set Alarm");
        getContentPane().setBackground(new Color(106, 106, 106));
//        setSize(400, 400);
        setBounds(200, 200, 400, 400);
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        setTime();
        setDays();
        setSaveButton();
        setCancelButton();
        startAlarmCheck();

    }

    //Method to set the time (hh:mm a)
    private void setTime()
    {
        //Create a panel to set time
        setTimePanel = new JPanel();
        setTimePanel.setBackground(new Color(138, 137, 137));
        setTimePanel.setLayout(null);
        setTimePanel.setBounds(0, 0, 400, 140);


        setHour();
        setMinute();
        setAmPm();


        add(setTimePanel, BorderLayout.CENTER);

    }

    //Method used see days selected and button to select the days
    private void setDays() {
        JPanel setDayButtonPanel = new JPanel();
        JButton setDayButton = new JButton("Set Day");

        //Edit button
        button_Style.stopStyle(setDayButton);
        setDayButton.setOpaque(false);
        setDayButton.setForeground(new Color(81, 80, 80, 176));

        setDayButtonPanel.setLayout(null);
        setDayButtonPanel.setBackground(new Color(138, 137, 137));
        setDayButtonPanel.setBounds(0, 150, 400, 50);

        setDayButton.setBounds(30, 10, 110, 30);

        //Configure the selectDaysLabel
        selectedDaysLabel.setBounds(180,10,200,30);
        selectedDaysLabel.setFont(font_Style.roman.getFont());
        selectedDaysLabel.setForeground(Color.WHITE);


        //Add action listeners
        setDayButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               setDaysFrame();
            }
        });
        setDayButtonPanel.add(setDayButton);
        setDayButtonPanel.add(selectedDaysLabel);
        add(setDayButtonPanel);
    }

    //Method to create a new frame to set the days
    private void setDaysFrame() {
         setDaysFrame = new JFrame();

        //edit frame
        setDaysFrame.getContentPane().setBackground(new Color(106, 106, 106));
        setDaysFrame.setTitle("Set Days");
        setDaysFrame.setLayout(null);
        setDaysFrame.setBounds(0, 0, 400, 400);

        selectDays();

        setDaysFrame.setVisible(true);
    }


    //Create a method to
    private void selectDays() {
         JPanel selectDayPanel = new JPanel();
        selectDayPanel.setBackground(new Color(138, 137, 137));
        selectDayPanel.setLayout(new BoxLayout(selectDayPanel, BoxLayout.Y_AXIS));
        selectDayPanel.setBounds(25, 5, 330, 330);

        String[] days =  {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        //Create and add checkboxes for each day
        for(int i=0; i<days.length; i++){

            dayCheckboxes[i] = new JCheckBox(days[i]);
            dayCheckboxes[i].setBackground(new Color(138, 137, 137));
            dayCheckboxes[i].setFont(font_Style.roman.getFont());
            dayCheckboxes[i].setFocusPainted(false);
            dayCheckboxes[i].setPreferredSize(new Dimension(150, 25));
            selectDayPanel.add(Box.createVerticalStrut(5));
            selectDayPanel.add(dayCheckboxes[i]);
        }

        JButton confirmButton = new JButton("Confirm");
        button_Style.attributeStyle(confirmButton);
        confirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sendSelectedDays();
                setDaysFrame.dispose();
            }
        });
        //Create spacing between the checkboxes and button
        selectDayPanel.add(Box.createVerticalStrut(10));
        selectDayPanel.add(Box.createHorizontalStrut(3));

        //Add confirm button and select days panel
        selectDayPanel.add(confirmButton);
        setDaysFrame.add(selectDayPanel);
    }
    //Method to send in the data gotten from the selected days
    private void sendSelectedDays() {
        StringBuilder selectedDays = new StringBuilder();
        for(JCheckBox checkBox : dayCheckboxes){
            if(checkBox.isSelected()){
                if(selectedDays.length() > 0) selectedDays.append(", ");
                selectedDays.append(checkBox.getText());
            }
        }

        //Update days label with the select days
        if(selectedDays.length() > 0)  selectedDaysLabel.setText(" " + selectedDays.toString());
         else selectedDaysLabel.setText("Selected Days: None");
    }


    //Method to set Am or Pm
    private void setAmPm() {
        JPanel setAmPm = new JPanel();
        setAmPm.setBackground(new Color(122, 100, 100));
        setAmPm.setBounds(205, 24, 50, 100);
        setAmPm.setLayout(new GridLayout(3,1));
        setAmPm.setOpaque(false);
        JPanel AmPmPanel = new JPanel();

        //Text field panel
        AmPmPanel.setLayout(new FlowLayout());
        AmPmPanel.setBackground(new Color(244, 54, 54));
        AmPmPanel.setOpaque(false);

         AmPmField = new JTextField("AM", 2);

        //Edit text field
        AmPmField.setOpaque(false);
        AmPmField.setFont(font_Style.sansSerif.getFont());
        AmPmField.setBorder(null);
        AmPmField.setHorizontalAlignment(JTextField.CENTER);
        AmPmField.setFocusable(false);
        AmPmField.setPreferredSize(new Dimension(20, 22));
        AmPmField.setEditable(false);
        AmPmPanel.add(AmPmField);

        //set new objects for the icon methods
        JLabel upAmPmIcon = upIcon();
        JLabel downAmPmIcon = downIcon();


        upAmPmIcon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(AmPmField.getText().equals("AM")) AmPmField.setText("PM");
                else AmPmField.setText("AM");
            }
        });

        downAmPmIcon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(AmPmField.getText().equals("PM")) AmPmField.setText("AM");
                else AmPmField.setText("PM");
            }
        });

        setAmPm.add(upAmPmIcon);
        setAmPm.add(AmPmPanel);
        setAmPm.add(downAmPmIcon);
        setTimePanel.add(setAmPm);
    }

    //Method to set Hour value
    private void setHour() {
        JPanel setHourPanel = new JPanel();
        setHourPanel.setBackground(new Color(122, 100, 100));
        setHourPanel.setBounds(125, 24, 50, 100);
        setHourPanel.setLayout(new GridLayout(3,1));
        setHourPanel.setOpaque(false);JPanel timeFieldPanel = new JPanel();

        //Text field panel
        timeFieldPanel.setLayout(new FlowLayout());
        timeFieldPanel.setBackground(new Color(244, 54, 54));
        timeFieldPanel.setOpaque(false);
        //to set to current time
        LocalDateTime now = LocalDateTime.now();
        String currentTime = now.format(DateTimeFormatter.ofPattern("hh"));

         hourField = new JTextField(currentTime, 2);

        //Edit text field
        hourField.setOpaque(false);
        hourField.setFont(font_Style.sansSerif.getFont());
        hourField.setBorder(null);
        hourField.setHorizontalAlignment(JTextField.CENTER);
        hourField.setFocusable(false);
        hourField.setPreferredSize(new Dimension(20, 22));
        hourField.setEditable(false);
        timeFieldPanel.add(hourField);

        //set new objects for the icon methods
        JLabel upHourIcon = upIcon();
        JLabel downHourIcon = downIcon();


        upHourIcon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                incrementTime(hourField, 12);
            }

        });

        downHourIcon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                decrementTime(hourField, 0);
            }
        });

        setHourPanel.add(upHourIcon);
       setHourPanel.add(timeFieldPanel);
        setHourPanel.add(downHourIcon);
        setTimePanel.add(setHourPanel);
    }

    //Method to set minute value
    private void setMinute() {
        JPanel setMinutePanel = new JPanel();
        setMinutePanel.setBackground(new Color(122, 100, 100));
        setMinutePanel.setBounds(165, 24, 50, 100);
        setMinutePanel.setLayout(new GridLayout(3,1));
        setMinutePanel.setOpaque(false);JPanel timeFieldPanel = new JPanel();

        //Text field panel
        timeFieldPanel.setLayout(new FlowLayout());
        timeFieldPanel.setBackground(new Color(244, 54, 54));
        timeFieldPanel.setOpaque(false);
        LocalDateTime now = LocalDateTime.now();
        //To set current time
          String currentTime = now.format(DateTimeFormatter.ofPattern("mm"));
         minuteField = new JTextField(currentTime, 2);

        //Edit text field
        minuteField.setOpaque(false);
        minuteField.setFont(font_Style.sansSerif.getFont());
        minuteField.setBorder(null);
        minuteField.setHorizontalAlignment(JTextField.CENTER);
        minuteField.setFocusable(false);
        minuteField.setPreferredSize(new Dimension(20, 22));
        minuteField.setEditable(false);
        timeFieldPanel.add(minuteField);

        //set new objects for the icon methods
        JLabel upMinuteIcon = upIcon();
        JLabel downMinuteIcon = downIcon();


        upMinuteIcon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                incrementTime(minuteField, 59);
            }
        });

        downMinuteIcon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                decrementTime(minuteField, 0);
            }
        });

        setMinutePanel.add(upMinuteIcon);
        setMinutePanel.add(timeFieldPanel);
        setMinutePanel.add(downMinuteIcon);
        setTimePanel.add(setMinutePanel);
    }

    //A cancel method to dispose the frame on click
    private void setCancelButton() {
        JButton cancelButton = new JButton("Cancel");

        //Button style
        button_Style.stopStyle(cancelButton);
        cancelButton.setBounds(40, 300, 150, 50);

        //Add action listeners
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        add(cancelButton);
    }

    //Create save Button method to save Button
    private void setSaveButton() {
        JButton saveButton = new JButton("Save");

        //Button style
        button_Style.attributeStyle(saveButton);
        saveButton.setBounds(200, 300, 150, 50);

        //Add action listener
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("button clicked");
                saveAlarm();

            }
        });

        add(saveButton);
    }

    //save alarm method (implementing the right functions
    private void saveAlarm() {
        // Get selected time
       String hour = hourField.getText();
       String minute = minuteField.getText();
       String amPm = AmPmField.getText();
       String time = hour + ":" + minute + " " + amPm;

        // Get selected days
        String days = selectedDaysLabel.getText().replace("Selected Days: ", "");

        if (days.equals("None")) {
            days = "No days selected";
        }
        // Create and store alarm
        alarmMemory alarm = new alarmMemory(time, days);
        alarms.add(alarm);

        // Send alarm to the parent panel
        if (parentPanel != null) {
            parentPanel.addAlarm(time + " : " + days);
            parentPanel.revalidate();
            parentPanel.repaint();
        }

        // Close the frame
        dispose();

    }
    //Method for up icon label
    private JLabel upIcon() {

        ImageIcon upIcon = new ImageIcon("Clock_Gui/src/Import/upIcon.png");
        Image scaledImage = upIcon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        JLabel upIconLabel = new JLabel(scaledIcon);
        upIconLabel.setHorizontalAlignment(SwingConstants.CENTER);
        upIconLabel.setVerticalAlignment(SwingConstants.BOTTOM);

        return upIconLabel;
    }

    //Method for down icon label
    public JLabel downIcon() {
        ImageIcon upIcon = new ImageIcon("Clock_Gui/src/Import/down.png");
        Image scaledImage = upIcon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        JLabel downIconLabel = new JLabel(scaledIcon);

        return downIconLabel;
    }

    //Method to values time by 1
    private void incrementTime(JTextField field, int max) {
        int currentTime = Integer.parseInt(field.getText());
        if(currentTime < max) field.setText(String.format("%02d", currentTime + 1));
        else field.setText("01");
    }

    //Method to Decrement values by 1
    private void decrementTime(JTextField field, int min) {
        int currentTime = Integer.parseInt(field.getText());
        if(currentTime > min) field.setText(String.format("%02d", currentTime - 1));
        else field.setText("12");
    }

    //method to run a timer every 1 second to check the alarm every 1second
    private Timer timer;
    private void startAlarmCheck() {
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkAlarms();
            }
        });
        timer.start();
    }


    //Method to check alarm every second
    private void checkAlarms() {
        //Get Current time and date
        LocalDateTime now = LocalDateTime.now();
        String currentDay = now.getDayOfWeek().toString();
        String currentTime = now.format(DateTimeFormatter.ofPattern("hh:mm a"));

        for (alarmMemory alarm : alarms) {
            String alarmTime = alarm.getTime(); // Retrieve the alarm time in hh:mm AM/PM format
            String alarmDays = alarm.getDays(); // Retrieve the alarm days as a comma-separated string (e.g., "Monday, Tuesday")

            // Check if the current time matches the alarm time
            if (currentTime.equals(alarmTime)) {
                // Check if the current day is included in the alarm days
                if (alarmDays.equals("No days selected") || alarmDays.toUpperCase().contains(currentDay)) {
                    if(!alarm.isTriggeredToday())
                    {
                        triggerAlarm(alarmTime, alarmDays); // Trigger the alarm
                        alarm.setTriggeredToday(true); // Mark as triggered for today
                    }
                }
            }
        }
    }

    //Method to trigger alarm
    private void triggerAlarm(String alarmTime, String alarmDays) {
        System.out.println("It is time");
        playSound();
        JOptionPane.showMessageDialog(this, "Alarm! Time: " + alarmTime + "\nDays: "
                + alarmDays, "Alarm Triggered", JOptionPane.INFORMATION_MESSAGE);

    }

    // Method to play a beep sound
    private void playSound() {
        try {
            // Use a short beep sound
            Clip clip = AudioSystem.getClip();
            InputStream audioSrc = getClass().getResourceAsStream("/src/Import/bark.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(new BufferedInputStream(audioSrc));
            clip.open(audioStream);
            clip.start();


            // Play the sound
            System.out.println("Sound played");
        } catch (Exception ex) {
            System.err.println("Error playing sound: " + ex.getMessage());
        }
    }
}
