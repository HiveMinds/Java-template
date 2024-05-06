package com.doctestbot.unit_test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.doctestbot.Bicycle;
import com.doctestbot.BicycleWithoutWheels;
import org.junit.jupiter.api.Test;

/** Test class for the Bicycle class. */
@SuppressWarnings({"PMD.AtLeastOneConstructor"})
class TestHelloUniverse {

  /** Test method to verify the a bike will have 2 wheels after initialisation. */
  @Test
  void testTwoWheeledBicycleExists() throws BicycleWithoutWheels {
    final Bicycle someBike = new Bicycle(2);
    assertEquals(2, someBike.getNrOfWheels(), "Error, bike did not have two wheels.");
  }

  /**
   * Test method to verify the a custom BicycleWithoutWheels exception is thrown if one attempts to
   * create a bicycle without any wheels.
   */
  @Test
  @SuppressWarnings({"PMD.JUnitTestContainsTooManyAsserts"})
  void testBicycleWithoutWheelsThrowsError() throws BicycleWithoutWheels {

    final Exception exception =
        assertThrows(
            BicycleWithoutWheels.class,
            () -> {
              new Bicycle(0);
            });

    final String expectedMessage = "Tried to create a bicycle without wheels.";
    final String actualMessage = exception.getMessage();

    assertEquals(actualMessage, expectedMessage);
  }
}
