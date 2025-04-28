
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class History {

    private static String HISTORY_FILE = "history.txt";

    public static void saveHistory(String history, boolean isWin, int number, int tries) {
        try {
            Files.createFile(Paths.get(HISTORY_FILE));
        } catch (IOException e) {
            System.err.println("Error saving history" + e.getMessage());
        }

        String HistoryFormat;
        if (isWin) {
            HistoryFormat = "You won in " + tries + " tries. The number was " + number + ".";
        } else {
            HistoryFormat = "You lost. The number was " + number + ".";
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(HISTORY_FILE, true))) {
            bw.write(HistoryFormat + "\n");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    public static void viewHistory() {
        try (BufferedReader br = new BufferedReader(new FileReader(HISTORY_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
    }

    public static void deleteHistory() {
        try {
            Files.delete(Paths.get(HISTORY_FILE));
        } catch (IOException e) {

            System.err.println("Error deleting file: " + e.getMessage());
        }
    }

}
