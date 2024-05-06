package com.doctestbot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** This class represents a Bicycle object with a varying number of wheels. */
public class Bicycle {
  /** Can be used to output logs towards logging/Bicycle.log. */
  private static final Logger LOGGER = LoggerFactory.getLogger("Bicycle");

  /** Allows setting the number of wheels in the bicycle. */
  private final int nrOfWheels;

  /**
   * Default constructor for the Bicycle class.
   *
   * @param nrOfWheelsArg how many wheels the bicycle will have.
   * @throws BicycleWithoutWheels
   */
  public Bicycle(final int nrOfWheelsArg) throws BicycleWithoutWheels {
    if (LOGGER.isInfoEnabled()) {
      LOGGER.info("Created bicycle with:" + nrOfWheelsArg + " wheels.");
    }

    if (nrOfWheelsArg == 0) {
      throw new BicycleWithoutWheels("Tried to create a bicycle without wheels.");
    }
    nrOfWheels = nrOfWheelsArg;
  }

  /**
   * This method returns the number of wheels a bicycle typically has (2).
   *
   * @return The number of wheels (2)
   */
  public int getNrOfWheels() {
    return nrOfWheels;
  }
}
