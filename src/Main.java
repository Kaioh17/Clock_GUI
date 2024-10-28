package src;
import javax.swing.*;

public class Main {
    public static void main(String[] args)
    {
        //use SwingUtilities.invokeLater to ensure thred safety 
        SwingUtilities.invokeLater(() -> {
            clockApp clock = new clockApp();

            clock.setVisible(true);

        });
       
    }
}
