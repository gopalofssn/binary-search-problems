package com.gs.pattern.sequence;

import static org.junit.Assert.*;
import org.junit.Test;

public class PatternSequenceCheckerTest {

  private final String GIVEN_STRING = "hghgghacbdefuaz";
  private PatternSequenceChecker patternSequenceChecker = new PatternSequenceChecker(GIVEN_STRING);
  
  @Test
  public void testIfPresent() {
    assertTrue(patternSequenceChecker.isSubSequencePresent("acaz"));
  }
  
  @Test
  public void testIfNotPresent() {
    assertFalse(patternSequenceChecker.isSubSequencePresent("aacaz"));
  }
  
}
