package src;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import styles.*;

import javax.swing.*;
import java.awt.*;


public class clockPanel extends JPanel{

    private SimpleDateFormat timeFormat;
    private SimpleDateFormat dayFormat;
    private JLabel timeLabel;
    private JLabel dayLabel;
    private String time;
    private String day;

    /**
     This will be used te set real time and date on every panel* 
     */
    public clockPanel()
    {
        
        timeFormat = new SimpleDateFormat("hh:mm:ss a  ");
        dayFormat = new SimpleDateFormat(" MMMMM dd, yyyy");


        timeLabel = new JLabel();
        timeLabel.setFont(font_Style.roman.getFont());
        dayLabel = new JLabel();
        dayLabel.setFont(font_Style.roman.getFont());
        

        
         add(timeLabel);
         add(dayLabel);

         //using a timer to update every 1000 milliseconds hence 1 second
         Timer timer = new Timer(1000, e -> setTime());
         timer.start();

        
    }

   
    public void setTime()
    {
       
            
            time =  timeFormat.format(Calendar.getInstance().getTime());
            timeLabel.setText(time);

            day = dayFormat.format(Calendar.getInstance().getTime());
            dayLabel.setText(day);

            
     }
    
}