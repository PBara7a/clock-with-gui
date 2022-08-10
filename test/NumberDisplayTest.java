package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import src.NumberDisplay;

public class NumberDisplayTest {
  @Test
  public void testgetValue() {
    NumberDisplay display = new NumberDisplay(60);

    assertEquals(0, display.getValue());
  }

  @Test
  public void testSetValue() {
    NumberDisplay display = new NumberDisplay(60);
    display.setValue(35);

    assertEquals(35, display.getValue());
  }

  @Test
  public void testIncrement() {
    NumberDisplay display = new NumberDisplay(60);
    display.increment();
    display.increment();

    assertEquals(2, display.getValue());
  }

  @Test
  public void testGetDisplayValue() {
    NumberDisplay display = new NumberDisplay(60);
    display.increment();
    display.increment();

    assertEquals("02", display.getDisplayValue());
  }
}
