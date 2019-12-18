package com.gojek.assignment.parkinglot.entity;

/**
 * @author ErikMegantara
 */
public enum  ParkingLotCommand {
  CREATE("create_parking_lot"),
  STATUS("status"),
  PARK("park"),
  LEAVE("leave"),
  REGISTRATION_NUMBERS_BY_COLOR("registration_numbers_for_cars_with_colour"),
  SLOT_NUMBERS_BY_REGISTRATION_NUMBERS("slot_number_for_registration_number"),
  SLOT_NUMBER_BY_COLOR("slot_numbers_for_cars_with_colour");

  private String command;

  ParkingLotCommand(String command) {
    this.command = command;
  }

  public String getCommand() {
    return command;
  }
}
