package com.gojek.assignment.parkinglot.utility;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * @author ErikMegantara
 */
public class ParkingLotCommandUtilsTest {
  ParkingLotCommandUtils command = new ParkingLotCommandUtils();

  @Test
  public void getParkingCommand() {
    assertTrue(command.getParkingLotCommand().containsKey("create_parking_lot"));
    assertTrue(command.getParkingLotCommand().containsKey("status"));
    assertTrue(command.getParkingLotCommand().containsKey("leave"));
    assertTrue(command.getParkingLotCommand().containsKey("park"));
    assertTrue(command.getParkingLotCommand().containsKey("registration_numbers_for_cars_with_colour"));
    assertTrue(command.getParkingLotCommand().containsKey("slot_numbers_for_cars_with_colour"));
    assertTrue(command.getParkingLotCommand().containsKey("slot_number_for_registration_number"));
    assertFalse(command.getParkingLotCommand().containsKey("createParkingLot"));

  }

}
