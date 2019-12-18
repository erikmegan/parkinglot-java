package com.gojek.assignment.parkinglot.entity;

/**
 * @author ErikMegantara
 */
public class Car extends Vehicle {

  private static final VehicleType VEHICLE_TYPE_CAR = VehicleType.CAR;
  private static final int SIZE_CAR = 1;

  public Car(VehicleColor color, String number) {
    super(VEHICLE_TYPE_CAR, SIZE_CAR, color, number);
  }
}
