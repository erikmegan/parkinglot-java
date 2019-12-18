package com.gojek.assignment.parkinglot.service.api;

public interface ParkingLotManagement {

  void createSlot(String size);

  void status();

  void fillSlot(String registrationNumber, String vehicleColor);

  void removeSlot(String slotNumber);

  int getAvailableSlot();

  void getVehicleRegistrationNumberByColor(String color);

  void getSlotNumbersOfVehicleByColor(String color);

  void getSlotNumbersOfVehicleByRegistrationNumber(String registrationNumber);
}
