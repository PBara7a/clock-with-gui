package src;

/**
 * The ClockDisplay class implements a digital clock display for a
 * European-style 24 hour clock. The clock shows hours, minutes and seconds. The
 * range of the clock is 00:00:00 (midnight) to 23:59:59 (one second before
 * midnight).
 */
public class ClockDisplay {
  private NumberDisplay hours;
  private NumberDisplay minutes;
  private NumberDisplay seconds;
  private String displayString;

  /**
   * Default constructor. Creates a new clock set at 00:00.
   */
  public ClockDisplay() {
    hours = new NumberDisplay(24);
    minutes = new NumberDisplay(60);
    seconds = new NumberDisplay(60);
    updateDisplay();
  }

  /**
   * Creates a clock set at the time specified by the parameters.
   */
  public ClockDisplay(int hour, int mins, int secs) {
    hours = new NumberDisplay(24);
    minutes = new NumberDisplay(60);
    seconds = new NumberDisplay(60);
    setTime(hour, mins, secs);
  }

  public void setTime(int hour, int mins, int secs) {
    hours.setValue(hour);
    minutes.setValue(mins);
    seconds.setValue(secs);
    updateDisplay();
  }

  public String getTime() {
    return displayString;
  }

  public void updateDisplay() {
    displayString = hours.getDisplayValue()
        + ":" + minutes.getDisplayValue()
        + ":" + seconds.getDisplayValue();
  }

  public void timeTick() {
    seconds.increment();

    if (seconds.getValue() == 0) {
      minutes.increment();
    }

    if (seconds.getValue() == 0 && minutes.getValue() == 0) {
      hours.increment();
    }

    updateDisplay();
  }
}
