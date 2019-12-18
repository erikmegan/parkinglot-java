package com.gojek.assignment.parkinglot.utility;

import com.gojek.assignment.parkinglot.service.api.ParkingLotManagement;
import com.gojek.assignment.parkinglot.service.impl.ParkingLotManagementImpl;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author ErikMegantara
 */
public class InputUtils {

  private ParkingLotCommandUtils parkingLotCommandUtils;
  private ParkingLotManagement parkingLot;

  public InputUtils() {
    parkingLotCommandUtils = new ParkingLotCommandUtils();
    parkingLot = new ParkingLotManagementImpl();
  }
  public void parseTextInput(String inputString) {

    String[] input = inputString.split(" ");

    try {

      Method method = parkingLotCommandUtils.getParkingLotCommand().get(input[0]);
      int inputArgsLength = input.length;

      if (method != null) {

        if (inputArgsLength == 1) {
          method.invoke(parkingLot);
        }
        else if (inputArgsLength == 2) {
          method.invoke(parkingLot, input[1]);
        }
        else if (inputArgsLength == 3) {
          method.invoke(parkingLot, input[1], input[2]);
        }
        else {
          System.out.println("Invalid input");
        }
      }
      else {
        System.out.println("Invalid input");
      }

    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    }
  }
}
