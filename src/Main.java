package src;

import java.awt.*;
import src.panels.*;
import styles.*;
import java.awt.event.*;
import javax.swing.*;

public class Main extends JFrame 
{
    private CardLayout cardLayout;
    private JPanel mainPanel;

  
public Main()
    { //Set up for main frame
        setTitle("Clock");
        setSize(550,330);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        getContentPane().setBackground(Color.BLACK);



        //cardLayout for switching between panels
        cardLayout = new CardLayout();

        mainPanel = new JPanel(cardLayout);

        mainPanel.setBackground(Color.BLACK);

        // add the classes to the main panel
        mainPanel.add(new timerPanel(), "Timer");
        mainPanel.add(new alarmPanel(), "Alarm");
        mainPanel.add(new stopWatchPanel(), "Stop Watch");

//        //Icon test
//        ImageIcon timerIcon = new ImageIcon("src/Sounds/timer22.png");
//        // Resize icon if necessary
//        Image scaledImage = timerIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
//        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        //create buttons
        JButton timerButton = new JButton("Timer");
        JButton alarmButton = new JButton("Alarm");
        JButton stopWatchButton = new JButton("Stop Watch");



        //edit the button
        button_Style.mainStyle(timerButton, alarmButton,  stopWatchButton);
       
       

        //Action listeners for the button functions(using lambda)
        timerButton.addActionListener(e -> cardLayout.show(mainPanel, "Timer"));
        alarmButton.addActionListener(e -> cardLayout.show(mainPanel, "Alarm"));
        stopWatchButton.addActionListener(e -> cardLayout.show(mainPanel, "Stop Watch"));

        // Action listeners for timerButton, alarmButton, and stopWatchButton.
        // When a button is clicked, it changes its text color to a specific color (dark orange),
        // while setting the text color of the other two buttons to light gray, indicating
        // which mode is currently active (Timer, Alarm, or Stopwatch). This provides
        // a visual cue to the user about which functionality is selected.

        timerButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                timerButton.setForeground(new Color(183, 85, 0));
                alarmButton.setForeground(Color.lightGray);
                stopWatchButton.setForeground(Color.lightGray);
            }
        });


        alarmButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                alarmButton.setForeground(new Color(183, 85, 0));
                timerButton.setForeground(Color.lightGray);
                stopWatchButton.setForeground(Color.lightGray);
            }
        });

        stopWatchButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                alarmButton.setForeground(Color.lightGray);
                timerButton.setForeground(Color.lightGray);
                stopWatchButton.setForeground(new Color(183, 85, 0));


            }
        });
        //A panel for the buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(timerButton);
        buttonPanel.add(alarmButton);
        buttonPanel.add(stopWatchButton);

        buttonPanel.setBackground(Color.BLACK);
       
        

        /*
        Panel to set clock and calender in real time *          
        */
        JPanel clock_Panel = new JPanel();
       clock_Panel.add(new clockPanel());

       clock_Panel.setBackground(Color.BLACK);

        //Add panels to the main frame
        add(buttonPanel,BorderLayout.SOUTH);
        add(mainPanel, BorderLayout.CENTER);
        add(clock_Panel,BorderLayout.NORTH);
        
        
       
    }

    public static void main(String[] args)
    {
        //use SwingUtilities.invokeLater to ensure thread safety
        SwingUtilities.invokeLater(() -> {
            Main clock = new Main();

            clock.setVisible(true);
         });
       
    }

   

}
