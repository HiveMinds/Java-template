package com.doctestbot;

import java.io.Serializable;

/** Custom error. */
public class BicycleWithoutWheels extends Exception implements Serializable {
  /*
   * This id can be used by the JVM to verify compatibility for serialized data and the class used for deserialization.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Method to allow one to raise a custom error.
   *
   * @param errorMessage the message shown if this error is raised.
   */
  public BicycleWithoutWheels(final String errorMessage) {
    super(errorMessage);
  }
}
