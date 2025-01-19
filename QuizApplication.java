import java.util.Scanner;
import java.io.IOException;

public class QuizApplication {
    private static final int TIME_LIMIT = 10; // Time limit for each question (in seconds)
    private static int score = 0;            // User's score
    private static int questionIndex = 0;   // Current question index

    // Questions, options, and answers
    private static final String[][] QUESTIONS = {
            {"What is the capital of India?", "1. Paris", "2. London", "3. Berlin", "4. New Delhi"},
            {"What is 6 + 3?", "1. 6", "2. 7", "3. 8", "4. 9"},
            {"Which language is used for AIML?", "1. Python", "2. Java", "3. C#", "4. Swift"}
    };
    private static final int[] ANSWERS = {4, 4, 1}; // Correct answers (1-based indices)

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Quiz Application!");
        System.out.println("You have " + TIME_LIMIT + " seconds to answer each question.\n");

        // Iterate through each question
        for (String[] question : QUESTIONS) {
            if (!askQuestion(scanner, question)) {
                System.out.println("Time's up! Moving to the next question.\n");
            }
        }

        System.out.println("Quiz Over! Your score: " + score + "/" + QUESTIONS.length);
        scanner.close();
    }

    private static boolean askQuestion(Scanner scanner, String[] question) throws IOException {
        System.out.println("Question " + (questionIndex + 1) + ": " + question[0]);

        // Display options
        for (int i = 1; i < question.length; i++) {
            System.out.println(question[i]);
        }

        // Start the timer
        long startTime = System.currentTimeMillis();
        boolean answered = false;

        while ((System.currentTimeMillis() - startTime) / 1000 < TIME_LIMIT) {
            if (System.in.available() > 0) { // Check if user input is available
                int userAnswer = scanner.nextInt();
                answered = true;

                // Check if the answer is correct
                if (userAnswer == ANSWERS[questionIndex]) {
                    System.out.println("Correct!\n");
                    score++;
                } else {
                    System.out.println("Wrong! The correct answer was: " + ANSWERS[questionIndex] + "\n");
                }
                break;
            }
            try {
                Thread.sleep(100); // Sleep for 100ms to prevent busy waiting
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        questionIndex++;
        return answered;
    }
}
