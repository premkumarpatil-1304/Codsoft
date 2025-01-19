import java.util.Random;
import java.util.Scanner;

public class guess_the_random_number {
    public static void main(String args[]){
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int randomnumber = random.nextInt(100) + 1;

        System.out.println("I have generated a random number between 1 and 100.");
        System.out.print(" Enter your guess: ");

        //input for guessing the number
        int guess= scanner.nextInt();
        //checking the user's guess
        if(randomnumber==guess){
            System.out.println("YOUR GUESS IS CORRECT");
        }
        else if(randomnumber>guess){
            System.out.println("your guess is low.The correct number is "+randomnumber);
        }
        else {
            System.out.println("your guess is high.The correct number is "+randomnumber);
        }

    }
}
