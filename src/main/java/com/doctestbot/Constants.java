package com.doctestbot;

import java.util.HashMap;
import java.util.Map;

/** Stores the global variables in this repo. */
public final class Constants {

  /** Example of global mapping. */
  public static final Map<String, String> SOME_MAPPING;

  static {
    // Initialize the language-to-extension mapping.
    SOME_MAPPING = new HashMap<>();
    SOME_MAPPING.put("python", "py");
    SOME_MAPPING.put("java", "java");
    // Add more mappings as needed...
  }

  // Private constructor to prevent instantiation of the class
  private Constants() {
    throw new AssertionError("A utility class should not be instantiated.");
  }
}
