
import java.util.Scanner;

public class GuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(ColorStyle.Style.bold + ColorStyle.Color.purple + "|------------------------------------|" + ColorStyle.Color.reset + ColorStyle.Style.reset);
        System.out.println(ColorStyle.Style.bold + ColorStyle.Color.purple + "| ⚜️ Welcome to the Guessing Game ⚜️   |" + ColorStyle.Color.reset + ColorStyle.Style.reset);
        System.out.println(ColorStyle.Style.bold + ColorStyle.Color.purple + "|------------------------------------|" + ColorStyle.Color.reset + ColorStyle.Style.reset);

        while (true) {
            int mode = 0;
            boolean validInput = false;

            while (!validInput) {
                System.out.println("\n|-----------------------------------------------|");
                System.out.println("|            Select a mode:                     |");
                System.out.println("|-----------------------------------------------|");
                System.out.println("0. EASY");
                System.out.println("1. NORMAL");
                System.out.println("2. HARD");
                System.out.println("3. SUPER HARD");
                System.out.println("4. Win twice and receive 1k Mode");
                System.out.println("5. View History");
                System.out.println("6. Delete history");
                System.out.print("ENTER MODE: ");

                mode = scanner.nextInt();
                if (mode >= 0 && mode <= 6) {
                    validInput = true;
                } else {
                    System.out.println("Invalid mode. Please enter a number between 0 and 6.");
                    scanner.next();
                }

            }

            int range = 0;
            int tries = 3;

            switch (mode) {
                case 0:
                    System.out.println("😃 EASY MODE 😃");
                    range = 10;
                    break;
                case 1:
                    System.out.println("☺️ NORMAL MODE ☺️");
                    range = 50;
                    break;
                case 2:
                    System.out.println("🥲 HARD MODE 🥲");
                    range = 100;
                    break;
                case 3:
                    System.out.println("🍀 SUPER HARD MODE 🍀");
                    range = 500;
                    break;
                case 4:
                    System.out.println("😎 Win twice in a row and receive 5k Mode 😎");
                    range = 1000;
                    break;
                case 5:
                    History.viewHistory();
                    continue;
                case 6:
                    History.deleteHistory();
                    continue;
                default:
                    System.out.println("Invalid mode. Please enter a number between 0 and 5.");
                    continue;
            }

            int number = (int) (Math.random() * range);
            System.out.println("\nI'm thinking 🤔 of a number between 0 and " + range + ". Can you guess it?");
            System.out.println("-------------------------------------------------------------------------");

            while (tries > 0) {
                System.out.print("\nEnter your guess: ");
                int guess = scanner.nextInt();

                if (guess == number) {

                    System.out.println("\n🎋🎋🎋🎋🎋🎋🎋🎋🎋🎋🎋🎋🎋🎋🎋🎋🎋🎋🎋🎋");
                    System.out.println(ColorStyle.Style.bold + ColorStyle.Color.green + "🎋  You won ☺️🎉 you recieve a star ⭐ 🎋" + ColorStyle.Color.reset + ColorStyle.Style.reset);
                    System.out.println("🎋🎋🎋🎋🎋🎋🎋🎋🎋🎋🎋🎋🎋🎋🎋🎋🎋🎋🎋🎋");
                    History.saveHistory("You won in " + (3 - tries + 1) + " tries. The number was " + number + ".", true, number, 3 - tries + 1);
                    break;
                } else if (guess < number) {
                    System.out.println("\n🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥");
                    System.out.println(ColorStyle.Style.bold + ColorStyle.Color.red + "You missed, The random number is greater than " + guess + "." + ColorStyle.Color.reset + ColorStyle.Style.reset);
                    System.out.println("🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥");
                } else {
                    System.out.println("\n🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥");
                    System.out.println(ColorStyle.Style.bold + ColorStyle.Color.red + "You missed!The random number is lesser than " + guess + "." + ColorStyle.Color.reset + ColorStyle.Style.reset);
                    System.out.println("🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥");
                }

                tries--;
                if (tries > 0) {
                    System.out.println(ColorStyle.Style.bold + ColorStyle.Color.blue + "You have " + tries + " 😢 tries left. Please try again!" + ColorStyle.Color.reset + ColorStyle.Style.reset);
                }
            }

            if (tries == 0) {
                System.out.println("\n🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁");
                System.out.println(ColorStyle.Style.bold + ColorStyle.Color.yellow + " You lose 😭 The number was 📢 " + number + "." + ColorStyle.Color.reset + ColorStyle.Style.reset);
                System.out.println("🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁");
                History.saveHistory("You lost. The number was " + number + ".", false, number, 3);

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
