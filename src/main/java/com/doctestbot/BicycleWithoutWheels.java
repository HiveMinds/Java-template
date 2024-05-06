package com.doctestbot;

// Java program that demonstrates the use of throw
public class BicycleWithoutWheels extends Exception { 
  public BicycleWithoutWheels(String errorMessage) {
      super(errorMessage);
  }
}
