package src;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main extends JFrame 
{
    private CardLayout cardLayout;
    private JPanel clockPanel;

   public Main()
    {
        //Set up for main frame
        setTitle("Clock");
        setSize(500,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);

        //cardLayout for switching betwen panels
        cardLayout = new CardLayout();
        clockPanel = new JPanel(cardLayout);

        // add the classes to the main panel
        clockPanel.add(new timerPanel(), "Timer");
        clockPanel.add(new alarmPanel(), "Alarm");
        clockPanel.add(new stopWatchPanel(), "Stop Watch");

        //create buttons
        JButton timerButton = new JButton("Timer");
        JButton alarmButton = new JButton("Alarm");
        JButton stopWatchButton = new JButton("Stop Watch");

        //Action listeners for the button functions(using lambda)
        timerButton.addActionListener(e -> cardLayout.show(clockPanel, "Timer"));
        alarmButton.addActionListener(e -> cardLayout.show(clockPanel, "Alarm"));
        stopWatchButton.addActionListener(e -> cardLayout.show(clockPanel, "Stop Watch"));

        //A panel for the buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(timerButton);
        buttonPanel.add(alarmButton);
        buttonPanel.add(stopWatchButton);

        //Add panels to the main frame
        add(buttonPanel, BorderLayout.SOUTH);
        add(clockPanel, BorderLayout.CENTER);
        
       
    }

    public static void main(String[] args)
    {
        //use SwingUtilities.invokeLater to ensure thred safety 
        SwingUtilities.invokeLater(() -> {
            Main clock = new Main();

            clock.setVisible(true);
         });
       
    }

   

}
