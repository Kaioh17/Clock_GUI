package styles;

import javax.swing.*;
import javax.swing.border.Border;


import java.awt.*;


public class button_Style {
    
    //a method to hold the button ui edit layout using (varags) to handle as many buttons as possible
    public static void mainStyle(JButton... buttons)
    {
        for(JButton button : buttons )
        {
            button.setBackground(Color.BLACK);
            button.setForeground(Color.WHITE);
            button.setFont(font_Style.roman.getFont());
            button.setFocusable(false);
            // button.setBorder(null);
            button.setSize(150, 10);
        }
    }

    public static void attributeStyle(JButton... buttons)
    {
        for(JButton button : buttons)
        {
        button.setBackground(new Color(183, 85, 0));
            button.setForeground(Color.WHITE);
            button.setFont(font_Style.sansSerif.getFont());
            button.setFocusable(false);
            button.setSize(150, 10);
            button.setBorderPainted(false);
            button.setContentAreaFilled(false); // Remove the default button area fill
            button.setOpaque(true);


        }
    }

    public static void stopStyle(JButton... buttons)
    {
        for(JButton button : buttons)
        {
            button.setBackground(Color.RED); 
            button.setForeground(Color.WHITE);
            button.setFont(font_Style.sansSerif.getFont());
            button.setFocusable(false);
            button.setSize(150, 10);
            button.setBorderPainted(false);
            button.setContentAreaFilled(false); // Remove the default button area fill
            button.setOpaque(true);

        }
    }
    public static void up_downStyle(JButton... buttons)
    {
        for(JButton button : buttons)
        {
            button.setBackground(Color.CYAN);
            button.setForeground(Color.BLACK);
            button.setFont(font_Style.roman.getFont());
            button.setFocusable(false);
            button.setSize(150, 10);
        }
    }





}
