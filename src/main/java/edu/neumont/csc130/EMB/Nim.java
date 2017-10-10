package edu.neumont.csc130.EMB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Nim {
  private Player[] players = new Player[2];
  private Board board;

  public void play() {
    printInstructions();
    chooseGameMode();
    chooseDifficulty();





  }

  private void printInstructions() {
    System.out.println( " __    __  ______  __       __ \n" +
                        "|  \\  |  \\|      \\|  \\     /  \\\n" +
                        "| $$\\ | $$ \\$$$$$$| $$\\   /  $$\n" +
                        "| $$$\\| $$  | $$  | $$$\\ /  $$$\n" +
                        "| $$$$\\ $$  | $$  | $$$$\\  $$$$\n" +
                        "| $$\\$$ $$  | $$  | $$\\$$ $$ $$\n" +
                        "| $$ \\$$$$ _| $$_ | $$ \\$$$| $$\n" +
                        "| $$  \\$$$|   $$ \\| $$  \\$ | $$\n" +
                        " \\$$   \\$$ \\$$$$$$ \\$$      \\$$");
    System.out.println("Welcome to the game of Nim!");
    System.out.println("Enter 0 at eny time during text entry to quit Nim");
    System.out.println("Instructions:");
    System.out.println("\tNim is a game for two players");
    System.out.println("\tEach Player has to remove a number of tokens from a heap of their choosing");
    System.out.println("\tThe player who removes the last item is the looser");
    System.out.println();
  }

  private String getConsoleInput() {
    System.out.print("> ");

    String input = "";

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    try {
      input = br.readLine();
    } catch (IOException e) {
      System.out.println("Unable to read Console Input!");
    }

    if (input.trim().equals("0")){
      System.out.println("Thanks for Playing!");
      System.exit(0);
    }

    return input;
  }

  private void chooseGameMode() {
    System.out.println("Choose a Game Mode!");
    System.out.println("1:Player Vs Computer\t2:Player Vs Player");

    String input = null;
    boolean valid = false;
    while (!valid) {
      input = getConsoleInput();
      if (input.trim().equals("1") || input.trim().equals("2")){
        valid = true;
      } else {
        System.out.println("Invalid Entry");
      }
    }

    int gameMode = Integer.parseInt(input.trim());

    createPlayers(gameMode);

  }

  private void createPlayers(int gameMode) {
    for (int i = 0; i < gameMode; i++) {
      players[i] = new Player();
      System.out.println("Please enter your name using only alphanumeric characters: ");

      String input = "";
      boolean valid = false;
      while (!valid) {
          input = getConsoleInput();
          if (players[i].isValidName(input)) {
            valid = true;
          } else {
            System.out.println("Invalid name, your name may only contain alphanumeric characters. Please try again: ");
          }
      }
      players[i].setName(input);
    }

    if (gameMode == 1) {
      players[1] = new AI();
    }

  }

  private void chooseDifficulty() {
    System.out.println("Choose a Game Difficulty!");
    System.out.println("1:Easy\t2:Medium\t3:Hard");

    String input = null;
    boolean valid = false;
    while (!valid) {
      input = getConsoleInput();
      if (input.trim().equals("1") || input.trim().equals("2") || input.trim().equals("3")){
        valid = true;
      } else {
        System.out.println("Invalid Entry");
      }
    }

    int difficulty = Integer.parseInt(input.trim());

    board = new Board(difficulty);
  }

}
