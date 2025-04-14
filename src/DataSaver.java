import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DataSaver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> dataList = new ArrayList<>();
        int currentId = 1;
        String userResponse;

        do {
            System.out.print("First Name: ");
            String firstName = scanner.nextLine();

            System.out.print("Last Name: ");
            String lastName = scanner.nextLine();

            String id = String.format("%06d", currentId); // Format like 000001

            System.out.print("Email: ");
            String email = scanner.nextLine();

            System.out.print("Year of Birth (YYYY): ");
            String yearOfBirth = scanner.nextLine();

            // Create a record in CSV format
            String record = firstName + ", " + lastName + ", " + id + ", " + email + ", " + yearOfBirth;
            dataList.add(record); // Add record to the list

            currentId++;

            System.out.print("Do you want to enter another record? (yes/no): ");
            userResponse = scanner.nextLine();
        } while (userResponse.equalsIgnoreCase("yes"));

        System.out.print("Enter the file name to save (with .csv): ");
        String fileName = scanner.nextLine();

        try {
            FileWriter fileWriter = new FileWriter("src/" + fileName);
            for (String entry : dataList) {
                fileWriter.write(entry + "\n");
            }
            fileWriter.close();
            System.out.println("Data saved successfully to src/" + fileName);
        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }

        scanner.close();
    }
}
