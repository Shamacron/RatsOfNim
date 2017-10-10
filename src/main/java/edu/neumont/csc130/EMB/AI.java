package edu.neumont.csc130.EMB;

import java.util.Random;

public class AI extends Player {

	public AI() {
		setName("Computer");
	}

	@Override
	public void takeTurn(Board board) {
		Random rand = new Random();
		
		String heapChoice = null;
		boolean valid = false;
		do {
			heapChoice = Character.toString((char)(rand.nextInt(4)+65));
			System.out.println(heapChoice);
			heapChoice = heapChoice.toUpperCase();
			if (board.isValidHeapChoice(heapChoice)) {
				valid = true;
			}
		} while (!valid);
		valid = false; 

		int tokenChoice;
		do {
			tokenChoice = rand.nextInt(9)+1; 
			if (board.isValidTokenChoice(tokenChoice, heapChoice)) {
				valid = true;
			}
		} while (!valid);
		
		board.removeTokens(heapChoice, tokenChoice);
	}

}
