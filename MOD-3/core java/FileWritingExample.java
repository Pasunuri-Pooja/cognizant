// FileWritingExample.java

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileWritingExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string to write to the file: ");
        String input = scanner.nextLine();

        try {
            // Create a FileWriter in overwrite mode
            FileWriter writer = new FileWriter("output.txt");

            // Write the input string to the file
            writer.write(input);

            // Close the writer to save the file
            writer.close();

            System.out.println("Data has been written to output.txt successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
