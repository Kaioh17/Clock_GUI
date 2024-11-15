package src.panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import styles.*;

public class setTimerFrame extends JFrame {

    private JButton clearButton;
    private final JPanel valuePanel;
    private JButton upButton;
    private JButton downButton;
    private JTextField numberField;
    protected int hour =0;
    private int minute;
    private int second;
    public TimerCallback callback;

    public setTimerFrame(TimerCallback callback) {
        this.callback = callback;
        //create an ui for users to set timer
        setTitle("Set Timer");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setBackground(Color.BLACK);
        setLayout(new GridLayout(2,1));

        //create a panel to contain the
        valuePanel = new JPanel();
        valuePanel.setBackground(Color.BLACK);
        valuePanel.setLayout(new GridLayout(1,3, 10,5));
//        valuePanel.setLayout(new FlowLayout());
        valuePanel.setPreferredSize(new Dimension(200, 50));

        valuePanel.setSize(400, 20);

        JButton startButton = new JButton("Start");
        JPanel buttonPanel = new JPanel();
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
        JButton upButton = new JButton(">");
        JTextField numberField = new JTextField(String.valueOf(hour), 5 );
        JButton downButton = new JButton("<");

    //Edit buttons
        button_Style.up_downStyle(upButton,downButton);


        //Assigning functions to the up & down buttons
        upButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    if(hour <= 23) hour++;// to increment as long as hour not greater than 24
                    else hour=0;
                    numberField.setText(String.valueOf(hour));
                }
                catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Error updating hour" +ex.getMessage(),"error", JOptionPane.ERROR_MESSAGE);
                }

            }
        });

        downButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try
                {
                    if(hour > 0)hour-- ;
                    else hour = 0;
                    numberField.setText(String.valueOf(hour));
                }
                catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Error updating hour" +ex.getMessage(),"error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });


        JPanel hourPanel = new JPanel();
        hourPanel.setBackground(Color.RED);
        hourPanel.setLayout(new GridLayout(3,3));

        hourPanel.add(upButton);
        hourPanel.add(numberField);
        hourPanel.add(downButton);

        valuePanel.add(hourPanel);
    }

    private void setMinuteValue()
    {
        JButton upButton = new JButton(">");
        JTextField numberField = new JTextField(String.valueOf(minute), 5 );
        JButton downButton = new JButton("<");

        //Edit buttons
        button_Style.up_downStyle(upButton,downButton);


        //Assigning functions to the up & down buttons
        upButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    if(minute <= 59) minute++;// to increment as long as hour not greater than 24
                    else minute=0;
                    numberField.setText(String.valueOf(minute));
                }
                catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Error updating hour" +ex.getMessage(),"error", JOptionPane.ERROR_MESSAGE);
                }

            }
        });

        downButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try
                {
                    if(minute > 0)minute-- ;
                    else minute = 0;
                    numberField.setText(String.valueOf(minute));
                }
                catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Error updating hour" +ex.getMessage(),"error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });



        JPanel minutePanel = new JPanel();
        minutePanel.setBackground(Color.RED);
        minutePanel.setLayout(new GridLayout(3,3));

        minutePanel.add(upButton);
        minutePanel.add(numberField);
        minutePanel.add(downButton);

        valuePanel.add(minutePanel);
    }

    private void setSecondValue()
    {
        JButton upButton = new JButton(">");
        JTextField numberField = new JTextField(String.valueOf(second), 5 );
        JButton downButton = new JButton("<");

        //Edit buttons
        button_Style.up_downStyle(upButton,downButton);


        //Assigning functions to the up & down buttons
        upButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    if(second <= 59) second++;// to increment as long as hour not greater than 24
                    else second=0;
                    numberField.setText(String.valueOf(second));
                }
                catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Error updating hour" +ex.getMessage(),"error", JOptionPane.ERROR_MESSAGE);
                }

            }
        });

        downButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try
                {
                    if(second > 0)second-- ;
                    else second = 0;
                    numberField.setText(String.valueOf(second));
                }
                catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Error updating hour" +ex.getMessage(),"error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });



        JPanel minutePanel = new JPanel();
        minutePanel.setBackground(Color.RED);
        minutePanel.setLayout(new GridLayout(3,3));

        minutePanel.add(upButton);
        minutePanel.add(numberField);
        minutePanel.add(downButton);

        valuePanel.add(minutePanel);
    }


    //Create a call back method to send timer information to the main frame
    public interface TimerCallback {
        void onTimeSet(int hour,int minute,int second);
    }

}