package task1_number_game;

import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int totalScore = 0;
        int roundsPlayed = 0;
        int maxAttempts = 7;

        System.out.println("Welcome to the Number Guessing Game!");

        while (playAgain) {
            int numberToGuess = random.nextInt(100) + 1;
            int attempts = 0;
            boolean hasGuessedCorrectly = false;
            roundsPlayed++;

            System.out.println("\n--- Round " + roundsPlayed + " ---");
            System.out.println("I have chosen a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts to guess it.");

            while (attempts < maxAttempts && !hasGuessedCorrectly) {
                System.out.print("Enter your guess: ");
                
                String input = scanner.nextLine();
                int userGuess;
                
                try {
                    userGuess = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid whole number.");
                    continue; // Skip the rest of the loop, but don't count as an attempt
                }

                attempts++;

                if (userGuess == numberToGuess) {
                    hasGuessedCorrectly = true;
                    int pointsForRound = maxAttempts - attempts + 1;
                    totalScore += pointsForRound;
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempt(s).");
                    System.out.println("You earned " + pointsForRound + " points this round.");
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low! Try a higher number. Attempts remaining: " + (maxAttempts - attempts));
                } else {
                    System.out.println("Too high! Try a lower number. Attempts remaining: " + (maxAttempts - attempts));
                }
            }

            if (!hasGuessedCorrectly) {
                System.out.println("Game Over for this round! The correct number was: " + numberToGuess);
            }

            System.out.println("Current Total Score: " + totalScore);
            System.out.print("\nWould you like to play another round? (yes/no): ");
            String response = scanner.nextLine().trim().toLowerCase();
            if (!response.equals("yes") && !response.equals("y")) {
                playAgain = false;
            }
        }

        System.out.println("\n--- Final Results ---");
        System.out.println("Total Rounds Played: " + roundsPlayed);
        System.out.println("Final Total Score: " + totalScore);
        System.out.println("Thank you for playing!");
        scanner.close();
    }
}
