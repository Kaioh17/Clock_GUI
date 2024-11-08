package styles;

import javax.swing.*;


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
            // button.setBorder(null);
            button.setSize(150, 10);
        }
    }

    public static void attributeStyle(JButton... buttons)
    {
        for(JButton button : buttons)
        {
            button.setBackground(Color.BLUE);
            button.setForeground(Color.WHITE);
            button.setFont(font_Style.roman.getFont());
        }
    }

    public static void stopStyle(JButton... buttons)
    {
        for(JButton button : buttons)
        {
            button.setBackground(Color.RED); 
            button.setForeground(Color.WHITE);
            button.setFont(font_Style.roman.getFont());
        }
    }
    public static void up_downStyle(JButton... buttons)
    {
        for(JButton button : buttons)
        {
            button.setBackground(Color.RED);
            button.setForeground(Color.WHITE);
            button.setFont(font_Style.roman.getFont());
        }
    }







}
