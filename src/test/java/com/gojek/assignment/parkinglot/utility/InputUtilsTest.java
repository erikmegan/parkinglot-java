package com.gojek.assignment.parkinglot.utility;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author ErikMegantara
 */
public class InputUtilsTest {
  InputUtils inputParser = new InputUtils();
  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

  @Before
  public void before() {
    System.setOut(new PrintStream(outContent));
  }

  @After
  public void after() {
    System.setOut(null);
  }

  @Test
  public void parseTextInput() {
    inputParser.parseTextInput("test");
    inputParser.parseTextInput("status");
    assertEquals("Invalidinput", outContent.toString().trim().replace(" ", ""));
  }
}
