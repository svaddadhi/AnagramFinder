import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Anagram {

	public static char[] charArray;
	public static Set<String> words = new HashSet<>();
	public static Set<String> anagramWords = null;
	public static String enteredWord = null;

	public Anagram() {
		
	}

	/**
	 * 
	 * @param newsize
	 *     shuffles the characters 
	 */
	public void changeOrder(int newsize) {
		int j;
		int pointAt = charArray.length - newsize;
		char temp = charArray[pointAt];
   
		for (j = pointAt + 1; j < charArray.length; j++) {
			charArray[j - 1] = charArray[j];
		}

		charArray[j - 1] = temp;
	}

	/**
	 * @param newsize
	 *   generates index to shuffle characters
	 */
	public void doAnagram(int newsize) {
		if (newsize == 1) {
			return;
		}
		for (int i = 0; i < newsize; i++) {
			doAnagram(newsize - 1);
			if (newsize == 2) {
				append();
			}
			changeOrder(newsize);
		}
	}

	/**
	 * 
	 * @param word
	 * 		generates anagram from the user input
	 */
	public void generateAnagram(String word) {
		charArray = word.toCharArray();
		doAnagram(charArray.length);
	}

	/**
	 *    adds an generated anagram to a Set 
	 *    this set contains all the anagrams from the user input
	 */
	public void append() {
		if (!String.valueOf(charArray).equals(enteredWord)) {
			anagramWords.add(String.valueOf(charArray));
		}
		
	}

	/**
	 * 
	 * @param fileName
	 *       reads the file from user input and
	 *       constructs a Set<String> of words from the file
	 */
	public static void loadFileContent(String fileName) {
		BufferedReader br = null;
		String currentLine;

		try {
			try {
				br = new BufferedReader(new FileReader(fileName));
				//reads the file and adds the words to a Set<String>
				while ((currentLine = br.readLine()) != null) {
					words.add(currentLine.trim());
				}

			} catch (FileNotFoundException e) {
				System.out.println("File not found or invalid file path");
				e.printStackTrace();
			}
		} catch (IOException e) {
			System.out.println("IO Error:");
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	
}
