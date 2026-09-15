package scrabbleapp;

public class Lettergen {
	
	// VARIABLES
	// Simple array of 7 characters to hold the letters
	char[] letters = new char[7];
	
	// CONSTRUCTOR
	// Fill array with random letters from generateLetter() method
	public Lettergen() {
		for (int i = 0; i < letters.length; i++) {
			letters[i] = generateLetter();
		}
	}
	
	// SETTERS AND GETTERS
	public char[] getLetters() {
		return letters;
	}

	public void setLetters(char[] letters) {
		this.letters = letters;
	}
	
	// FUNCTIONS
	
	public char generateLetter() {
		// Generate a random letter from A-Z
		return (char) ('A' + (int) (Math.random() * 26));
	}
	
}
