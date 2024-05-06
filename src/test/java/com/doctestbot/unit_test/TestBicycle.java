package com.doctestbot.unit_test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.doctestbot.Bicycle;
import com.doctestbot.BicycleWithoutWheels;

/** Test class for the Bicycle class. */
@SuppressWarnings({"PMD.AtLeastOneConstructor"})
class TestHelloUniverse {

  /** Test method to verify the a bike will have 2 wheels after initialisation. */
  @Test
  void testTwoWheeledBicycleExists() throws BicycleWithoutWheels {
    final Bicycle someBike = new Bicycle(2);
    assertEquals(2, someBike.getNrOfWheels(), "Error, bike did not have two wheels.");
  }

  /** Test method to verify the a custom BicycleWithoutWheels exception is thrown if one attempts to create a bicycle without any wheels.*/
  @Test
  void testBicycleWithoutWheelsThrowsError() throws BicycleWithoutWheels {

    Exception exception = assertThrows(BicycleWithoutWheels.class, () -> {
      new Bicycle(0);
    });

    String expectedMessage = "Tried to create a bicycle without wheels.";
    String actualMessage = exception.getMessage();

    assertEquals(actualMessage, expectedMessage);
  }
}
