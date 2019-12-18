package com.gojek.assignment.parkinglot.entity;

/**
 * @author ErikMegantara
 */
public abstract class Vehicle {
  private VehicleType vehicleType;
  private int vehicleSize;
  private VehicleColor color;
  private String registrationNumber;

  public Vehicle(VehicleType vehicleType, int vehicleSize, VehicleColor color, String registrationNumber) {
    this.vehicleType = vehicleType;
    this.vehicleSize = vehicleSize;
    this.color = color;
    this.registrationNumber = registrationNumber;
  }

  public VehicleType getVehicleType() {
    return vehicleType;
  }

  public void setVehicleType(VehicleType vehicleType) {
    this.vehicleType = vehicleType;
  }

  public int getVehicleSize() {
    return vehicleSize;
  }

  public void setVehicleSize(int vehicleSize) {
    this.vehicleSize = vehicleSize;
  }

  public VehicleColor getColor() {
    return color;
  }

  public void setColor(VehicleColor color) {
    this.color = color;
  }

  public String getRegistrationNumber() {
    return registrationNumber;
  }

  public void setRegistrationNumber(String registrationNumber) {
    this.registrationNumber = registrationNumber;
  }
}
