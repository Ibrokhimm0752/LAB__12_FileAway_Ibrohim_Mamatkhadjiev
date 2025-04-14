import javax.swing.JFileChooser;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileInspector {
    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("src"));

        int userChoice = fileChooser.showOpenDialog(null);

        if (userChoice == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();

            int lines = 0;
            int words = 0;
            int characters = 0;

            try (Scanner reader = new Scanner(file)) {
                System.out.println("File content:\n");

                while (reader.hasNextLine()) {
                    String currentLine = reader.nextLine();
                    System.out.println(currentLine);
                    lines++;

                    if (!currentLine.trim().isEmpty()) {
                        words += currentLine.trim().split("\\s+").length;
                    }

                    characters += currentLine.length();
                }

                // Summary
                System.out.println("\n--- File Summary ---");
                System.out.println("File Name: " + file.getName());
                System.out.println("Lines: " + lines);
                System.out.println("Words: " + words);
                System.out.println("Characters: " + characters);

            } catch (FileNotFoundException e) {
                System.out.println("Error: File not found.");
            }
        }
    }
}