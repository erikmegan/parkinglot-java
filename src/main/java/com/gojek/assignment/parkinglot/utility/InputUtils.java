package com.gojek.assignment.parkinglot.utility;

import com.gojek.assignment.parkinglot.service.api.ParkingLotManagement;
import com.gojek.assignment.parkinglot.service.impl.ParkingLotManagementImpl;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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

  public void parseFileInput(String filePath) {

    File inputFile = new File(filePath);

    try {
      BufferedReader br = new BufferedReader(new FileReader(inputFile));
      String line;

      try {
        while ((line = br.readLine()) != null) {
          parseTextInput(line.trim());
        }
      } catch (IOException ex) {
        ex.printStackTrace();
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }
}
