package edu.neumont.csc130.EMB;

import java.util.regex.Pattern;

public class Player {

	/**
	 * name is the player's name
	 */
	private String name;

	/**
	 * creates a person object
	 */
	public Player() {
	}

	/**
	 * returns player's name
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * sets the player's name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * validates the player's input for name
	 * @param name
	 * @return boolean
	 */
	public boolean isValidName(String name) {
		// only accepts names that are alphanumeric, excluding symbols and whitespace
		// returns false if name is not valid
		String regex = "^[a-zA-Z0-9]+$";
		return Pattern.compile(regex, Pattern.MULTILINE).matcher(name).matches();
	}


	/**
	 * requests the player's input for heap and heap choice, validates
	 * the board removes the tokens chosen by player
	 * @param board
	 */
	public void takeTurn(Board board) {
		// heap choice
		System.out.println("Enter the corresponding letter of the heap you would like to remove token(s) from:");

		String heapChoice = null;
		boolean valid = false;
		do {
			// accepts input through the game class 
			heapChoice = Nim.getConsoleInput();
			heapChoice = heapChoice.toUpperCase();
			// validates the heap choice through the board class
			// returns true if the heap contains tokens, false if empty
			// if false, requests user input again
			if (board.isValidHeapChoice(heapChoice)) {
				valid = true;
			} else {
				System.out.println("Invalid Heap Choice. Please try again:");
			}
		} while (!valid);
		valid = false; 

		// token choice
		System.out.println("Enter the number of tokens you would like to remove from heap " + heapChoice + ":");

		int tokenChoice;
		do {
			// accepts user input through the game class
			tokenChoice = Integer.parseInt(Nim.getConsoleInput());
			// validates if the amount of tokens in chosen heap can be chosen
			// returns true if possible user choice, false if not
			// if flase, requests user input again
			if (board.isValidTokenChoice(tokenChoice, heapChoice)) {
				valid = true;
			} else {
				System.out.println("Invalid number of token(s). Please try again:");
			}
		} while (!valid);
		
		// removes tokens through board class
		board.removeTokens(heapChoice, tokenChoice);

	}
}
