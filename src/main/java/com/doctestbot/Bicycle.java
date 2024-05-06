package com.doctestbot;

/** This class represents a Bicycle object with a varying number of wheels. */
public class Bicycle {

  /** Allows setting the number of wheels in the bicycle. */
  private final int nrOfWheels;

  /**
   * Default constructor for the Bicycle class.
   *
   * @param nrOfWheelsArg how many wheels the bicycle will have.
   */
  public Bicycle(final int nrOfWheelsArg) {
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
