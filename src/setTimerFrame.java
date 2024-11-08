package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import styles.*;

public class setTimerFrame extends JFrame {

    private JButton startButton;
    private JPanel buttonPanel;
    private JPanel valuePanel;
    private JButton upButton;
    private JButton downButton;
    private JTextField numberField;
    private int hour;
    private int minute;
    private int second;

    public setTimerFrame() {
        //create an ui for users to set timer
        setTitle("Set Timer");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setBackground(Color.BLACK);
        setLayout(new FlowLayout());

        //create a panel to contain the
        valuePanel = new JPanel();
        valuePanel.setBackground(Color.BLACK);
        valuePanel.setLayout(new GridLayout(1,3, 10,5));

        valuePanel.setSize(400, 200);

       setHourValue();
       setMinuteValue();



        add(valuePanel, BorderLayout.SOUTH);

    }

    private void setHourValue()
    {
        JButton upButton = new JButton(">");
        JTextField numberField = new JTextField(String.valueOf(hour), 5 );
        JButton downButton = new JButton("<");

    //Edit buttons
        button_Style.attributeStyle(upButton,downButton);


        //Assigning functions to the up & down buttons
        upButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    if(hour <= 24) hour++;// to increment as long as hour not greater than 24
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
        JTextField numberField = new JTextField(String.valueOf(hour), 5 );
        JButton downButton = new JButton("<");


        JPanel minutePanel = new JPanel();
        minutePanel.setBackground(Color.RED);
        minutePanel.setLayout(new GridLayout(3,3));

        minutePanel.add(upButton);
        minutePanel.add(numberField);
        minutePanel.add(downButton);

        valuePanel.add(minutePanel);
    }

}