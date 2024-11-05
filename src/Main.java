package src;

import java.awt.*;
import styles.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

public class Main extends JFrame 
{
    private CardLayout cardLayout;
    private JPanel mainPanel;

  
public Main()
    { //Set up for main frame
        setTitle("Clock");
        setSize(550,330);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setBackground(Color.BLACK);


        //cardLayout for switching betwen panels
        cardLayout = new CardLayout();

        mainPanel = new JPanel(cardLayout);

        // add the classes to the main panel
        mainPanel.add(new timerPanel(), "Timer");
        mainPanel.add(new alarmPanel(), "Alarm");
        mainPanel.add(new stopWatchPanel(), "Stop Watch");

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

        //A panel for the buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(timerButton);
        buttonPanel.add(alarmButton);
        buttonPanel.add(stopWatchButton);
       
        

        /**
        Panel to set clock and calender in real time *          
        */
        JPanel clock_Panel = new JPanel();
       clock_Panel.add(new clockPanel());

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
