package src;

import javax.swing.*;
import java.awt.*;


public class timerPanel extends JPanel {
    
    public timerPanel()
    {
        setLayout(new BorderLayout());
        JLabel label = new JLabel("Stopwatch functionality goes here!", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.PLAIN, 24));
           add(label, BorderLayout.CENTER);

    }
    

}

