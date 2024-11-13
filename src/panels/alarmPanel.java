package src.panels;

import javax.swing.*;
import java.awt.*;

public class alarmPanel  extends JPanel{

    public alarmPanel()
    {
       

           setLayout(new BorderLayout());
           JLabel label = new JLabel("Alarm functionality goes here!", SwingConstants.CENTER);
           label.setFont(new Font("Arial", Font.PLAIN, 24));
              add(label, BorderLayout.CENTER);

              System.out.println("Alarm");
   
    }
    

}
