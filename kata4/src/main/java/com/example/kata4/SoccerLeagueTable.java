package com.example.kata4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SoccerLeagueTable {

  public static void main(String[] args) {
    SpringApplication.run(SoccerLeagueTable.class, args);
      String filePath = "/Users/inescortina/PDT/kata4/src/main/java/com/example/kata4/football.dat";
      System.out.println("reading file...");
    try {
      BufferedReader reader = new BufferedReader(new FileReader(filePath));

      int smallestSpreadTeamFor = -1;
      int smallestSpreadTeamAgainst = -1;
      int smallestSpreadValueFor = Integer.MAX_VALUE;
      int smallestSpreadValueAgainst = Integer.MAX_VALUE;
      String line;
      boolean firstLineSkipped = false;

      while ((line = reader.readLine()) != null) {
        if (!firstLineSkipped) {
          firstLineSkipped = true;
          continue;
        }
//          System.out.println("printing lines" + line);
        String[] columns = line.split("\\s+");
        try {
          if (columns.length >= 3) {
            int team = Integer.parseInt(columns[2]);
            int parsedScoredByThem = Integer.parseInt(columns[7].replaceAll("\\D", ""));
            int parsedScoredByOpp = Integer.parseInt(columns[9].replaceAll("\\D", ""));
            int diffGoalsFor = parsedScoredByThem - parsedScoredByOpp;
            int diffGoalsAgainst = parsedScoredByOpp - parsedScoredByThem;
            System.out.println(diffGoalsFor + "diffGoals");
            if (diffGoalsFor < smallestSpreadValueFor) {
              smallestSpreadTeamFor = team;
              smallestSpreadValueFor = diffGoalsFor;
            }
            System.out.println(diffGoalsAgainst + "diffGoals");
            if (diffGoalsAgainst < smallestSpreadValueAgainst) {
              smallestSpreadTeamAgainst = team;
              smallestSpreadValueAgainst = diffGoalsAgainst;
            }
          }
        } catch (NumberFormatException e) {}
      }
      if (smallestSpreadTeamFor != -1) {
        System.out.println("Day number with the smallest spread: " + smallestSpreadTeamFor);
      } else {
        System.out.println("No valid data found in the file.");
      }
      if (smallestSpreadTeamAgainst != -1) {
        System.out.println("Day number with the smallest spread: " + smallestSpreadTeamAgainst);
      } else {
        System.out.println("No valid data found in the file.");
      }
      reader.close();
    } catch (IOException e) {
      System.out.println("Error reading the file: " + e.getMessage());
    }
  }

}
