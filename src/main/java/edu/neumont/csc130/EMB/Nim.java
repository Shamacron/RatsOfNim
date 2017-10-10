package edu.neumont.csc130.EMB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Nim {
  private Player[] players = new Player[2];
  private Board board;

  public void play() {
    do {
      printInstructions();
      chooseGameMode();
      chooseDifficulty();

      while (!board.checkForLoss()) {
        for (int i = 0; i < players.length; i++) {
          System.out.println("\n=================\n");
          System.out.println(players[i].getName() + "'s Turn");
          System.out.println(board);
          players[i].takeTurn(board);

          if (board.checkForLoss()) {
            System.out.println(players[i].getName() + " Lost");
            break;
          }
        }
      }

    } while (continuePlaying());
  }

  /**
   * Prints the Home Screen and Instructions on how to play
   */
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
    System.out.println("Enter 0 at any time during text entry to quit Nim");
    System.out.println("Instructions:");
    System.out.println("\tNim is a game for two players");
    System.out.println("\tEach Player has to remove a number of tokens from a heap of their choosing");
    System.out.println("\tThe player who removes the last item is the looser");
    System.out.println();
  }

  /**
   * Gets Console Input
   * @return Input as String
   */
  public static String getConsoleInput() {
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

  /**
   * Allow User to choose a game mode
   */
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

  /**
   * Create the Players based on the game mode
   * @param gameMode
   */
  private void createPlayers(int gameMode) {
    // Game Mode is set up in a way that option 1:pvc = 1 person, and option 2:pvp = 2 people
    for (int i = 0; i < gameMode; i++) {
      players[i] = new Player();
      System.out.println("Player #" + (i+1) + ": Please enter your name using only alphanumeric characters: ");

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

  /**
   * Allow User to Choose a Difficulty
   */
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

  /**
   * Prompts whether they want to play again
   * @return boolean
   */
  private boolean continuePlaying() {
    System.out.println("Play Again? y/n");

    String input = getConsoleInput();
    if (input.trim().equalsIgnoreCase("y") || input.trim().equalsIgnoreCase("yes")) {
      return true;
    }

    return false;
  }

}
