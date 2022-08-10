package src;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ClockDisplayTest {
  @Test
  public void testGetTime() {
    ClockDisplay clock = new ClockDisplay(12, 30, 0);

    assertEquals("12:30:00", clock.getTime());
  }

  @Test
  public void testTimeTick() {
    ClockDisplay clock = new ClockDisplay(12, 59, 59);
    clock.timeTick();

    assertEquals("13:00:00", clock.getTime());
  }
}
