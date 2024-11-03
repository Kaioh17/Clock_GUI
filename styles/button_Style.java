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
            button.setFont(font_Style.roman.getFont());
        }
    }

    public static void attributeStyle(JButton... buttons)
    {
        for(JButton button : buttons)
        {
            button.setBackground(Color.BLACK);
            button.setFont(font_Style.roman.getFont());
        }
    }

    
}
