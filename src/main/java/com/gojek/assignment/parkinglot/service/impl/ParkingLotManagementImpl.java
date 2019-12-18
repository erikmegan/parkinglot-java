package com.gojek.assignment.parkinglot.service.impl;

import com.gojek.assignment.parkinglot.entity.Car;
import com.gojek.assignment.parkinglot.entity.ParkingSlot;
import com.gojek.assignment.parkinglot.entity.Vehicle;
import com.gojek.assignment.parkinglot.entity.VehicleColor;
import com.gojek.assignment.parkinglot.service.api.ParkingLotManagement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ErikMegantara
 */
public class ParkingLotManagementImpl implements ParkingLotManagement {

  private int availableSlot;
  private ParkingSlot[] parkingSlots;
  private int slotsNumber = 0;

  public ParkingLotManagementImpl() {
  }

  @Override
  public void createSlot(String size){
    availableSlot = Integer.parseInt(size);
    parkingSlots = new ParkingSlot[availableSlot];

    System.out.println("Created a parking lot with " + availableSlot + " slots");
  }
  @Override
  public void status(){
    if (parkingSlots == null) {
      System.out.println("No parking lot created");
      return;
    }

    if (parkingSlots.length == 0) {
      System.out.println("No parking lot created");
      return;
    }

    System.out.println("Slot No.\tRegistration No.\tColor");
    for (int i = 0; i < parkingSlots.length; i++) {
      if (parkingSlots[i] != null){
        System.out.println(i + "\t" + parkingSlots[i].getVehicle().getRegistrationNumber() + "\t" + parkingSlots[i].getVehicle().getColor());
      }
    }
  }
  @Override
  public void fillSlot(String registrationNumber, String strColor){
    VehicleColor vehicleColor = vehicleColorMapper(strColor);

    if (vehicleColor != null) {
      Vehicle vehicle = new Car(vehicleColor, registrationNumber);

      if (isAvailableToPark(vehicle)) {
        reserveSlot(vehicle);
        System.out.println("Allocated slot number: " + slotsNumber);
      } else {
        System.out.println("Parking lot is full");
      }
    } else {
      System.out.println("Vehicle color is not recognized");
    }
  }
  @Override
  public void removeSlot(String strSlotNumber){
    int slotsNumber = Integer.parseInt(strSlotNumber);

    if (isAvailableToLeave(slotsNumber)) {

      for (int i = 0; i < parkingSlots.length; i++) {
        if (slotsNumber == i) {
          parkingSlots[slotsNumber] = null;
          availableSlot++;
        }
      }

      System.out.println("Slot number "+ slotsNumber +" is free");
    }
  }
  public int getAvailableSlot(){
    return availableSlot;
  }
  @Override
  public void getVehicleRegistrationNumberByColor(String color){
    VehicleColor vehicleColor = vehicleColorMapper(color);

    List<String> registrationNumbers = new ArrayList<String>();

    for (int i = 0; i < parkingSlots.length; i++) {
      if (parkingSlots[i] != null) {
        if (parkingSlots[i].getVehicle().getColor().toString().equalsIgnoreCase(vehicleColor.toString())) {
          registrationNumbers.add(parkingSlots[i].getVehicle().getRegistrationNumber());
        }
      }
    }

    if (registrationNumbers.isEmpty()) {
      System.out.println("Not found");
    } else {
      System.out.println(String.join(", ", registrationNumbers));
    }
  }
  @Override
  public void getSlotNumbersOfVehicleByColor(String color){
    VehicleColor vehicleColor = vehicleColorMapper(color);
    List<Integer> slotNumbers = new ArrayList<Integer>();

    for (int i = 0; i < parkingSlots.length; i++) {
      if (parkingSlots[i] != null) {
        if (parkingSlots[i].getVehicle().getColor().toString().equalsIgnoreCase(vehicleColor.toString())) {
          slotNumbers.add(i+1);
        }
      }
    }

    printSlotNumber(slotNumbers);

  }
  @Override
  public void getSlotNumbersOfVehicleByRegistrationNumber(String registrationNumber){
    List<Integer> slotNumbers = new ArrayList<Integer>();

    for (int i = 0; i < parkingSlots.length; i++) {
      if (parkingSlots[i] != null) {
        if (parkingSlots[i].getVehicle().getRegistrationNumber().equalsIgnoreCase(registrationNumber)) {
          slotNumbers.add(i+1);
        }
      }
    }

    printSlotNumber(slotNumbers);
  }

  private VehicleColor vehicleColorMapper(String color) {
    if (color.equalsIgnoreCase(VehicleColor.White.toString())) {
      return VehicleColor.White;
    } else if (color.equalsIgnoreCase(VehicleColor.Black.toString())) {
      return VehicleColor.Black;
    } else if (color.equalsIgnoreCase(VehicleColor.Red.toString())) {
      return VehicleColor.Red;
    } else if (color.equalsIgnoreCase(VehicleColor.Blue.toString())) {
      return VehicleColor.Blue;
    } else if (color.equalsIgnoreCase(VehicleColor.Green.toString())) {
      return VehicleColor.Green;
    } else {
      return null;
    }
  }
  private boolean isAvailableToPark(Vehicle vehicle) {

    for (int i = 0; i < parkingSlots.length; i++) {
      if (parkingSlots[i] == null) {
        return true;
      }
    }

    return availableSlot > 0
        && availableSlot >= ((parkingSlots.length - 1) + vehicle.getVehicleSize())
        && slotsNumber < availableSlot;
  }
  private void reserveSlot(Vehicle vehicle) {
    ParkingSlot parkingSlot = new ParkingSlot(vehicle);

    for (int i = 0; i < parkingSlots.length; i++) {

      if (parkingSlots[i] == null && i < parkingSlots.length - 1 && parkingSlots[i+1] != null) {
        parkingSlots[i] = parkingSlot;
        slotsNumber = i;
        break;
      }

      if (parkingSlots[i] == null) {
        parkingSlots[i] = parkingSlot;
        slotsNumber = i + vehicle.getVehicleSize();
        break;
      }
    }
    availableSlot--;
  }
  private boolean isAvailableToLeave(int slotsNumber) {
    return slotsNumber <= parkingSlots.length;
  }

  private void printSlotNumber(List<Integer> slotNumbers) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < slotNumbers.size(); i++) {
      sb.append(slotNumbers.get(i));
      if (i < slotNumbers.size() - 1) {
        sb.append(", ");
      }
    }

    if(sb.toString().isEmpty()) {
      System.out.println("Not found");
    } else {
      System.out.println(sb.toString());
    }
  }



}
