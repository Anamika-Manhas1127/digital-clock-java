import java.awt.BorderLayout;
import java.awt.Font;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class Main extends JFrame {
    // Formats the time as hours:minutes:seconds AM/PM.
    private final DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("hh:mm:ss a");

    private final JLabel clockLabel = new JLabel("", SwingConstants.CENTER);

    public Main() {
        setTitle("Digital Clock");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Make the time large and easy to read.
        clockLabel.setFont(new Font("Arial", Font.BOLD, 40));
        add(clockLabel, BorderLayout.CENTER);

        updateClock(); // Show the time immediately when the window opens.

        // Swing Timer runs this update every 1,000 milliseconds (one second).
        Timer timer = new Timer(1000, event -> updateClock());
        timer.start();

        setSize(350, 150);
        setLocationRelativeTo(null); // Center the window on the screen.
        setVisible(true);
    }

    private void updateClock() {
        // Read the computer's current time and display it.
        clockLabel.setText(LocalTime.now().format(formatter));
    }

    public static void main(String[] args) {
        // Start the window safely on Swing's event-dispatch thread.
        javax.swing.SwingUtilities.invokeLater(Main::new);
    }
}


