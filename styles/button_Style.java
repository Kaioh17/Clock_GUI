package styles;

import javax.swing.*;
import javax.swing.border.Border;


import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class button_Style {
    
    //a method to hold the button ui edit layout using (varags) to handle as many buttons as possible
    public static void mainStyle(JButton... buttons)
    {
        for(JButton button : buttons )
        {
            button.setBackground(Color.BLACK);
            button.setForeground(Color.LIGHT_GRAY);
            button.setFont(font_Style.roman.getFont());
            button.setFocusable(false);
            // button.setBorder(null);
            button.setSize(150, 10);
            button.setBorderPainted(false);
            button.setContentAreaFilled(false); // Remove the default button area fill
            button.setOpaque(true);


        }
    }

    public static void attributeStyle(JButton... buttons)
    {
        for(JButton button : buttons)
        {
        button.setBackground(new Color(183, 85, 0));
            button.setForeground(Color.green);
            button.setFont(font_Style.sansSerif.getFont());
            button.setFocusable(false);
            button.setPreferredSize(new Dimension(100, 50));
            button.setBorderPainted(false);
            button.setContentAreaFilled(false); // Remove the default button area fill
            button.setOpaque(true);


            //Add mouse listeners for button effect
            button.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                   button.setForeground(Color.LIGHT_GRAY );
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    button.setForeground(Color.WHITE);
                }
            });

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
            button.setPreferredSize(new Dimension(150, 50));
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
            button.setPreferredSize(new Dimension(50, 50));
        }
    }





}
