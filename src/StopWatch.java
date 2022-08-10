package src;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * A very simple GUI (graphical user interface) of a stopwatch using the
 * ClockDisplay.
 */
public class StopWatch {
  private JFrame frame;
  private JLabel label;
  private ClockDisplay clock;
  private boolean clockRunning = false;
  private TimerThread timerThread;

  public StopWatch() {
    makeFrame();
    clock = new ClockDisplay();
  }

  private void start() {
    clockRunning = true;
    timerThread = new TimerThread();
    timerThread.start();
  }

  private void stop() {
    clockRunning = false;
  }

  private void reset() {
    clock.setTime(0, 0, 0);
    label.setText(clock.getTime());
  }

  private void step() {
    clock.timeTick();
    label.setText(clock.getTime());
  }

  private void makeFrame() {
    frame = new JFrame("StopWatch");
    JPanel contentPane = (JPanel) frame.getContentPane();
    contentPane.setBorder(new EmptyBorder(1, 60, 1, 60));

    // Specify the layout manager with nice spacing
    contentPane.setLayout(new BorderLayout(12, 12));

    // Create the image pane in the center
    label = new JLabel("00:00:00", SwingConstants.CENTER);
    Font displayFont = label.getFont().deriveFont(96.0f);
    label.setFont(displayFont);
    // imagePanel.setBorder(new EtchedBorder());
    contentPane.add(label, BorderLayout.CENTER);

    // Create the toolbar with the buttons
    JPanel toolbar = new JPanel();
    toolbar.setLayout(new GridLayout(1, 0));

    JButton startButton = new JButton("Start");
    startButton.addActionListener(e -> start());
    toolbar.add(startButton);

    JButton stopButton = new JButton("Stop");
    stopButton.addActionListener(e -> stop());
    toolbar.add(stopButton);

    JButton resetButton = new JButton("Reset");
    resetButton.addActionListener(e -> reset());
    toolbar.add(resetButton);

    JButton stepButton = new JButton("Step");
    stepButton.addActionListener(e -> step());
    toolbar.add(stepButton);

    // Add toolbar into panel with flow layout for spacing
    JPanel flow = new JPanel();
    flow.add(toolbar);

    contentPane.add(flow, BorderLayout.SOUTH);

    // building is done - arrange the components
    frame.pack();

    // place the frame at the center of the screen and show
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    frame.setLocation(d.width / 2 - frame.getWidth() / 2, d.height / 2 - frame.getHeight() / 2);
    frame.setVisible(true);
  }

  class TimerThread extends Thread {
    public void run() {
      while (clockRunning) {
        step();
        pause();
      }
    }

    private void pause() {
      try {
        Thread.sleep(1000);
      } catch (InterruptedException exc) {
      }
    }
  }

  public static void main(String[] args) {
    StopWatch clock = new StopWatch();
  }
}
