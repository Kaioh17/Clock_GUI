package src;

import javax.swing.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
public class clockPanel extends JPanel{

    private Calendar calender;
    private SimpleDateFormat timeFormat;
    private JLabel timeLabel;
    String time;

    public clockPanel()
    {
        timeFormat = new SimpleDateFormat("hh:mm:ss a");
        timeLabel = new JLabel();

        time =  timeFormat.format(Calendar.getInstance().getTime());
        timeLabel.setText(time);

         add(timeLabel);

         setTime();

    }

    private void setTime()
    {
        //this will allow it to keep running until it is closed
        while(true){
            time =  timeFormat.format(Calendar.getInstance().getTime());
            timeLabel.setText(time);

            //this will handle any error that could slow down or crash the code
            try
            {
                // this will be use to iterate throught the time ever 1000 millisecond hence: 1second
                Thread.sleep(1000);
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }
        }        
    }
}
