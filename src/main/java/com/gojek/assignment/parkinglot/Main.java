package com.gojek.assignment.parkinglot;

import com.gojek.assignment.parkinglot.utility.InputUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author ErikMegantara
 */
public class Main {
  public static void main(String[]args){
    InputUtils inputUtils = new InputUtils();
    Boolean exit = false;
    if (args.length == 0) {
      do {
        try {
          BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
          String inputString = bufferRead.readLine();
          if (inputString.equalsIgnoreCase("exit")) {
            exit = true;
          } else {
            inputUtils.parseTextInput(inputString.trim());
          }
        } catch(IOException e) {
          e.printStackTrace();
        }
      }while (!exit);
    }
    else if (args.length == 1) {
      inputUtils.parseFileInput(args[0]);
    }else{
      System.out.println("invalid command");
    }
  }

}
