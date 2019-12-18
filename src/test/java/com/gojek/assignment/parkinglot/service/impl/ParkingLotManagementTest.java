package com.gojek.assignment.parkinglot.service.impl;

import static org.junit.Assert.assertEquals;

import com.gojek.assignment.parkinglot.entity.VehicleColor;
import com.gojek.assignment.parkinglot.service.api.ParkingLotManagement;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author ErikMegantara
 */
public class ParkingLotManagementTest {
  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

  @Before
  public void before() {
    System.setOut(new PrintStream(outContent));
  }

  @After
  public void after() {
    System.setOut(null);
  }

  private static final String REGISTRATION_NUMBER_1 = "AB-1231-CG";
  private static final String REGISTRATION_NUMBER_2 = "AB-1232-CG";
  private static final String REGISTRATION_NUMBER_3 = "AB-1233-CG";
  private static final String REGISTRATION_NUMBER_4 = "AB-1234-CG";
  private static final String REGISTRATION_NUMBER_5 = "AB-1235-CG";
  private static final String REGISTRATION_NUMBER_6 = "AB-1236-CG";

  @Test
  public void createSlotTestSuccess() {
    ParkingLotManagement parkingLot = new ParkingLotManagementImpl();
    parkingLot.createSlot("4");

    assertEquals(4, parkingLot.getAvailableSlot());
    assertEquals("Createdaparkinglotwith4slots", outContent.toString().trim().replace(" ", ""));
  }
  @Test
  public void fillSlotTestSuccess() {
    // given
    ParkingLotManagement parkingLot = new ParkingLotManagementImpl();
    parkingLot.createSlot("6");

    // test
    parkingLot.fillSlot(REGISTRATION_NUMBER_1, VehicleColor.White.toString());
    parkingLot.fillSlot(REGISTRATION_NUMBER_2, VehicleColor.Black.toString());
    parkingLot.fillSlot(REGISTRATION_NUMBER_3, VehicleColor.Black.toString());
    parkingLot.fillSlot(REGISTRATION_NUMBER_4, VehicleColor.Red.toString());
    parkingLot.fillSlot(REGISTRATION_NUMBER_5, VehicleColor.Blue.toString());
    parkingLot.fillSlot(REGISTRATION_NUMBER_6, VehicleColor.Black.toString());

    // verify
    assertEquals(0, parkingLot.getAvailableSlot());
    assertEquals(
        "Createdaparkinglotwith6slots\n"
            + "Allocatedslotnumber:1\n"
            + "Allocatedslotnumber:2\n"
            + "Allocatedslotnumber:3\n"
            + "Allocatedslotnumber:4\n"
            + "Allocatedslotnumber:5\n"
            + "Allocatedslotnumber:6",
        outContent.toString().trim().replace(" ", ""));
  }

  @Test
  public void leaveSuccess() {
    // given
    ParkingLotManagement parkingLot = new ParkingLotManagementImpl();
    parkingLot.createSlot("6");

    // test
    parkingLot.fillSlot(REGISTRATION_NUMBER_1, VehicleColor.White.toString());
    parkingLot.fillSlot(REGISTRATION_NUMBER_2, VehicleColor.Black.toString());
    parkingLot.fillSlot(REGISTRATION_NUMBER_3, VehicleColor.Black.toString());
    parkingLot.fillSlot(REGISTRATION_NUMBER_4, VehicleColor.Red.toString());
    parkingLot.fillSlot(REGISTRATION_NUMBER_5, VehicleColor.Blue.toString());
    parkingLot.fillSlot(REGISTRATION_NUMBER_6, VehicleColor.Black.toString());

    parkingLot.removeSlot("4");

    // verify
    assertEquals(1, parkingLot.getAvailableSlot());
    assertEquals(
        "Createdaparkinglotwith6slots\n"
            + "Allocatedslotnumber:1\n"
            + "Allocatedslotnumber:2\n"
            + "Allocatedslotnumber:3\n"
            + "Allocatedslotnumber:4\n"
            + "Allocatedslotnumber:5\n"
            + "Allocatedslotnumber:6\n"
            + "Slotnumber4isfree",
        outContent.toString().trim().replace(" ", ""));
  }

  @Test
  public void leaveThenParkSuccess() {
    // given
    ParkingLotManagement parkingLot = new ParkingLotManagementImpl();
    parkingLot.createSlot("6");

    // test
    parkingLot.fillSlot(REGISTRATION_NUMBER_1, VehicleColor.White.toString());
    parkingLot.fillSlot(REGISTRATION_NUMBER_2, VehicleColor.White.toString());
    parkingLot.fillSlot(REGISTRATION_NUMBER_3, VehicleColor.Black.toString());
    parkingLot.fillSlot(REGISTRATION_NUMBER_4, VehicleColor.Red.toString());
    parkingLot.fillSlot(REGISTRATION_NUMBER_5, VehicleColor.Blue.toString());
    parkingLot.fillSlot(REGISTRATION_NUMBER_6, VehicleColor.Black.toString());

    // test remove
    parkingLot.removeSlot("4");
    assertEquals(1, parkingLot.getAvailableSlot());

    // test insert again
    parkingLot.fillSlot("new-regis", VehicleColor.Black.toString());

    // verify
    assertEquals(
        "Createdaparkinglotwith6slots\n"
            + "Allocatedslotnumber:1\n"
            + "Allocatedslotnumber:2\n"
            + "Allocatedslotnumber:3\n"
            + "Allocatedslotnumber:4\n"
            + "Allocatedslotnumber:5\n"
            + "Allocatedslotnumber:6\n"
            + "Slotnumber4isfree\n"
            + "Allocatedslotnumber:4",
        outContent.toString().trim().replace(" ", ""));
  }

  @Test
  public void statusTestSuccess() {

    // given
    ParkingLotManagement parkingLot = new ParkingLotManagementImpl();
    parkingLot.createSlot("6");

    // test
    parkingLot.fillSlot(REGISTRATION_NUMBER_1, VehicleColor.White.toString());
    parkingLot.fillSlot(REGISTRATION_NUMBER_2, VehicleColor.Black.toString());
    parkingLot.fillSlot(REGISTRATION_NUMBER_3, VehicleColor.Black.toString());
    parkingLot.fillSlot(REGISTRATION_NUMBER_4, VehicleColor.Red.toString());
    parkingLot.fillSlot(REGISTRATION_NUMBER_5, VehicleColor.Blue.toString());
    parkingLot.fillSlot(REGISTRATION_NUMBER_6, VehicleColor.Black.toString());

    parkingLot.removeSlot("4");

    parkingLot.status();

    // verify
    assertEquals(1, parkingLot.getAvailableSlot());
    assertEquals(
        "Createdaparkinglotwith6slots\n"
            + "Allocatedslotnumber:1\n"
            + "Allocatedslotnumber:2\n"
            + "Allocatedslotnumber:3\n"
            + "Allocatedslotnumber:4\n"
            + "Allocatedslotnumber:5\n"
            + "Allocatedslotnumber:6\n"
            + "Slotnumber4isfree\n"
            + "SlotNo.\tRegistrationNo.\tColor\n"
            + "0\tAB-1231-CG\tWhite\n"
            + "1\tAB-1232-CG\tBlack\n"
            + "2\tAB-1233-CG\tBlack\n"
            + "3\tAB-1234-CG\tRed\n"
            + "5\tAB-1236-CG\tBlack",
        outContent.toString().trim().replace(" ", ""));
  }

  @Test
  public void getCarsRegistrationNumberByColor() {
    // given
    ParkingLotManagement parkingLot = new ParkingLotManagementImpl();
    parkingLot.createSlot("6");

    // test
    parkingLot.fillSlot(REGISTRATION_NUMBER_1, VehicleColor.White.toString());
    parkingLot.fillSlot(REGISTRATION_NUMBER_2, VehicleColor.White.toString());
    parkingLot.fillSlot(REGISTRATION_NUMBER_3, VehicleColor.Black.toString());
    parkingLot.fillSlot(REGISTRATION_NUMBER_4, VehicleColor.Red.toString());
    parkingLot.fillSlot(REGISTRATION_NUMBER_5, VehicleColor.Blue.toString());
    parkingLot.fillSlot(REGISTRATION_NUMBER_6, VehicleColor.Black.toString());

    parkingLot.removeSlot("4");

    parkingLot.getVehicleRegistrationNumberByColor(VehicleColor.White.toString());

    // verify
    assertEquals(1, parkingLot.getAvailableSlot());
    assertEquals(
        "Createdaparkinglotwith6slots\n"
            + "Allocatedslotnumber:1\n"
            + "Allocatedslotnumber:2\n"
            + "Allocatedslotnumber:3\n"
            + "Allocatedslotnumber:4\n"
            + "Allocatedslotnumber:5\n"
            + "Allocatedslotnumber:6\n"
            + "Slotnumber4isfree\n"
            + "AB-1231-CG,AB-1232-CG",
        outContent.toString().trim().replace(" ", ""));
  }

  @Test
  public void getSlotNumbersForCarWithRegistrationNumber() {
    // given
    ParkingLotManagement parkingLot = new ParkingLotManagementImpl();
    parkingLot.createSlot("6");

    // test
    parkingLot.fillSlot(REGISTRATION_NUMBER_1, VehicleColor.White.toString());
    parkingLot.fillSlot(REGISTRATION_NUMBER_2, VehicleColor.White.toString());
    parkingLot.fillSlot(REGISTRATION_NUMBER_3, VehicleColor.Black.toString());
    parkingLot.fillSlot(REGISTRATION_NUMBER_4, VehicleColor.Red.toString());
    parkingLot.fillSlot(REGISTRATION_NUMBER_5, VehicleColor.Blue.toString());
    parkingLot.fillSlot(REGISTRATION_NUMBER_6, VehicleColor.Black.toString());

    parkingLot.removeSlot("4");

    parkingLot.getVehicleRegistrationNumberByColor(VehicleColor.White.toString());
    parkingLot.getSlotNumbersOfVehicleByColor(VehicleColor.White.toString());
    parkingLot.getSlotNumbersOfVehicleByRegistrationNumber(REGISTRATION_NUMBER_6);
    parkingLot.getSlotNumbersOfVehicleByRegistrationNumber("xxx");

    // verify
    assertEquals(1, parkingLot.getAvailableSlot());
    assertEquals(
        "Createdaparkinglotwith6slots\n"
            + "Allocatedslotnumber:1\n"
            + "Allocatedslotnumber:2\n"
            + "Allocatedslotnumber:3\n"
            + "Allocatedslotnumber:4\n"
            + "Allocatedslotnumber:5\n"
            + "Allocatedslotnumber:6\n"
            + "Slotnumber4isfree\n"
            + "AB-1231-CG,AB-1232-CG\n"
            + "1,2\n"
            + "6\n"
            + "Notfound",
        outContent.toString().trim().replace(" ", ""));
  }
  @Test
  public void getSlotNumbersForCarWithColorNotFound() {
    // given
    ParkingLotManagement parkingLot = new ParkingLotManagementImpl();
    parkingLot.createSlot("6");

    // test
    parkingLot.fillSlot(REGISTRATION_NUMBER_1, VehicleColor.White.toString());
    parkingLot.fillSlot(REGISTRATION_NUMBER_2, VehicleColor.White.toString());
    parkingLot.fillSlot(REGISTRATION_NUMBER_3, VehicleColor.Black.toString());
    parkingLot.fillSlot(REGISTRATION_NUMBER_4, VehicleColor.Red.toString());
    parkingLot.fillSlot(REGISTRATION_NUMBER_5, VehicleColor.Blue.toString());
    parkingLot.fillSlot(REGISTRATION_NUMBER_6, VehicleColor.Black.toString());

    parkingLot.removeSlot("4");

    parkingLot.getVehicleRegistrationNumberByColor(VehicleColor.White.toString());
    parkingLot.getSlotNumbersOfVehicleByColor(VehicleColor.Green.toString());

    // verify
    assertEquals(1, parkingLot.getAvailableSlot());
    assertEquals(
        "Createdaparkinglotwith6slots\n"
            + "Allocatedslotnumber:1\n"
            + "Allocatedslotnumber:2\n"
            + "Allocatedslotnumber:3\n"
            + "Allocatedslotnumber:4\n"
            + "Allocatedslotnumber:5\n"
            + "Allocatedslotnumber:6\n"
            + "Slotnumber4isfree\n"
            + "AB-1231-CG,AB-1232-CG\n"
            + "Notfound",
        outContent.toString().trim().replace(" ", ""));
  }
}
