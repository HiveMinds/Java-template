package com.doctestbot;

import java.io.FileNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** The Main class serves as the entry point for the doctestbot application. */
@SuppressWarnings("PMD.ShortClassName")
public final class Main {

  /** Can be used to output logs towards logging/Generic.log. */
  private static final Logger LOGGER = LoggerFactory.getLogger("Generic");

  private Main() {
    // Prevent instantiation anywhere other than in class Main.
    throw new AssertionError("Instantiating utility class...");
  }

  /**
   * The main method is the entry point for the doctestbot application.
   *
   * @param args The command-line arguments provided when running the application.
   * @throws BicycleWithoutWheels
   */
  public static void main(final String[] args) throws FileNotFoundException, BicycleWithoutWheels {
    if (LOGGER.isInfoEnabled()) {
      LOGGER.info("Starting your code...");
    }

    new Bicycle(3);
    if (LOGGER.isInfoEnabled()) {
      LOGGER.info("Code completed.");
    }
  }

  /**
   * Outputs a hardcoded string.
   *
   * @return the message in string form.
   */
  public static String writeHelloUniverse() {
    return "Hello Universe";
  }
}
