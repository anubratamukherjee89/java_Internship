
import java.io.*;
import java.util.Scanner;

public class javaNotesApp {

    private static final String FILE_NAME = "notes.txt";
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Notes App ---");
            System.out.println("1. Write Note");
            System.out.println("2. View Notes");
            System.out.println("3. Exit");
            System.out.print("Choose an option (1-3): ");
            int choice = scanner.nextInt();
            scanner.nextLine();  

            switch (choice) {
                case 1:
                    writeNote();
                    break;
                case 2:
                    readNotes();
                    break;
                case 3:
                    System.out.println("Exiting Notes App.");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void writeNote() {
        System.out.print("Enter your note: ");
        String note = scanner.nextLine();

        try (FileWriter fw = new FileWriter(FILE_NAME, true)) {  
            fw.write(note + "\n");
            System.out.println("Note saved.");
        } catch (IOException e) {
            System.out.println("Error writing note: " + e.getMessage());
        }
    }

    private static void readNotes() {
        System.out.println("\n--- Your Notes ---");

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            int count = 1;
            while ((line = br.readLine()) != null) {
                System.out.println(count++ + ". " + line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("No notes found. Write a note first.");
        } catch (IOException e) {
            System.out.println("Error reading notes: " + e.getMessage());
        }
    }
}

