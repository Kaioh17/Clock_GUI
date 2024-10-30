package src;

import javax.swing.*;
import java.awt.*;

public class stopWatchPanel extends JPanel{

    public stopWatchPanel()
    {
      


        setLayout(new BorderLayout());
        JLabel label = new JLabel("Stopwatch functionality goes here!", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.PLAIN, 24));
           add(label, BorderLayout.CENTER);

          
    }

}
