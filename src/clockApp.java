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

       //initialize card layout and panel
        cardLayout = new CardLayout();
        mainPanel = new JPanel();

        //create and add the various other pannels
        mainPanel.add(new timerPanel(), "Timer");
        mainPanel.add(new alarmPanel(), "Alarm");
        mainPanel.add(new stopWatchPanel(), "Stop Watch");

        //Creating a menu to handle the different panels
        JMenuBar menuBar = new JMenuBar();
        JMenu mennu = new JMenu("options");



        add(mainPanel);

    }
    
    
    


    

}
