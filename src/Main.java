package src;

import java.awt.*;
import src.panels.*;
import styles.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.*;

public class Main extends JFrame 
{
    private CardLayout cardLayout;
    private JPanel mainPanel;

  
public Main()
    { //Set up for main frame
        setTitle("Clock");
        setSize(510,450);
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

        //Add icon to buttons(timer)
        ImageIcon timerIcon = new ImageIcon("Clock_Gui/src/Sounds/timerIconW.png");
        // Resize icon if necessary
        Image scaledImage = timerIcon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        //Add icon to buttons(stopwatch)
        ImageIcon stopWatchIcon = new ImageIcon("Clock_Gui/src/Sounds/stopWatchIconW.png");
        // Resize icon if necessary
        Image scaledImage2 = stopWatchIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon stopwatchScaledIcon = new ImageIcon(scaledImage2);

        //Add icon to buttons(alarm)
        ImageIcon alarmIcon = new ImageIcon("Clock_Gui/src/Sounds/alarmIconW.png");
        // Resize icon if necessary
        Image alarmScaledImage = alarmIcon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ImageIcon alarmScaledIcon = new ImageIcon(alarmScaledImage);

        //Check if file exists
        File file = new File("Clock_Gui/src/Sounds/stopwatch.png");

        System.out.println("File exists: " + file.exists());
        System.out.println("Absolute path: " + file.getAbsolutePath());

        //create buttons
        JButton timerButton = new JButton();
        JButton alarmButton = new JButton();
        JButton stopWatchButton = new JButton();

        //add the icons to buttons
        timerButton.setIcon(scaledIcon);
        stopWatchButton.setIcon(stopwatchScaledIcon);
        alarmButton.setIcon(alarmScaledIcon);



        //edit the button
        button_Style.mainStyle(timerButton, alarmButton,  stopWatchButton);
//        timerButton.setPreferredSize(new Dimension(150,58));
//        stopWatchButton.setPreferredSize(new Dimension(150,58));
       
       

        //Action listeners for the button functions(using lambda)
        timerButton.addActionListener(e -> cardLayout.show(mainPanel, "Timer"));
        alarmButton.addActionListener(e -> cardLayout.show(mainPanel, "Alarm"));
        stopWatchButton.addActionListener(e -> cardLayout.show(mainPanel, "Stop Watch"));

        // Action listeners for timerButton, alarmButton, and stopWatchButton.
        // When a button is clicked, it changes its icon color to a specific color (dark orange),
        // while setting the icon color of the other two buttons to light gray, indicating
        // which mode is currently active (Timer, Alarm, or Stopwatch). This provides
        // a visual cue to the user about which functionality is selected.

        timerButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {


                //Change icon image
                ImageIcon timerIcon = new ImageIcon("Clock_Gui/src/Sounds/timerIconOrange.png");
              // Resize icon if necessary
                Image scaledImage = timerIcon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
                ImageIcon scaledIcon = new ImageIcon(scaledImage);

                timerButton.setIcon(scaledIcon);

                //Add icon to buttons
                ImageIcon stopWatchIcon = new ImageIcon("Clock_Gui/src/Sounds/stopWatchIconW.png");
                // Resize icon if necessary
                Image scaledImage2 = stopWatchIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
                ImageIcon stopwatchScaledIcon = new ImageIcon(scaledImage2);

                stopWatchButton.setIcon(stopwatchScaledIcon);

                ImageIcon alarmIcon = new ImageIcon("Clock_Gui/src/Sounds/alarmIconW.png");
                // Resize icon if necessary
                Image alarmScaledImage = alarmIcon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
                ImageIcon alarmScaledIcon = new ImageIcon(alarmScaledImage);

                alarmButton.setIcon(alarmScaledIcon);
            }
        });


        alarmButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                //Change icon image
                ImageIcon timerIcon = new ImageIcon("Clock_Gui/src/Sounds/timerIconW.png");
                // Resize icon if necessary
                Image scaledImage = timerIcon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
                ImageIcon scaledIcon = new ImageIcon(scaledImage);

                timerButton.setIcon(scaledIcon);

                //Add icon to buttons
                ImageIcon stopWatchIcon = new ImageIcon("Clock_Gui/src/Sounds/stopWatchIconW.png");
                // Resize icon if necessary
                Image scaledImage2 = stopWatchIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
                ImageIcon stopwatchScaledIcon = new ImageIcon(scaledImage2);

                stopWatchButton.setIcon(stopwatchScaledIcon);

                ImageIcon alarmIcon = new ImageIcon("Clock_Gui/src/Sounds/alarmIconOrange.png");
                // Resize icon if necessary
                Image alarmScaledImage = alarmIcon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
                ImageIcon alarmScaledIcon = new ImageIcon(alarmScaledImage);

                alarmButton.setIcon(alarmScaledIcon);
            }
        });

        stopWatchButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                //Change icon image
                ImageIcon timerIcon = new ImageIcon("Clock_Gui/src/Sounds/timerIconW.png");
                // Resize icon if necessary
                Image scaledImage = timerIcon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
                ImageIcon scaledIcon = new ImageIcon(scaledImage);

                timerButton.setIcon(scaledIcon);

                //Add icon to buttons
                ImageIcon stopWatchIcon = new ImageIcon("Clock_Gui/src/Sounds/stopWatchOrange.png");
                // Resize icon if necessary
                Image scaledImage2 = stopWatchIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
                ImageIcon stopwatchScaledIcon = new ImageIcon(scaledImage2);

                stopWatchButton.setIcon(stopwatchScaledIcon);

                ImageIcon alarmIcon = new ImageIcon("Clock_Gui/src/Sounds/alarmIconW.png");
                // Resize icon if necessary
                Image alarmScaledImage = alarmIcon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
                ImageIcon alarmScaledIcon = new ImageIcon(alarmScaledImage);

                alarmButton.setIcon(alarmScaledIcon);
            }
        });
        //A panel for the buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(timerButton);
        buttonPanel.add(alarmButton);
        buttonPanel.add(stopWatchButton);

        buttonPanel.setBackground(Color.BLACK);
        buttonPanel.setLayout(new FlowLayout());

       
        

        /*
        Panel to set clock and calendar in real time *
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
