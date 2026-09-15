package scrabbleapp;

import java.io.File;

public class Wordgen {
	// VARIABLES
	String[] words = new String[1000];
	
	// CONSTRUCTOR
	public Wordgen(String letters) {
		// Initialize the words array
		generateWords(letters);

	}
	
	public String[] generateWords(String letters) {
		// Generate words from the letters
		try {
			// Read the words from the dictionary file
			File file = new File("src/scrabbleapp/dictionary.txt");
			java.util.Scanner scanner = new java.util.Scanner(file);
			int i = 0;
			while (scanner.hasNextLine()) {
				String word = scanner.nextLine();
				// Check if the word can be made from the letters
				if (canMakeWord(word, letters)) {
					words[i] = word;
					i++;
				}
			}
			scanner.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return words;
	}

	// Check if a valid word can be made from the letters provided
	private boolean canMakeWord(String word, String letters) {
		String charPool = letters.toUpperCase();
		for (char c : word.toCharArray()) {
			int index = charPool.indexOf(c);
			if (index == -1) {
				return false;
			}
			{
			charPool = charPool.substring(0, index) + charPool.substring(index + 1);
		}
		}
		return true;
	}
	
}
