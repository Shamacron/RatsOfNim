package edu.neumont.csc130.EMB;

import java.util.Random;

public class AI extends Player {

	/**
	 * creates AI object
	 */
	public AI() {
		setName("Computer");
	}

	/**
	 * randomly chooses heap and token amounts, validates, and removes tokens
	 */
	@Override
	public void takeTurn(Board board) {
		Random rand = new Random();
		
		// heap randomization
		String heapChoice = null;
		boolean valid = false;
		do {
			// random integer conversion to Char, and then to String
			heapChoice = Character.toString((char)(rand.nextInt(4)+65));
			// validates random choice validity
			// returns true if possible, false if not
			// loops until valid heap
			if (board.isValidHeapChoice(heapChoice)) {
				valid = true;
			}
		} while (!valid);
		valid = false; 

		// token randomization
		int tokenChoice;
		do {
			// generates random int for tokens to remove
			tokenChoice = rand.nextInt(9)+1; 
			// validates random choice validity
			// returns true if possible, false if not
			// loops until valid token choice
			if (board.isValidTokenChoice(tokenChoice, heapChoice)) {
				valid = true;
			}
		} while (!valid);
		
		// removes tokens
		board.removeTokens(heapChoice, tokenChoice);
	}

}
