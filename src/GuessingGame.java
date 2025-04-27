
import java.util.InputMismatchException;
import java.util.Scanner;

public class GuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(ColorStyle.Style.bold + ColorStyle.Color.purple + "|------------------------------------|" + ColorStyle.Color.reset + ColorStyle.Style.reset);
        System.out.println(ColorStyle.Style.bold + ColorStyle.Color.purple + "| ⚜️ Welcome to the Guessing Game ⚜️ |" + ColorStyle.Color.reset + ColorStyle.Style.reset);
        System.out.println(ColorStyle.Style.bold + ColorStyle.Color.purple + "|------------------------------------|" + ColorStyle.Color.reset + ColorStyle.Style.reset);


        while (true) {
            int mode = -1;
            boolean validInput = false;

            while (!validInput) {
                System.out.println("\nSelect a mode:");
                System.out.println("0. EASY");
                System.out.println("1. NORMAL");
                System.out.println("2. HARD");
                System.out.println("3. SUPER HARD");
                System.out.println("4. Win twice and receive 1k Mode");
                System.out.print("Enter MODE: ");

               
                    mode = scanner.nextInt();
                    if (mode >= 0 && mode <= 4) {
                        validInput = true;
                    } else {
                        System.out.println("Invalid mode. Please enter a number between 0 and 4.");
                        scanner.next();
                    }
              
            }

            int range = 0;
            int tries = 3;

            switch (mode) {
                case 0:
                    System.out.println("😃EASY MODE😃");
                    range = 10;
                    break;
                case 1:
                    System.out.println("NORMAL MODE");
                    range = 50;
                    break;
                case 2:
                    System.out.println("HARD MODE");
                    range = 100;
                    break;
                case 3:
                    System.out.println("SUPER HARD MODE");
                    range = 500;
                    break;
                case 4:
                    System.out.println("Win twice in a row and receive 5k Mode");
                    range = 1000;
                    break;
            }

            int number = (int) (Math.random() * range);
            System.out.println("\nI'm thinking 🤔 of a number between 0 and " + range + ". Can you guess it?");
            System.out.println("-------------------------------------------------------------------------");

            while (tries > 0) {
                System.out.print("\nEnter your guess: ");
                int guess = scanner.nextInt();

                if (guess == number) {

                    System.out.println("\n🎋🎋🎋🎋🎋🎋🎋🎋🎋🎋🎋🎋🎋🎋🎋🎋🎋🎋🎋🎋");
                    System.out.println("🎋  You won ☺️🎉 you recieve a star ⭐ 🎋");
                    System.out.println("🎋🎋🎋🎋🎋🎋🎋🎋🎋🎋🎋🎋🎋🎋🎋🎋🎋🎋🎋🎋");
                    break;
                } else if (guess < number) {
                    System.out.println("\n🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥");
                    System.out.println(ColorStyle.Style.bold + ColorStyle.Color.red + "You missed, The random number is greater than " + guess + "." + ColorStyle.Color.reset + ColorStyle.Style.reset);
                    System.out.println("🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥");
                } else {
                    System.out.println("🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥");
                    System.out.println(ColorStyle.Style.bold + ColorStyle.Color.red + "You missed!The random number is lesser than " + guess + "." + ColorStyle.Color.reset + ColorStyle.Style.reset);
                    System.out.println("🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥");
                }

                tries--;
                if (tries > 0) {
                    System.out.println(ColorStyle.Style.bold + ColorStyle.Color.blue + "You have " + tries + " 😢 tries left. Please try again!" + ColorStyle.Color.reset + ColorStyle.Style.reset);
                }
            }

            if (tries == 0) {
                System.out.println("\n🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥");
                System.out.println(ColorStyle.Style.bold + ColorStyle.Color.yellow + " You lose 😭 The number was " + number + "." + ColorStyle.Color.reset + ColorStyle.Style.reset);
                System.out.println("🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥");

            }
            System.out.println("\n🎆🎆🎆🎆🎆🎆🎆🎆🎆🎆🎆🎆🎆🎆🎆🎆🎆🎆🎆🎆🎆🎆🎆🎆🎆🎆🎆🎆🎆");
            System.out.println("Press Enter key to restart or any other key to exit:");
            System.out.println("🎆🎆🎆🎆🎆🎆🎆🎆🎆🎆🎆🎆🎆🎆🎆🎆🎆🎆🎆🎆🎆🎆🎆🎆🎆🎆🎆🎆🎆");
            scanner.nextLine();
            String restart = scanner.nextLine();
            if (!restart.isEmpty()) {
                System.out.println("Thanks for playing Goodbye ");
                break;
            }
        }

        scanner.close();
    }
}
