package com.doctestbot;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/** Test class for the Bicycle class. */
@SuppressWarnings({"PMD.AtLeastOneConstructor"})
class TestHelloUniverse {

  /** Test method to verify the a bike will have 2 wheels after initialisation. */
  @Test
  @SuppressWarnings({"PMD.LawOfDemeter", "PMD.AvoidInstantiatingObjectsInLoops"})
  void testComplianceArgsExists() {
    final Bicycle someBike = new Bicycle(2);
    assertEquals(2, someBike.getNrOfWheels(), "Error, bike did not have two wheels.");
  }
}
