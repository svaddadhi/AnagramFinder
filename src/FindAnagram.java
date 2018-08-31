import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class FindAnagram extends Anagram {
	
	public static void main(String args[]) {

		Anagram.loadFileContent(args[0]);
		Anagram anagram = new Anagram();
		Scanner userInput = new Scanner(System.in);

		try {
			while (true) {
				anagramWords = new HashSet<>();
				System.out.print("Enter a word:  ");

				String word = userInput.next();
				enteredWord = word;
				anagram.generateAnagram(word);
				System.out.println("The anagrams of '"+word+"' if any, are: ");
				anagramWords.retainAll(words);
				//iterating available anagrams and printing them
				for (String str : anagramWords) {
					System.out.println(str);	
				}

				System.out.print("Do your want to do it again: (y/n) ");
				String resp = userInput.next();

				if (resp.equals("n")) {
					break;
				}
			}
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			if (userInput != null) {
				userInput.close();
			}
		}
	}

}
