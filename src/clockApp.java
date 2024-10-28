package src;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class clockApp extends JFrame 
{
    private JPanel mainPanel;
    private CardLayout cardLayout;
    
    
   public clockApp()
    {
        //Set up for main frame
        setTitle("Clock");
        setSize(480,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setAlwaysOnTop(rootPaneCheckingEnabled);
        setResizable(false);
        

       //initialize card layout and panel
        cardLayout = new CardLayout();
        mainPanel = new JPanel();

        //create and add the various other pannels
        mainPanel.add(new timerPanel(), "Timer");
        mainPanel.add(new alarmPanel(), "Alarm");
        mainPanel.add(new stopWatchPanel(), "Stop Watch");

        //Creating a menu to handle the different panels
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("options");
        menu.setFont(new Font("Gothic", Font.PLAIN, 18));
        JMenuItem timerItem = new JMenuItem("Timer");
        JMenuItem alarmItem = new JMenuItem("Alarm");
        JMenuItem stopWatchItem = new JMenuItem("Stop Watch");  

        //Set font for menu items
        Font menuItemFont = new Font("Arial", Font.PLAIN, 14);
        timerItem.setFont(menuItemFont);
        alarmItem.setFont(menuItemFont);
        stopWatchItem.setFont(menuItemFont);
        


        //using lambda to give the panels actions
        timerItem.addActionListener(e -> cardLayout.show(mainPanel, "Timer"));
        timerItem.addActionListener(e -> cardLayout.show(mainPanel, "Alarm")); 
        timerItem.addActionListener(e -> cardLayout.show(mainPanel, "Stopwatch"));

        //Add the menu options to the main frame
        menu.add(timerItem);
        menu.add(alarmItem);
        menu.add(stopWatchItem);
        menuBar.add(menu);

        setJMenuBar(menuBar);
        add(mainPanel);

    }
    
    
    


    

}
