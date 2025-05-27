// TryCatchExample.java

import java.util.Scanner;

public class TryCatchExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Prompt user for two integers
            System.out.print("Enter the numerator (integer): ");
            int numerator = scanner.nextInt();

            System.out.print("Enter the denominator (integer): ");
            int denominator = scanner.nextInt();

            // Attempt division
            int result = numerator / denominator;

            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            // Handle division by zero
            System.out.println("Error: Division by zero is not allowed.");
        } finally {
            scanner.close();
        }
    }
}
