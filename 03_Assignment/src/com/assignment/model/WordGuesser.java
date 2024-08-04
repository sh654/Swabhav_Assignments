package com.assignment.model;
import java.util.Random;
import java.util.Scanner;
public class WordGuesser {
	String Spaces(String word) {
		String newWord = "";
		for (int i = 0; i < word.length(); i++) {
			newWord += word.charAt(i) + " ";
		}
		return newWord;
	}
	String replaceCharAtIndex(String word, int index, char letter) {
		return word.substring(0, index) + letter + word.substring(index+1); 
	}
	String askToGuess(Scanner input, String answer, String wordHolder){
		//ask
		System.out.println("Guess a letter! ");
		String modifiedWordHolder = wordHolder;
		char letter = input.next().toLowerCase().charAt(0);
		for (int i = 0; i < answer.length(); i++) {
			if(answer.charAt(i) == letter) {
				// return direct if word already filled
				if(wordHolder.charAt(i) == letter) {
					System.out.println("Already Filled!");
					return modifiedWordHolder;
				}
				modifiedWordHolder = this.replaceCharAtIndex(modifiedWordHolder, i, letter);
			}
		}
		// return blank if no modification
		if(modifiedWordHolder.equals(wordHolder)) {
			return "";
		}
		return modifiedWordHolder;
	}
 
	public static void main(String[] args) {
		String[] wordList = {
				"joker",
				"swabhav",
				"rabbit",
				"nokia",
				"orange",
				"mango"
		};
		Random ran = new Random();
 
		// random word
		String randomWord = wordList[ran.nextInt(wordList.length)].toLowerCase();
		int lives = randomWord.length() - 1;
 
		// create blanks
		String wordHolder = "";
		for (int i = 0; i < randomWord.length(); i++) {
			wordHolder += "_";
		}
 
 
		Scanner input = new Scanner(System.in);
		WordGuesser wordGuesser = new WordGuesser();
 
		System.out.println("Welcome to word guesser!");
		System.out.println("fill in the blanks");
 
		while(lives>0) {
			System.out.println();
			System.out.println(wordGuesser.Spaces(wordHolder));
			System.out.println();
 
			String modifiedWordHolder = wordGuesser.askToGuess(input, randomWord, wordHolder);
 
			// if modifiedWordHolder is empty then no changes
			if(modifiedWordHolder.isEmpty()) {
				System.out.println("Your guess was wrong!");
				lives--;
				System.out.println("You lost a live");
				System.out.println("Remaining Lives " + lives);
				if(lives == 0) {
					System.out.println("Game Over");
				}
			}
			else {
				wordHolder = modifiedWordHolder;
				// check if wordHolder has blanks
				if(!modifiedWordHolder.contains("_")) {
					System.out.println(randomWord);
					System.out.println("Game Over");
					lives = 0;
				};
			}
 
		}
		input.close();
	}
}