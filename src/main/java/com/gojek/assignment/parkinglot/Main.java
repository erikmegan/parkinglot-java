package com.gojek.assignment.parkinglot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author ErikMegantara
 */
public class Main {
  public static void main(String[]args){
    Boolean exit = false;
    if (args.length == 0) {
      do {
        try {
          BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
          String inputString = bufferRead.readLine();
          if (inputString.equalsIgnoreCase("exit")) {
            exit = true;
          } else {

          }
        } catch(IOException e) {
          e.printStackTrace();
        }
      }while (!exit);
    }
    else if (args.length == 1) {

    }
  }

}
