package edu.neumont.csc130.EMB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Player {

	private String name;

	public Player() {
	}

	public String getName() {
		return name;
	}

	public void setName() throws IOException {
		String input;
		boolean valid = false;
		System.out.println("Please enter your name using only alphanumeric characters: ");
		do {
			input = getConsoleInput();
			if (isValidName(input)) {
				valid = true;
				this.name = input;
			} else {
				System.out.println(
						"Invalid name, your name may only contain alphanumeric characters. Please try again: ");
			}
		} while (!valid);
	}

	private boolean isValidName(String name) {
		String regex = "^[a-zA-Z0-9]+$";
		return Pattern.compile(regex, Pattern.MULTILINE).matcher(name).matches();
	}

	private String getConsoleInput() {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String input = null;
		try {
			input = in.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return input.trim();
	}

	public void takeTurn(Board board) {
		System.out.println("Enter the corresponding letter of the heap you would like to remove token(s) from:");

		String heapChoice = null;
		boolean valid = false;
		do {
			heapChoice = getConsoleInput();
			heapChoice = heapChoice.toUpperCase();
			if (board.isValidHeapChoice(heapChoice)) {
				valid = true;
			} else {
				System.out.println("Invalid name, your name may only contain alphanumeric characters. Please try again:");
			}
		} while (!valid);
		valid = false; 

		
		System.out.println("Enter the number of tokens you would like to remove from heap " + heapChoice + ":");

		int tokenChoice;
		do {
			tokenChoice = Integer.parseInt(getConsoleInput());
			if (board.isValidTokenChoice(tokenChoice, heapChoice)) {
				valid = true;
			} else {
				System.out.println("Invalid number of token(s). Please try again:");
			}
		} while (!valid);
		
		board.removeTokens(heapChoice, tokenChoice);

	}
}
