package src;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.*;
import java.awt.*;


public class clockPanel extends JPanel{

    private SimpleDateFormat timeFormat;
    private SimpleDateFormat dayFormat;
    private JLabel timeLabel;
    private JLabel dayLabel;
    private String time;
    private String day;

    public clockPanel()
    {
        
        timeFormat = new SimpleDateFormat("hh:mm:ss a  ");
        dayFormat = new SimpleDateFormat(" MMMMM dd, yyyy");


        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Times New Roman",Font.PLAIN,15));
        dayLabel = new JLabel();
        dayLabel.setFont(new Font("Times New Roman",Font.PLAIN,15));
        

        
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
