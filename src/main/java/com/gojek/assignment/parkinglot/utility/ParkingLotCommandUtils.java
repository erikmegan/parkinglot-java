package com.gojek.assignment.parkinglot.utility;

import com.gojek.assignment.parkinglot.entity.ParkingLotCommand;
import com.gojek.assignment.parkinglot.service.api.ParkingLotManagement;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ErikMegantara
 */
public class ParkingLotCommandUtils {
  private Map<String, Method> commandMap;

  public ParkingLotCommandUtils() {
    commandMap = new HashMap<String, Method>();
    setParkingCommand();
  }

  private void setParkingCommand() {
    try {
      commandMap.put(ParkingLotCommand.CREATE.getCommand(),
          ParkingLotManagement.class.getMethod("createSlot", String.class));

      commandMap.put(ParkingLotCommand.STATUS.getCommand(),
          ParkingLotManagement.class.getMethod("status"));

      commandMap.put(ParkingLotCommand.PARK.getCommand(),
          ParkingLotManagement.class.getMethod("fillSlot", String.class, String.class));

      commandMap.put(ParkingLotCommand.LEAVE.getCommand(),
          ParkingLotManagement.class.getMethod("removeSlot", String.class));

      commandMap.put(ParkingLotCommand.REGISTRATION_NUMBERS_BY_COLOR.getCommand(),
          ParkingLotManagement.class.getMethod("getVehicleRegistrationNumberByColor", String.class));

      commandMap.put(ParkingLotCommand.SLOT_NUMBER_BY_COLOR.getCommand(),
          ParkingLotManagement.class.getMethod("getSlotNumbersOfVehicleByColor", String.class));

      commandMap.put(ParkingLotCommand.SLOT_NUMBERS_BY_REGISTRATION_NUMBERS.getCommand(),
          ParkingLotManagement.class.getMethod("getSlotNumbersOfVehicleByRegistrationNumber", String.class));

    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    }
  }

  public Map<String, Method> getParkingLotCommand() {
    return commandMap;
  }
}
