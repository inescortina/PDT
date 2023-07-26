package com.example.kata4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
@SpringBootApplication
public class WeatherData {

  public static void main(String[] args) {
    SpringApplication.run(WeatherData.class, args);
      String filePath = "/Users/inescortina/PDT/kata4/src/main/java/com/example/kata4/weather.dat";
      System.out.println("reading file...");
      try {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));

        int smallestSpreadDay = -1;
        int smallestSpreadValue = Integer.MAX_VALUE;
        String line;

        while ((line = reader.readLine()) != null) {
//          System.out.println("printing lines" + line);
            String[] columns = line.split("\\s+");
//            System.out.println("printing columns" + columns);
            try {
            if (columns.length >= 3) {
              int dayNumber = Integer.parseInt(columns[1]);
//              System.out.println("printing daynum" + dayNumber);
              int parsedMaxTemp = Integer.parseInt(columns[2].replaceAll("\\D", ""));
              int parsedMinTemp = Integer.parseInt(columns[3].replaceAll("\\D", ""));
              int diffTemp = parsedMaxTemp - parsedMinTemp;
              if (diffTemp < smallestSpreadValue) {
                smallestSpreadDay = dayNumber;
                smallestSpreadValue = diffTemp;
              }
            }
          } catch (NumberFormatException e) {}
        }
        if (smallestSpreadDay != -1) {
          System.out.println("Day number with the smallest temperature spread: " + smallestSpreadDay);
        } else {
          System.out.println("No valid data found in the file.");
        }
        reader.close();
      } catch (IOException e) {
        System.out.println("Error reading the file: " + e.getMessage());
      }
      }
  }

