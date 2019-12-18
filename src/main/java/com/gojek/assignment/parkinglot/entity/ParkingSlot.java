package com.gojek.assignment.parkinglot.entity;

/**
 * @author ErikMegantara
 */
public class ParkingSlot {
  private Vehicle vehicle;

  public ParkingSlot(Vehicle vehicle) {
    this.vehicle = vehicle;
  }

  public Vehicle getVehicle() {
    return vehicle;
  }

  public void setVehicle(Vehicle vehicle) {
    this.vehicle = vehicle;
  }
}
