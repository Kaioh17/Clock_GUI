package styles;

import javax.swing.*;
import javax.swing.border.Border;


import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;


public class button_Style {
    
    //a method to hold the button ui edit layout using (varags) to handle as many buttons as possible
    public static void mainStyle(JButton... buttons)
    {
        for(JButton button : buttons )
        {
            button.setBackground(Color.WHITE);
            button.setForeground(Color.LIGHT_GRAY);
            button.setFont(font_Style.roman.getFont());

            button.setFocusable(false);
            // button.setBorder(null);
            button.setPreferredSize(new Dimension(110,48));
            button.setBorderPainted(false);
            button.setContentAreaFilled(false); // Remove the default button area fill
            button.setOpaque(false);


        }
    }
    //Button style for most buttons
    public static void attributeStyle(JButton... buttons)
    {
        for(JButton button : buttons)
        {
            button.setBackground(new Color(0, 101, 3));
            button.setForeground(Color.green);
            button.setFont(font_Style.sansSerif.getFont());
            button.setFocusable(false);
            button.setPreferredSize(new Dimension(150, 50));
            button.setBorderPainted(false);
            button.setContentAreaFilled(false); // Remove the default button area fill
            button.setOpaque(true);




        }
    }
    //Stop Button Style
    public static void stopStyle(JButton... buttons)
    {
        for(JButton button : buttons)
        {
            button.setBackground(Color.DARK_GRAY);
            button.setForeground(Color.GRAY);
            button.setFont(font_Style.sansSerif.getFont());
            button.setFocusable(false);
            button.setPreferredSize(new Dimension(150, 50));
            button.setBorderPainted(false);
            button.setContentAreaFilled(false); // Remove the default button area fill
            button.setOpaque(true);

        }
    }
    //resume button style
    public static void resumeStyle(JButton... buttons)
    {
        for(JButton button : buttons)
        {
            button.setForeground(new Color(255, 135, 0));
            button.setBackground(new Color(255, 77,0, 245));
            button.setFont(font_Style.sansSerif.getFont());
            button.setFocusable(false);
            button.setPreferredSize(new Dimension(150, 50));
            button.setBorderPainted(false);
            button.setContentAreaFilled(false); // Remove the default button area fill
            button.setOpaque(true);

        }
    }
    //UP and Down button style
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

//    @Override
//    protected void paintComponent(int x,int y,int w, int h)
//    {
//        Graphics g = null;
//        RoundRectangle2D roundedRectangle = new RoundRectangle2D.Float(x, y, w, h, 10, 10);
//        g.fill(roundedRectangle);
//    }





}
