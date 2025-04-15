import java.util.Scanner;
import java.util.Random;

public class NumberGame {
    private static final int MAX_ATTEMPTS = 10;
    private static final int MAX_ROUNDS = 3;
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 100;
    
    private static int totalScore = 0;
    private static int roundsWon = 0;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("You have " + MAX_ATTEMPTS + " attempts to guess a number between " 
            + MIN_RANGE + " and " + MAX_RANGE + " in each round.");
        System.out.println("There will be " + MAX_ROUNDS + " rounds in total.\n");
        
        // Play multiple rounds
        for (int round = 1; round <= MAX_ROUNDS; round++) {
            int targetNumber = random.nextInt(MAX_RANGE) + MIN_RANGE;
            int attemptsLeft = MAX_ATTEMPTS;
            boolean hasWon = false;
            
            System.out.println("--- Round " + round + " ---");
            System.out.println("Guess the number between " + MIN_RANGE + " and " + MAX_RANGE + ".");
            
            // Single round gameplay
            while (attemptsLeft > 0 && !hasWon) {
                System.out.print("Attempts left: " + attemptsLeft + ". Enter your guess: ");
                
                try {
                    int userGuess = scanner.nextInt();
                    
                    if (userGuess < MIN_RANGE || userGuess > MAX_RANGE) {
                        System.out.println("Please enter a number between " + MIN_RANGE + " and " + MAX_RANGE + ".");
                        continue;
                    }
                    
                    if (userGuess == targetNumber) {
                        hasWon = true;
                        int roundScore = attemptsLeft * 10; // More points for fewer attempts
                        totalScore += roundScore;
                        roundsWon++;
                        
                        System.out.println("Congratulations! You guessed the correct number " + targetNumber + "!");
                        System.out.println("Round score: " + roundScore + " points");
                    } else if (userGuess < targetNumber) {
                        System.out.println("Too low! Try a higher number.");
                    } else {
                        System.out.println("Too high! Try a lower number.");
                    }
                    
                    attemptsLeft--;
                } catch (Exception e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                    scanner.next(); // Clear the invalid input
                }
            }
            
            if (!hasWon) {
                System.out.println("Sorry, you've used all your attempts. The correct number was " + targetNumber + ".");
            }
            
            System.out.println(); // Blank line for separation
        }
        
        // Game summary
        System.out.println("=== Game Over ===");
        System.out.println("Rounds won: " + roundsWon + " out of " + MAX_ROUNDS);
        System.out.println("Total score: " + totalScore + " points");
        
        scanner.close();
    }
}