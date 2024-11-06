package src;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import styles.*;


public class timerPanel extends JPanel {
    
   private JLabel timerLabel;
   private Timer timer;
   private setTimerFrame setFrame;
   private JButton setButton;
   private JButton pauseButton;
   private JPanel buttonPanel;

    
    public timerPanel()
    {

         //timer label   (00:00:00)
         timerLabel = new JLabel("00:00.00");
         timerLabel.setFont(font_Style.ROMAN.getFont());
         timerLabel.setHorizontalAlignment(SwingConstants.CENTER);
         timerLabel.setForeground(Color.BLACK);
//         timerLabel.setBounds(10,10,300,100);

         //initialize component
         buttonPanel = new JPanel();
         setButton = new JButton("Set");//set will prompt a new frame to set timer
         pauseButton = new JButton("pause");

         //edit panel
//        setLayout(null);
//         buttonPanel.setBounds(50, 120, 500, 50);
         buttonPanel.setBackground(Color.pink);

        //set button functions
        setButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               setFrame = new setTimerFrame();
               setFrame.setVisible(true);
                System.out.println("set timer");
            }
        });
         //edit button
        button_Style.attributeStyle(setButton);
        button_Style.stopStyle(pauseButton);

        //add buttons to the panel
         buttonPanel.add(setButton);
         buttonPanel.add(pauseButton);

         add(timerLabel, BorderLayout.CENTER);
         add(buttonPanel, BorderLayout.SOUTH);
    }

}

