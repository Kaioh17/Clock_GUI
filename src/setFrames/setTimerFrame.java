package src.setFrames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import styles.*;

public class setTimerFrame extends JFrame {

    private JButton clearButton;
    private  JPanel valuePanel;
    private JButton upButton;
    private JButton downButton;
    private JTextField numberField;
    protected int hour;
    private int minute;
    private int second;
    public TimerCallback callback;

    public setTimerFrame(TimerCallback callback) {
        this.callback = callback;
        //create an ui for users to set timer
        setTitle("Set Timer");
        setSize(400, 280);
        getContentPane().setBackground(new Color(106, 106, 106));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLayout(new GridLayout(2,1));





        setTimerPanel();
    }

    private void setTimerPanel() {
        //create a panel to contain the
        valuePanel = new JPanel();
        valuePanel.setBackground(new Color(138, 137, 137));
        valuePanel.setLayout(null);
        valuePanel.setBounds(0, 0, 400, 140);
//        valuePanel.setPreferredSize(new Dimension(200, 50));


        JButton startButton = new JButton("Set Alarm");
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(106, 106, 106));
        buttonPanel.setLayout(null);
        buttonPanel.setBounds(0, 0, 400, 40);
        startButton.setBounds(100,40,150,50);
        buttonPanel.add(startButton);


        button_Style.attributeStyle(startButton);
        startButton.addActionListener(e -> {
            if (callback != null) callback.onTimeSet(hour,minute,second);
            dispose();// Close this frame

        });

        //add the methods to the panel
        setHourValue();
        setMinuteValue();
        setSecondValue();

        add(valuePanel, BorderLayout.SOUTH);
        add(buttonPanel, BorderLayout.NORTH);

    }

    private void setHourValue()
    {
        JPanel setHourPanel = new JPanel();
        setHourPanel.setBackground(new Color(122, 100, 100));
        setHourPanel.setBounds(125, 24, 50, 100);
        setHourPanel.setLayout(new GridLayout(3,1));
        setHourPanel.setOpaque(false);

        //Text field panel
        JPanel timeFieldPanel = new JPanel();
        timeFieldPanel.setLayout(new FlowLayout());
        timeFieldPanel.setBackground(new Color(244, 54, 54));
        timeFieldPanel.setOpaque(false);

        //Initialize the hour field to show the current hour
        JTextField hourField = new JTextField(String.valueOf(hour), 3);

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
                try{
                    if(hour <= 23) hour++;// to increment as long as hour not greater than 24
                    else hour=0;
                    hourField.setText(String.valueOf(hour));
                }
                catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Error updating hour" +ex.getMessage(),"error", JOptionPane.ERROR_MESSAGE);
                }

            }
        });

        downHourIcon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try
                {
                    if(hour > 0)hour-- ;
                    else hour = 23;
                    hourField.setText(String.valueOf(hour));
                }
                catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Error updating hour" +ex.getMessage(),"error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        setHourPanel.add(upHourIcon);
        setHourPanel.add(timeFieldPanel);
        setHourPanel.add(downHourIcon);
        valuePanel.add(setHourPanel);
    }

    //Set minute value
    private void setMinuteValue()
    {
        JPanel serMinutePanel = new JPanel();
        serMinutePanel.setBackground(new Color(122, 100, 100));
        serMinutePanel.setBounds(165, 24, 50, 100);
        serMinutePanel.setLayout(new GridLayout(3,1));
        serMinutePanel.setOpaque(false);

        //Text field panel
        JPanel timeFieldPanel = new JPanel();
        timeFieldPanel.setLayout(new FlowLayout());
        timeFieldPanel.setBackground(new Color(244, 54, 54));
        timeFieldPanel.setOpaque(false);

        //Initialize the hour field to show the current hour
        JTextField minuteField = new JTextField(String.valueOf(minute), 3);

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
        JLabel upHourIcon = upIcon();
        JLabel downHourIcon = downIcon();


        upHourIcon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try
                {
                    if(minute < 59)minute++ ;
                    else minute = 0;
                    minuteField.setText(String.valueOf(minute));
                }
                catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Error updating hour" +ex.getMessage(),"error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        downHourIcon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try
                {
                    if(minute > 0)minute-- ;
                    else minute = 59;
                    minuteField.setText(String.valueOf(minute));
                }
                catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Error updating hour" +ex.getMessage(),"error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        serMinutePanel.add(upHourIcon);
        serMinutePanel.add(timeFieldPanel);
        serMinutePanel.add(downHourIcon);
        valuePanel.add(serMinutePanel);
    }

    //Method to set second value
    private void setSecondValue()
    {
        JPanel setSecondPanel = new JPanel();
        setSecondPanel.setBackground(new Color(122, 100, 100));
        setSecondPanel.setBounds(205, 24, 50, 100);
        setSecondPanel.setLayout(new GridLayout(3,1));
        setSecondPanel.setOpaque(false);

        //Text field panel
        JPanel timeFieldPanel = new JPanel();
        timeFieldPanel.setLayout(new FlowLayout());
        timeFieldPanel.setBackground(new Color(244, 54, 54));
        timeFieldPanel.setOpaque(false);

        //Initialize the hour field to show the current hour
        JTextField secondsField = new JTextField(String.valueOf(second), 3);

        //Edit text field
        secondsField.setOpaque(false);
        secondsField.setFont(font_Style.sansSerif.getFont());
        secondsField.setBorder(null);
        secondsField.setHorizontalAlignment(JTextField.CENTER);
        secondsField.setFocusable(false);
        secondsField.setPreferredSize(new Dimension(20, 22));
        secondsField.setEditable(false);
        timeFieldPanel.add(secondsField);

        //set new objects for the icon methods
        JLabel upHourIcon = upIcon();
        JLabel downHourIcon = downIcon();


        upHourIcon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try{
                    if(second <= 59) second++;// to increment as long as hour not greater than 24
                    else second=0;
                    secondsField.setText(String.valueOf(second));
                }
                catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Error updating hour" +ex.getMessage(),"error", JOptionPane.ERROR_MESSAGE);
                }

            }
        });

        downHourIcon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try
                {
                    if(second > 0)second-- ;
                    else second = 59;
                    secondsField.setText(String.valueOf(second));
                }
                catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Error updating hour" +ex.getMessage(),"error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        setSecondPanel.add(upHourIcon);
        setSecondPanel.add(timeFieldPanel);
        setSecondPanel.add(downHourIcon);
        valuePanel.add(setSecondPanel);


    }

    //Method for up icon
    private JLabel upIcon() {
//        JPanel upIconPanel = new JPanel();
        ImageIcon upIcon = new ImageIcon("Clock_Gui/src/Import/upIcon.png");
        Image scaledImage = upIcon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        JLabel upIconLabel = new JLabel(scaledIcon);
        upIconLabel.setHorizontalAlignment(SwingConstants.CENTER);
        upIconLabel.setVerticalAlignment(SwingConstants.BOTTOM);

        return upIconLabel;
    }

    //Method for down icon
    private JLabel downIcon() {
        ImageIcon upIcon = new ImageIcon("Clock_Gui/src/Import/down.png");
        Image scaledImage = upIcon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        JLabel downIconLabel = new JLabel(scaledIcon);

        return downIconLabel;
    }

//    // Method to increment time value with a maximum limit
//    private void incrementTime(JTextField field, int currentValue, int maxValue) {
//        try{
//
//        }
//        if (currentValue < maxValue) {
//            currentValue++;
//        } else {
//            currentValue = 0; // Reset to 0 if it exceeds max value
//        }
//        field.setText(String.valueOf(currentValue));
//    }
//
//    // Method to decrement time value with a minimum limit of 0
//    private void decrementTime(JTextField field, int currentValue, int maxValue) {
//        if (currentValue > 0) {
//            currentValue--;
//        } else {
//            currentValue = maxValue; // Reset to max if it goes below 0
//        }
//        field.setText(String.valueOf(currentValue));
//    }
    //Create a call back method to send timer information to the main frame
    public interface TimerCallback {
        void onTimeSet(int hour,int minute,int second);
    }

}