public class History {


    private static final String HISTORY_FILE_NAME = "history.txt";

    public static void saveHistory(String history) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(HISTORY_FILE_NAME, true))) {
            bw.write(history + "\n");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    public static void viewHistory() {
        try (BufferedReader br = new BufferedReader(new FileReader(HISTORY_FILE_NAME))) {
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
            Files.delete(Paths.get(HISTORY_FILE_NAME));
        } catch (IOException e) {
            System.err.println("Error deleting file: " + e.getMessage());
        }
    }
}