package src;


    import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

    public class Alarmtest extends JFrame {
        private JTextField dateField, timeField;
        private JLabel statusLabel;
        private List<LocalDateTime> alarmsList = new ArrayList<>();
        private JTextArea alarmDisplay;

        public Alarmtest() {
            setTitle("Multi-Alarm Clock");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(500, 300);
            setLayout(new BorderLayout());

            // Date and time input panel
            JPanel inputPanel = new JPanel(new GridLayout(2, 2, 5, 5));
            inputPanel.add(new JLabel("Enter date (YYYY-MM-DD):"));
            dateField = new JTextField(10);
            inputPanel.add(dateField);
            inputPanel.add(new JLabel("Enter time (HH:mm):"));
            timeField = new JTextField(5);
            inputPanel.add(timeField);
            add(inputPanel, BorderLayout.NORTH);

            // Set Alarm button
            JButton setAlarmButton = new JButton("Set Alarm");
            setAlarmButton.addActionListener(e -> setAlarm());
            add(setAlarmButton, BorderLayout.CENTER);

            // Status label and alarm display
            statusLabel = new JLabel("No alarms set.", SwingConstants.CENTER);
            add(statusLabel, BorderLayout.SOUTH);

            // Alarm display area
            alarmDisplay = new JTextArea(5, 20);
            alarmDisplay.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(alarmDisplay);
            add(scrollPane, BorderLayout.EAST);

            // Timer to check every second
            Timer timer = new Timer(1000, e -> checkAlarms());
            timer.start();

            setVisible(true);
        }

        // Function to set a new alarm
        private void setAlarm() {
            try {
                String dateText = dateField.getText();
                String timeText = timeField.getText();

                // Parse the input into a LocalDateTime
                LocalDateTime alarmDateTime = LocalDateTime.parse(dateText + "T" + timeText);

                // Add the new alarm to the list
                alarmsList.add(alarmDateTime);
                updateAlarmsDisplay();

                statusLabel.setText("Alarm set for: " + alarmDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Invalid date/time format.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        // Function to check all alarms in the list
        private void checkAlarms() {
            LocalDateTime currentTime = LocalDateTime.now();
            Iterator<LocalDateTime> iterator = alarmsList.iterator();

            while (iterator.hasNext()) {
                LocalDateTime alarmTime = iterator.next();
                // If the current time matches or has passed the alarm time
                if (currentTime.isEqual(alarmTime) || currentTime.isAfter(alarmTime)) {
                    triggerAlarm(alarmTime);
                    iterator.remove(); // Remove the alarm after it goes off
                    updateAlarmsDisplay(); // Refresh the alarm list display
                }
            }
        }

        // Function to trigger an alarm
        private void triggerAlarm(LocalDateTime alarmTime) {
            JOptionPane.showMessageDialog(this, "Alarm is ringing for: " + alarmTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")), "Alarm", JOptionPane.INFORMATION_MESSAGE);
            Toolkit.getDefaultToolkit().beep();
        }

        // Function to update the list of alarms displayed in the text area
        private void updateAlarmsDisplay() {
            alarmDisplay.setText("");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            for (LocalDateTime alarm : alarmsList) {
                alarmDisplay.append(alarm.format(formatter) + "\n");
            }

            if (alarmsList.isEmpty()) {
                statusLabel.setText("No alarms set.");
            }
        }

        public static void main(String[] args) {
            SwingUtilities.invokeLater(Alarmtest::new);
        }
    }


