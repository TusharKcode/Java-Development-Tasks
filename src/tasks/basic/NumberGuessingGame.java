package tasks.basic;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // generate a random number between 1 - 100
        int randomNumber = random.nextInt(100) + 1;
        int attempts = 0;
        int maxAttempts = 5;            // user gets 5 chances to guess number

        boolean guessedCorrectly  = false;

        System.out.println("===== Number Guessing Game =====");
        System.out.println("Guess the number between 1 to 100");
        System.out.println("You have " + maxAttempts + " attempts!");

        while(attempts < maxAttempts){
            System.out.println("Enter your guess: ");

            if (!scanner.hasNextInt()){
                System.out.println("Invalid input! Please enter a number.");
                scanner.next();         // clear invalid input
            }

            int userGuess = scanner.nextInt();
            attempts++;

            if (userGuess == randomNumber){
                System.out.println("Congratulations! You guessed it right in " + attempts + " attempts!");
                guessedCorrectly = true;
                break;
            } else if (userGuess < randomNumber){
                System.out.println("Too Low! Try again.");
            } else {
                System.out.println("Too High! Try again.");
            }
            System.out.println("Attempts left: " + (maxAttempts - attempts));
        }

        if (!guessedCorrectly){
            System.out.println("Sorry! You've used all attempts. The correct number was: " + randomNumber);
        }

        scanner.close();
    }
}
