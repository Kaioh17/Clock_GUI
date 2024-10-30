package src;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;



public class timerPanel extends JPanel {
    
   
    

    
    public timerPanel()
    {

        setLayout(new FlowLayout());
        JLabel label = new JLabel("Timer functionality goes here!", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.PLAIN, 24));
           add(label, BorderLayout.CENTER);

           System.out.println("Timer!!");

        
        
    }

}

